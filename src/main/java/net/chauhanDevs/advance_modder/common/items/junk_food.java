package net.chauhanDevs.advance_modder.common.items;

import net.chauhanDevs.advance_modder.common.blocks.plate;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class junk_food extends Item {
    public junk_food(Item.Properties prop, int foodId){
		super(prop);
		this.foodId = foodId;
    }
    protected final int foodId;
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Item item = context.getPlayer().getItemInHand(context.getHand()).getItem();
    	plate.updatePlate(context, foodId, item, 0);
        return super.useOn(context);
    }
}
