package fr.zom.elementary.items;

import fr.zom.elementary.blocks.tileentity.TileEntityCollecter;
import fr.zom.elementary.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemElementsScythe extends Item {

    public ItemElementsScythe() {
        super(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1).rarity(Rarity.RARE));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {

        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        CompoundNBT nbt = context.getItem().getOrCreateTag();

        if (!world.isRemote) {
            BlockPos pos = context.getPos();
            BlockState state = world.getBlockState(pos);

            // On set le catalyser
            if (player.isSneaking()) {
                if (state.getBlock() == ModBlocks.ELEMENT_CATALYSER.get()) {
                    nbt.put("catalyser", NBTUtil.writeBlockPos(pos));
                    player.sendStatusMessage(new TranslationTextComponent("element_scythe.get_catalyser_pos"), true);
                    return ActionResultType.SUCCESS;
                }
            }
            // Relie le catalyser au collecter
            else {

                if(state.getBlock() == ModBlocks.ELEMENT_COLLECTER.get()) {
                    if (nbt.contains("catalyser")) {
                        TileEntityCollecter te = (TileEntityCollecter) world.getTileEntity(pos);
                        if (te != null) {
                            te.setCatalyserPos(NBTUtil.readBlockPos(nbt.getCompound("catalyser")));
                            player.sendStatusMessage(new TranslationTextComponent("element_scythe.set_catalyser_pos"), true);
                            return ActionResultType.SUCCESS;
                        }
                    }
                }

            }
        }
        return ActionResultType.FAIL;
    }
}
