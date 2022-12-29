package net.chunkymonkey.fglider.client;

import net.chunkymonkey.fglider.item.*;
import net.chunkymonkey.fglider.client.render.GliderFeatureRenderer;
import net.chunkymonkey.fglider.registry.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.ArmorStandEntityRenderer;

@Environment(EnvType.CLIENT)
public class FabricGlider implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerModelPredicates();
        registerFeatureRenderers();
    }

    private void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.GLIDER, new Identifier("broken"),
                (stack, arg1, arg2, arg3) -> GliderItem.isUsable(stack) ? 0 : 1);
    }

    private void registerFeatureRenderers() {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer instanceof ArmorStandEntityRenderer || entityRenderer instanceof PlayerEntityRenderer) {
                registrationHelper.register(new GliderFeatureRenderer<>(entityRenderer, context.getModelLoader()));
            }
        });
    }
}