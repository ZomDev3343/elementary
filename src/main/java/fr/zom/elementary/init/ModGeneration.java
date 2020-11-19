package fr.zom.elementary.init;

import fr.zom.elementary.Elementary;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModGeneration {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onBiomeLoad(BiomeLoadingEvent e) {

        ConfiguredFeature<?, ?> shard_ore = register("shard_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.SHARD_ORE.get().getDefaultState(), 4)).maxHeight(52).repeat(ModConfigs.CONFIG.shard_ore_spawn_amount.get()));

        BiomeGenerationSettingsBuilder gen = e.getGeneration();
        if(e.getCategory() != Biome.Category.ICY)
        {
            gen.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, shard_ore);
        }
    }

    public static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Elementary.MODID + ":" + name, feature);
    }


}
