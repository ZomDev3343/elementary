package fr.zom.elementary.events;

import fr.zom.elementary.capability.elemental.ElementalProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ElementalEvents {

    @SubscribeEvent
    public static void attachCapa(AttachCapabilitiesEvent<Entity> e) {
        if (e.getObject() instanceof PlayerEntity) {
            e.addCapability(ElementalProvider.CAP_KEY, new ElementalProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone e) {
        e.getOriginal().getCapability(ElementalProvider.ELEMENTAL_CAPA).ifPresent(cap -> e.getPlayer().getCapability(ElementalProvider.ELEMENTAL_CAPA).ifPresent(cap1 -> cap1.setCapa(cap)));
    }

}
