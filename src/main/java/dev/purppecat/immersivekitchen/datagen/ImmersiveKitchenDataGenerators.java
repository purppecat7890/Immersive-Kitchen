package dev.purppecat.immersivekitchen.datagen;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ImmersiveKitchenDataGenerators {

    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();
        boolean onServer = event.includeServer();
        generator.addProvider(onServer, new ImmersiveKitchenLootTables(packOutput, registries));
        generator.addProvider(event.includeClient(), new ImmersiveKitchenItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(onServer, new ImmersiveKitchenBlockStateProvider(packOutput, existingFileHelper));
    }
}
