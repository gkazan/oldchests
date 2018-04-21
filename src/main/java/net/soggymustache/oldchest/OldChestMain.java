package net.soggymustache.oldchest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntityChestRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.soggymustache.oldchest.proxy.CommonProxy;

@Mod(modid = OldChestReference.MOD_ID, name = OldChestReference.NAME, version = OldChestReference.VERSION)
public class OldChestMain {

	public static final Logger logger = LogManager.getLogger(OldChestReference.MOD_ID);

	@SidedProxy(serverSide = OldChestReference.SERVER_PROXY_CLASS, clientSide = OldChestReference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.Instance(OldChestReference.MOD_ID)
	public static OldChestMain instance;

	@EventHandler()
	public static void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
		proxy.registerRenders();
	}

	@EventHandler()
	public static void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
