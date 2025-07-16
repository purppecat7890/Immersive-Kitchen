package dev.purppecat.immersivekitchen.datagen;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.purppecat.immersivekitchen.world.block.ImmersiveKitchenBlocks;
import dev.thomasglasser.tommylib.api.data.loot.ExtendedBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlags;

import java.util.Set;

public class ImmersiveKitchenBlockLootTables extends ExtendedBlockLootSubProvider {
    protected ImmersiveKitchenBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider, ImmersiveKitchenBlocks.BLOCKS);
    }

    @Override
    protected void generate() {
        dropSelf(ImmersiveKitchenBlocks.PURP_LUCKY_BLOCK.get());
    }
}
