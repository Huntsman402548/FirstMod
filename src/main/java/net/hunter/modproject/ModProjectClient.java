package net.hunter.modproject;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.hunter.modproject.block.ModBlocks;

@Environment(EnvType.CLIENT)
public class ModProjectClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // ...

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x355e3b, ModBlocks.REDWOOD_LEAVES);
    }
}