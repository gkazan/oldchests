package net.soggymustache.oldchest.proxy;

import net.minecraft.tileentity.TileEntityChest;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.soggymustache.oldchest.client.render.RenderTileEntityChest;
 
public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChest.class, new RenderTileEntityChest());
	}

	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}
}