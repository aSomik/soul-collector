package soulcollector.data;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import soulcollector.items.SoulCollectorItems;

import java.util.ArrayList;
import java.util.Arrays;

public class SoulCollectorLootTables {

    private static FabricLootSupplierBuilder supplier;
    private static Identifier id;

    private static final ArrayList<String> ANCIENT_SOUL_CHESTS = new ArrayList<>(Arrays.asList("abandoned_mineshaft",
            "desert_pyramid", "jungle_temple", "nether_bridge", "ruined_portal", "shipwreck_treasure", "simple_dungeon",
            "stronghold_corridor", "stronghold_crossing", "underwater_ruin_big", "underwater_ruin_small", "woodland_mansion",
            "village_temple"));

    private static final ArrayList<String> STEEL_CHESTS = new ArrayList<>(Arrays.asList("abandoned_mineshaft",
            "jungle_temple", "pillager_outpost", "ruined_portal", "simple_dungeon", "stronghold_corridor",
            "stronghold_crossing", "underwater_ruin_big", "village_armorer", "village_toolsmith", "village_weaponsmith"));

    private static final ArrayList<String> TECHNOBLADE_CHESTS = new ArrayList<>(Arrays.asList("bastion_bridge",
            "bastion_hoglin_stable", "bastion_other", "bastion_treasure", "end_city_treasure", "nether_bridge",
            "ruined_portal", "simple_dungeon"));

    private static final ArrayList<String> SUCCORY_CHESTS = new ArrayList<>(Arrays.asList("village_armorer",
            "village_butcher", "village_cartographer", "village_desert_house", "village_fisher", "village_fletcher",
            "village_mason", "village_plains_house", "village_savanna_house", "village_shepherd", "village_snowy_house",
            "village_taiga_house", "village_tannery", "village_temple", "village_toolsmith", "village_weaponsmith",
            "abandoned_mineshaft", "bastion_bridge", "bastion_hoglin_stable", "bastion_other", "bastion_treasure",
            "buried_treasure", "desert_pyramid", "end_city_treasure", "igloo_chest", "jungle_temple", "jungle_temple_dispenser",
            "nether_bridge", "pillager_outpost", "ruined_portal", "shipwreck_map", "shipwreck_supply", "shipwreck_treasure",
            "simple_dungeon", "spawn_bonus_chest", "stronghold_corridor", "stronghold_crossing", "stronghold_library",
            "underwater_ruin_big", "underwater_ruin_small", "woodland_mansion"));

    public static void register(){

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if(!id.toString().contains("minecraft:chests/")) return;
            SoulCollectorLootTables.id = id;
            SoulCollectorLootTables.supplier = supplier;

            ancientSoulChest(SoulCollectorItems.ANCIENT_SOUL, 0.1f);
            steelChest(SoulCollectorItems.STEEL_INGOT, 0.15f);
            steelChest(SoulCollectorItems.STEEL_NUGGET, 0.35f);
            technobladeChest(SoulCollectorItems.PIG_CROWN, 0.01f);
            succoryChest(SoulCollectorItems.SUCCORY, 0.00001f);
        });
    }

    static void steelChest(Item item, Float chance){
        String chest = id.toString();
        if (isSteelChest(chest)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1)).withCondition(RandomChanceLootCondition.builder(chance).build())
                    .withEntry(ItemEntry.builder(item).build());
            supplier.withPool(poolBuilder.build());
        }
    }

    static void ancientSoulChest(Item item, Float chance){
        String chest = id.toString();
        if (isAncientSoulChest(chest)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1)).withCondition(RandomChanceLootCondition.builder(chance).build())
                    .withEntry(ItemEntry.builder(item).build());
            supplier.withPool(poolBuilder.build());
        }
    }

    static void technobladeChest(Item item, Float chance){
        String chest = id.toString();
        if (isSteelChest(chest)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1)).withCondition(RandomChanceLootCondition.builder(chance).build())
                    .withEntry(ItemEntry.builder(item).build());
            supplier.withPool(poolBuilder.build());
        }
    }

    static void succoryChest(Item item, Float chance){
        String chest = id.toString();
        if (isSuccoryChest(chest)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1)).withCondition(RandomChanceLootCondition.builder(chance).build())
                    .withEntry(ItemEntry.builder(item).build());
            supplier.withPool(poolBuilder.build());
        }
    }

    static boolean isSteelChest(String string){
        for(String chest : STEEL_CHESTS){
            if(string.contains(chest)) return true;
        }
        return false;
    }
    static boolean isAncientSoulChest(String string){
        for(String chest : ANCIENT_SOUL_CHESTS){
            if(string.contains(chest)) return true;
        }
        return false;
    }
    static boolean isTechnobladeChest(String string){
        for(String chest : TECHNOBLADE_CHESTS){
            if(string.contains(chest)) return true;
        }
        return false;
    }
    static boolean isSuccoryChest(String string){
        for(String chest : SUCCORY_CHESTS){
            if(string.contains(chest)) return true;
        }
        return false;
    }
}

