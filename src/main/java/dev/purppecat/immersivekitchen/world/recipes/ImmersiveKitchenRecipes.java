package dev.purppecat.immersivekitchen.world.recipes;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.thomasglasser.tommylib.api.registration.DeferredHolder;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ImmersiveKitchenRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, ImmersiveKitchen.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, ImmersiveKitchen.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MortarRecipe>> MORTAR_SERIALIZER =
            SERIALIZERS.register("mortar", MortarRecipe.Serializer::new);

    public static final DeferredHolder<RecipeType<?>, RecipeType<MortarRecipe>> MORTAR_TYPE =
            TYPES.register("mortar", () -> new RecipeType<MortarRecipe>() {
                @Override
                public String toString() {
                    return "mortar";
                }
            });

    public static void init() {}
}
