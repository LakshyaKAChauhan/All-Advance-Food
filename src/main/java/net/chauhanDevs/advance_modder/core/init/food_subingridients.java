package net.chauhanDevs.advance_modder.core.init;

import net.chauhanDevs.advance_modder.common.items.cottage_cheese_packet;
import net.chauhanDevs.advance_modder.food;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class food_subingridients {
    public static final DeferredRegister<Item> SUB_I = DeferredRegister.create(ForgeRegistries.ITEMS,
            food.MOD_ID);

    //Cheese
     static final RegistryObject<Item> CHEESE_SLICE = SUB_I.register("cheese_slice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().build()).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> CHEESE_CUBE = SUB_I.register("cheese_cube",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().build()).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> GRATED_CHEESE = SUB_I.register("grated_cheese",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().build()).tab(CreativeModeTab.TAB_FOOD)));

}
