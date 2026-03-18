package de.srr.createvehiclesadditional.content.fluids.pipes;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.fluids.FluidTransportBehaviour;
import com.simibubi.create.content.fluids.pipes.EncasedPipeBlock;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlock;
import com.simibubi.create.content.fluids.pipes.GlassFluidPipeBlock;
import com.simibubi.create.content.fluids.pipes.StraightPipeBlockEntity;
import com.simibubi.create.content.schematics.requirement.ItemRequirement;
import de.srr.createvehiclesadditional.CVABlockEntities;
import net.createmod.catnip.data.Iterate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public class CVAGlassPipeBlock extends GlassFluidPipeBlock {

    public final CVAPipes.PipeMaterial material;

    public CVAGlassPipeBlock(Properties p_i48339_1_, CVAPipes.PipeMaterial material) {
        super(p_i48339_1_);
        this.material = material;
    }

    @Override
    public ItemRequirement getRequiredItems(BlockState state, BlockEntity te) {
        return ItemRequirement.of(CVAPipes.PIPES.get(material).getPipe().getDefaultState(), te);
    }

    // @Override
    // public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos,
    //                                    Player player) {
    //     return CVAPipes.CVA_PIPES.get(material).get(0).asStack();
    // }

    @Override
    public BlockState toRegularPipe(LevelAccessor world, BlockPos pos, BlockState state) {
        Direction side = Direction.get(Direction.AxisDirection.POSITIVE, state.getValue(AXIS));
        Map<Direction, BooleanProperty> facingToPropertyMap = FluidPipeBlock.PROPERTY_BY_DIRECTION;
        return CVAPipes.PIPES.get(material).getPipe().get()
                .updateBlockState(CVAPipes.PIPES.get(material).getPipe().getDefaultState()
                        .setValue(facingToPropertyMap.get(side), true)
                        .setValue(facingToPropertyMap.get(side.getOpposite()), true), side, null, world, pos);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!AllBlocks.COPPER_CASING.isIn(player.getItemInHand(hand)))
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        if (level.isClientSide)
            return ItemInteractionResult.SUCCESS;
        BlockState newState = CVAPipes.PIPES.get(material).getEncased().getDefaultState();
        for (Direction d : Iterate.directionsInAxis(getAxis(state)))
            newState = newState.setValue(EncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(d), true);
        FluidTransportBehaviour.cacheFlows(level, pos);
        level.setBlockAndUpdate(pos, newState);
        FluidTransportBehaviour.loadFlows(level, pos);
        return ItemInteractionResult.SUCCESS;
    }




    @Override
    public Class<StraightPipeBlockEntity> getBlockEntityClass() {
        return StraightPipeBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends StraightPipeBlockEntity> getBlockEntityType() {
        return CVABlockEntities.GLASS_CVA_PIPE.get();
    }
}