package net.soggymustache.oldchest.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Knightworm
 * Created using Tabula 5.1.0
 */
@SideOnly(Side.CLIENT)
public class ModelOldChest extends ModelBase {
    public ModelRenderer shape1;

    public ModelOldChest() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
    }

    public void renderAll() {
    	GlStateManager.pushMatrix();
    	GlStateManager.rotate(180, 1, 0, 0);
    	GlStateManager.rotate(180, 0, 0, 1);
    	GlStateManager.translate(0.0F, 0.0F, 1.0F);
    	this.shape1.render(0.0625F);
    	GlStateManager.popMatrix();
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
