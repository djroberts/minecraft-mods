package com.horsemeat;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HorseMeatMod.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HorseMeatMod.MOD_ID);
    
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
    
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HORSE_MEAT_TAB = CREATIVE_TABS.register("horse_meat_tab", () -> 
        CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.horsemeat.horse_meat"))
            .icon(() -> new ItemStack(RAW_HORSE_MEAT.get()))
            .displayItems((features, output) -> {
                output.accept(RAW_HORSE_MEAT.get());
                output.accept(HORSE_STEAK.get());
                output.accept(HORSE_SAUSAGE.get());
            })
            .build());
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        CREATIVE_TABS.register(eventBus);
    }
}
