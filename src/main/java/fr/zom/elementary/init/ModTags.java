package fr.zom.elementary.init;

import fr.zom.elementary.Elementary;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModTags
{

    public static final Tags.IOptionalNamedTag<Block> EARTH_ELEMENTS = BlockTags.createOptional(new ResourceLocation(Elementary.MODID, "earth_elemental_blocks"));

}
