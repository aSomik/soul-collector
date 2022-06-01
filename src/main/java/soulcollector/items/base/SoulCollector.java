package soulcollector.items.base;

import net.minecraft.client.item.TooltipContext;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static net.minecraft.entity.EntityType.*;
import static net.minecraft.entity.effect.StatusEffects.*;


public class SoulCollector extends SwordItem {

    public static final Map<EntityType<?>, Map.Entry<StatusEffect, Integer>> ENTRIES = new LinkedHashMap<>();

    public SoulCollector(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        put(SLOW_FALLING, 100, CHICKEN, BEE);
        put(SLOW_FALLING, 200, PARROT, EntityType.WITHER);
        put(SATURATION, 0, COW, PIG, SHEEP, MOOSHROOM, HOGLIN, ZOGLIN);
        put(LEVITATION, 20, SHULKER_BULLET);
        put(LEVITATION, 80, BAT, VEX, PHANTOM);
        put(LEVITATION, 200, ENDER_DRAGON, GHAST);
        put(WATER_BREATHING, 200, AXOLOTL, GUARDIAN, DOLPHIN, TURTLE);
        put(WATER_BREATHING, 100, COD, PUFFERFISH, TROPICAL_FISH, SALMON, DROWNED, SQUID, GLOW_SQUID);
        put(FIRE_RESISTANCE, 100, MAGMA_CUBE, BLAZE, WITCH);
        put(FIRE_RESISTANCE, 200, STRIDER, GHAST);
        put(NIGHT_VISION, 600, BAT, OCELOT, CAT);
        put(NIGHT_VISION, 3600, PHANTOM);
        put(SPEED, 100, WOLF, OCELOT, CAT, SILVERFISH, ENDERMITE, SPIDER, ENDERMAN, FOX);
        put(SPEED, 200, DONKEY, HORSE, MULE, SKELETON_HORSE, ZOMBIE_HORSE, CAVE_SPIDER, STRIDER);
        put(SPEED, 300, PLAYER);
        put(SPEED, 400, RAVAGER);
        put(JUMP_BOOST, 100, RABBIT, FOX);
        put(JUMP_BOOST, 200, CAVE_SPIDER, SLIME, MAGMA_CUBE);
        put(DOLPHINS_GRACE, 600, DOLPHIN, ELDER_GUARDIAN);
        put(CONDUIT_POWER, 6000, ELDER_GUARDIAN);
        put(STRENGTH, 60, ZOMBIE, ZOMBIE_VILLAGER, HUSK, DROWNED, WITHER_SKELETON, WITCH);
        put(STRENGTH, 100, PIGLIN_BRUTE, ENDERMAN);
        put(STRENGTH, 300, PLAYER);
        put(STRENGTH, 400, RAVAGER);
        put(STRENGTH, 12000, EntityType.WITHER, ELDER_GUARDIAN);
        put(STRENGTH, 36000, ENDER_DRAGON);
        put(HUNGER, 60, ZOMBIE, ZOMBIE_VILLAGER, HUSK, DROWNED, ZOMBIE_HORSE, ZOMBIFIED_PIGLIN, ZOGLIN);
        put(WEAKNESS, 100, SKELETON, STRAY, SNOW_GOLEM, SKELETON_HORSE);
        put(SLOWNESS, 100, STRAY, SKELETON, PILLAGER, VINDICATOR, SNOW_GOLEM, IRON_GOLEM, WITCH);
        put(StatusEffects.WITHER, 40, WITHER_SKELETON);
        put(StatusEffects.WITHER, 100, EntityType.WITHER);
        put(HASTE, 100, CREEPER, SILVERFISH, ENDERMITE, ENDERMAN);
        put(MINING_FATIGUE, 1200, ELDER_GUARDIAN);
        put(POISON, 60, CAVE_SPIDER, WITCH);
        put(GLOWING, 200, GLOW_SQUID);
        put(NAUSEA, 100, PUFFERFISH, MOOSHROOM);
        put(INVISIBILITY, 300, ENDERMAN, ENDERMITE);
        put(ABSORPTION, 1200, IRON_GOLEM, SHULKER, PLAYER);
        put(RESISTANCE, 100, TURTLE);
        put(RESISTANCE, 300, SHULKER, PLAYER);
        put(RESISTANCE, 600, IRON_GOLEM);
        put(LUCK, 600, PILLAGER, VINDICATOR);
        put(LUCK, 1200, EVOKER, RAVAGER);
        put(UNLUCK, 1200, VILLAGER, WANDERING_TRADER, TRADER_LLAMA);
        put(INSTANT_DAMAGE, 0, PANDA, POLAR_BEAR, LLAMA, GOAT);
        put(INSTANT_HEALTH, 0, CREEPER, SKELETON, STRAY, SKELETON_HORSE, WITCH, PLAYER);
        put(UNLUCK, 72000, PANDA);
    }

    private static void put(EntityType<?> entityType, StatusEffect effect, int duration){
        ENTRIES.put(entityType, new AbstractMap.SimpleEntry<>(effect, duration));
    }

    private static void put(StatusEffect effect, int duration, EntityType<?>... entityTypes){
        for(var entity : entityTypes){
            ENTRIES.put(entity, new AbstractMap.SimpleEntry<>(effect, duration));
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.soulcoll.soul_collector.tooltip").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.soul_collector.tooltip1").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.soul_collector.tooltip2").formatted(Formatting.DARK_GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
