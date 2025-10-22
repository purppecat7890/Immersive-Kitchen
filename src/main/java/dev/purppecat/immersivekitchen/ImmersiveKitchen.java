package dev.purppecat.immersivekitchen;

import dev.purppecat.immersivekitchen.datagen.ImmersiveKitchenDataGenerators;
import dev.purppecat.immersivekitchen.loot.ImmersiveKitchenLootContextParamSets;
import dev.purppecat.immersivekitchen.world.block.ImmersiveKitchenBlockEntities;
import dev.purppecat.immersivekitchen.world.block.ImmersiveKitchenBlocks;
import dev.purppecat.immersivekitchen.world.block.renderer.MortarBlockEntityRenderer;
import dev.purppecat.immersivekitchen.world.item.ImmersiveKitchenItems;
import dev.purppecat.immersivekitchen.world.recipes.ImmersiveKitchenRecipes;
import dev.purppecat.immersivekitchen.world.screen.ImmersiveKitchenMenuTypes;
import dev.purppecat.immersivekitchen.world.screen.custom.MortarScreen;
import dev.purppecat.immersivekitchen.world.tabs.ImmersiveKitchenCreativeModeTabs;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(ImmersiveKitchen.MOD_ID)
public class ImmersiveKitchen {
    public static final String MOD_ID = "immersivekitchen";
    public static final String MOD_NAME = "Immersive Kitchen";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public ImmersiveKitchen(IEventBus modEventBus) {
        ImmersiveKitchenItems.init();
        ImmersiveKitchenBlocks.init();
        ImmersiveKitchenBlockEntities.init();
        ImmersiveKitchenCreativeModeTabs.init();
        ImmersiveKitchenMenuTypes.init();
        ImmersiveKitchenRecipes.init();
        ImmersiveKitchenLootContextParamSets.init();

        modEventBus.addListener(ImmersiveKitchenDataGenerators::gatherData);
    }

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ImmersiveKitchenMenuTypes.MORTAR_MENU.get(), MortarScreen::new);
        }
        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ImmersiveKitchenBlockEntities.MORTAR_E.get(), MortarBlockEntityRenderer::new);
        }
    }
}
