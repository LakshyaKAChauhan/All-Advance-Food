package net.chauhanDevs.advance_modder.common.blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class plate extends Block {
    public plate(BlockBehaviour.Properties p) {
        super(p);
    }
    public static final IntegerProperty FOOD_ID = IntegerProperty.create("food_id", 0, 1);


    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> state) {

        super.createBlockStateDefinition(state);
    }
}
