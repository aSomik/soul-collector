package soulcollector.items.base;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TechnoBlade extends SwordItem {
    public TechnoBlade(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public static void setKillCount(ItemStack stack, int count){
        stack.getOrCreateNbt().putInt("killCount", count);
    }

    public static int getKillCount(ItemStack stack){
        return stack.getOrCreateNbt().getInt("killCount");
    }

    public static int getDamage(ItemStack stack){
        int count = getKillCount(stack);
        float damage = (float)count/501;
        return (int) damage;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
        target.damage(DamageSource.mob(attacker), getDamage(stack));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.soulcoll.techno_blade.tooltip").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.techno_blade.tooltip1").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.techno_blade.tooltip2").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.techno_blade.tooltip3").formatted(Formatting.DARK_GRAY, Formatting.ITALIC));
        tooltip.add(new LiteralText("Counter: " + getKillCount(stack)).formatted(Formatting.DARK_GREEN));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
