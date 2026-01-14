package de.srr.createvehiclesadditional.Blocks;

import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import de.srr.createvehiclesadditional.BlockEntities.ElementSeparatorBlockEntity;
import de.srr.createvehiclesadditional.registry.ModBlockEntities;
import de.srr.createvehiclesadditional.util.ShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import net.minecraft.world.level.LevelReader;

import java.util.EnumMap;
import java.util.Map;


public class ElementSeparatorBlock extends HorizontalKineticBlock implements IBE<ElementSeparatorBlockEntity> {


    //Basis Shape
    private static final VoxelShape SHAPE_NORTH;
    //Rotated Shapes
    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    static {
        // Oberer voller Block (voller 16x14x16 Block)
        VoxelShape top = Block.box(0, 2, 0, 16, 16, 16);

        // Unterer voller Block (15x2x15)
        VoxelShape bottom = Block.box(1, 0, 1, 15, 2, 15);

        // Innenraum (8x12x14)
        VoxelShape inner = Block.box(2, 2, 4, 14, 16, 12);  //1 minX, minY, minZ //2 maxX, maxY, maxZ


        //Solid Kombinieren
        VoxelShape solid = Shapes.or(top, bottom);
        // Hohlraum erzeugen
        SHAPE_NORTH = Shapes.join(solid, inner, BooleanOp.ONLY_FIRST);


        //Rotation Vorberechnen
        SHAPES.put(Direction.NORTH, SHAPE_NORTH);
        SHAPES.put(Direction.EAST,  ShapeUtils.rotateShape(SHAPE_NORTH, Direction.NORTH, Direction.EAST));
        SHAPES.put(Direction.SOUTH, ShapeUtils.rotateShape(SHAPE_NORTH, Direction.NORTH, Direction.SOUTH));
        SHAPES.put(Direction.WEST,  ShapeUtils.rotateShape(SHAPE_NORTH, Direction.NORTH, Direction.WEST));
    }


    //Constructor
    public ElementSeparatorBlock(Properties properties) {
        super(properties.noOcclusion());
        registerDefaultState(defaultBlockState().setValue(HORIZONTAL_FACING, Direction.NORTH));
    }


    //Shapes
    @Override
    public @NotNull VoxelShape getShape(
            BlockState state,
            @NotNull BlockGetter level,
            @NotNull BlockPos pos,
            @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(HORIZONTAL_FACING));
    }

    @Override
    public @NotNull VoxelShape getInteractionShape(
            BlockState state,
            BlockGetter level,
            BlockPos pos) {
        return Shapes.block();
    }


    //Kinetics
    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(HORIZONTAL_FACING).getClockWise().getAxis();
    }

    @Override
    public boolean hasShaftTowards(
            LevelReader level,
            BlockPos pos,
            BlockState state,
            Direction face
    ) {
        return face == state.getValue(HORIZONTAL_FACING).getOpposite();
    }


    //Block Entity
    @Override
    public Class<ElementSeparatorBlockEntity> getBlockEntityClass() {
        return ElementSeparatorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends ElementSeparatorBlockEntity> getBlockEntityType() {
        return ModBlockEntities.ELEMENT_SEPARATOR.get();
    }

}


