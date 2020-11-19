package fr.zom.elementary.events;

import fr.zom.elementary.Elementary;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elementary.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ElementalChargeEvents {

    public static void playerBreakEvent(BlockEvent.BreakEvent e) {
        PlayerEntity player = e.getPlayer();


    }
}
