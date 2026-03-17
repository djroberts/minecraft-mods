package com.horsemeat;

import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.world.item.CreativeModeTabs;

@Mod(HorseMeatMod.MOD_ID)
public class HorseMeatMod {
    public static final String MOD_ID = "horsemeat";

    public HorseMeatMod(IEventBus modEventBus) {
        ModItems.register(modEventBus);
        NeoForge.EVENT_BUS.register(ModEvents.class);
        modEventBus.addListener(this::addCreativeTabItems);
        System.out.println("Horse Meat Mod loaded! Extra meat drops from horses!");
    }

    private void addCreativeTabItems(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.RAW_HORSE_MEAT);
            event.accept(ModItems.HORSE_STEAK);
            event.accept(ModItems.HORSE_SAUSAGE);
        }
    }
}
