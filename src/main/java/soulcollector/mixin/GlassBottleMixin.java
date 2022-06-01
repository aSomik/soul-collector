package soulcollector.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import soulcollector.blocks.SoulCollectorBlocks;
import soulcollector.fluid.SoulCollectorFluids;
import soulcollector.items.SoulCollectorItems;

@Mixin(GlassBottleItem.class)
public abstract class GlassBottleMixin extends Item {

    public GlassBottleMixin(Settings settings) {
        super(settings);
    }

    @Inject(method="use", at = @At("HEAD"), cancellable = true)
    void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir){
        HitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        BlockPos blockPos = ((BlockHitResult)hitResult).getBlockPos();
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.getBlockState(blockPos).isOf(SoulCollectorBlocks.MELIS)) {
            world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
            cir.setReturnValue(TypedActionResult.success(fillMelis(itemStack, user, new ItemStack(SoulCollectorItems.MELIS_BOTTLE)), world.isClient()));
        }
    }
    protected ItemStack fillMelis(ItemStack stack, PlayerEntity player, ItemStack outputStack) {
        player.incrementStat(Stats.USED.getOrCreateStat(this));
        return ItemUsage.exchangeStack(stack, player, outputStack);
    }
}
