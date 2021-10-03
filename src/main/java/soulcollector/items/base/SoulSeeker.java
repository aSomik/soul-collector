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

public class SoulSeeker extends Item {
    public SoulSeeker(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.soulcoll.soul_seeker.tooltip").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.soul_seeker.tooltip1").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.soul_seeker.tooltip2").formatted(Formatting.DARK_GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
