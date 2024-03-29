package com.paneedah.mwc.client;

import com.paneedah.mwc.ModernWarfare;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModernWarfare.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CTRegistry {

    public static CreativeModeTab BaseTab;
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        BaseTab = event.registerCreativeModeTab(new ResourceLocation(ModernWarfare.MOD_ID, "basetab"), builder -> {
            builder.title(Component.translatable("itemGroup.mwc.basetab"))
                    .icon(() -> new ItemStack(ModRegistry.GUNMETAL_INGOT.get()));
            builder.withSearchBar();
            builder.displayItems((flags, output) -> {
                ModRegistry.ITEMS.getEntries().forEach(registryObject -> output.accept(registryObject.get()));
            });
        });
    }
}
