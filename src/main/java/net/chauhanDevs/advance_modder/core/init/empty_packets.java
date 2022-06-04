package net.chauhanDevs.advance_modder.core.init;

import net.chauhanDevs.advance_modder.common.items.e_packet;
import net.chauhanDevs.advance_modder.food;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class empty_packets {
    public static final DeferredRegister<Item> E_PACKET = DeferredRegister.create(ForgeRegistries.ITEMS,
            food.MOD_ID);

    public static final RegistryObject<e_packet> E_FRENCH_FRIES_PACKET = E_PACKET.register("e_french_fries_packet",
            () -> new e_packet(blocks.E_FRENCH_FRIES_PACKET.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1), 3));
}
