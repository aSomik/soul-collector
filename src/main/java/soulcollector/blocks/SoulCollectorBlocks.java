package soulcollector.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import soulcollector.SoulCollectorMod;
import soulcollector.blocks.base.BaseFluidBlock;
import soulcollector.blocks.base.SoulCollectorBaseBlock;
import soulcollector.fluid.SoulCollectorFluids;

import java.util.LinkedHashMap;
import java.util.Map;

public class SoulCollectorBlocks {

    public static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    public static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    public static final Block SINGULARITY_ORE = add("singularity_ore", new SoulCollectorBaseBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)));
    public static final Block DEEPSLATE_SINGULARITY_ORE = add("deepslate_singularity_ore", new SoulCollectorBaseBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final Block BEBROCK_ORE = add("bebrock_ore", new SoulCollectorBaseBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));
    public static final Block BEBRBLOCK = add("bebrblock", new SoulCollectorBaseBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    public static Block MELIS = add("melis", new BaseFluidBlock(SoulCollectorFluids.STILL_MELIS, FabricBlockSettings.copyOf(Blocks.LAVA)));

    private static Block add(String name, Block block) {
        Item.Settings settings = new Item.Settings();
        settings.group(SoulCollectorMod.ITEM_GROUP_BLOCKS);
        return addBlockItem(name, block, new BlockItem(block, settings));
    }

    private static Block addBlockItem(String name, Block block, BlockItem item) {
        addBlock(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(SoulCollectorMod.newId(name), item);
        }
        return block;
    }

    private static Block addBlock(String name, Block block) {
        BLOCKS.put(SoulCollectorMod.newId(name), block);
        return block;
    }

    public static void register() {
        ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, ITEMS.get(id)));
        BLOCKS.forEach((id, block) -> Registry.register(Registry.BLOCK, id, BLOCKS.get(id)));
    }
}
