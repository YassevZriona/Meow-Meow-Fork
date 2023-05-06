package com.paneedah.mwc.things.items;

import com.paneedah.mwc.things.ModRegistry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SyringeBase extends Item {

    public SyringeBase(Properties properties) {
        super(properties);
        properties.stacksTo(16);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(this == ModRegistry.STIMPAK.get()) {
            if(hand == InteractionHand.MAIN_HAND) {
                player.heal(5);
                player.getCooldowns().addCooldown(this, 15);
                player.getMainHandItem().shrink(1);
                if (!player.getInventory().add(new ItemStack(ModRegistry.EMPTY_SYRINGE.get()))) {
                    player.drop(new ItemStack(ModRegistry.EMPTY_SYRINGE.get(), 1), false);
                }
            }
        }
        return super.use(level,player,hand);
    }
}
