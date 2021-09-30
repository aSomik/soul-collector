package soulcollector.items.tools.steel;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import soulcollector.items.SoulCollectorItems;

public class SteelMaterial implements ToolMaterial {
    public static final SteelMaterial STEEL_MATERIAL = new SteelMaterial();

    @Override
    public int getDurability() {
        return 400;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.0F;
    }

    @Override
    public float getAttackDamage() {
        return 5.5F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(SoulCollectorItems.STEEL_INGOT);
    }
}
