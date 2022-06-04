package net.chauhanDevs.advance_modder.common.blocks;

import net.chauhanDevs.advance_modder.core.init.blocks;
import net.chauhanDevs.advance_modder.misc.Objects.FoodItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class plate extends Block {
    public static final BooleanProperty isWithPacket = BooleanProperty.create("is_with_packet");
    public static final IntegerProperty foodId = IntegerProperty.create("food", 1, 5);

    public plate(BlockBehaviour.Properties p) {
        super(p);
        registerDefaultState(this.defaultBlockState().setValue(foodId, 1).setValue(isWithPacket, false));
    }
    //overridden methods
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(isWithPacket);
        state.add(foodId);
        super.createBlockStateDefinition(state);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level,
                                          @NotNull BlockPos pos, @NotNull Player player,
                                          @NotNull InteractionHand hand,
                                          @NotNull BlockHitResult result) {
        if(player.getItemInHand(hand).is(Items.AIR)){
            if(state.getValue(foodId) - 1 > 0) {
                FoodItem foodI = removeFood(level, pos, state);
                ItemStack stack = foodI.getItem().getDefaultInstance();
                stack.setCount(1);
                player.setItemInHand(hand, stack);
            }
        }
        return super.use(state, level, pos, player, hand, result);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_,
                               BlockPos p_60557_, CollisionContext p_60558_) {
        return Block.box(0, 0, 0, 16, 2, 16);
    }

    //custom methods
    public static boolean isEmpty(BlockState state) {
        return state.getValue(foodId) == 1;
    }
    private static void setFood(int id, boolean withPacket,  Level level, BlockPos pos, BlockState state){
        level.setBlock(pos, state.setValue(foodId, id + 1).setValue(isWithPacket, withPacket), 3);
    }
    private static FoodItem removeFood(Level level, BlockPos pos, BlockState state){
        level.setBlockAndUpdate(pos, state.getBlock().defaultBlockState().setValue(foodId, 0));
        int id = (plate.getFoodIdByState(state) - 1);
        return new FoodItem(id);
    }
    public static int getFoodIdByState(BlockState state){
        return state.getValue(foodId);
    }
    public static void updatePlate(UseOnContext context, int withFood, Item replaceWith, int foodType) {
    	BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        assert player != null;
        Item item = player.getItemInHand(hand).getItem();
        int val = player.getItemInHand(hand).getCount();
        if(state.is(blocks.PLATE.get())){
            ItemStack stack;
        	if(plate.isEmpty(state)) {
                if(player.isCrouching()) {
                    plate.setFood(withFood, true, level, pos, state);
                    if(val <= 0) {
                        stack = new ItemStack(Items.AIR);
                    }else {
                        stack = new ItemStack(item);
                        stack.setCount(val - 1);
                    }
                }else{
                    plate.setFood(withFood, false, level, pos, state);
                    if(val <= 0) {
                        stack = new ItemStack(Items.AIR);
                    }else{
                        if(foodType == 0){
                            stack = new ItemStack(replaceWith);
                            stack.setCount(val - 1);
                        }else{
                            stack = new ItemStack(replaceWith);
                            stack.setCount(1);
                        }

                    }
                }
	            player.setItemInHand(hand, stack);
        	}
        	
        }
    }
}