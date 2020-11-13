package fr.zom.elementary.container;

import fr.zom.elementary.init.ModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.IContainerFactory;

@OnlyIn(Dist.CLIENT)
public class ContainerShardBag extends Container implements IContainerFactory<ContainerShardBag>, INamedContainerProvider
{

    private final PlayerInventory playerInventory;
    private final PacketBuffer data;
    private final PlayerEntity player;

    public ContainerShardBag(int id, PlayerInventory playerInventory, PacketBuffer data)
    {
        super(ModContainers.SHARD_BAG.get(), id);
        this.playerInventory = playerInventory;
        this.player = this.playerInventory.player;
        this.data = data;

        for(int i = 0; i < playerInventory.getSizeInventory(); i ++)
        {
            //addSlot(new Slot(playerInventory, i, i*18, ))
        }

    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn)
    {
        return true;
    }

    @Override
    public ContainerShardBag create(int windowId, PlayerInventory inv, PacketBuffer data)
    {
        return new ContainerShardBag(windowId, playerInventory, data);
    }

    @Override
    public ContainerShardBag create(int p_create_1_, PlayerInventory p_create_2_)
    {
        return create(p_create_1_, p_create_2_, null);
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return new TranslationTextComponent("container.shard_bag.name");
    }

    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_)
    {
        return create(p_createMenu_1_, p_createMenu_2_);
    }
}
