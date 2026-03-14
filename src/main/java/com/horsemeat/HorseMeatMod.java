package com.horsemeat;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(HorseMeatMod.MOD_ID)
public class HorseMeatMod {
    public static final String MOD_ID = "horsemeat";
    
    public HorseMeatMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(ModEvents::onLivingDrops);
        modContainer.getEventBus().register(this);
        System.out.println("Horse Meat Mod loaded! Extra meat drops from horses!");
    }
}
