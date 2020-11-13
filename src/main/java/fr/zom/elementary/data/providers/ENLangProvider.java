package fr.zom.elementary.data.providers;

import fr.zom.elementary.Elementary;
import fr.zom.elementary.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENLangProvider extends LanguageProvider {

    public ENLangProvider(DataGenerator gen) {
        super(gen, Elementary.MODID, "en_us");
    }

    @Override
    public void addTranslations() {
        add(ModItems.BOLT_INFUSED_SHARD.get(), "Bolt Infused Shard");
        add(ModItems.EARTH_INFUSED_SHARD.get(), "Earth Infused Shard");
        add(ModItems.FIRE_INFUSED_SHARD.get(), "Fire Infused Shard");
        add(ModItems.ELEMENTAL_SHARD.get(), "Elemental Infused Shard");
        add(ModItems.ICE_SHARD.get(), "Ice Infused Shard");
        add(ModItems.ROCK_SHARD.get(), "Rock Infused Shard");
        add(ModItems.WATER_INFUSED_SHARD.get(), "Water Infused Shard");
        add(ModItems.ELEMENTAL_BOOK.get(), "Elemental Book");
        add(ModItems.ELEMENTS_SCYTHE.get(), "Elements Scythe");

    }
}
