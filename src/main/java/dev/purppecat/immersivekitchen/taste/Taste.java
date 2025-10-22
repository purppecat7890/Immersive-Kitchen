package dev.purppecat.immersivekitchen.taste;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import java.util.function.Consumer;

import dev.purppecat.immersivekitchen.tags.ImmersiveKitchenItemTags;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

public enum Taste implements TooltipProvider, StringRepresentable {


    SOUR(0xf2d863, ImmersiveKitchenItemTags.SOUR),
    SWEET(0xbdf797, ImmersiveKitchenItemTags.SWEET),
    TANGY(0x8a8c30, ImmersiveKitchenItemTags.TANGY),
    SALTY(0xdbdbdb, ImmersiveKitchenItemTags.SALTY),
    SPICY(0x73202e, ImmersiveKitchenItemTags.SPICY),
    NATURAL(0x3f2b0b,ImmersiveKitchenItemTags.NATURAL),
    JUICY(0xdd6a6a, ImmersiveKitchenItemTags.JUICY),
    CRISPY(0xCA8606,ImmersiveKitchenItemTags.CRISPY),
    FRESH(0xd7ff00, ImmersiveKitchenItemTags.FRESH),
    TART(0xebea8f, ImmersiveKitchenItemTags.TART),
    DRY(0x8c736b, ImmersiveKitchenItemTags.DRY),
    SMOOTH(0xede5ce, ImmersiveKitchenItemTags.SMOOTH),
    SOFT(0xf0c9ee, ImmersiveKitchenItemTags.SOFT),
    INTENSE(0xd1bdab,ImmersiveKitchenItemTags.INTENSE),
    CREAMY(0xfaead1, ImmersiveKitchenItemTags.CREAMY),
    FATTY(0xd18916, ImmersiveKitchenItemTags.FATTY),
    BLAND(0x999999, ImmersiveKitchenItemTags.BLAND),
    POWDERY(0x595246, ImmersiveKitchenItemTags.POWDERY),
    BITTER(0x3b1c12, ImmersiveKitchenItemTags.BITTER),
    CHEWY(0xa86939, ImmersiveKitchenItemTags.CHEWY),
    MEATY(0xeb4452 , ImmersiveKitchenItemTags.MEATY),

    STARCHY(0xa89d85, ImmersiveKitchenItemTags.STARCHY),;


    private final Component displayName;
    private final TagKey<Item> tag;

    Taste(int color, TagKey<Item> tag) {
        this.displayName = Component.translatable("taste." + ImmersiveKitchen.MOD_ID + "." + getSerializedName()).withStyle().withColor(color);
        this.tag = tag;
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

    public TagKey<Item> tag() {
        return tag;
    }
}
