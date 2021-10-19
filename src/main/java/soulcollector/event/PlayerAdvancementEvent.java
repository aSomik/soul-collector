package soulcollector.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.advancement.Advancement;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public interface PlayerAdvancementEvent {
    Event<PlayerAdvancementEvent> EVENT = EventFactory.createArrayBacked(
            PlayerAdvancementEvent.class,
            playerAdvancementEvents -> (player, advancement) -> {
                for(var event : playerAdvancementEvents){
                    event.onAdvancementComplete(player, advancement);
                }
            }
    );

    void onAdvancementComplete(ServerPlayerEntity player, Advancement advancement);
}
