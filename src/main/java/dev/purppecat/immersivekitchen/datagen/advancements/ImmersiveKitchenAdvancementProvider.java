package dev.purppecat.immersivekitchen.datagen.advancements;

import dev.purppecat.immersivekitchen.datagen.advancements.packs.ImmersiveKitchenAdvancements;
import dev.thomasglasser.tommylib.api.data.advancements.ExtendedAdvancementProvider;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ImmersiveKitchenAdvancementProvider extends ExtendedAdvancementProvider {
    public ImmersiveKitchenAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, BiConsumer<String, String> lang, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, ReferenceOpenHashSet.of(
                new ImmersiveKitchenAdvancements(lang)));
    }
}
