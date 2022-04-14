package net.chauhanDevs.advance_modder.common.items;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class cottage_cheese_packet extends packet {
    public cottage_cheese_packet(Block block, Properties prop) {
        super(block, prop);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        var player = context.getPlayer();
        var level = Objects.requireNonNull(player).level;
        BlockState block = level.getBlockState((context.getClickedPos()));
        return super.useOn(context);
    }
}
