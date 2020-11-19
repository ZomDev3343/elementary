package fr.zom.elementary.data;

import fr.zom.elementary.Elementary;
import fr.zom.elementary.data.providers.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Elementary.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGathering {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();

        if (e.includeClient()) {
            generator.addProvider(new ItemModelsProvider(generator));
            generator.addProvider(new BlockstatesProvider(generator));
        }
        if (e.includeServer()) {
            generator.addProvider(new RecipesProvider(generator));
            generator.addProvider(new ENLangProvider(generator));
            generator.addProvider(new FRLangProvider(generator));
            generator.addProvider(new ModLootTableProvider(generator));
        }
    }

}
