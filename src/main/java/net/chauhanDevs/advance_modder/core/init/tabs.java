package net.chauhanDevs.advance_modder.core.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public abstract class tabs extends CreativeModeTab {
    public static final tabs UTENSILS = new tabs(CreativeModeTab.TABS.length, "utensils"){
        @OnlyIn(Dist.CLIENT)
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(items.PLATE.get());
        }
    };
    public static final tabs F_ITEMS = new tabs(CreativeModeTab.TABS.length, "f_items"){
        @OnlyIn(Dist.CLIENT)
        @Override
        public @NotNull ItemStack makeIcon(){return new ItemStack(foods.CHEESE_BURGER.get());}
    };
    public tabs(int p_i1853_1_, String p_i1853_2_) {
        super(p_i1853_1_, p_i1853_2_);
    }
}
