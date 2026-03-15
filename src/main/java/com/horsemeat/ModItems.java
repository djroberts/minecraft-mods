package com.horsemeat;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.minecraft.world.food.FoodProperties;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HorseMeatMod.MOD_ID);
    
    public static final DeferredItem<Item> HORSE_SAUSAGE = ITEMS.registerSimpleItem("horse_sausage", 
        props -> props.food(new FoodProperties.Builder()
            .nutrition(6)
            .build()));
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
