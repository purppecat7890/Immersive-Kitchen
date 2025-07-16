package dev.purppecat.immersivekitchen;

import dev.purppecat.immersivekitchen.datagen.ImmersiveKitchenDataGenerators;
import dev.purppecat.immersivekitchen.taste.ImmersiveKitchenTooltipHandler;
import dev.purppecat.immersivekitchen.world.block.ImmersiveKitchenBlocks;
import dev.purppecat.immersivekitchen.world.item.ImmersiveKitchenItems;
import dev.purppecat.immersivekitchen.world.tabs.ImmersiveKitchenCreativeModeTabs;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
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
        ImmersiveKitchenCreativeModeTabs.init();

        modEventBus.addListener(ImmersiveKitchenDataGenerators::gatherData);
    }

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
