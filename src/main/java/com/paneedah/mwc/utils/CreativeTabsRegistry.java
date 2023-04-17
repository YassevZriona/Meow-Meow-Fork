package com.paneedah.mwc.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mwc", bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabsRegistry {

    public static CreativeModeTab BaseTab;
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        BaseTab = event.registerCreativeModeTab(new ResourceLocation("mwc", "basetab"), builder -> {
            builder.title(Component.translatable("itemGroup.mwc.basetab"))
                    .icon(() -> new ItemStack(MainRegistry.URANIUM_INGOT.get()));
            builder.withSearchBar();
            builder.displayItems((flags, output) -> {
                MainRegistry.ITEMS.getEntries().forEach(registryObject -> output.accept(registryObject.get()));
            });
        });
    }
}
