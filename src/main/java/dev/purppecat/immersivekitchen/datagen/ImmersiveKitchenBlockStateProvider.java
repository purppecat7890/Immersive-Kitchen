package dev.purppecat.immersivekitchen.datagen;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.purppecat.immersivekitchen.world.block.ImmersiveKitchenBlocks;
import dev.thomasglasser.tommylib.api.data.blockstates.ExtendedBlockStateProvider;
import dev.thomasglasser.tommylib.api.registration.DeferredBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ImmersiveKitchenBlockStateProvider extends ExtendedBlockStateProvider {
    public ImmersiveKitchenBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ImmersiveKitchen.MOD_ID, exFileHelper);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ImmersiveKitchenBlocks.PURP_LUCKY_BLOCK);
    }
}
