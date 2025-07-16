package dev.purppecat.immersivekitchen.world.item;

import dev.purppecat.immersivekitchen.taste.Taste;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ButterItem extends Item {
    public ButterItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(Taste.SALTY.displayName());
        tooltipComponents.add(Taste.FATTY.displayName());
        tooltipComponents.add(Taste.CREAMY.displayName());
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 41;
    }
}
