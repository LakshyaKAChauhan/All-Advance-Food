package net.chauhanDevs.advance_modder.misc.Objects;

import net.chauhanDevs.advance_modder.core.init.food_in_packet;
import net.chauhanDevs.advance_modder.core.init.foods;
import net.minecraft.world.item.Item;

public class FoodItem {

    protected final Item item;
    public FoodItem(int id){
        this.item = getItemById(id);
    }
    public final Item getItemById(int id){
        if(id == 0){
            throw new IllegalArgumentException("Food Id Cannot Be 0! O Represents Empty Plate.\nIf You Are Making An Addon.\nThe Error is You Can't set The Parameter to 0\n0 Represents Empty Plate In This Mod");
        }else if(id < 0){
            throw new IllegalArgumentException("Food Id Can't Be Less Than 1!\nIt Is "+ id);
        }else{
            return switch (id) {
                case 1 -> foods.CHEESE_BURGER.get();
                case 2 -> food_in_packet.FRENCH_FRIES.get();
                default -> throw new IllegalStateException("Unexpected value: " + id);
            };
        }
    }
    public final Item getItem(){
        return this.item;
    }
}
