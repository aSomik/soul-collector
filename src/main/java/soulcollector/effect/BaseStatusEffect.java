package soulcollector.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class BaseStatusEffect extends StatusEffect{
    protected BaseStatusEffect(StatusEffectType type, int color) {
        super(type, color);
    }
}
