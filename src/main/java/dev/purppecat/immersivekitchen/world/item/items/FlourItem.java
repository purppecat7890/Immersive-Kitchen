package dev.purppecat.immersivekitchen.world.item.items;

import dev.purppecat.immersivekitchen.taste.Taste;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class FlourItem extends Item {
    public FlourItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(Taste.BLAND.displayName());
        tooltipComponents.add(Taste.DRY.displayName());
        tooltipComponents.add(Taste.POWDERY.displayName());
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 5;
    }
}
