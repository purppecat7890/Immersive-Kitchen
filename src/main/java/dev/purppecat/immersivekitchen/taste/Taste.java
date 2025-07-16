package dev.purppecat.immersivekitchen.taste;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.function.Consumer;

public enum Taste implements TooltipProvider, StringRepresentable {
    SOUR(0xf2d863),
    SWEET(0xbdf797),
    TANGY(0x8a8c30),
    SALTY(0xdbdbdb),
    SPICY(0x73202e),
    EARTHY(0x3f2b0b),

    JUICY(0xdd6a6a),

    CRISPY(0xCA8606),

    FRESH(0xd7ff00),

    TART(0xebea8f),

    DRY(0x8c736b),
    SMOOTH(0xede5ce),
    SOFT(0xf0c9ee),
    SHARP(0xd1bdab),
    CREAMY(0xfaead1),
    FATTY(0xd18916),
    BLAND(0x999999),
    POWDERY(0x595246),
    BITTER(0x3b1c12);

    private final Component displayName;

    Taste(int color) {
        this.displayName = Component.translatable("taste." + ImmersiveKitchen.MOD_ID + "." + getSerializedName()).withStyle().withColor(color);
    }

    public Component displayName() {
        return displayName;
    }
    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
        tooltipAdder.accept(this.displayName);
    }

    @Override
    public String getSerializedName() {
        return name().toLowerCase();
    }
}