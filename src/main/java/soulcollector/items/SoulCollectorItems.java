package soulcollector.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BucketItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.bclib.items.BaseDrinkItem;
import soulcollector.MainClassMod;
import soulcollector.fluid.SoulCollectorFluids;
import soulcollector.items.base.*;

import java.util.LinkedHashMap;
import java.util.Map;
@SuppressWarnings("unused")
public class SoulCollectorItems {
    public static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item STEEL_INGOT = add("steel_ingot", new BaseItem(settings1()));
    public static final Item STEEL_NUGGET = add("steel_nugget", new BaseItem(settings1()));
    public static final Item ANCIENT_SOUL = add("ancient_soul", new AncientSoul(settings1()));
    public static final Item SOUL_INGOT = add("soul_ingot", new SoulIngot(settings1()));
    public static final Item RAW_BEBROCK = add("raw_bebrock", new RawBebrock(settings1()));
    public static final Item BEBROCK = add("bebrock_ingot", new Bebrock(settings1()));
    public static final Item UNSTABLE_SHARD = add("unstable_shard", new UnstableShard(settings1()));
    public static final Item SINGULARITY_SHARD = add("singularity_shard", new Singularity(settings1()));
    public static final Item INACTIVE_SINGULARITY = add("inactive_singularity", new Singularity(settings1()));
    public static final Item FRIENDLY_SINGULARITY = add("fren_singularity", new Singularity(settings1()));
    public static final Item PEACEFUL_SINGULARITY = add("peaceful_singularity", new Singularity(settings1()));
    public static final Item HARMFUL_SINGULARITY = add("harmful_singularity", new Singularity(settings1()));
    public static final Item HOSTILE_SINGULARITY = add("hostile_singularity", new Singularity(settings1()));
    public static final Item MELIS_BUCKET = add("melis_bucket", new BucketItem(SoulCollectorFluids.STILL_MELIS, settings1().recipeRemainder(Items.BUCKET).maxCount(1)));
    public static final Item MELIS_BOTTLE = add("melis_bottle", new BaseDrinkItem(settings1().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 0), 0.01f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 1), 0.1f).build())));
    public static final Item SOUL_MIXTURE = add("soul_mixture", new BaseItem(settings1().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0), 0.2f).statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 60, 0), 0.1f).build())));
    public static final Item SUCCORY = add("succory", new Succory(settings1().food(new FoodComponent.Builder().hunger(20).saturationModifier(1f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1f).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 900, 1), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 900, 1), 1f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 6000, 4), 1f).alwaysEdible().build())));
    public static final Item PIG_CROWN = add("pig_crown", new TechnoCrown(settings1()));
    public static final Item PIG_MASK = add("nyusha_mask", new MaskItem(settings1()));

    public static final Item CHICKEN_SOUL = add("chicken_soul", new SoulItem(settings(), EntityType.CHICKEN));
    public static final Item COW_SOUL = add("cow_soul", new SoulItem(settings(), EntityType.COW));
    public static final Item SHEEP_SOUL = add("sheep_soul", new SoulItem(settings(), EntityType.SHEEP));
    public static final Item PIG_SOUL = add("pig_soul", new SoulItem(settings(), EntityType.PIG));
    public static final Item RABBIT_SOUL = add("rabbit_soul", new SoulItem(settings(), EntityType.RABBIT));
    public static final Item HORSE_SOUL = add("horse_soul", new SoulItem(settings(), new EntityType[]{EntityType.HORSE, EntityType.MULE, EntityType.DONKEY, EntityType.ZOMBIE_HORSE, EntityType.SKELETON_HORSE}));
    public static final Item FOX_SOUL = add("fox_soul", new SoulItem(settings(), EntityType.FOX));
    public static final Item WOLF_SOUL = add("wolf_soul", new SoulItem(settings(), EntityType.WOLF));
    public static final Item BEE_SOUL = add("bee_soul", new SoulItem(settings(), EntityType.BEE));
    public static final Item LLAMA_SOUL = add("llama_soul", new SoulItem(settings(), new EntityType[]{EntityType.LLAMA, EntityType.TRADER_LLAMA}));
    public static final Item SQUID_SOUL = add("squid_soul", new SoulItem(settings(), new EntityType[]{EntityType.SQUID, EntityType.GLOW_SQUID}));
    public static final Item FISH_SOUL = add("fish_soul", new SoulItem(settings(), new EntityType[]{EntityType.COD, EntityType.SALMON, EntityType.PUFFERFISH, EntityType.TROPICAL_FISH}));
    public static final Item TURTLE_SOUL = add("turtle_soul", new SoulItem(settings(), EntityType.TURTLE));

    public static final Item BAT_SOUL = add("bat_soul", new SoulItem(settings(), EntityType.BAT));
    public static final Item DOLPHIN_SOUL = add("dolphin_soul", new SoulItem(settings(), EntityType.DOLPHIN));
    public static final Item OCELOT_SOUL = add("ocelot_soul", new SoulItem(settings(), EntityType.OCELOT));
    public static final Item PARROT_SOUL = add("parrot_soul", new SoulItem(settings(), EntityType.PARROT));
    public static final Item GOAT_SOUL = add("goat_soul", new SoulItem(settings(), EntityType.GOAT));
    public static final Item BEAR_SOUL = add("bear_soul", new SoulItem(settings(), new EntityType[]{EntityType.PANDA, EntityType.POLAR_BEAR}));
    public static final Item AXOLOTL_SOUL = add("axolotl_soul", new SoulItem(settings(), EntityType.AXOLOTL));
    public static final Item STRIDER_SOUL = add("strider_soul", new SoulItem(settings(), EntityType.STRIDER));
    public static final Item VILLAGER_SOUL = add("villager_soul", new SoulItem(settings(), new EntityType[]{EntityType.VILLAGER, EntityType.WANDERING_TRADER}));
    public static final Item MOOSHROOM_SOUL = add("mooshroom_soul", new SoulItem(settings(), EntityType.MOOSHROOM));

    public static final Item ZOMBIE_SOUL = add("zombie_soul", new SoulItem(settings(), new EntityType[]{EntityType.ZOMBIE, EntityType.DROWNED, EntityType.HUSK, EntityType.ZOMBIFIED_PIGLIN, EntityType.ZOMBIE_VILLAGER, EntityType.ZOMBIE_HORSE, EntityType.ZOGLIN}));
    public static final Item SKELETON_SOUL = add("skeleton_soul", new SoulItem(settings(), new EntityType[]{EntityType.SKELETON, EntityType.STRAY, EntityType.SKELETON_HORSE}));
    public static final Item SPIDER_SOUL = add("spider_soul", new SoulItem(settings(), new EntityType[]{EntityType.SPIDER, EntityType.CAVE_SPIDER}));
    public static final Item CREEPER_SOUL = add("awman_soul", new SoulItem(settings(), EntityType.CREEPER));
    public static final Item ENDERMAN_SOUL = add("enderman_soul", new SoulItem(settings(), EntityType.ENDERMAN));
    public static final Item ENDERMITE_SOUL = add("endermite_soul", new SoulItem(settings(), EntityType.ENDERMITE));
    public static final Item ILLAGER_SOUL = add("illager_soul", new SoulItem(settings(), new EntityType[]{EntityType.PILLAGER, EntityType.VINDICATOR, EntityType.EVOKER, EntityType.ILLUSIONER, EntityType.WITCH}));
    public static final Item GUARDIAN_SOUL = add("guardian_soul", new SoulItem(settings(), EntityType.GUARDIAN));
    public static final Item SILVERFISH_SOUL = add("silverfish_soul", new SoulItem(settings(), EntityType.SILVERFISH));
    public static final Item PIGLIN_SOUL = add("piglin_soul", new SoulItem(settings(), new EntityType[]{EntityType.PIGLIN, EntityType.PIGLIN_BRUTE, EntityType.ZOMBIFIED_PIGLIN}));
    public static final Item HOGLIN_SOUL = add("hoglin_soul", new SoulItem(settings(), new EntityType[]{EntityType.HOGLIN, EntityType.ZOGLIN}));
    public static final Item MAGMA_CUBE_SOUL = add("magma_cube_soul", new SoulItem(settings(), EntityType.MAGMA_CUBE));
    public static final Item BLAZE_SOUL = add("blaze_soul", new SoulItem(settings(), EntityType.BLAZE));
    public static final Item GHAST_SOUL = add("ghast_soul", new SoulItem(settings(), EntityType.GHAST));

    public static final Item SLIME_SOUL = add("slime_soul", new SoulItem(settings(), EntityType.SLIME));
    public static final Item RAVAGER_SOUL = add("ravager_soul", new SoulItem(settings(), EntityType.RAVAGER));
    public static final Item PHANTOM_SOUL = add("phantom_soul", new SoulItem(settings(), EntityType.PHANTOM));
    public static final Item SHULKER_SOUL = add("shulker_soul", new SoulItem(settings(), EntityType.SHULKER));
    public static final Item ELDER_GUARDIAN_SOUL = add("elder_guardian_soul", new SoulItem(settings(), EntityType.ELDER_GUARDIAN));
    public static final Item WITHER_SOUL = add("wither_soul", new SoulItem(settings(), EntityType.WITHER));
    public static final Item DRAGON_SOUL = add("dragon_soul", new SoulItem(settings(), EntityType.ENDER_DRAGON));
    public static final Item PLAYER_SOUL = add("player_soul", new PlayerSoulItem(settings(), ""));
    public static final Item SOMIK_SOUL = add("somik_soul", new PlayerSoulItem(settings(), "aSomik"));
    public static final Item GOOSIK_SOUL = add("goosik_soul", new PlayerSoulItem(settings(), "PinkGoosik"));
    public static final Item ANDRYUSHKA_SOUL = add("night_soul", new PlayerSoulItem(settings(), "Librarian_Night"));
    public static final Item SPUSIK_SOUL = add("space_soul", new PlayerSoulItem(settings(), "Spusik"));
    public static final Item VIOLET_SOUL = add("love_soul", new PlayerSoulItem(settings(), "aViolet"));

    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(new Identifier(MainClassMod.MODID, name), item);
        return item;
    }

    private static FabricItemSettings settings1(){
        return new FabricItemSettings().group(MainClassMod.ITEM_GROUP_ITEMS);
    }

    private static FabricItemSettings settings(){
        return new FabricItemSettings().group(MainClassMod.ITEM_GROUP_SOULS);
    }

    public static void register() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
    }
}
