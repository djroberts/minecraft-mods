package com.horsemeat;

import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.bus.api.SubscribeEvent;

@Mod(HorseMeatMod.MOD_ID)
public class HorseMeatMod {
    public static final String MOD_ID = "horsemeat";
    
    public HorseMeatMod(IEventBus modEventBus) {
        ModItems.register(modEventBus);
        NeoForge.EVENT_BUS.register(ModEvents.class);
        System.out.println("Horse Meat Mod loaded! Extra meat drops from horses!");
    }
}
