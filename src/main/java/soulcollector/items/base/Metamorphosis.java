package soulcollector.items.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Metamorphosis extends MiningToolItem {

    public Metamorphosis(float attackDamage, float attackSpeed, ToolMaterial material, Settings settings) {
        super(attackDamage, attackSpeed, material, BlockTags.AXE_MINEABLE, settings);
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if(getMode(stack) == 0){
            return 1.0f;
        }
        else if(getMode(stack) == 1){
            return BlockTags.PICKAXE_MINEABLE.contains(state.getBlock()) ? this.miningSpeed : 1.0F;
        }
        else if(getMode(stack) == 2){
            return BlockTags.AXE_MINEABLE.contains(state.getBlock()) ? this.miningSpeed : 1.0F;
        }
        else if(getMode(stack) == 3){
            return BlockTags.SHOVEL_MINEABLE.contains(state.getBlock()) ? this.miningSpeed : 1.0F;
        }
        else if(getMode(stack) == 4){
            return BlockTags.HOE_MINEABLE.contains(state.getBlock()) ? this.miningSpeed : 1.0F;
        }
        return 1.0F;
    }

    public static int getMode(ItemStack stack){
        return stack.getOrCreateNbt().getInt("metamorphosisMode");
    }

    public static void setMode(ItemStack stack, int mode){
        stack.getOrCreateNbt().putInt("metamorphosisMode", mode);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient) return TypedActionResult.fail(user.getStackInHand(hand));
        if(user.isSneaking()){
            ItemStack stack = user.getStackInHand(hand);
            if(getMode(stack) == 0){
                setMode(stack, 1);
            }
            else if(getMode(stack) == 1){
                setMode(stack, 2);
            }
            else if(getMode(stack) == 2){
                setMode(stack, 3);
            }
            else if(getMode(stack) == 3){
                setMode(stack, 4);
            }
            else if(getMode(stack) == 4){
                setMode(stack, 0);
            }
            return TypedActionResult.success(stack);
        }
        return TypedActionResult.fail(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.soulcoll.metamorphosis.tooltip").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.metamorphosis.tooltip1").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.metamorphosis.tooltip2").formatted(Formatting.DARK_GRAY));
        if(getMode(stack) == 0){
            tooltip.add(new LiteralText("Mode: Sword").formatted(Formatting.DARK_GREEN));
        }
        else if(getMode(stack) == 1){
            tooltip.add(new LiteralText("Mode: Pickaxe").formatted(Formatting.DARK_GREEN));
        }
        else if(getMode(stack) == 2) {
            tooltip.add(new LiteralText("Mode: Axe").formatted(Formatting.DARK_GREEN));
        }
        else if(getMode(stack) == 3) {
            tooltip.add(new LiteralText("Mode: Shovel").formatted(Formatting.DARK_GREEN));
        }
        else if(getMode(stack) == 4) {
            tooltip.add(new LiteralText("Mode: Hoe").formatted(Formatting.DARK_GREEN));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
