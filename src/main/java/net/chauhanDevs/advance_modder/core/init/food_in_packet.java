package net.chauhanDevs.advance_modder.core.init;

import net.chauhanDevs.advance_modder.common.items.cottage_cheese_packet;
import net.chauhanDevs.advance_modder.common.items.packet;
import net.chauhanDevs.advance_modder.food;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class food_in_packet {
    public static final DeferredRegister<Item> FIP = DeferredRegister.create(ForgeRegistries.ITEMS,
            food.MOD_ID);
    //Food Packets
    public static final RegistryObject<packet> PACKET = FIP.register("packet",
            () -> new packet(blocks.PACKET.get(), new packet.Properties().tab(CreativeModeTab.TAB_FOOD)));

    //Advance Food Packet Items
    public static final RegistryObject<cottage_cheese_packet> COTTAGE_CHEESE_PACKET = FIP.register("cottage_cheese_packet",
            () -> new cottage_cheese_packet(blocks.PACKET.get(), new cottage_cheese_packet.Properties().tab(CreativeModeTab.TAB_FOOD)));

}
