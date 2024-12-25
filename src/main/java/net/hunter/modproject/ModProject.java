package net.hunter.modproject;

import net.fabricmc.api.ModInitializer;

import net.hunter.modproject.block.ModBlocks;
import net.hunter.modproject.item.ModItemGroups;
import net.hunter.modproject.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModProject implements ModInitializer {
	public static final String MOD_ID = "modproject";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}