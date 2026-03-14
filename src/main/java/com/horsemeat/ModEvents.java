package com.horsemeat;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraft.fml.common.Mod;
import net.minecraft.util.RandomSource;

public class ModEvents {
    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntity().getType() == EntityType.HORSE) {
            var horse = event.getEntity();
            RandomSource random = horse.getRandom();

            if (random.nextDouble() < 0.5) {
                event.getDrops().add(new ItemEntity(
                    horse.level(),
                    horse.getX(),
                    horse.getY(),
                    horse.getZ(),
                    new ItemStack(Items.COOKED_BEEF, 1 + random.nextInt(3))
                ));
            }

            if (random.nextDouble() < 0.3) {
                event.getDrops().add(new ItemEntity(
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