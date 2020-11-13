package fr.zom.elementary.data.providers;

import fr.zom.elementary.Elementary;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Collections;

public class BlockstatesProvider extends BlockStateProvider {

    public BlockstatesProvider(DataGenerator gen) {
        super(gen, Elementary.MODID, new ExistingFileHelper(Collections.emptyList(), false));
    }

    @Override
    protected void registerStatesAndModels() {
        //getVariantBuilder(Blocks.BONE_BLOCK).forAllStates(blockState -> ConfiguredModel.allYRotations(cubeAll(Blocks.BONE_BLOCK), 0, true));

    }

    void normalBlock(Block block)
    {
        String path = block.getRegistryName().getPath();
        simpleBlock(block);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc(path)));
        cubeAll(block);
    }
}
