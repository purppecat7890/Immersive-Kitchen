package dev.purppecat.immersivekitchen.datagen;

import dev.purppecat.immersivekitchen.loot.ImmersiveKitchenBlockLoots;
import dev.purppecat.immersivekitchen.loot.ImmersiveKitchenLootContextParamSets;
import dev.purppecat.immersivekitchen.loot.ImmersiveKitchenPestleLootTable;
import dev.thomasglasser.tommylib.api.data.loot.ExtendedLootTableProvider;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ImmersiveKitchenLootTables extends ExtendedLootTableProvider {
    public ImmersiveKitchenLootTables(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pOutput, Set.of(), List.of(
                new SubProviderEntry(ImmersiveKitchenBlockLoots::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(ImmersiveKitchenPestleLootTable::new, ImmersiveKitchenLootContextParamSets.PESTLE)), lookupProvider);
    }
}
