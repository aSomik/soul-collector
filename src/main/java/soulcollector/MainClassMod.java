package soulcollector;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import soulcollector.blocks.SoulCollectorBlocks;
import soulcollector.data.SoulCollectorLootTables;
import soulcollector.effect.SoulCollectorEffects;
import soulcollector.event.PlayerAdvancementEvent;
import soulcollector.event.SoulCollectorEvents;
import soulcollector.fluid.SoulCollectorFluids;
import soulcollector.items.SoulCollectorItems;
import soulcollector.items.base.armor.SoulCollectorArmor;
import soulcollector.items.tools.SoulCollectorTools;
import soulcollector.worldgen.SoulCollectorConfiguredFeatures;

public class MainClassMod implements ModInitializer {

	public static final String MODID = "soulcoll";

	public static final ItemGroup ITEM_GROUP_ITEMS = FabricItemGroupBuilder.build(
			newId("items"),
			() -> new ItemStack(SoulCollectorItems.STEEL_INGOT));

	public static final ItemGroup ITEM_GROUP_EQUIPMENT = FabricItemGroupBuilder.build(
			newId("equip"),
			() -> new ItemStack(SoulCollectorTools.STEEL_SWORD));

	public static final ItemGroup ITEM_GROUP_SOULS = FabricItemGroupBuilder.build(
			newId("souls"),
			() -> new ItemStack(SoulCollectorItems.ANCIENT_SOUL));

	public static final ItemGroup ITEM_GROUP_BLOCKS = FabricItemGroupBuilder.build(
			newId("blocks"),
			() -> new ItemStack(SoulCollectorBlocks.SINGULARITY_ORE));

	@Override
	public void onInitialize() {
		SoulCollectorArmor.register();
		SoulCollectorItems.register();
		SoulCollectorTools.register();
		SoulCollectorFluids.register();
		SoulCollectorBlocks.register();
		SoulCollectorEvents.register();
		SoulCollectorEffects.register();
		SoulCollectorLootTables.register();
		SoulCollectorConfiguredFeatures.register();

		PlayerAdvancementEvent.EVENT.register((player, advancement) -> {
			Identifier advancementId = new Identifier("minecraft:end/kill_dragon");
			if(advancementId.equals(advancement.getId())){
				player.giveItemStack(SoulCollectorTools.DRAGON_RAGE.getDefaultStack());
			}
		});
	}

	public static Identifier newId(String path){
		return new Identifier(MODID, path);
	}
}
