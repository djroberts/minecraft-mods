package com.horsemeat;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.minecraft.util.RandomSource;

public class ModEvents {

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity().getType() == EntityType.HORSE) {
            var horse = event.getEntity();
            RandomSource random = horse.getRandom();

            if (random.nextDouble() < 0.5) {
                horse.level().addFreshEntity(new net.minecraft.world.entity.item.ItemEntity(
                    horse.level(),
                    horse.getX(),
                    horse.getY(),
                    horse.getZ(),
                    new ItemStack(Items.COOKED_BEEF, 1 + random.nextInt(3))
                ));
            }

            if (random.nextDouble() < 0.3) {
                horse.level().addFreshEntity(new net.minecraft.world.entity.item.ItemEntity(
                    horse.level(),
                    horse.getX(),
                    horse.getY(),
                    horse.getZ(),
                    new ItemStack(Items.COOKED_PORKCHOP, 1 + random.nextInt(2))
                ));
            }
        }
    }
}
