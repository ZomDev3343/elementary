package fr.zom.elementary.init;

import fr.zom.elementary.Elementary;
import fr.zom.elementary.blocks.BlockCatalyser;
import fr.zom.elementary.blocks.BlockElementCollecter;
import fr.zom.elementary.blocks.BlockShardOre;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Elementary.MODID);

    public static final RegistryObject<Block> SHARD_ORE = createBlock("shard_ore", BlockShardOre::new);
    public static final RegistryObject<Block> ELEMENT_CATALYSER = createBlock("element_catalyser", BlockCatalyser::new);
    public static final RegistryObject<Block> ELEMENT_COLLECTER = createBlock("element_collecter", BlockElementCollecter::new);



    private static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> block) {
        RegistryObject<Block> b = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(b.get(), new Item.Properties()));
        return b;
    }

}
