package soulcollector.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.impl.biome.modification.BiomeSelectionContextImpl;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import soulcollector.MainClassMod;
import soulcollector.blocks.SoulCollectorBlocks;

public class SoulCollectorConfiguredFeatures {
public static ConfiguredFeature<?, ?> SINGULARITY_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SoulCollectorBlocks.SINGULARITY_ORE.getDefaultState(), 5))
        .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(1), YOffset.fixed(8)))).spreadHorizontally().repeat(5);
    public static ConfiguredFeature<?, ?> BEBROCK_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SoulCollectorBlocks.BEBROCK_ORE.getDefaultState(), 3))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(1), YOffset.fixed(5)))).spreadHorizontally().repeat(4);

    public static void register(){
        RegistryKey<ConfiguredFeature<?, ?>> singularity_ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, MainClassMod.newId("singularity_ore_feature"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, singularity_ore.getValue(), SINGULARITY_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, singularity_ore);

        RegistryKey<ConfiguredFeature<?, ?>> bebrock_ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, MainClassMod.newId("bebrock_ore_feature"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, bebrock_ore.getValue(), BEBROCK_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, bebrock_ore);
    }
}
