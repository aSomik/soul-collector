package soulcollector.items.base;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DullKnife extends SwordItem {
    public DullKnife(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.soulcoll.dull_knife.tooltip"));
        tooltip.add(new TranslatableText("item.soulcoll.dull_knife.tooltip1"));
        tooltip.add(new TranslatableText("item.soulcoll.dull_knife.tooltip2"));
        tooltip.add(new TranslatableText("item.soulcoll.dull_knife.tooltip3"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
