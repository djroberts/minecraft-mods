package com.horsemeat;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.item.ItemEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class ModFurnaceEvents {

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = player.level();
        BlockPos pos = event.getPos();
        
        // Check if player right-clicked with raw horse meat on a cooking block
        boolean isCookingBlock = level.getBlockState(pos).getBlock() == Blocks.FURNACE ||
                               level.getBlockState(pos).getBlock() == Blocks.SMOKER ||
                               level.getBlockState(pos).getBlock() == Blocks.CAMPFIRE;
        
        if (isCookingBlock && player.getMainHandItem().getItem() == ModItems.RAW_HORSE_MEAT.get()) {
            
            // Check if sneaking (to avoid normal furnace interaction)
            if (player.isShiftKeyDown()) {
                // Determine output based on furnace type
                ItemStack output;
                if (level.getBlockState(pos).getBlock() == Blocks.SMOKER) {
                    output = new ItemStack(ModItems.HORSE_SAUSAGE.get());
                } else {
                    output = new ItemStack(ModItems.HORSE_STEAK.get());
                }
                
                // Give player the cooked item
                if (!player.getInventory().add(output)) {
                    // Drop item if inventory is full
                    level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), output));
                }
                
                // Consume one raw horse meat
                player.getMainHandItem().shrink(1);
                
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }
    }
}
