package fr.zom.elementary;

import fr.zom.elementary.capability.elemental.ElementalProvider;
import fr.zom.elementary.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Elementary.MODID)
public class Elementary
{

    public static final String MODID = "elementary";

    public Elementary()
    {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);

        ModItems.ITEMS.register(bus);

    }

    private void setup(final FMLCommonSetupEvent e)
    {
        // Enregistrement de la capa 'Elemental'
        ElementalProvider.register();
    }

    private void clientSetup(final FMLClientSetupEvent e)
    {

    }
}
