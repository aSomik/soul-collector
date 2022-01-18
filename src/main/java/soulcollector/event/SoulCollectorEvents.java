package soulcollector.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import soulcollector.items.SoulCollectorItems;
import soulcollector.items.base.PlayerSoulItem;
import soulcollector.items.base.SoulCollector;
import soulcollector.items.base.SoulItem;
import soulcollector.items.tools.SoulCollectorTools;

public class SoulCollectorEvents {

    public static void register(){
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            if(entity instanceof LivingEntity attacker){
                if(attacker.getStackInHand(Hand.MAIN_HAND).isOf(SoulCollectorTools.SOUL_BASHER)){
                    SoulCollectorItems.ITEMS.forEach((identifier, item) -> {
                        if(item instanceof SoulItem soulItem){
                            for(EntityType<?> type : soulItem.entityTypes){
                                if(killedEntity.getType().equals(type)){
                                    if(killedEntity instanceof PlayerEntity player){
                                        if(item instanceof PlayerSoulItem soul){
                                            if(player.getName().asString().equals(soul.name)){
                                                killedEntity.dropStack(soul.getDefaultStack());
                                            }
                                        }
                                    }
                                    else killedEntity.dropStack(soulItem.getDefaultStack());
                                }
                            }
                        }
                    });
                }
            }
        });
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            if(entity instanceof LivingEntity attacker){
                if(attacker.getStackInHand(Hand.MAIN_HAND).isOf(SoulCollectorTools.SOUL_COLLECTOR)){
                    SoulCollector.ENTRIES.forEach((entityType, entry) -> {
                        if(killedEntity.getType().equals(entityType)){
                            attacker.addStatusEffect(new StatusEffectInstance(entry.getKey(), entry.getValue()));
                        }
                    });
                }
            }
        });
    }
}
