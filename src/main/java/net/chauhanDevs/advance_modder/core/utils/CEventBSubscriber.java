package net.chauhanDevs.advance_modder.core.utils;

import net.chauhanDevs.advance_modder.food;
import net.chauhanDevs.advance_modder.client.KeyBindingsInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = food.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CEventBSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        KeyBindingsInit.register(event);
    }
}

