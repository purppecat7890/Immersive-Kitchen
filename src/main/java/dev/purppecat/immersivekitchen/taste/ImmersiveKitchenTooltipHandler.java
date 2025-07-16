package dev.purppecat.immersivekitchen.taste;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;
@EventBusSubscriber(modid = ImmersiveKitchen.MOD_ID, bus   = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ImmersiveKitchenTooltipHandler {
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();

        if (stack.getItem() == Items.SUGAR) {
            List<Component> tooltip = event.getToolTip();
            tooltip.add(Taste.SWEET.displayName());
            tooltip.add(Taste.SOFT.displayName());
            tooltip.add(Taste.SMOOTH.displayName());
        }
        else if (stack.getItem() == Items.MILK_BUCKET) {
            List<Component> tooltip = event.getToolTip();
            tooltip.add(Taste.SWEET.displayName());
            tooltip.add(Taste.SOFT.displayName());
            tooltip.add(Taste.CREAMY.displayName());
        }
        else if (stack.getItem() == Items.WATER_BUCKET) {
            List<Component> tooltip = event.getToolTip();
            tooltip.add(Taste.BLAND.displayName());
            tooltip.add(Taste.SMOOTH.displayName());
            tooltip.add(Taste.FRESH.displayName());
        }
        else if (stack.getItem() == Items.MELON || stack.getItem() == Items.MELON_SLICE) {
            List<Component> tooltip = event.getToolTip();
            tooltip.add(Taste.SWEET.displayName());
            tooltip.add(Taste.JUICY.displayName());
            tooltip.add(Taste.FRESH.displayName());
        }
        else if (stack.getItem() == Items.SWEET_BERRIES) {
            List<Component> tooltip = event.getToolTip();
            tooltip.add(Taste.SWEET.displayName());
            tooltip.add(Taste.TART.displayName());
            tooltip.add(Taste.JUICY.displayName());
        }
        else if (stack.getItem() == Items.GLOW_BERRIES) {
            List<Component> tooltip = event.getToolTip();
            tooltip.add(Taste.SWEET.displayName());
            tooltip.add(Taste.EARTHY.displayName());
            tooltip.add(Taste.SOFT.displayName());
        }
        else if (stack.getItem() == Items.EGG) {
            List<Component> tooltip = event.getToolTip();
            tooltip.add(Taste.BLAND.displayName());
            tooltip.add(Taste.SOFT.displayName());
            tooltip.add(Taste.CREAMY.displayName());
        }
        else if (stack.getItem() == Items.APPLE) {
            List<Component> tooltip = event.getToolTip();
            tooltip.add(Taste.SWEET.displayName());
            tooltip.add(Taste.CRISPY.displayName());
            tooltip.add(Taste.JUICY.displayName());
        }
    }
}
