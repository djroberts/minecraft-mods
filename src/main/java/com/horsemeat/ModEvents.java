package com.horsemeat;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class ModEvents {

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity().getType() == EntityType.HORSE) {
            var horse = event.getEntity();

            horse.level().addFreshEntity(new net.minecraft.world.entity.item.ItemEntity(
                horse.level(),
                horse.getX(),
                horse.getY(),
                horse.getZ(),
                new ItemStack(ModItems.HORSE_SAUSAGE.get(), 1)
            ));
        }
    }
}
