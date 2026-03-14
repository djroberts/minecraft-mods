package com.horsemeat;

import net.minecraftforge.fml.common.Mod;

@Mod(HorseMeatMod.MOD_ID)
public class HorseMeatMod {
    public static final String MOD_ID = "horsemeat";
    
    public HorseMeatMod() {
        MinecraftForge.EVENT_BUS.register(ModEvents.class);
        System.out.println("Horse Meat Mod loaded! Extra meat drops from horses!");
    }
}