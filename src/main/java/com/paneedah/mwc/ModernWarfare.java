package com.paneedah.mwc;

import com.paneedah.mwc.utils.CreativeTabsRegistry;
import com.paneedah.mwc.utils.MainRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mwc")
public class ModernWarfare {

    public ModernWarfare() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MainRegistry.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(FMLClientSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeTabsRegistry.BaseTab) {
            event.accept(MainRegistry.URANIUM_INGOT);
        }
    }

    @Mod.EventBusSubscriber(modid = "mwc", bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
