package com.horsemeat;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.minecraft.world.entity.item.ItemEntity;

public class ModEvents {

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity().getType() == EntityType.HORSE) {
            var horse = event.getEntity();
            var level = horse.level();
            
            // Create the item stack
            ItemStack itemStack = new ItemStack(ModItems.RAW_HORSE_MEAT.get(), 1);
            
            // Create and spawn the item entity
            ItemEntity itemEntity = new ItemEntity(level, horse.getX(), horse.getY(), horse.getZ(), itemStack);
            itemEntity.setDefaultPickUpDelay();
            level.addFreshEntity(itemEntity);
        }
    }
}
