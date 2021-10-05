package soulcollector.items.tools.dev;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import soulcollector.items.SoulCollectorItems;

public class BebrockMaterial implements ToolMaterial {
    public static final BebrockMaterial BEBROCK_MATERIAL = new BebrockMaterial();

    @Override
    public int getDurability() {
        return 9999;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 20.0f;
    }

    @Override
    public float getAttackDamage() {
        return 9;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 99;
    }

    @Override
    public Ingredient getRepairIngredient() {return Ingredient.ofItems(SoulCollectorItems.BEBROCK);}
}
