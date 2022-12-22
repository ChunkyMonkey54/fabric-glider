package net.chunkymonkey.fglider;

import net.chunkymonkey.fglider.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricGlider implements ModInitializer {
	public static final String MOD_ID = "fglider";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
