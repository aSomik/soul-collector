package soulcollector.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class SoulCollectorEffects {
    public static final Map<Identifier, StatusEffect> EFFECTS = new LinkedHashMap<>();

    public static final StatusEffect SOUL_DEGRADATION = add("soul_degradation", new SoulDegradationEffect(StatusEffectCategory.HARMFUL, 0x3c002d)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "401b7e66-f01a-4df4-8f2d-1728082a1f1b" , -0.25F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "86574fa5-10e4-4d54-a4cb-d4d391121e08", -2F, EntityAttributeModifier.Operation.ADDITION));

    public static final StatusEffect SOUL_POWER = add("soul_power", new BaseStatusEffect(StatusEffectCategory.BENEFICIAL, 0x7180ac)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "67664da1-e750-4bfc-a5c5-9595d3d9938d", 0.1F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "939abe04-03c9-4f61-b13f-7d7c72bd5641", 1F, EntityAttributeModifier.Operation.ADDITION));

    private static StatusEffect add(String name, StatusEffect effect) {
        EFFECTS.put(new Identifier("soulcoll", name), effect);
        return effect;
    }

    public static void register() {
        EFFECTS.forEach((id, effect) -> Registry.register(Registry.STATUS_EFFECT, id, effect));
    }
}

