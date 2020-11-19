package fr.zom.elementary.blocks;

import fr.zom.elementary.blocks.tileentity.TileEntityCatalyser;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BlockCatalyser extends Block {

    public BlockCatalyser() {
        super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(5f, 20f).notSolid().sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool());
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityCatalyser();
    }

}
