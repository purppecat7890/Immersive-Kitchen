package dev.purppecat.immersivekitchen.taste;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = ImmersiveKitchen.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ImmersiveKitchenTooltipHandler {
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();
        for (Taste taste : Taste.values()) {
            if (stack.is(taste.tag())) {
                taste.addToTooltip(event.getContext(), tooltip::add, event.getFlags());
            }
        }

//        if (stack.getItem() == Items.SUGAR) {
//            tooltip.add(Taste.SWEET.displayName());
//            tooltip.add(Taste.SOFT.displayName());
//            tooltip.add(Taste.SMOOTH.displayName());
//        } else if (stack.getItem() == Items.MILK_BUCKET) {
//            tooltip.add(Taste.SWEET.displayName());
//            tooltip.add(Taste.SOFT.displayName());
//            tooltip.add(Taste.CREAMY.displayName());
//        } else if (stack.getItem() == Items.WATER_BUCKET) {
//            tooltip.add(Taste.BLAND.displayName());
//            tooltip.add(Taste.SMOOTH.displayName());
//            tooltip.add(Taste.FRESH.displayName());
//        } else if (stack.getItem() == Items.MELON || stack.getItem() == Items.MELON_SLICE) {
//            tooltip.add(Taste.SWEET.displayName());
//            tooltip.add(Taste.JUICY.displayName());
//            tooltip.add(Taste.FRESH.displayName());
//        } else if (stack.getItem() == Items.SWEET_BERRIES) {
//            tooltip.add(Taste.SWEET.displayName());
//            tooltip.add(Taste.TART.displayName());
//            tooltip.add(Taste.JUICY.displayName());
//        } else if (stack.getItem() == Items.GLOW_BERRIES) {
//            tooltip.add(Taste.SWEET.displayName());
//            tooltip.add(Taste.NATURAL.displayName());
//            tooltip.add(Taste.SOFT.displayName());
//        } else if (stack.getItem() == Items.EGG) {
//            tooltip.add(Taste.BLAND.displayName());
//            tooltip.add(Taste.SOFT.displayName());
//            tooltip.add(Taste.CREAMY.displayName());
//        } else if (stack.getItem() == Items.APPLE) {
//            tooltip.add(Taste.SWEET.displayName());
//            tooltip.add(Taste.CRISPY.displayName());
//            tooltip.add(Taste.JUICY.displayName());
//        }
    }
}
