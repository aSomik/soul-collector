package soulcollector.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import soulcollector.MainClassMod;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class SoulCollectorEffects {
    public static final Map<Identifier, StatusEffect> EFFECTS = new LinkedHashMap<>();

    public static final StatusEffect SOUL_DEGRADATION = add("soul_degradation", new SoulDegradationEffect(StatusEffectCategory.HARMFUL, 0x704e0)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "401B7E66-F01A-4DF4-8F2D-1728082A1F1B" , -0.25F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "86574fa5-10e4-4d54-a4cb-d4d391121e08", -2F, EntityAttributeModifier.Operation.ADDITION));

    private static StatusEffect add(String name, StatusEffect effect) {
        EFFECTS.put(new Identifier("soulcoll", name), effect);
        return effect;
    }

    public static void register() {
        EFFECTS.forEach((id, effect) -> Registry.register(Registry.STATUS_EFFECT, id, effect));
    }
}

