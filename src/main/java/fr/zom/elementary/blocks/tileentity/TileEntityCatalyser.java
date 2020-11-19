package fr.zom.elementary.blocks.tileentity;

import fr.zom.elementary.init.ModElements;
import fr.zom.elementary.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCatalyser extends TileEntity implements ITickableTileEntity {

    private ModElements elementType;
    private double elementAmount;

    public TileEntityCatalyser() {
        super(ModTileEntities.TILE_ENTITY_CATALYSER.get());
        this.elementType = ModElements.NONE;
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);

        this.elementType = ModElements.values()[nbt.getInt("elementType")];
        this.elementAmount = nbt.getDouble("elementAmount");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);

        compound.putInt("elementType", this.elementType.ordinal());
        compound.putDouble("elementAmount", this.elementAmount);

        return compound;
    }

    public void addElement(double amount)
    {
        setElement(this.elementAmount + amount);
    }

    public void setElement(double amount)
    {
        this.elementAmount = Math.max(0.0D, amount);
    }

    public void removeElement(double amount)
    {
        addElement(-amount);
    }

    public ModElements getElementType() {
        return elementType;
    }

    public void setElementType(ModElements elementType) {
        this.elementType = elementType;
    }

    public double getElementAmount() {
        return elementAmount;
    }

    @Override
    public void tick() {

        if(world == null)return;

        if(!world.isRemote) System.out.println(elementAmount);

        if(elementAmount >= 100D)
        {
            setElement(0D);
            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY()+1D, pos.getZ(), new ItemStack(Blocks.DIRT)));
        }
    }
}
