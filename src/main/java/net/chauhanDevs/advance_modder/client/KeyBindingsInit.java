package net.chauhanDevs.advance_modder.client;

import java.awt.event.KeyEvent;

import net.chauhanDevs.advance_modder.food;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


public final class KeyBindingsInit {
	
	public static KeyMapping ExtractItemInPlateFromPacketInHand;

	public static void register(FMLClientSetupEvent event) {
		ExtractItemInPlateFromPacketInHand = create("eiipfpih", KeyEvent.VK_NUMPAD1, "afc");
		
		ClientRegistry.registerKeyBinding(ExtractItemInPlateFromPacketInHand);
	}
	
	
	private static KeyMapping create(String name, int key, String category){
        return new KeyMapping("key." + food.MOD_ID + "." + name, key, "key.category." + category);
    }
}
