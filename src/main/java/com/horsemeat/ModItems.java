package com.horsemeat;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.minecraft.world.food.FoodProperties;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HorseMeatMod.MOD_ID);
    
    public static final DeferredItem<Item> RAW_HORSE_MEAT = ITEMS.registerSimpleItem("raw_horse_meat", 
        props -> props.food(new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3f)
            .build()));
    
    public static final DeferredItem<Item> HORSE_STEAK = ITEMS.registerSimpleItem("horse_steak", 
        props -> props.food(new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.8f)
            .build()));
    
    public static final DeferredItem<Item> HORSE_SAUSAGE = ITEMS.registerSimpleItem("horse_sausage", 
        props -> props.food(new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.6f)
            .build()));
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
