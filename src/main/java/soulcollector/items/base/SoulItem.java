package soulcollector.items.base;

import net.minecraft.entity.EntityType;

public class SoulItem extends BaseItem{

    public final EntityType<?> entityType;
    public SoulItem(Settings settings, EntityType<?> entity) {
        super(settings);
        this.entityType=entity;
    }
}
