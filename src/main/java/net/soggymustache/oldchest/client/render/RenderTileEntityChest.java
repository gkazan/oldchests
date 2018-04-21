package net.soggymustache.oldchest.client.render;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.oldchest.OldChestReference;
import net.soggymustache.oldchest.client.model.ModelOldChest;
import net.soggymustache.oldchest.client.model.ModelOldDoubleChest;

@SideOnly(Side.CLIENT)
public class RenderTileEntityChest extends TileEntitySpecialRenderer<TileEntityChest> {
	private static final ResourceLocation TEXTURE_TRAPPED_DOUBLE = new ResourceLocation(OldChestReference.MOD_ID + ":textures/entity/double_trapped.png");
	private static final ResourceLocation TEXTURE_NORMAL_DOUBLE = new ResourceLocation(OldChestReference.MOD_ID + ":textures/entity/double.png");
	private static final ResourceLocation TEXTURE_TRAPPED = new ResourceLocation(OldChestReference.MOD_ID + ":textures/entity/trapped.png");
	private static final ResourceLocation TEXTURE_NORMAL = new ResourceLocation(OldChestReference.MOD_ID + ":textures/entity/chest.png");
	private final ModelOldChest simpleChest = new ModelOldChest();
	private final ModelOldDoubleChest largeChest = new ModelOldDoubleChest();

	public RenderTileEntityChest() {

	}

	public void render(TileEntityChest te, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
		GlStateManager.enableDepth();
		GlStateManager.depthFunc(515);
		GlStateManager.depthMask(true);
		int i;

		if (te.hasWorld()) {
			Block block = te.getBlockType();
			i = te.getBlockMetadata();

			if (block instanceof BlockChest && i == 0) {
				((BlockChest) block).checkForSurroundingChests(te.getWorld(), te.getPos(),
						te.getWorld().getBlockState(te.getPos()));
				i = te.getBlockMetadata();
			}

			te.checkForAdjacentChests();
		} else {
			i = 0;
		}

		if (te.adjacentChestZNeg == null && te.adjacentChestXNeg == null) {
			if (te.adjacentChestXPos == null && te.adjacentChestZPos == null) {
				ModelOldChest modelchest = this.simpleChest;

				if (destroyStage >= 0) {
					this.bindTexture(DESTROY_STAGES[destroyStage]);
					GlStateManager.matrixMode(5890);
					GlStateManager.pushMatrix();
					GlStateManager.matrixMode(5888);
				} else if (te.getChestType() == BlockChest.Type.TRAP) {
					this.bindTexture(TEXTURE_TRAPPED);
				} else {
					this.bindTexture(TEXTURE_NORMAL);
				}

				GlStateManager.pushMatrix();

				if (destroyStage < 0) {
					GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
				}

				GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
				GlStateManager.translate(0.5F, 0.5F, 0.5F);
				int j = 0;

				if (i == 2) {
					j = 180;
					GlStateManager.translate(0.0F, 0.0F, -2.0F);
				}

				if (i == 3) {
					j = 0;
					GlStateManager.translate(0.0F, 0.0F, 0.0F);
				}

				if (i == 4) {
					j = -90;
					GlStateManager.translate(-1.0F, 0.0F, -1.0F);
				}

				if (i == 5) {
					j = 90;
					GlStateManager.translate(1.0F, 0.0F, -1.0F);
				}

				if (i == 2 && te.adjacentChestXPos != null) {
					GlStateManager.translate(1.0F, 0.0F, 0.0F);
				}

				if (i == 5 && te.adjacentChestZPos != null) {
					GlStateManager.translate(0.0F, 0.0F, -1.0F);
				}

				GlStateManager.rotate((float) j, 0.0F, 1.0F, 0.0F);

				GlStateManager.rotate(180, 0, 0, 1);
				modelchest.renderAll();
				GlStateManager.popMatrix();
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			} else {
				ModelOldDoubleChest modelchest = this.largeChest;

				if (destroyStage >= 0) {
					this.bindTexture(DESTROY_STAGES[destroyStage]);
					GlStateManager.matrixMode(5890);
					GlStateManager.pushMatrix();
					GlStateManager.scale(8.0F, 4.0F, 1.0F);
					GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
					GlStateManager.matrixMode(5888);
				} else if (te.getChestType() == BlockChest.Type.TRAP) {
					this.bindTexture(TEXTURE_TRAPPED_DOUBLE);
				} else {
					this.bindTexture(TEXTURE_NORMAL_DOUBLE);
				}

				GlStateManager.pushMatrix();

				if (destroyStage < 0) {
					GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
				}

				GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
				GlStateManager.translate(0.5F, 0.5F, 0.5F);
				int j = 0;

				if (i == 2) {
					j = 0;
					GlStateManager.translate(0.0F, 0.0F, -1.0F);
				}

				if (i == 3) {
					j = 180;
					GlStateManager.translate(0.0F, 0.0F, -1.0F);
				}

				if (i == 4) {
					j = 90;
					GlStateManager.translate(0.0F, 0.0F, -1.0F);
				}

				if (i == 5) {
					j = -90;
					GlStateManager.translate(0.0F, 0.0F, 1.0F);
				}

				if (i == 2 && te.adjacentChestXPos != null) {
					GlStateManager.translate(1.0F, 0.0F, 0.0F);
				}

				if (i == 5 && te.adjacentChestZPos != null) {
					GlStateManager.translate(0.0F, 0.0F, -1.0F);
				}

				GlStateManager.rotate((float) j, 0.0F, 1.0F, 0.0F);
				GlStateManager.rotate(180, 0, 0, 1);
				modelchest.renderAll();
				GlStateManager.popMatrix();
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

			}
			if (destroyStage >= 0) {
				GlStateManager.matrixMode(5890);
				GlStateManager.popMatrix();
				GlStateManager.matrixMode(5888);
			}
		}
	}
}