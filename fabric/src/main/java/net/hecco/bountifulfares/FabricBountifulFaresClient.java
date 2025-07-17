package net.hecco.bountifulfares;

import net.fabricmc.api.ClientModInitializer;

public class FabricBountifulFaresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BountifulFaresClient.onInitializeClient();
    }
}
