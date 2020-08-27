package fr.zom.elementary.capability.elemental;

import fr.zom.elementary.Elementary;
import net.minecraft.nbt.IntArrayNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ElementalProvider implements ICapabilitySerializable<IntArrayNBT>
{

    @CapabilityInject(IElementalCapa.class)
    public static final Capability<IElementalCapa> ELEMENTAL_CAPA = null;

    private IElementalCapa defaultInstance = ELEMENTAL_CAPA.getDefaultInstance();
    private final LazyOptional<IElementalCapa> lazyOptional = LazyOptional.of(() -> this.defaultInstance);

    public static final ResourceLocation CAP_KEY = new ResourceLocation(Elementary.MODID, "elemental_capa");

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side)
    {
        return ELEMENTAL_CAPA.orEmpty(cap, lazyOptional).cast();
    }

    @Override
    public IntArrayNBT serializeNBT()
    {
        return (IntArrayNBT) ELEMENTAL_CAPA.writeNBT(defaultInstance, null);
    }

    @Override
    public void deserializeNBT(IntArrayNBT nbt)
    {
        ELEMENTAL_CAPA.readNBT(this.defaultInstance, null, nbt);
    }

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IElementalCapa.class, new ElementalStorage(), DefaultElemental::new);
    }

}
