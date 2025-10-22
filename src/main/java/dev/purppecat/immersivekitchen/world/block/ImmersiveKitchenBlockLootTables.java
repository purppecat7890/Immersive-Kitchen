package dev.purppecat.immersivekitchen.world.block;

import dev.thomasglasser.tommylib.api.data.loot.ExtendedBlockLootSubProvider;
import java.util.Set;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlags;

public class ImmersiveKitchenBlockLootTables extends ExtendedBlockLootSubProvider {
    public ImmersiveKitchenBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider, ImmersiveKitchenBlocks.BLOCKS);
    }

    @Override
    protected void generate() {
        dropSelf(ImmersiveKitchenBlocks.MORTAR.get());
    }
}
