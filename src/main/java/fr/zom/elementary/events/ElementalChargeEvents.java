package fr.zom.elementary.events;

import fr.zom.elementary.Elementary;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = Elementary.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ElementalChargeEvents
{



    @SubscribeEvent
    public static void playerBreakEvent(BlockEvent.BreakEvent e)
    {
        PlayerEntity player = e.getPlayer();



    }
}
