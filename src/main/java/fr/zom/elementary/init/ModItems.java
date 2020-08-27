package fr.zom.elementary.init;

import fr.zom.elementary.Elementary;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Elementary.MODID);

    public static final RegistryObject<Item> ROCK_SHARD = ITEMS.register("rock_shard", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ICE_SHARD = ITEMS.register("ice_shard", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ELEMENTAL_SHARD = ITEMS.register("elemental_shard", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> FIRE_INFUSED_SHARD = ITEMS.register("fire_infused_shard", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> WATER_INFUSED_SHARD = ITEMS.register("water_infused_shard", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> EARTH_INFUSED_SHARD = ITEMS.register("earth_infused_shard", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BOLT_INFUSED_SHARD = ITEMS.register("bolt_infused_shard", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));


}
