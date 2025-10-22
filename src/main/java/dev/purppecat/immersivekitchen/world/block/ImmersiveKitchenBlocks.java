package dev.purppecat.immersivekitchen.world.block;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.purppecat.immersivekitchen.world.block.blocks.MortarBlock;
import dev.purppecat.immersivekitchen.world.item.*;
import dev.thomasglasser.tommylib.api.registration.DeferredBlock;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ImmersiveKitchenBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ImmersiveKitchen.MOD_ID);

    public static final DeferredBlock<Block> MORTAR = registerBlock("mortar",
            () -> new MortarBlock(BlockBehaviour.Properties.of().noOcclusion()));
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ImmersiveKitchenItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void init() {}
}
