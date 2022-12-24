package net.chunkymonkey.fglider;

import net.chunkymonkey.fglider.item.*;
import net.chunkymonkey.fglider.renderer.GliderFeatureRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.ArmorStandEntityRenderer;

public class FabricGliderClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(ModItems.GLIDER, new Identifier("broken"),
                (stack, arg1, arg2, arg3) -> GliderItem.isUsable(stack) ? 0 : 1);
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer instanceof ArmorStandEntityRenderer || entityRenderer instanceof PlayerEntityRenderer) {
                registrationHelper.register(new GliderFeatureRenderer<>(entityRenderer, context.getModelLoader()));
            }
        });
    }
}