package soulcollector.client;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import soulcollector.items.SoulCollectorItems;

public class SoulCollectorClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SoulCollectorItems.ITEMS.forEach((identifier, item) -> {
            if(item instanceof TrinketRenderer renderer){
                TrinketRendererRegistry.registerRenderer(item, renderer);
            }
        });
    }
}
