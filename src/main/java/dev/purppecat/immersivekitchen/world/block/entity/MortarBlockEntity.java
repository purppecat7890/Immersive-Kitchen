package dev.purppecat.immersivekitchen.world.block.entity;

import dev.purppecat.immersivekitchen.world.block.ImmersiveKitchenBlockEntities;
import dev.purppecat.immersivekitchen.world.recipes.ImmersiveKitchenRecipes;
import dev.purppecat.immersivekitchen.world.recipes.MortarRecipe;
import dev.purppecat.immersivekitchen.world.recipes.MortarRecipeInput;
import dev.purppecat.immersivekitchen.world.screen.custom.MortarMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MortarBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler inventory = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    public MortarBlockEntity(BlockPos pos, BlockState blockState) {
        super(ImmersiveKitchenBlockEntities.MORTAR_E.get(), pos, blockState);

        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> MortarBlockEntity.this.progress;
                    case 1 -> MortarBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0: MortarBlockEntity.this.progress = value;
                    case 1: MortarBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public void clearContents() {
        inventory.setStackInSlot(0, ItemStack.EMPTY);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
        progress = tag.getInt("mortar.progress");
        maxProgress = tag.getInt("mortar.max_progress");
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
        progress = tag.getInt("growth_chamber.progress");
        maxProgress = tag.getInt("growth_chamber.max_progress");
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 72;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private Optional<RecipeHolder<MortarRecipe>> getCurrentRecipe() {
        return this.level.getRecipeManager()
                .getRecipeFor(ImmersiveKitchenRecipes.MORTAR_TYPE.get(), new MortarRecipeInput(inventory.getStackInSlot(INPUT_SLOT)), level);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return inventory.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                inventory.getStackInSlot(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = inventory.getStackInSlot(OUTPUT_SLOT).isEmpty() ? 64 : inventory.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        int currentCount = inventory.getStackInSlot(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<MortarRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().output();
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private void craftItem() {
        Optional<RecipeHolder<MortarRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        inventory.extractItem(INPUT_SLOT, 1, false);
        inventory.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(),
                inventory.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Mortar");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new MortarMenu(i, inventory, this, this.data);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(level, blockPos, blockState);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }


    public void drops() {
        SimpleContainer container = new SimpleContainer(inventory.getSlots());
        for (int i = 0; i < inventory.getSlots(); i++) {
            container.setItem(i, inventory.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, container);
    }
}
