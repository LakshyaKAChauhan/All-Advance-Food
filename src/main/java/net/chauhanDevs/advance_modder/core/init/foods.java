package net.chauhanDevs.advance_modder.core.init;

import net.chauhanDevs.advance_modder.food;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class foods {
    public static final DeferredRegister<Item> FOODS = DeferredRegister.create(ForgeRegistries.ITEMS,
            food.MOD_ID);
    public static final RegistryObject<Item> CHEESE_BURGER = FOODS.register("cheese_burger",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().build())));
}
