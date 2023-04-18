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
            event.accept(MainRegistry.GUNMETAL_COMPOSITE);
            event.accept(MainRegistry.GUNMETAL_INGOT);
            event.accept(MainRegistry.GUNMETAL_PLATE);
            event.accept(MainRegistry.LEAD_INGOT);
            event.accept(MainRegistry.LEAD_ORE);
            event.accept(MainRegistry.LEAD_RAW);
            event.accept(MainRegistry.STEEL_DUST);
            event.accept(MainRegistry.STEEL_INGOT);
            event.accept(MainRegistry.SULFUR_DUST);
            event.accept(MainRegistry.SULFUR_ORE);
            event.accept(MainRegistry.SULFUR_RAW);
            event.accept(MainRegistry.SYNTHETIC_PLASTIC);
            event.accept(MainRegistry.SYNTHETIC_POLYMER_COMPOSITE);
            event.accept(MainRegistry.TIN_INGOT);
            event.accept(MainRegistry.TIN_ORE);
            event.accept(MainRegistry.TIN_RAW);
            event.accept(MainRegistry.ALUMINUM_ORE);
            event.accept(MainRegistry.RUBY_ORE);
            event.accept(MainRegistry.SILICON_ORE);
            event.accept(MainRegistry.TITANIUM_ORE);
            event.accept(MainRegistry.ALUMINUM_RAW);
            event.accept(MainRegistry.ALUMINUM_INGOT);
        }
    }

    @Mod.EventBusSubscriber(modid = "mwc", bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
