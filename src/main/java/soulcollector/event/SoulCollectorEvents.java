package soulcollector.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import soulcollector.api.armor.ArmorEffectRegistry;
import soulcollector.items.SoulCollectorItems;
import soulcollector.items.base.PlayerSoulItem;
import soulcollector.items.base.SoulCollector;
import soulcollector.items.base.SoulItem;
import soulcollector.items.tools.SoulCollectorTools;

import java.util.Arrays;

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
        ServerTickEvents.START_WORLD_TICK.register((world) -> world.getPlayers().forEach((player) -> ArmorEffectRegistry.getArmorEffects().forEach(armorEffect -> {
            if(Arrays.equals(getArmorAsList(player), armorEffect.getArmorAsList())){
                if(armorEffect.getStatusEffect() != null && !player.hasStatusEffect(armorEffect.getStatusEffect())){
                    player.addStatusEffect(new StatusEffectInstance(armorEffect.getStatusEffect(), 100, armorEffect.getAmplifier(), false, false));
                }
                armorEffect.tick(player, world);
            }
        })));
        PlayerAdvancementEvent.EVENT.register((player, advancement) -> {
            Identifier advancementId = new Identifier("minecraft:end/kill_dragon");
            if(advancementId.equals(advancement.getId())){
                player.giveItemStack(SoulCollectorTools.DRAGON_RAGE.getDefaultStack());
            }
        });
    }
    public static Item[] getArmorAsList(LivingEntity livingEntity){
        return new Item[]{livingEntity.getEquippedStack(EquipmentSlot.FEET).getItem(), livingEntity.getEquippedStack(EquipmentSlot.LEGS).getItem(), livingEntity.getEquippedStack(EquipmentSlot.CHEST).getItem(), livingEntity.getEquippedStack(EquipmentSlot.HEAD).getItem()};
    }
}
