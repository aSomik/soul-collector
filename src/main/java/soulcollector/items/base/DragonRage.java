package soulcollector.items.base;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DragonRage extends SwordItem {
    public DragonRage(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public static int getMode(ItemStack stack){
        return stack.getOrCreateNbt().getInt("dragonRageMode");
    }

    public static void setMode(ItemStack stack, int mode){
        stack.getOrCreateNbt().putInt("dragonRageMode", mode);
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
                setMode(stack, 0);
            }
            return TypedActionResult.success(stack);
        }
        return TypedActionResult.fail(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.soulcoll.dragon_rage.tooltip").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.dragon_rage.tooltip1").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.dragon_rage.tooltip2").formatted(Formatting.DARK_GRAY));
        if(getMode(stack) == 0){
            tooltip.add(new LiteralText("Mode: Melee").formatted(Formatting.DARK_GREEN));
        }
        else if(getMode(stack) == 1){
            tooltip.add(new LiteralText("Mode: Ability").formatted(Formatting.DARK_GREEN));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
