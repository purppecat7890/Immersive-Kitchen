package dev.purppecat.immersivekitchen.tags;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.thomasglasser.tommylib.api.tags.TagUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ImmersiveKitchenItemTags {
    /// Items that taste sweet.
    public static final TagKey<Item> SWEET = create("sweet");
    /// Items that taste salty.
    public static final TagKey<Item> SALTY = create("salty");
    /// Items that taste smooth.
    public static final TagKey<Item> SMOOTH = create("smooth");
    /// Items that taste powdery.
    public static final TagKey<Item> POWDERY = create("powdery");
    /// Items that taste tangy.
    public static final TagKey<Item> TANGY = create("tangy");
    /// Items that taste dry.
    public static final TagKey<Item> DRY = create("dry");
    /// Items that taste spicy.
    public static final TagKey<Item> SPICY = create("spicy");
    /// Items that taste fresh.
    public static final TagKey<Item> FRESH = create("fresh");
    /// Items that taste like tart.
    public static final TagKey<Item> TART = create("tart");
    /// Items that taste bitter.
    public static final TagKey<Item> BITTER = create("bitter");
    /// Items that taste bland.
    public static final TagKey<Item> BLAND = create("bland");
    /// Items that taste fatty.
    public static final TagKey<Item> FATTY = create("fatty");
    /// Items that taste crispy.
    public static final TagKey<Item> CRISPY = create("crispy");
    /// Items that taste juicy.
    public static final TagKey<Item> JUICY = create("juicy");
    /// Items that taste creamy.
    public static final TagKey<Item> CREAMY = create("creamy");
    /// Items that taste intense.
    public static final TagKey<Item> INTENSE = create("intense");
    /// Items that taste natural.
    public static final TagKey<Item> NATURAL = create("natural");
    /// Items that taste soft.
    public static final TagKey<Item> SOFT = create("soft");
    /// Items that taste starchy.
    public static final TagKey<Item> STARCHY = create("starchy");
    /// Items that taste chewy.
    public static final TagKey<Item> CHEWY = create("chewy");
    ///  Items that taste sour.
    public static final TagKey<Item> SOUR = create("sour");
    ///  Items that taste like meat.
    public static final TagKey<Item> MEATY = create("meaty");
    ///  Items that taste fishy.
    public static final TagKey<Item> FISHY = create("fishy");
    ///  Items that taste floral.
    public static final TagKey<Item> FLORAL = create("floral");
    ///  Items that taste special.
    public static final TagKey<Item> SPECIAL = create("special");
    ///  Items that taste mild.
    public static final TagKey<Item> MILD = create("mild");
    ///  Items that taste oily.
    public static final TagKey<Item> OILY = create("oily");
    ///  Items that taste rich.
    public static final TagKey<Item> RICH = create("rich");
    ///  Items that taste flaky.
    public static final TagKey<Item> FLAKY = create("flaky");
    ///  Items that taste savory.
    public static final TagKey<Item> SAVORY = create("savory");


    private static TagKey<Item> create(String name) {
        return TagKey.create(Registries.ITEM, ImmersiveKitchen.modLoc(name));
    }

    private static TagKey<Item> createC(String name) {
        return TagUtils.createConventional(Registries.ITEM, name);
    }
}
