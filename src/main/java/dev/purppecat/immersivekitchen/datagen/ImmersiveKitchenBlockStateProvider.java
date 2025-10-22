package dev.purppecat.immersivekitchen.datagen;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.thomasglasser.tommylib.api.data.blockstates.ExtendedBlockStateProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ImmersiveKitchenBlockStateProvider extends ExtendedBlockStateProvider {
    public ImmersiveKitchenBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ImmersiveKitchen.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {}
}
