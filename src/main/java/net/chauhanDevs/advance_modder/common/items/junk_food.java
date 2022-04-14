package net.chauhanDevs.advance_modder.common.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import javax.annotation.Nullable;

public class junk_food extends Item {
    public junk_food(junk_food.Properties prop){
        super(prop);
    }
    public static class Properties extends Item.Properties{
        public float happiness = 0;
        public float energy = 0;
        int maxStackSize = 64;
        int maxDamage;
        @Nullable
        Item craftingRemainingItem;
        @Nullable
        CreativeModeTab category;
        Rarity rarity = Rarity.COMMON;
        @Nullable
        FoodProperties foodProperties;
        boolean isFireResistant;
        private boolean canRepair = true;

        public junk_food.Properties food(FoodProperties p_41490_) {
            this.foodProperties = p_41490_;
            return this;
        }

        public junk_food.Properties stacksTo(int p_41488_) {
            if (this.maxDamage > 0) {
                throw new RuntimeException("Unable to have damage AND stack.");
            } else {
                this.maxStackSize = p_41488_;
                return this;
            }
        }

        public junk_food.Properties defaultDurability(int p_41500_) {
            return this.maxDamage == 0 ? this.durability(p_41500_) : this;
        }

        public junk_food.Properties durability(int p_41504_) {
            this.maxDamage = p_41504_;
            this.maxStackSize = 1;
            return this;
        }

        public junk_food.Properties craftRemainder(Item p_41496_) {
            this.craftingRemainingItem = p_41496_;
            return this;
        }

        public junk_food.Properties tab(CreativeModeTab p_41492_) {
            this.category = p_41492_;
            return this;
        }

        public junk_food.Properties rarity(Rarity p_41498_) {
            this.rarity = p_41498_;
            return this;
        }

        public junk_food.Properties fireResistant() {
            this.isFireResistant = true;
            return this;
        }

        public junk_food.Properties setNoRepair() {
            canRepair = false;
            return this;
        }
        public void setHappiness(float happiness){
            this.happiness = happiness;
        }
        public void setEnergy(float energy){
            this.energy = energy;
        }
    }
}
