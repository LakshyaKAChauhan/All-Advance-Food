package net.chauhanDevs.advance_modder.core.init;

import net.chauhanDevs.advance_modder.common.blocks.eatable_f_packet_block;
import net.chauhanDevs.advance_modder.common.blocks.plate;
import net.chauhanDevs.advance_modder.common.blocks.test_block;
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
    public static final RegistryObject<Block> COTTAGE_CHEESE_PACKET = BLOCKS.register("cottage_cheese_packet",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT)
                    .strength(0.1f, 0.6f).sound(SoundType.CROP)));

    //BLOCKS
    public static final RegistryObject<plate> PLATE = BLOCKS.register("plate",
            () -> new plate(BlockBehaviour.Properties.of(Material.STONE).noOcclusion().noCollission()));

    public static final RegistryObject<test_block> TEST = BLOCKS.register("test",
            () -> new test_block(BlockBehaviour.Properties.of(Material.BAMBOO)));
    //FOOD ITEMS
    public static final RegistryObject<eatable_f_packet_block> FRENCH_FRIES = BLOCKS.register("french_fries",
            () -> new eatable_f_packet_block(BlockBehaviour.Properties.of(Material.PLANT).noOcclusion().noCollission()));
    //EMPTY PACKETS
    public static final RegistryObject<Block> E_FRENCH_FRIES_PACKET = BLOCKS.register("e_french_fries_packet",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT).noOcclusion().noCollission()));
}
