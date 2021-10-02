package soulcollector.items.tools.steel;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class SteelHoe extends HoeItem {
    public SteelHoe(ToolMaterial material, float attackDamage1, float attackSpeed, Settings settings) {
        super(material, (int) attackDamage1, attackSpeed, settings);
    }
}
