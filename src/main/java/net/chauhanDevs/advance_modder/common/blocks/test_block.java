package net.chauhanDevs.advance_modder.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class test_block extends Block {
    public static final BooleanProperty lol = BooleanProperty.create("lol");

    public test_block(Properties p) {
        super(p);
        registerDefaultState(this.defaultBlockState().setValue(lol, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(lol);
    }
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult result) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            boolean cState = state.getValue(lol);
            level.setBlock(pos, state.setValue(lol, !cState), 3);
        }
        return InteractionResult.SUCCESS;
    }
}
