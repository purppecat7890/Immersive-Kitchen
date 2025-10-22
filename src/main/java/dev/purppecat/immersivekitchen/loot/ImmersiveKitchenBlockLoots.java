package dev.purppecat.immersivekitchen.loot;

import dev.purppecat.immersivekitchen.world.block.ImmersiveKitchenBlocks;
import dev.thomasglasser.tommylib.api.data.loot.ExtendedBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlags;

import java.util.Set;

public class ImmersiveKitchenBlockLoots extends ExtendedBlockLootSubProvider {
    public ImmersiveKitchenBlockLoots(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider, ImmersiveKitchenBlocks.BLOCKS);
    }

    @Override
    protected void generate() {
        dropSelf(ImmersiveKitchenBlocks.MORTAR.get());
    }
}

