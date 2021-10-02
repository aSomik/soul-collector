package soulcollector.items.tools.soul;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import soulcollector.items.SoulCollectorItems;
import soulcollector.items.tools.steel.SteelMaterial;

public class SoulMaterial implements ToolMaterial {
    public static final SoulMaterial SOUL_MATERIAL = new SoulMaterial();

    @Override
    public int getDurability() {
        return 1111;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 6;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {return Ingredient.ofItems(SoulCollectorItems.SOUL_INGOT);
    }
}
