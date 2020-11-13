package fr.zom.elementary.items;

import fr.zom.elementary.capability.elemental.ElementalProvider;
import fr.zom.elementary.capability.elemental.IElementalCapa;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class ItemElementalBook extends Item {

    public ItemElementalBook() {
        super(new Properties().group(ItemGroup.TOOLS).maxStackSize(1).rarity(Rarity.EPIC).isImmuneToFire());
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        CompoundNBT tag = stack.getOrCreateTag();

        tag.putUniqueId("ownerID", playerIn.getUniqueID());
        tag.putString("owner", playerIn.getName().getString());

        stack.setTag(tag);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        ItemStack stack = playerIn.getHeldItem(handIn);
        CompoundNBT tag = stack.getOrCreateTag();

        if (tag.contains("owner") && tag.contains("ownerID")) return ActionResult.resultPass(stack);

        tag.putUniqueId("ownerID", playerIn.getUniqueID());
        tag.putString("owner", playerIn.getName().getString());

        return ActionResult.resultSuccess(stack);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if (stack.getOrCreateTag().contains("ownerID")) {
            System.out.println(stack.getOrCreateTag());
            PlayerEntity owner = worldIn.getPlayerByUuid(stack.getOrCreateTag().getUniqueId("ownerID"));
            if (owner != null) {
                owner.getCapability(ElementalProvider.ELEMENTAL_CAPA).ifPresent(cap -> addTooltips(cap, tooltip));
            }
        }
    }

    private void addTooltips(IElementalCapa cap, List<ITextComponent> tooltip) {
        tooltip.add(new TranslationTextComponent("tooltip.elemental_book.air", TextFormatting.YELLOW + String.valueOf(cap.getAir())));
        tooltip.add(new TranslationTextComponent("tooltip.elemental_book.fire", TextFormatting.GOLD + String.valueOf(cap.getFire())));
        tooltip.add(new TranslationTextComponent("tooltip.elemental_book.water", TextFormatting.BLUE + String.valueOf(cap.getWater())));
        tooltip.add(new TranslationTextComponent("tooltip.elemental_book.earth", TextFormatting.DARK_GRAY + String.valueOf(cap.getEarth())));
        tooltip.add(new TranslationTextComponent("tooltip.elemental_book.bolt", TextFormatting.AQUA + String.valueOf(cap.getBolt())));
        tooltip.add(new TranslationTextComponent("tooltip.elemental_book.shadow", TextFormatting.DARK_PURPLE + String.valueOf(cap.getShadow())));
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        return stack.getOrCreateTag().contains("owner") ? new TranslationTextComponent("tooltip.name.elemental_book", stack.getOrCreateTag().getString("owner")) : super.getDisplayName(stack);
    }
}
