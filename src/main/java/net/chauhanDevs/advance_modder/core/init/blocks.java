package net.chauhanDevs.advance_modder.core.init;

import net.chauhanDevs.advance_modder.food;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            food.MOD_ID);

    public static final RegistryObject<Block> PACKET = BLOCKS.register("packet",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT)
                    .strength(0.1f, 0.6f).sound(SoundType.CROP)));
}
