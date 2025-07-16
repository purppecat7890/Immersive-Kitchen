package dev.purppecat.immersivekitchen.datagen;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.purppecat.immersivekitchen.world.item.ImmersiveKitchenItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ImmersiveKitchenItemModelProvider extends ItemModelProvider {
    public ImmersiveKitchenItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ImmersiveKitchen.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ImmersiveKitchenItems.LEMON.get());
        basicItem(ImmersiveKitchenItems.SALT.get());
        basicItem(ImmersiveKitchenItems.BUTTER.get());
        basicItem(ImmersiveKitchenItems.FLOUR.get());
        basicItem(ImmersiveKitchenItems.BLACK_PEPPER_POWDER.get());
    }
}
