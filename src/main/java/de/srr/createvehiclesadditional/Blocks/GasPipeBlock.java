package de.srr.createvehiclesadditional.Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class GasPipeBlock extends Block {

    private static final VoxelShape SHAPE_NORTH = Block.box(4, 4, 0, 12, 12, 16);
    private static final VoxelShape SHAPE_SOUTH = Block.box(4, 4, 0, 12, 12, 16);
    private static final VoxelShape SHAPE_WEST  = Block.box(0, 4, 4, 16, 12, 12);
    private static final VoxelShape SHAPE_EAST  = Block.box(0, 4, 4, 16, 12, 12);


    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public GasPipeBlock(Properties properties) {
        super(properties.noOcclusion());

        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState()
                .setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level,
                                        @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST  -> SHAPE_WEST;
            case EAST  -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter level,
                                          @NotNull BlockPos pos) {
        return true;
    }
}

