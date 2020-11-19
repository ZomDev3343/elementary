package fr.zom.elementary.init;

import fr.zom.elementary.config.ModCommonConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ModConfigs {

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ModCommonConfig CONFIG;

    public static void registerConfigs() {
        createConfigDir("elementary");

        Pair<ModCommonConfig, ForgeConfigSpec> COMMON = new ForgeConfigSpec.Builder().configure(ModCommonConfig::new);
        CONFIG = COMMON.getLeft();
        COMMON_CONFIG = COMMON.getRight();

        register(ModConfig.Type.COMMON, COMMON_CONFIG, "elementary/elementary-common.toml");
    }

    public static void createConfigDir(String path) {
        try {
            Path configDir = Paths.get(FMLPaths.CONFIGDIR.get().toAbsolutePath().toString(), path);
            Files.createDirectories(configDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void register(ModConfig.Type type, ForgeConfigSpec config) {
        ModLoadingContext.get().registerConfig(type, config);
    }


    public static void register(ModConfig.Type type, ForgeConfigSpec config, String path) {
        ModLoadingContext.get().registerConfig(type, config, path);
    }
}
