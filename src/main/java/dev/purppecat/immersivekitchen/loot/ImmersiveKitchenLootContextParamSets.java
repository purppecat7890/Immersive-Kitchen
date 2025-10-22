package dev.purppecat.immersivekitchen.loot;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.function.Consumer;

public class ImmersiveKitchenLootContextParamSets {
    public static final LootContextParamSet PESTLE = register("pestle", builder -> builder
            .required(LootContextParams.ORIGIN)
            .build());

    private static LootContextParamSet register(String registryName, Consumer<LootContextParamSet.Builder> builderConsumer) {
        LootContextParamSet.Builder lootcontextparamset$builder = new LootContextParamSet.Builder();
        builderConsumer.accept(lootcontextparamset$builder);
        LootContextParamSet lootcontextparamset = lootcontextparamset$builder.build();
        ResourceLocation resourcelocation = ImmersiveKitchen.modLoc(registryName);
        LootContextParamSet lootcontextparamset1 = LootContextParamSets.REGISTRY.put(resourcelocation, lootcontextparamset);
        if (lootcontextparamset1 != null) {
            throw new IllegalStateException("Loot table parameter set " + resourcelocation + " is already registered");
        } else {
            return lootcontextparamset;
        }
    }

    public static void init() {}
}
