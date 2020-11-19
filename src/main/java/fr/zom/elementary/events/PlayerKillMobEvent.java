package fr.zom.elementary.events;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerKillMobEvent {

    @SubscribeEvent
    public static void onPlayerKillEntity(LivingAttackEvent e) {
        LivingEntity entityLiving = e.getEntityLiving();
        if (e.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) e.getSource().getTrueSource();


        }
    }

}
