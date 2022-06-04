package soulcollector.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BaseStatusEffect extends StatusEffect{
    protected BaseStatusEffect(StatusEffectCategory type, int color) {
        super(type, color);
    }
}
