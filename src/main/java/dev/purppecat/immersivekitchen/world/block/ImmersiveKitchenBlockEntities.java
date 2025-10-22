package dev.purppecat.immersivekitchen.world.block;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.purppecat.immersivekitchen.world.block.entity.MortarBlockEntity;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ImmersiveKitchenBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ImmersiveKitchen.MOD_ID);

    public static final Supplier<BlockEntityType<MortarBlockEntity>> MORTAR_E = BLOCK_ENTITIES.register("mortar_e", () -> BlockEntityType.Builder.of(
            MortarBlockEntity::new, ImmersiveKitchenBlocks.MORTAR.get()).build(null));

    public static void init() {}
}
