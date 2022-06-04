package net.chauhanDevs.advance_modder.common.events;

import net.chauhanDevs.advance_modder.food;
import net.chauhanDevs.advance_modder.client.KeyBindingsInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = food.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class inputEvents {
    
	@SubscribeEvent
	public static void clientTick(ClientTickEvent event) {
		if(KeyBindingsInit.ExtractItemInPlateFromPacketInHand.isDown()) {
			System.out.println("That Key Pressed!");
		}
	}
}