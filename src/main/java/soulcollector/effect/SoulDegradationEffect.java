package soulcollector.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SoulDegradationEffect extends BaseStatusEffect{
    public SoulDegradationEffect(StatusEffectCategory type, int color) {
        super(type, color);
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier){
        entity.damage(DamageSource.MAGIC, 1.0F);
    }
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return duration % 40 == 0;
    }
}
