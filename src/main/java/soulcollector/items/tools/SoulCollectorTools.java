package soulcollector.items.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import soulcollector.MainClassMod;
import soulcollector.items.tools.soul.SoulMaterial;
import soulcollector.items.tools.steel.SteelAxe;
import soulcollector.items.tools.steel.SteelHoe;
import soulcollector.items.tools.steel.SteelMaterial;
import soulcollector.items.tools.steel.SteelPickaxe;

import java.util.LinkedHashMap;
import java.util.Map;

public class SoulCollectorTools {
    private static final Map<Identifier, Item> TOOLITEMS = new LinkedHashMap<>();

    public static final ToolItem STEEL_SWORD = add("steel_sword", new SwordItem(SteelMaterial.STEEL_MATERIAL, 0, -2.4f, settings()));
    public static final ToolItem SOUL_SWORD = add("soul_seeker", new SwordItem(SoulMaterial.SOUL_MATERIAL, 0, -2.4f, settings()));
    public static final ToolItem STEEL_SHOVEL = add("steel_shovel", new ShovelItem(SteelMaterial.STEEL_MATERIAL, -1.5f, -3f, settings()));
    public static final ToolItem STEEL_PICKAXE = add("steel_pickaxe", new SteelPickaxe(SteelMaterial.STEEL_MATERIAL,  -2, -2.8f, settings()));
    public static final ToolItem STEEL_AXE = add ("steel_axe", new SteelAxe(SteelMaterial.STEEL_MATERIAL, 3, -3.1f, settings()));
    public static final ToolItem STEEL_HOE = add ("steel_hoe", new SteelHoe(SteelMaterial.STEEL_MATERIAL, -5.5f, -1.67f, settings()));

    private static <I extends ToolItem> I add(String name, I item) {
        TOOLITEMS.put(new Identifier(MainClassMod.MODID, name), item);
        return item;
    }

    private static FabricItemSettings settings(){
        return new FabricItemSettings().group(MainClassMod.ITEM_GROUP_EQUIPMENT);
    }

    public static void register() {
        for (Identifier id : TOOLITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, TOOLITEMS.get(id));
        }
    }
}
