package soulcollector.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import soulcollector.items.SoulCollectorItems;
import soulcollector.items.base.DragonRage;
import soulcollector.items.base.SoulItem;
import soulcollector.items.base.TechnoBlade;
import soulcollector.items.tools.SoulCollectorTools;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    LivingEntity self = (LivingEntity)(Object)this;
    @Inject(method="drop", at = @At("TAIL"))
    void drop(DamageSource source, CallbackInfo ci){
        if(source.getAttacker() instanceof LivingEntity attacker){
            if(attacker.getStackInHand(Hand.MAIN_HAND).isOf(SoulCollectorTools.SOUL_BASHER)){
                SoulCollectorItems.ITEMS.forEach((identifier, item) -> {
                    if(item instanceof SoulItem soulItem){
                        for(EntityType<?> type : soulItem.entityTypes){
                            if(self.getType().equals(type)){
                                self.dropStack(soulItem.getDefaultStack());
                            }
                        }
                    }
                });
            }
        }
    }
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
}
