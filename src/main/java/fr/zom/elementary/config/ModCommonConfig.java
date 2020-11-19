package fr.zom.elementary.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModCommonConfig {

    public final ForgeConfigSpec.IntValue shard_ore_spawn_amount;

    public ModCommonConfig(ForgeConfigSpec.Builder builder) {

        builder.push("World Gen");

        this.shard_ore_spawn_amount = builder.comment("Chances for shard ore to spawn in the world")
                .defineInRange("shard_ore_amount", 25, 10, 35);

        builder.pop();
    }
}
