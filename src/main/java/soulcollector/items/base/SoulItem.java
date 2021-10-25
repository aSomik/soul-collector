package soulcollector.items.base;

import net.minecraft.entity.EntityType;
import ru.bclib.items.ModelProviderItem;

public class SoulItem extends ModelProviderItem {

    public final EntityType<?>[] entityTypes;
    public SoulItem(Settings settings, EntityType<?> entity) {
        super(settings);
        this.entityTypes = new EntityType[]{entity};
    }
    public SoulItem(Settings settings, EntityType<?>[] enTITIes) {
        super(settings);
        this.entityTypes = enTITIes;
    }
}
