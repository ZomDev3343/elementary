package fr.zom.elementary.data.providers;

import fr.zom.elementary.Elementary;
import fr.zom.elementary.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.Collections;

public class ItemModelsProvider extends ItemModelProvider {


    public ItemModelsProvider(DataGenerator generator) {
        super(generator, Elementary.MODID, new ExistingFileHelper(Collections.emptyList(), false));
    }

    @Override
    protected void registerModels() {

        for (RegistryObject<Item> obj :
                ModItems.ITEMS.getEntries()) {
            Item item = obj.get();
            String name = item.getRegistryName().getPath();
            if(item instanceof ToolItem)
            {
                handheld(name);
            }else
            {
                generated(name);
            }
        }
    }

    public ItemModelBuilder generated(String name)
    {
        return singleTexture(name, mcLoc("item/generated"), "layer0", modLoc("item/" + name));
    }


    public ItemModelBuilder handheld(String name)
    {
        return singleTexture(name, mcLoc("item/handheld"), "layer0", modLoc("item/" + name));
    }



    public ItemModelBuilder withParent(String name, ResourceLocation parent, String textureKey) {
        return getBuilder(name).parent(getExistingFile(parent)).texture(textureKey, modLoc(name));
    }


}
