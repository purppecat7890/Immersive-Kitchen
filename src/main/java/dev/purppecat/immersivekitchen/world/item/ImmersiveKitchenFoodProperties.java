package dev.purppecat.immersivekitchen.world.item;

import net.minecraft.world.food.FoodProperties;

public class ImmersiveKitchenFoodProperties {
    public static final FoodProperties LEMON = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .alwaysEdible().build();
    public static final FoodProperties SALT = new FoodProperties.Builder().nutrition(0).saturationModifier(-1)
            .alwaysEdible().build();
    public static final FoodProperties BUTTER = new FoodProperties.Builder().nutrition(1).saturationModifier(2)
            .alwaysEdible().build();
    public static final FoodProperties FLOUR = new FoodProperties.Builder().nutrition(0).saturationModifier(-1)
            .alwaysEdible().build();

    public static final FoodProperties BLACK_PEPPER = new FoodProperties.Builder().nutrition(1).saturationModifier(0)
            .alwaysEdible().build();
}
