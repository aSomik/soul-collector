package soulcollector.items.base;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Singularity extends Item {
    public Singularity(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.soulcoll.singularity.tooltip").formatted(Formatting.DARK_GRAY).formatted(Formatting.OBFUSCATED));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
