package de.srr.createvehiclesadditional.content.steelLadle;


import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.foundation.block.IBE;
import de.srr.createvehiclesadditional.CVABlockEntities;
import de.srr.createvehiclesadditional.util.ShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;

public class     SteelLadleBlock extends Block implements IBE<SteelLadleBlockEntity>, IWrenchable {

    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;


    //Basis Shape
    private static final Direction BASE_DIR = Direction.NORTH;
    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    static {

        VoxelShape body  = Block.box(2, 4, 1, 14, 19, 15);
        VoxelShape foot  = Block.box(4, 0, 4, 12, 6, 12);
        //inner
        VoxelShape inner1 = Block.box(4, 7, 4, 12, 18, 12);
        VoxelShape inner2 = Block.box(2, 18, 4, 14, 19, 12);
        //top rim
        VoxelShape rim1  = Block.box(2, 19, 1, 4, 21, 3);
        VoxelShape rim2  = Block.box(12, 19, 13, 14, 21, 15);
        VoxelShape rim3  = Block.box(12, 19, 1, 14, 21, 3);
        VoxelShape rim4  = Block.box(2, 19, 13, 4, 21, 15);



        //Solid Kombinieren
        VoxelShape solid = Shapes.or(body, foot, rim1, rim2, rim3, rim4);
        VoxelShape unsolid = Shapes.or(inner1, inner2);
        // Hohlraum erzeugen
        VoxelShape base = Shapes.join(solid, unsolid, BooleanOp.ONLY_FIRST).optimize();


        for (Direction d : Direction.Plane.HORIZONTAL) {
            SHAPES.put(d, d == BASE_DIR ? base : ShapeUtils.rotateShape(base, BASE_DIR, d));
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block,
                                BlockPos fromPos, boolean isMoving) {
        if (level.isClientSide) return;

        boolean powered = level.hasNeighborSignal(pos);
        if (powered == state.getValue(POWERED)) return;

        level.setBlock(pos, state.setValue(POWERED, powered).setValue(OPEN, powered), 3);
        level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS,
                0.3f, powered ? 0.6f : 0.5f);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Override
    public @NotNull VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return Shapes.block();
    }

    //Constructor
    public SteelLadleBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any()
                .setValue(OPEN, false)
                .setValue(FACING, Direction.NORTH)
                .setValue(POWERED, false));
    }






    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        // createBlockStateDefinition
        builder.add(OPEN, FACING, POWERED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // Vorderseite zeigt zum Spieler
        return defaultBlockState().setValue(FACING, Direction.NORTH);
    }

    //Wrench
    @Override
    public BlockState getRotatedBlockState(BlockState state, Direction targetedFace) {
        return state.setValue(FACING, state.getValue(FACING).getClockWise());
    }

    @Override
    public Class<SteelLadleBlockEntity> getBlockEntityClass() {
        return SteelLadleBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends SteelLadleBlockEntity> getBlockEntityType() {
        return CVABlockEntities.STEEL_LADLE.get();
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hit) {

        if (!(level.getBlockEntity(pos) instanceof SteelLadleBlockEntity ladle))
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        // Kein Fluid-Container
        if (stack.getCapability(Capabilities.FluidHandler.ITEM) == null)
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        IFluidHandler handler = ladle.getTankBehaviour().getPrimaryHandler();
        if (FluidUtil.interactWithFluidHandler(player, hand, handler))
            return ItemInteractionResult.sidedSuccess(level.isClientSide);


        // Hebel nicht auslösen und kein Wasser platzieren
        return ItemInteractionResult.CONSUME;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                                        Player player, BlockHitResult hit) {

        boolean currentlyOpen = state.getValue(OPEN);
        boolean shiftHeld = player.isShiftKeyDown();

        // Rechtsklick-> öffnen; Shift-Rechtsklick-> schließen
        boolean targetState = !shiftHeld;

        if (currentlyOpen == targetState)
            return InteractionResult.PASS;

        if (level.isClientSide)
            return InteractionResult.SUCCESS;
        //lever sound !!!
        level.setBlock(pos, state.setValue(OPEN, targetState), 3);
        level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS,
                0.3f, targetState ? 0.6f : 0.5f);

        return InteractionResult.SUCCESS;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return IBE.super.getTicker(level, state, type);
    }
}