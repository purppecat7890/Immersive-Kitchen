package dev.purppecat.immersivekitchen.datagen.advancements.packs;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.thomasglasser.tommylib.api.data.advancements.ExtendedAdvancementGenerator;
import net.minecraft.core.HolderLookup;

import java.util.function.BiConsumer;

public class ImmersiveKitchenAdvancements extends ExtendedAdvancementGenerator {
    public ImmersiveKitchenAdvancements(BiConsumer<String, String> lang) {
        super(ImmersiveKitchen.MOD_ID, "immersive_kitchen", lang);
    }

    @Override
    protected void generate(HolderLookup.Provider provider) {

    }
}
