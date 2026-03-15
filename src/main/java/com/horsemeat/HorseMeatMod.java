package com.horsemeat;

import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(HorseMeatMod.MOD_ID)
public class HorseMeatMod {
    public static final String MOD_ID = "horsemeat";
    
    public HorseMeatMod() {
        NeoForge.EVENT_BUS.register(ModEvents.class);
        System.out.println("Horse Meat Mod loaded! Extra meat drops from horses!");
    }
}
