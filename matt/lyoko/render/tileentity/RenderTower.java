package matt.lyoko.render.tileentity;

import matt.lyoko.CodeLyoko;
import matt.lyoko.client.ClientProxy;
import matt.lyoko.entities.tileentity.TileEntityTower;
import matt.lyoko.lib.BlockIds;
import matt.lyoko.render.TileAnimator;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTower extends TileEntitySpecialRenderer {

    private ClientProxy proxy;
    private final TileAnimator animator;

    public RenderTower() {
        animator = new TileAnimator(1.0F, 1.0F, 1, 8, 0.25F);
        CodeLyoko.animatorInstances.add(animator);
    }

    /**
     * Renders the TileEntity for the Tower at a position.
     */
    public void render(TileEntityTower entity, double x, double y, double z, float scale) {
        Tessellator tessellator = Tessellator.instance;

        this.bindTextureByName("/mods/lyoko/textures/blocks/towerwall.png");

        int i;
        if (!entity.func_70309_m()) {
            i = 0;
        } else {
            i = entity.getBlockMetadata();
        }

        GL11.glPushMatrix();
        proxy.alphaOn();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
        GL11.glTranslatef((float)x, (float)y, (float)z);

        float width = 1.0F;
        float offsetX = 0;
        float offsetZ = 0;
        float rotationY = 0;
        
        if(entity.worldObj.getBlockId((int)x-1, (int)y, (int)z-1) == CodeLyoko.TowerBlock.blockID
                || entity.worldObj.getBlockId((int)x+1, (int)y, (int)z+1) == CodeLyoko.TowerBlock.blockID
                || entity.worldObj.getBlockId((int)x-1, (int)y, (int)z+1) == CodeLyoko.TowerBlock.blockID
                || entity.worldObj.getBlockId((int)x+1, (int)y, (int)z-1) == CodeLyoko.TowerBlock.blockID) {
            width = 0.8F;
            System.out.println(width);
            
        }

        switch(i) {
            case 0: 
                offsetZ = -0.2F;
                break;
            case 1: 
                offsetX = 1.2F;
                rotationY = -90F;
                break;
            case 2: 
                offsetZ = 1.2F;
                offsetX = 1.0F;
                rotationY = 180F;
                break;
            case 3: 
                offsetX = -0.2F;
                offsetZ = 1.0F;
                rotationY = 90F;
                break;
        }

        GL11.glTranslatef(offsetX, 0F, offsetZ);
        GL11.glRotatef(rotationY, 0F, 1F, 0F);

        this.renderRect(tessellator, width, 1.0F);

        proxy.alphaOff();
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
        this.render((TileEntityTower) par1TileEntity, par2, par4, par6, par8);
    }

    private void renderRect(Tessellator tessellator, float w, float h) {
        tessellator.startDrawingQuads();

        // TOP RIGHT
        float[] topRight = this.animator.getTopRight();
        tessellator.addVertexWithUV(w, 0.0, 0.0, topRight[0], topRight[1]);
        // TOP LEFT
        float[] topLeft = this.animator.getTopLeft();
        tessellator.addVertexWithUV(0.0, 0.0, 0.0, topLeft[0], topLeft[1]);
        // BOTTOM LEFT
        float[] botLeft = this.animator.getBottomLeft();
        tessellator.addVertexWithUV(0.0, h, 0.0, botLeft[0], botLeft[1]);
        // BOTTOM RIGHT
        float[] botRight = this.animator.getBottomRight();
        tessellator.addVertexWithUV(w, h, 0.0, botRight[0], botRight[1]);

        tessellator.draw();
    }
}