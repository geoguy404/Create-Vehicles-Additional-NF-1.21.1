package de.srr.createvehiclesadditional.Blocks;

import de.srr.createvehiclesadditional.Blocks.Base.HorizontalRotatableBlock;
import de.srr.createvehiclesadditional.util.ShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;

public class ElementSeparatorBlock extends HorizontalRotatableBlock {
    //Basis Shape
    private static final VoxelShape ELEMENT_SEPARATOR_SHAPE_NORTH;
    //Rotated Shapes
    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    static {
        // Oberer voller Block (voller 16x14x16 Block)
        VoxelShape top = Block.box(0, 2, 0, 16, 16, 16);

        // Unterer voller Block (15x2x15)
        VoxelShape bottom = Block.box(1, 0, 1, 15, 2, 15);

        // Innenraum (8x12x14)
        VoxelShape inner = Block.box(
                2, 2, 4,    // minX, minY, minZ
                14, 16, 12  // maxX, maxY, maxZ
        );


        //Solid Kombinieren
        VoxelShape combinedSolid = Shapes.or(top, bottom);

        // Hohlraum erzeugen
        ELEMENT_SEPARATOR_SHAPE_NORTH = Shapes.join(combinedSolid, inner, BooleanOp.ONLY_FIRST);
    }

    //Rotation Vorberechnen
    static {
        SHAPES.put(Direction.NORTH, ELEMENT_SEPARATOR_SHAPE_NORTH);
        SHAPES.put(Direction.EAST,  ShapeUtils.rotateShape(ELEMENT_SEPARATOR_SHAPE_NORTH, Direction.NORTH, Direction.EAST));
        SHAPES.put(Direction.SOUTH, ShapeUtils.rotateShape(ELEMENT_SEPARATOR_SHAPE_NORTH, Direction.NORTH, Direction.SOUTH));
        SHAPES.put(Direction.WEST,  ShapeUtils.rotateShape(ELEMENT_SEPARATOR_SHAPE_NORTH, Direction.NORTH, Direction.WEST));
    }


    public ElementSeparatorBlock(Properties properties) {
        super(properties.noOcclusion());
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level,
                                        @NotNull BlockPos pos, @NotNull CollisionContext context) {

        return SHAPES.get(state.getValue(FACING));
    }

    @Override
    public @NotNull VoxelShape getInteractionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {

        return Block.box(0, 0, 0, 16, 16, 16);
    }

}


