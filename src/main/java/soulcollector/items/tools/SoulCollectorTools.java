package soulcollector.items.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.bclib.items.tool.BaseSwordItem;
import soulcollector.SoulCollectorMod;
import soulcollector.items.base.*;
import soulcollector.items.tools.dev.BebrockMaterial;
import soulcollector.items.tools.soul.SoulMaterial;
import soulcollector.items.tools.steel.SteelAxe;
import soulcollector.items.tools.steel.SteelHoe;
import soulcollector.items.tools.steel.SteelMaterial;
import soulcollector.items.tools.steel.SteelPickaxe;

import java.util.LinkedHashMap;
import java.util.Map;

public class SoulCollectorTools {
    public static final Map<Identifier, Item> TOOLITEMS = new LinkedHashMap<>();

    public static final ToolItem STEEL_SWORD = add("steel_sword", new SwordItem(SteelMaterial.STEEL_MATERIAL, 0, -2.4f, settings()));
    public static final ToolItem SOUL_SWORD = add("soul_sword", new BaseSwordItem(SoulMaterial.SOUL_MATERIAL, 0, -2f, settings()));
    public static final ToolItem SOUL_BASHER = add("soul_basher", new SoulBasher(SoulMaterial.SOUL_MATERIAL, 2, -3f, settings()));
    public static final ToolItem SOUL_COLLECTOR = add("soul_collector", new SoulCollector(SoulMaterial.SOUL_MATERIAL, 5, -2.4f, settings()));
    public static final ToolItem DRAGON_RAGE = add("dragon_rage", new DragonRage(SoulMaterial.SOUL_MATERIAL, 2, -2.4f, settings()));
    public static final ToolItem TECHNO_BLADE = add("techno_blade", new TechnoBlade(SoulMaterial.SOUL_MATERIAL, -6, -2.4f, settings()));
    public static final Item METAMORPHOSIS = add("metamorphosis", new Metamorphosis(0, -2.4f, BebrockMaterial.BEBROCK_MATERIAL, settings()));
    public static final ToolItem RESPRITE_HAMMER = add("resprite_hammer", new RespriteHammer(BebrockMaterial.BEBROCK_MATERIAL, 989, -3f, settings()));
    public static final ToolItem DULL_KNIFE = add("dull_knife", new DullKnife(BebrockMaterial.BEBROCK_MATERIAL, 19, -3.9f, settings()));
    public static final ToolItem STEEL_SHOVEL = add("steel_shovel", new ShovelItem(SteelMaterial.STEEL_MATERIAL, -1.5f, -3f, settings()));
    public static final ToolItem STEEL_PICKAXE = add("steel_pickaxe", new SteelPickaxe(SteelMaterial.STEEL_MATERIAL,  -2, -2.8f, settings()));
    public static final ToolItem STEEL_AXE = add ("steel_axe", new SteelAxe(SteelMaterial.STEEL_MATERIAL, 3, -3.1f, settings()));
    public static final ToolItem STEEL_HOE = add ("steel_hoe", new SteelHoe(SteelMaterial.STEEL_MATERIAL, -5.5f, -1.67f, settings()));

    private static <I extends ToolItem> I add(String name, I item) {
        TOOLITEMS.put(new Identifier(SoulCollectorMod.MODID, name), item);
        return item;
    }

    private static FabricItemSettings settings(){
        return new FabricItemSettings().group(SoulCollectorMod.ITEM_GROUP_EQUIPMENT);
    }

    public static void register() {
        for (Identifier id : TOOLITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, TOOLITEMS.get(id));
        }
    }
}
