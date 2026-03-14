package com.horsemeat;

import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(HorseMeatMod.MOD_ID)
@Mod.EventBusSubscriber(modid = HorseMeatMod.MOD_ID)
public class HorseMeatMod {
    public static final String MOD_ID = "horsemeat";
    
    public HorseMeatMod() {
        System.out.println("Horse Meat Mod loaded! Extra meat drops from horses!");
    }
    
    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        // Check if killed entity is a horse
        if (event.getEntity() instanceof Horse) {
            java.util.Random random = new java.util.Random();
            
            // 50% chance for extra cooked beef (horse sausage)
            if (random.nextDouble() < 0.5) {
                event.getDrops().add(new ItemEntity(
                    event.getEntity().level(),
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    new ItemStack(Items.COOKED_BEEF, 1 + random.nextInt(3))
                ));
            }
            
            // 30% chance for cooked porkchop (frikandel)
            if (random.nextDouble() < 0.3) {
                event.getDrops().add(new ItemEntity(
                    event.getEntity().level(),
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    new ItemStack(Items.COOKED_PORKCHOP, 1 + random.nextInt(2))
                ));
            }
        }
    }
}
