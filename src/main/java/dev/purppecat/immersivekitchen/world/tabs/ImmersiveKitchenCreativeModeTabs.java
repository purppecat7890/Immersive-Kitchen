package dev.purppecat.immersivekitchen.world.tabs;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.purppecat.immersivekitchen.world.item.ImmersiveKitchenItems;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ImmersiveKitchenCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ImmersiveKitchen.MOD_ID);

    public static final Supplier<CreativeModeTab> FRUITS_TAB = CREATIVE_MODE_TABS.register("fruits",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.APPLE)).title(Component.translatable("creativetab.immersivekitchen.fruits").withColor(0xcf302d))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ImmersiveKitchenItems.LEMON.get());
                        output.accept(Items.SWEET_BERRIES);
                        output.accept(Items.MELON);
                        output.accept(Items.APPLE);
                        output.accept(Items.GLOW_BERRIES);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> VEGETABLES = CREATIVE_MODE_TABS.register("vegetables",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.CARROT)).title(Component.translatable("creativetab.immersivekitchen.vegetables").withColor(0x45b058))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(Items.CARROT);
                        output.accept(Items.POTATO);
                        output.accept(Items.BEETROOT);
                        output.accept(Items.KELP);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> SEASONINGS = CREATIVE_MODE_TABS.register("seasonings",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ImmersiveKitchenItems.SALT.get())).title(Component.translatable("creativetab.immersivekitchen.seasonings").withColor(0xcf7e2d))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ImmersiveKitchenItems.SALT.get());
                        output.accept(ImmersiveKitchenItems.BLACK_PEPPER_POWDER.get());
                    })
                    .build());
    public static final Supplier<CreativeModeTab> KEY_INGREDIENTS = CREATIVE_MODE_TABS.register("key_ingredients",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.EGG)).title(Component.translatable("creativetab.immersivekitchen.key_ingredients").withColor(0x83f28e))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(Items.EGG);
                        output.accept(ImmersiveKitchenItems.FLOUR.get());
                        output.accept(ImmersiveKitchenItems.BUTTER.get());
                        output.accept(Items.MILK_BUCKET);
                        output.accept(Items.SUGAR);
                        output.accept(ImmersiveKitchenItems.SALT.get());
                        output.accept(Items.WATER_BUCKET);
                    })
                    .build());


    public static void init() {}
}
