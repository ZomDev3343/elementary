package fr.zom.elementary.items;

import fr.zom.elementary.init.ModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ItemShardBag extends Item
{

    private final IItemHandler holder = new ItemStackHandler(27);
    private final LazyOptional<IItemHandler> lo = LazyOptional.of(() -> this.holder);

    public ItemShardBag()
    {
        super(new Properties().group(ItemGroup.TOOLS).maxStackSize(1).rarity(Rarity.RARE));
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt)
    {
        return new ICapabilityProvider()
        {
            @Override
            public <T> LazyOptional<T> getCapability( Capability<T> cap, Direction side)
            {
                if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
                    return lo.cast();
                }
                return getCapability(cap);
            }
        };
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        if(!worldIn.isRemote)
        {
            playerIn.openContainer(ModContainers.SHARD_BAG.get().create(0, playerIn.inventory));
        }

        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
    }
}
