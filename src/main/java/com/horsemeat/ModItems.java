package com.horsemeat;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.food.FoodProperties;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HorseMeatMod.MOD_ID);
    
    public static final Supplier<Item> HORSE_SAUSAGE = ITEMS.register("horse_sausage", 
        () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(6)
            .build())));
            
    public static final Supplier<Item> FRIKANDEL = ITEMS.register("frikandel",
        () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(8)
            .build())));
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
