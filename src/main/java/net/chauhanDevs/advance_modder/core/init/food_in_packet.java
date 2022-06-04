package net.chauhanDevs.advance_modder.core.init;

import net.chauhanDevs.advance_modder.common.items.cottage_cheese_packet;
import net.chauhanDevs.advance_modder.common.items.f_packet;
import net.chauhanDevs.advance_modder.food;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class food_in_packet {
    public static final DeferredRegister<Item> FIP = DeferredRegister.create(ForgeRegistries.ITEMS,
            food.MOD_ID);

    //Advance Food Packet Items
    public static final RegistryObject<cottage_cheese_packet> COTTAGE_CHEESE_PACKET = FIP.register("cottage_cheese_packet",
            () -> new cottage_cheese_packet(blocks.COTTAGE_CHEESE_PACKET.get(), new cottage_cheese_packet.Properties().tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<f_packet> FRENCH_FRIES = FIP.register("french_fries",
            () -> new f_packet(blocks.FRENCH_FRIES.get(), new Item.Properties()
            		.food(new FoodProperties.Builder().build())
            		.tab(CreativeModeTab.TAB_FOOD).stacksTo(1),
            		empty_packets.E_FRENCH_FRIES_PACKET.get(), 2));
}
