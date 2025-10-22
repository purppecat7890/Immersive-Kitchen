package dev.purppecat.immersivekitchen.world.screen;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.purppecat.immersivekitchen.world.screen.custom.MortarMenu;
import dev.thomasglasser.tommylib.api.registration.DeferredHolder;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;

public class ImmersiveKitchenMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(BuiltInRegistries.MENU, ImmersiveKitchen.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<MortarMenu>> MORTAR_MENU =
            registerMenuType("mortar_menu", MortarMenu::new);

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name,
                                                                                                               IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void init() {}
}
