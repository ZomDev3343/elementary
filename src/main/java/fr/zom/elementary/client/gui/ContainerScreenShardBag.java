package fr.zom.elementary.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.zom.elementary.container.ContainerShardBag;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class ContainerScreenShardBag extends ContainerScreen<ContainerShardBag> implements IHasContainer<ContainerShardBag>
{
    public ContainerScreenShardBag(ContainerShardBag screenContainer, PlayerInventory inv, ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks)
    {
        renderBackground(matrixStack);
       // render(matrixStack, mouseX, mouseY);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {

    }
}
