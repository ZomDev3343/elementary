package fr.zom.elementary.data.providers;

import fr.zom.elementary.Elementary;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Collections;

public class ItemModelsProvider extends ItemModelProvider {


    public ItemModelsProvider(DataGenerator generator) {
        super(generator, Elementary.MODID, new ExistingFileHelper(Collections.emptyList(), false));
    }

    @Override
    protected void registerModels() {

    }

    public ItemModelBuilder generated(String name) {
        return singleTexture(name, mcLoc("item/generated"), "layer0", modLoc("item/" + name));
    }


    public ItemModelBuilder handheld(String name) {
        return singleTexture(name, mcLoc("item/handheld"), "layer0", modLoc("item/" + name));
    }

    public ItemModelBuilder withParent(String name, ResourceLocation parent, String textureKey) {
        return getBuilder(name).parent(getExistingFile(parent)).texture(textureKey, modLoc(name));
    }


}
