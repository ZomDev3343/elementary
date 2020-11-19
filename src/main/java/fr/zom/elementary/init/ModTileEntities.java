package fr.zom.elementary.init;

import fr.zom.elementary.Elementary;
import fr.zom.elementary.blocks.tileentity.TileEntityCatalyser;
import fr.zom.elementary.blocks.tileentity.TileEntityCollecter;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Elementary.MODID);

    public static final RegistryObject<TileEntityType<TileEntityCatalyser>> TILE_ENTITY_CATALYSER = TILE_ENTITIES.register("tile_entity_catalyser", () -> TileEntityType.Builder.create(TileEntityCatalyser::new, ModBlocks.ELEMENT_CATALYSER.get()).build(null));
    public static final RegistryObject<TileEntityType<TileEntityCollecter>> TILE_ENTITY_COLLECTER = TILE_ENTITIES.register("tile_entity_collect", () -> TileEntityType.Builder.create(TileEntityCollecter::new, ModBlocks.ELEMENT_COLLECTER.get()).build(null));
}
