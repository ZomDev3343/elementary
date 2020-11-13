package fr.zom.elementary.init;

import fr.zom.elementary.Elementary;
import fr.zom.elementary.container.ContainerShardBag;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers
{

    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Elementary.MODID);

    public static final RegistryObject<ContainerType<ContainerShardBag>> SHARD_BAG = CONTAINERS.register("shard_bag",() -> IForgeContainerType.create(ContainerShardBag::new));

}
