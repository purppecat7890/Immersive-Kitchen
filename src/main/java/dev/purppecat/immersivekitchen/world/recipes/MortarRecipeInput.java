package dev.purppecat.immersivekitchen.world.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record MortarRecipeInput(ItemStack input) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }
}
