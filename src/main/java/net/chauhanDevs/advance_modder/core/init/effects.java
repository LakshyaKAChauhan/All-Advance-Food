package net.chauhanDevs.advance_modder.core.init;

import net.chauhanDevs.advance_modder.common.effects.energy;
import net.chauhanDevs.advance_modder.common.effects.tastiness;
import net.chauhanDevs.advance_modder.food;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class effects {
    public static final DeferredRegister<MobEffect> EFF = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,
            food.MOD_ID);

    public static final RegistryObject<tastiness> TASTINESS = EFF.register("tastiness",
            () -> new tastiness(MobEffectCategory.NEUTRAL, 189882));
    public static final RegistryObject<energy> ENERGY = EFF.register("energy",
            () -> new energy(MobEffectCategory.BENEFICIAL, 145219));
}
