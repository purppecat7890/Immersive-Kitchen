package dev.purppecat.immersivekitchen.tags;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.thomasglasser.tommylib.api.data.tags.ExtendedBlockTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ImmersiveKitchenBlockTagsProvider extends ExtendedBlockTagsProvider {
    public ImmersiveKitchenBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ImmersiveKitchen.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
