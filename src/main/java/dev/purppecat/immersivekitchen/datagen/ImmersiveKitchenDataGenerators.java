package dev.purppecat.immersivekitchen.datagen;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import dev.purppecat.immersivekitchen.datagen.advancements.ImmersiveKitchenAdvancementProvider;
import dev.purppecat.immersivekitchen.datagen.lang.ImmersiveKitchenEnUsLanguageProvider;
import dev.purppecat.immersivekitchen.tags.ImmersiveKitchenBlockTagsProvider;
import dev.purppecat.immersivekitchen.tags.ImmersiveKitchenItemTagsProvider;
import dev.thomasglasser.tommylib.api.data.DataGenerationUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class ImmersiveKitchenDataGenerators {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder();

    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();
        boolean onServer = event.includeServer();
        event.createDatapackRegistryObjects(BUILDER);
        DataGenerationUtils.createRegistryDumpReport(event, ImmersiveKitchen.MOD_ID);
        DatapackBuiltinEntriesProvider builtinEntriesProvider = new DatapackBuiltinEntriesProvider(packOutput, registries, BUILDER, Set.of(ImmersiveKitchen.MOD_ID));
//        generator.addProvider(onServer, builtinEntriesProvider);
        registries = builtinEntriesProvider.getRegistryProvider();

        //common
        DataGenerationUtils.createLangDependent(event, ImmersiveKitchenEnUsLanguageProvider::new, ImmersiveKitchenAdvancementProvider::new);

        DataGenerationUtils.createBlockAndItemTags(event, ImmersiveKitchenBlockTagsProvider::new, ImmersiveKitchenItemTagsProvider::new);


        generator.addProvider(onServer, new ImmersiveKitchenLootTables(packOutput, registries));
        generator.addProvider(event.includeClient(), new ImmersiveKitchenItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(onServer, new ImmersiveKitchenBlockStateProvider(packOutput, existingFileHelper));
    }
}
