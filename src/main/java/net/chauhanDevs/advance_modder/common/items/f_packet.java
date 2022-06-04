package net.chauhanDevs.advance_modder.common.items;

import net.chauhanDevs.advance_modder.common.blocks.plate;
import net.chauhanDevs.advance_modder.core.init.blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class f_packet extends BlockItem {

    protected Item item;
    protected final int foodId;

    public f_packet(Block block, Properties properties, Item item, int foodId) {
        super(block, properties);
        this.item = item;
        this.foodId = foodId;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos  = context.getClickedPos();
        Level level = context.getLevel();
        BlockState block = level.getBlockState(pos);
        if(block.is(blocks.PLATE.get())){
            plate.updatePlate(context, foodId, item, 1);
            return InteractionResult.SUCCESS;
        }else if(Objects.requireNonNull(context.getPlayer()).isCrouching()){
            InteractionResult interactionresult = this.place(new BlockPlaceContext(context));
            return InteractionResult.SUCCESS;
        }else{
            return InteractionResult.PASS;
        }
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, LivingEntity entity) {
        InteractionHand hand = entity.getUsedItemHand();
        entity.setItemInHand(hand, item.getDefaultInstance());
        return super.finishUsingItem(stack, level, entity);
    }
}
