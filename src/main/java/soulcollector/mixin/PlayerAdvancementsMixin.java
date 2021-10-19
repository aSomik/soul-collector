package soulcollector.mixin;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import soulcollector.event.PlayerAdvancementEvent;

@Mixin(PlayerAdvancementTracker.class)
public class PlayerAdvancementsMixin {
    @Shadow private ServerPlayerEntity owner;

    @Inject(method = "grantCriterion", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancements/AdvancementRewards;grant(Lnet/minecraft/server/level/ServerPlayer;)V", shift = At.Shift.AFTER))
    void balls(Advancement advancement, String criterionName, CallbackInfoReturnable<Boolean> cir){
        PlayerAdvancementEvent.EVENT.invoker().onAdvancementComplete(owner, advancement);
    }
}
