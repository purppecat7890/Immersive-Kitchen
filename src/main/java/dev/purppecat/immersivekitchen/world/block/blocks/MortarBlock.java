package dev.purppecat.immersivekitchen.world.block.blocks;

import com.mojang.serialization.MapCodec;
import dev.purppecat.immersivekitchen.loot.ImmersiveKitchenLootContextParamSets;
import dev.purppecat.immersivekitchen.loot.ImmersiveKitchenLootKeys;
import dev.purppecat.immersivekitchen.world.block.ImmersiveKitchenBlockStateProperties;
import dev.purppecat.immersivekitchen.world.block.entity.MortarBlockEntity;
import dev.purppecat.immersivekitchen.world.item.ImmersiveKitchenItems;
import dev.purppecat.immersivekitchen.world.screen.custom.MortarMenu;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MortarBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty PESTLE = ImmersiveKitchenBlockStateProperties.PESTLE;

    public MortarBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(PESTLE, Boolean.valueOf(false)));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, PESTLE);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(PESTLE, false);
    }

    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);
    public static final MapCodec<MortarBlock> CODEC = simpleCodec(MortarBlock::new);

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!level.isClientSide()) {
            if (state.getValue(PESTLE)) {
                if (state.getBlock() != newState.getBlock()) {
                    spawnPestle(state, level, pos);
                    level.updateNeighbourForOutputSignal(pos, this);
                }
            }
            if (state.getBlock() != newState.getBlock()) {
                if (level.getBlockEntity(pos) instanceof MortarBlockEntity mortarBlockEntity) {
                    mortarBlockEntity.drops();
                }
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MortarBlockEntity(pos, state);
    }

    private void spawnPestle(BlockState state, Level level, BlockPos pos) {
        if (!level.isClientSide()) {
            if (state.getValue(PESTLE)) {
                if (level instanceof ServerLevel serverLevel) {
                    LootTable lootTable = serverLevel.getServer().reloadableRegistries().getLootTable(ImmersiveKitchenLootKeys.PESTLE);

                    LootParams.Builder builder = new LootParams.Builder(serverLevel).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                            .withParameter(LootContextParams.BLOCK_STATE, state);

                    LootParams lootparams = builder.create(ImmersiveKitchenLootContextParamSets.PESTLE);
                    lootTable.getRandomItems(lootparams, itemStack -> Block.popResource(level, pos, itemStack));
                }
            }
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.isClientSide) return ItemInteractionResult.SUCCESS;
        ItemStack heldItem = player.getItemInHand(hand);
        BlockState currentState = level.getBlockState(pos);
        if (heldItem.isEmpty()) {
            if (currentState.getValue(PESTLE) && player.isCrouching()) {
                level.setBlock(pos, currentState.setValue(PESTLE, false), 3);
                player.addItem(ImmersiveKitchenItems.PESTLE.get().getDefaultInstance());
                return ItemInteractionResult.SUCCESS;
            } else {
                if(level.getBlockEntity(pos) instanceof MortarBlockEntity mortarBlockEntity) {
                    ((ServerPlayer) player).openMenu(new SimpleMenuProvider(mortarBlockEntity, Component.literal("Mortar")), pos);
                    return ItemInteractionResult.SUCCESS;
                }
            }
        } else if (heldItem.getItem() == ImmersiveKitchenItems.PESTLE.get()) {
            if (!currentState.getValue(PESTLE)) {
                level.setBlock(pos, currentState.setValue(PESTLE, true), 3);
                heldItem.shrink(1);
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
