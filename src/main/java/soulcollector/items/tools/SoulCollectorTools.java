package soulcollector.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import soulcollector.MainClassMod;
import soulcollector.items.tools.steel.SteelMaterial;

import java.util.LinkedHashMap;
import java.util.Map;

public class SoulCollectorTools {
    private static final Map<Identifier, Item> TOOLITEMS = new LinkedHashMap<>();

    public static final ToolItem STEEL_SWORD = add("steel_sword", new SwordItem(SteelMaterial.STEEL_MATERIAL, 1, -2.4f, new Item.Settings().group(MainClassMod.ITEM_GROUP_ITEMS)));

    private static <I extends ToolItem> I add(String name, I item) {
        TOOLITEMS.put(new Identifier(MainClassMod.MODID, name), item);
        return item;
    }

    public static void register() {
        for (Identifier id : TOOLITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, TOOLITEMS.get(id));
        }
    }
}
