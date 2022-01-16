package soulcollector.items.base.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import soulcollector.items.SoulCollectorItems;

public class SoulArmorMaterial implements ArmorMaterial {

    private static final int[] BASE_DURABILITY = new int[] {255, 411, 353, 290};
    private static final int[] PROTECTION_VALUES = new int[] {2, 7, 6, 3};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(SoulCollectorItems.SOUL_INGOT);
    }

    @Override
    public String getName() {
        return "soul";
    }

    @Override
    public float getToughness() {
        return 1.5f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
