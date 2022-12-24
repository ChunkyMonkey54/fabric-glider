package net.chunkymonkey.fglider;

import net.chunkymonkey.fglider.item.GliderItem;
import net.chunkymonkey.fglider.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class FabricGliderClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(ModItems.GLIDER, new Identifier("broken"),
                (stack, arg1, arg2, arg3) -> GliderItem.isUsable(stack) ? 0 : 1);
    }
}
