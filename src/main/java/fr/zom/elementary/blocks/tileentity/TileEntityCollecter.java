package fr.zom.elementary.blocks.tileentity;

import fr.zom.elementary.init.ModElements;
import fr.zom.elementary.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class TileEntityCollecter extends TileEntity implements ITickableTileEntity {

    //TODO finir les collecter et les catalyser

    /**
     * Type of elements collected by the collecter
     */
    private ModElements element;

    /**
     * Position of the catalyser linked to the collecter (made by right clicking with the elements scythe)
     */
    private BlockPos catalyserPos;

    public TileEntityCollecter() {
        super(ModTileEntities.TILE_ENTITY_COLLECTER.get());
        this.element = ModElements.NONE;
        this.catalyserPos = BlockPos.ZERO;
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);

        this.element = ModElements.values()[nbt.getInt("element")];
        this.catalyserPos = NBTUtil.readBlockPos(nbt.getCompound("catalyserPos"));
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);

        compound.putInt("element", element.ordinal());
        compound.put("catalyserPos", NBTUtil.writeBlockPos(this.catalyserPos));

        return compound;
    }


    @Override
    public void tick() {

        if(world == null || !getTileData().contains("catalyserPos")) return;

        BlockPos cPos = NBTUtil.readBlockPos(getTileData().getCompound("catalyserPos"));

        TileEntity te = world.getTileEntity(cPos);
        if(te instanceof TileEntityCatalyser)
        {
            TileEntityCatalyser catalyser = (TileEntityCatalyser) te;

            if(catalyser.getElementType() == ModElements.NONE)
            {
                catalyser.setElementType(element);
            }

            if(catalyser.getElementType() == element)
            {
                catalyser.addElement(0.1D);
            }
        }
    }

    public void setCatalyserPos(BlockPos catalyserPos) {
        this.catalyserPos = catalyserPos;
    }

    public BlockPos getCatalyserPos() {
        return catalyserPos;
    }

    public void setElement(ModElements element) {
        this.element = element;
    }

    public ModElements getElement() {
        return element;
    }
}

