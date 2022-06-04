package net.chauhanDevs.advance_modder.common.items;

import net.chauhanDevs.advance_modder.common.blocks.plate;
import net.chauhanDevs.advance_modder.core.init.blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class e_packet extends BlockItem {

    public e_packet(Block b, Properties p, int foodId) {
        super(b, p);
        isToBeOnlyFilledWithOn = false;
    }
    public e_packet(Block b, Properties p, Block toBeOnlyFilledWith, int foodId) {
        super(b, p);
        toBeOnlyFilledWithBlock = toBeOnlyFilledWith;
        isToBeOnlyFilledWithOn = true;
        this.foodId = foodId;
    }
    protected int foodId;
    protected boolean isToBeOnlyFilledWithOn;
    protected Block toBeOnlyFilledWithBlock;

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer().isCrouching()){
            InteractionResult interactionresult = this.place(new BlockPlaceContext(context));
            return InteractionResult.SUCCESS;
        }else {
        	Player player = context.getPlayer();
            Level level = Objects.requireNonNull(player).level;
            BlockPos pos = context.getClickedPos();
            BlockState blockState = level.getBlockState(pos);
            Block block = blockState.getBlock();
            if(isToBeOnlyFilledWithOn){
                if(blockState.is(toBeOnlyFilledWithBlock)){
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }else if(blockState.is(blocks.PLATE.get())){
                    plate.updatePlate(context, foodId, Items.AIR, 0);
                }
            }
        }
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
        return InteractionResult.PASS;
    }
}
