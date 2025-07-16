package dev.purppecat.immersivekitchen.world.item;

import java.util.List;

import dev.purppecat.immersivekitchen.taste.Taste;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class LemonItem extends Item {
    public LemonItem(Properties properties) {
        super(properties.food(ImmersiveKitchenFoodProperties.LEMON).stacksTo(12).durability(2));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(Taste.SOUR.displayName());
        tooltipComponents.add(Taste.TANGY.displayName());
        tooltipComponents.add(Taste.BITTER.displayName());
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 30;
    }
}
