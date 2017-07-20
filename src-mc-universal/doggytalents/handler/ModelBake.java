package doggytalents.handler;

import doggytalents.DoggyTalents;
import doggytalents.base.ObjectLib;
import doggytalents.base.d.DogBedModel;
import doggytalents.lib.Reference;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT)
//TODO @EventBusSubscriber(value = Side.CLIENT, modid = Reference.MOD_ID)
public class ModelBake {

	@SubscribeEvent
	public static void onModelBakeEvent(ModelBakeEvent event) {
	    
	    try {
		    ObjectLib.METHODS.onModelBakeEvent(event);
	    }
	    catch(Exception e) {
	    	DoggyTalents.LOGGER.warn("Could not get base Dog Bed model. Reverting to default textures...");
	    }
	}
	
	@SubscribeEvent
	public static void registerTextures(TextureStitchEvent.Pre event) {
		DogTextureLoader.loadYourTexures();

	}
}