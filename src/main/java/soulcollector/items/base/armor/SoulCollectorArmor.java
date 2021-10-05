package soulcollector.items.base.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import soulcollector.MainClassMod;

public class SoulCollectorArmor {

    public static final ArmorMaterial STEEL_ARMOR_MATERIAL = new SteelArmorMaterial();
    public static final Item STEEL_HELMET = new ArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(MainClassMod.ITEM_GROUP_EQUIPMENT));
    public static final Item STEEL_CHESTPLATE = new ArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(MainClassMod.ITEM_GROUP_EQUIPMENT));
    public static final Item STEEL_LEGGINGS = new ArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(MainClassMod.ITEM_GROUP_EQUIPMENT));
    public static final Item STEEL_BOOTS = new ArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(MainClassMod.ITEM_GROUP_EQUIPMENT));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MainClassMod.MODID, "steel_helmet"), STEEL_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MainClassMod.MODID, "steel_chestplate"), STEEL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MainClassMod.MODID, "steel_leggings"), STEEL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MainClassMod.MODID, "steel_boots"), STEEL_BOOTS);
    }

}
