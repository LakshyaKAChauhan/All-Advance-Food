package net.chauhanDevs.advance_modder.core.init;

import net.chauhanDevs.advance_modder.food;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class items {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS,
            food.MOD_ID);
    public static final RegistryObject<BlockItem> PLATE = ITEM.register("plate",
            () -> new BlockItem(blocks.PLATE.get(), new BlockItem.Properties().tab(tabs.UTENSILS)));
}
