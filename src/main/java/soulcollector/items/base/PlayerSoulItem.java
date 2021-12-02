package soulcollector.items.base;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;

public class PlayerSoulItem extends SoulItem {
    public final String name;
    public PlayerSoulItem(Settings settings, String name) {
        super(settings, EntityType.PLAYER);
        this.name = name;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(!name.isEmpty()){
            tooltip.add(new TranslatableText("item.soulcoll.player_soul.tooltip." + name.toLowerCase()).formatted(Formatting.DARK_GRAY));
            tooltip.add(new TranslatableText("item.soulcoll.player_soul.tooltip1." + name.toLowerCase()).formatted(Formatting.DARK_GRAY));
            tooltip.add(new TranslatableText("item.soulcoll.player_soul.tooltip2." + name.toLowerCase()).formatted(Formatting.DARK_GRAY));
        }
        tooltip.add(new TranslatableText("item.soulcoll.player_soul.tooltip").formatted(Formatting.DARK_GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
