package soulcollector.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import soulcollector.MainClassMod;
import soulcollector.items.base.BaseItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class SoulCollectorItems {
    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item STEEL_INGOT = add("steel_ingot", new BaseItem(settings()));

    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(new Identifier(MainClassMod.MODID, name), item);
        return item;
    }

    private static FabricItemSettings settings(){
        return new FabricItemSettings().group(MainClassMod.ITEM_GROUP_ITEMS);
    }

    public static void register() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
    }
}
