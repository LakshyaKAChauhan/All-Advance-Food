package net.chauhanDevs.advance_modder.core.init;

import net.chauhanDevs.advance_modder.common.items.junk_food;
import net.chauhanDevs.advance_modder.food;
import net.minecraft.world.effect.MobEffectInstance;
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
            () -> new junk_food(new junk_food.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().effect(() -> new MobEffectInstance(effects.ENERGY.get(), 1400, 2),
                            2f)
                            .effect(() -> new MobEffectInstance(effects.TASTINESS.get(),
                                    1300, 1), 0f).build())));
}
