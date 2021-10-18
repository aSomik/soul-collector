package soulcollector.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import soulcollector.items.SoulCollectorItems;
import soulcollector.items.base.SoulItem;
import soulcollector.items.tools.SoulCollectorTools;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    LivingEntity self = (LivingEntity)(Object)this;
    @Inject(method="drop", at = @At("TAIL"))
    void drop(DamageSource source, CallbackInfo ci){
        if(source.getAttacker()instanceof LivingEntity attacker){
            if(attacker.getStackInHand(Hand.MAIN_HAND).isOf(SoulCollectorTools.SOUL_HAMMER)){
                SoulCollectorItems.ITEMS.forEach((identifier, item) -> {
                    if(item instanceof SoulItem soulItem){
                        if(self.getType().equals(soulItem.entityType)){
                            self.dropStack(soulItem.getDefaultStack());
                        }
                    }
                });
            }
        }
    }
}
