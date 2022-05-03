package net.chauhanDevs.advance_modder.common.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class f_packet extends food_BlockItem {

    protected Item item;

    public f_packet(Block block, Properties properties, Item item) {
        super(block, properties);
        this.item = item;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, LivingEntity entity) {
        InteractionHand hand = entity.getUsedItemHand();
        entity.setItemInHand(hand, item.getDefaultInstance());
        return super.finishUsingItem(stack, level, entity);
    }
}
