package fr.zom.elementary.blocks;

import fr.zom.elementary.blocks.tileentity.TileEntityCollecter;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BlockElementCollecter extends Block {

    public BlockElementCollecter() {
        super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(5f, 15f).notSolid().harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().sound(SoundType.METAL));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityCollecter();
    }
}
