package dev.purppecat.immersivekitchen.world.item;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.thomasglasser.tommylib.api.registration.DeferredItem;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import dev.thomasglasser.tommylib.api.world.item.ItemUtils;
import java.util.function.Supplier;
import net.minecraft.world.item.Item;

public class ImmersiveKitchenItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ImmersiveKitchen.MOD_ID);

    public static final DeferredItem<LemonItem> LEMON = register("lemon", () -> new LemonItem(new Item.Properties().food(ImmersiveKitchenFoodProperties.LEMON).stacksTo(12).durability(2)));
    public static final DeferredItem<SaltItem> SALT = register("salt", () -> new SaltItem(new Item.Properties().food(ImmersiveKitchenFoodProperties.SALT).stacksTo(64)));
    public static final DeferredItem<FlourItem> FLOUR = register("flour", () -> new FlourItem(new Item.Properties().food(ImmersiveKitchenFoodProperties.FLOUR).stacksTo(64)));
    public static final DeferredItem<BlackPepperPowderItem> BLACK_PEPPER_POWDER = register("black_pepper_powder", () -> new BlackPepperPowderItem(new Item.Properties().food(ImmersiveKitchenFoodProperties.BLACK_PEPPER).stacksTo(64)));
    public static final DeferredItem<ButterItem> BUTTER = register("butter", () -> new ButterItem(new Item.Properties().food(ImmersiveKitchenFoodProperties.BUTTER).stacksTo(2)));



    public static <T extends Item> DeferredItem<T> register(String name, Supplier<T> item) {
        return ItemUtils.register(ITEMS, name, item);
    }

    public static void init() {}
}
