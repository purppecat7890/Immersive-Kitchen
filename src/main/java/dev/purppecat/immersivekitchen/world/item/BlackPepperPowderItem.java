package dev.purppecat.immersivekitchen.world.item;

import dev.purppecat.immersivekitchen.taste.Taste;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class BlackPepperPowderItem extends Item {
    public BlackPepperPowderItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(Taste.SPICY.displayName());
        tooltipComponents.add(Taste.SHARP.displayName());
        tooltipComponents.add(Taste.EARTHY.displayName());
        tooltipComponents.add(Taste.POWDERY.displayName());
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 5;
    }
}
