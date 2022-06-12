package soulcollector.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import soulcollector.items.base.DragonRage;
import soulcollector.items.base.TechnoBlade;
import soulcollector.items.tools.SoulCollectorTools;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method="onDeath", at = @At("TAIL"))
    void onDeath(DamageSource source, CallbackInfo ci){
        if(source.getAttacker() instanceof LivingEntity attacker){
            if(attacker.getStackInHand(Hand.MAIN_HAND).isOf(SoulCollectorTools.TECHNO_BLADE)){
                ItemStack attackerStack = attacker.getStackInHand(Hand.MAIN_HAND);
                int killCount = TechnoBlade.getKillCount(attackerStack);
                TechnoBlade.setKillCount(attackerStack, killCount+1);
            }
        }
    }
    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
        if(source.getAttacker() instanceof LivingEntity attacker){
            if(attacker.getStackInHand(Hand.MAIN_HAND).isOf(SoulCollectorTools.DRAGON_RAGE)){
                int mode = DragonRage.getMode(attacker.getStackInHand(Hand.MAIN_HAND));
                if(mode == 1){
                    cir.setReturnValue(false);
                }
            }
        }
    }
}
