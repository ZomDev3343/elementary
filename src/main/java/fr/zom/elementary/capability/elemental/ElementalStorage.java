package fr.zom.elementary.capability.elemental;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntArrayNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class ElementalStorage implements Capability.IStorage<IElementalCapa> {
    @Override
    public INBT writeNBT(Capability<IElementalCapa> capability, IElementalCapa instance, Direction side) {

        IntArrayNBT nbt = new IntArrayNBT(new int[]{instance.getFire(), instance.getWater(), instance.getEarth(), instance.getBolt(),
                instance.getShadow(), instance.getAir()});

        return nbt;
    }

    @Override
    public void readNBT(Capability<IElementalCapa> capability, IElementalCapa instance, Direction side, INBT nbt) {
        IntArrayNBT array = (IntArrayNBT) nbt;

        instance.setFire(array.get(0).getInt());
        instance.setWater(array.get(1).getInt());
        instance.setEarth(array.get(2).getInt());
        instance.setBolt(array.get(3).getInt());
        instance.setShadow(array.get(4).getInt());
        instance.setAir(array.get(5).getInt());

    }
}
