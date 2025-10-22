package dev.purppecat.immersivekitchen.tags;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.purppecat.immersivekitchen.taste.Taste;
import dev.thomasglasser.tommylib.api.data.tags.ExtendedItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ImmersiveKitchenItemTagsProvider extends ExtendedItemTagsProvider {
    public ImmersiveKitchenItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockLookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockLookup, ImmersiveKitchen.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addTastes();
    }

    private void addTastes() {
        // Sweet
        tag(ImmersiveKitchenItemTags.SWEET)
                .add(Items.SUGAR)
                .add(Items.MELON_SLICE)
                .add(Items.APPLE)
                .add(Items.CARROT)
                .add(Items.SWEET_BERRIES)
                .add(Items.GLOW_BERRIES)
                .add(Items.BEETROOT)
                .add(Items.MELON)
                .add(Items.MILK_BUCKET);
        // SMOOTH
        tag(ImmersiveKitchenItemTags.SMOOTH)
                .add(Items.WATER_BUCKET)
                .add(Items.SUGAR);
        // SOFT
        tag(ImmersiveKitchenItemTags.SOFT)
                .add(Items.EGG)
                .add(Items.SUGAR)
                .add(Items.POTATO)
                .add(Items.BEETROOT)
                .add(Items.GLOW_BERRIES)
                .add(Items.MILK_BUCKET);
        // Creamy
        tag(ImmersiveKitchenItemTags.CREAMY)
                .add(Items.EGG)
                .add(Items.MILK_BUCKET);
        // Fresh
        tag(ImmersiveKitchenItemTags.FRESH)
                .add(Items.MELON_SLICE)
                .add(Items.MELON)
                .add(Items.WATER_BUCKET);
        // Bland
        tag(ImmersiveKitchenItemTags.BLAND)
                .add(Items.EGG)
                .add(Items.POTATO)
                .add(Items.WATER_BUCKET);
        // Juicy
        tag(ImmersiveKitchenItemTags.JUICY)
                .add(Items.MELON_SLICE)
                .add(Items.SWEET_BERRIES)
                .add(Items.APPLE)
                .add(Items.MELON);
        // Tart
        tag(ImmersiveKitchenItemTags.TART)
                .add(Items.SWEET_BERRIES);
        // Natural
        tag(ImmersiveKitchenItemTags.NATURAL)
                .add(Items.CARROT)
                .add(Items.KELP)
                .add(Items.BEETROOT)
                .add(Items.GLOW_BERRIES);
        // Crispy
        tag(ImmersiveKitchenItemTags.CRISPY)
                .add(Items.DRIED_KELP)
                .add(Items.CARROT)
                .add(Items.APPLE);
        // STARCHY
            tag(ImmersiveKitchenItemTags.STARCHY)
                    .add(Items.POTATO);
        // CHEWY
            tag(ImmersiveKitchenItemTags.CHEWY)
                    .add(Items.KELP);
        // SALTY
            tag(ImmersiveKitchenItemTags.SALTY)
                    .add(Items.DRIED_KELP)
                    .add(Items.KELP);
        // DRY
            tag(ImmersiveKitchenItemTags.DRY)
                    .add(Items.DRIED_KELP);
    }
}
