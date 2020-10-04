package fr.zom.elementary.items;

import fr.zom.elementary.Elementary;
import fr.zom.elementary.capability.elemental.ElementalProvider;
import fr.zom.elementary.init.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;

import java.util.HashMap;

public class ItemElementsScythe extends Item
{

    public static final HashMap<Block, Integer> EARTH_ELEMENTS_DROP = new HashMap<>();

    static
    {
        ModTags.EARTH_ELEMENTS.values().forEach(block -> EARTH_ELEMENTS_DROP.put(block, 1));
    }

    public ItemElementsScythe()
    {
        super(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1).rarity(Rarity.RARE));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
    {

        if(entityLiving instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) entityLiving;

            // On ajoute la quantité d'élément si le block est valide
            player.getCapability(ElementalProvider.ELEMENTAL_CAPA).ifPresent(cap -> EARTH_ELEMENTS_DROP.computeIfPresent(state.getBlock(), (block ,amount) -> {cap.addEarth(amount); worldIn.destroyBlock(pos, false); return amount;}));
        }

        return true;
    }
}
