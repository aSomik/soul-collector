package soulcollector;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import soulcollector.event.PlayerAdvancementEvent;
import soulcollector.items.SoulCollectorItems;
import soulcollector.items.base.armor.SoulCollectorArmor;
import soulcollector.items.tools.SoulCollectorTools;

public class MainClassMod implements ModInitializer {

	public static final String MODID = "soulcoll";

	public static final ItemGroup ITEM_GROUP_ITEMS = FabricItemGroupBuilder.build(
			new Identifier(MODID, "items"),
			() -> new ItemStack(SoulCollectorItems.STEEL_INGOT));

	public static final ItemGroup ITEM_GROUP_EQUIPMENT = FabricItemGroupBuilder.build(
			new Identifier(MODID, "equip"),
			() -> new ItemStack(SoulCollectorTools.STEEL_SWORD));

	public static final ItemGroup ITEM_GROUP_SOULS = FabricItemGroupBuilder.build(
			new Identifier(MODID, "souls"),
			() -> new ItemStack(SoulCollectorItems.ANCIENT_SOUL));

	@Override
	public void onInitialize() {
		SoulCollectorArmor.register();
		SoulCollectorItems.register();
		SoulCollectorTools.register();

		PlayerAdvancementEvent.EVENT.register((player, advancement) -> {
			Identifier advancementId = new Identifier("minecraft:end/kill_dragon");
			if(advancementId.equals(advancement.getId())){
				player.giveItemStack(SoulCollectorTools.DRAGON_RAGE.getDefaultStack());
			}
		});
	}
}
