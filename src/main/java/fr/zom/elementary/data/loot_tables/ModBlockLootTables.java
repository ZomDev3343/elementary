package fr.zom.elementary.data.loot_tables;

import com.electronwill.nightconfig.core.conversion.ConversionTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class ModBlockLootTables extends BlockLootTables {

    private Map<ResourceLocation, LootTable.Builder> tables = Maps.newHashMap();

    @Override
    protected void addTables() {
        this.registerDropSelfLootTable(Blocks.BONE_BLOCK);
    }

    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> p_accept_1_) {
        this.addTables();

        for(ResourceLocation rs : tables.keySet()) {
            if (rs != LootTables.EMPTY ) {
                LootTable.Builder loottable$builder = this.tables.remove(rs);
                if (loottable$builder == null) {
                    throw new IllegalStateException(String.format("Missing loottable '%s'", rs));
                }

                p_accept_1_.accept(rs, loottable$builder);
            }
        }

        if (!this.tables.isEmpty()) {
            throw new IllegalStateException("Created block loot tables for non-blocks: " + this.tables.keySet());
        }
    }

    @Override
    protected void registerLootTable(Block blockIn, LootTable.Builder table) {
        this.tables.put(blockIn.getLootTable(), table);
    }
}
