package fr.zom.elementary.init;

import fr.zom.elementary.Elementary;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;

public class ModTags
{

    public static final Tags.IOptionalNamedTag<Block> EARTH_ELEMENTS = BlockTags.createOptional(new ResourceLocation(Elementary.MODID, "earth_elemental_blocks"));

}
