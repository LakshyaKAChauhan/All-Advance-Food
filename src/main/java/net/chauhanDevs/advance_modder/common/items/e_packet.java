package net.chauhanDevs.advance_modder.common.items;

import net.chauhanDevs.advance_modder.core.init.blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class e_packet extends food_BlockItem {

    public e_packet(Block b, Properties p) {
        super(b, p);
        isToBeOnlyFilledWithOn = false;
    }
    public e_packet(Block b, Properties p, Block toBeOnlyFilledWith) {
        super(b, p);
        toBeOnlyFilledWithBlock = toBeOnlyFilledWith;
        isToBeOnlyFilledWithOn = true;
    }
    protected boolean isToBeOnlyFilledWithOn;
    protected Block toBeOnlyFilledWithBlock;

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = Objects.requireNonNull(player).level;
        BlockPos pos = context.getClickedPos();
        BlockState blockState = level.getBlockState(pos);
        Block block = blockState.getBlock();
        if(isToBeOnlyFilledWithOn){
            if(blockState.is(toBeOnlyFilledWithBlock)){
                level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            }else if(blockState.is(blocks.PLATE.get())){
                level.setBlockAndUpdate(pos, blocks.PLATE.get().defaultBlockState());
            }
        }
        return super.useOn(context);
    }
}
