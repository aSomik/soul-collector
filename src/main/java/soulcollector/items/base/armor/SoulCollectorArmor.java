package soulcollector.items.base.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.bclib.items.BaseArmorItem;
import soulcollector.SoulCollectorMod;
import soulcollector.api.armor.ArmorEffectRegistry;
import soulcollector.effect.SoulCollectorEffects;

public class SoulCollectorArmor {

    public static final ArmorMaterial STEEL_ARMOR_MATERIAL = new SteelArmorMaterial();
    public static final ArmorMaterial SOUL_ARMOR_MATERIAL = new SoulArmorMaterial();
    public static final Item STEEL_HELMET = new BaseArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(SoulCollectorMod.ITEM_GROUP_EQUIPMENT));
    public static final Item STEEL_CHESTPLATE = new BaseArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(SoulCollectorMod.ITEM_GROUP_EQUIPMENT));
    public static final Item STEEL_LEGGINGS = new BaseArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(SoulCollectorMod.ITEM_GROUP_EQUIPMENT));
    public static final Item STEEL_BOOTS = new BaseArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(SoulCollectorMod.ITEM_GROUP_EQUIPMENT));
    public static final Item SOUL_HELMET = new BaseArmorItem(SOUL_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(SoulCollectorMod.ITEM_GROUP_EQUIPMENT));
    public static final Item SOUL_CHESTPLATE = new BaseArmorItem(SOUL_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(SoulCollectorMod.ITEM_GROUP_EQUIPMENT));
    public static final Item SOUL_LEGGINGS = new BaseArmorItem(SOUL_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(SoulCollectorMod.ITEM_GROUP_EQUIPMENT));
    public static final Item SOUL_BOOTS = new BaseArmorItem(SOUL_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(SoulCollectorMod.ITEM_GROUP_EQUIPMENT));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(SoulCollectorMod.MODID, "steel_helmet"), STEEL_HELMET);
        Registry.register(Registry.ITEM, new Identifier(SoulCollectorMod.MODID, "steel_chestplate"), STEEL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(SoulCollectorMod.MODID, "steel_leggings"), STEEL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(SoulCollectorMod.MODID, "steel_boots"), STEEL_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(SoulCollectorMod.MODID, "soul_helmet"), SOUL_HELMET);
        Registry.register(Registry.ITEM, new Identifier(SoulCollectorMod.MODID, "soul_chestplate"), SOUL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(SoulCollectorMod.MODID, "soul_leggings"), SOUL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(SoulCollectorMod.MODID, "soul_boots"), SOUL_BOOTS);
        registerArmorEffects();
    }
    static void registerArmorEffects() {
        ArmorEffectRegistry.register("Soul Armor Set", SOUL_HELMET, SOUL_CHESTPLATE, SOUL_LEGGINGS, SOUL_BOOTS, SoulCollectorEffects.SOUL_POWER, 0);
    }
}

