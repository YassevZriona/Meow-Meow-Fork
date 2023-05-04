package com.paneedah.mwc;

import com.paneedah.mwc.utils.CreativeTabsRegistry;
import com.paneedah.mwc.utils.ModRegistry;
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

        ModRegistry.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(FMLClientSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeTabsRegistry.BaseTab) {
            event.accept(ModRegistry.GUNMETAL_COMPOSITE);
            event.accept(ModRegistry.GUNMETAL_INGOT);
            event.accept(ModRegistry.GUNMETAL_PLATE);
            event.accept(ModRegistry.LEAD_INGOT);
            event.accept(ModRegistry.LEAD_ORE);
            event.accept(ModRegistry.LEAD_RAW);
            event.accept(ModRegistry.STEEL_DUST);
            event.accept(ModRegistry.STEEL_INGOT);
            event.accept(ModRegistry.SULFUR_DUST);
            event.accept(ModRegistry.SULFUR_ORE);
            event.accept(ModRegistry.SULFUR_RAW);
            event.accept(ModRegistry.SYNTHETIC_PLASTIC);
            event.accept(ModRegistry.SYNTHETIC_POLYMER_COMPOSITE);
            event.accept(ModRegistry.TIN_INGOT);
            event.accept(ModRegistry.TIN_ORE);
            event.accept(ModRegistry.TIN_RAW);
            event.accept(ModRegistry.ALUMINUM_ORE);
            event.accept(ModRegistry.RUBY_ORE);
            event.accept(ModRegistry.SILICON_ORE);
            event.accept(ModRegistry.TITANIUM_ORE);
            event.accept(ModRegistry.ALUMINUM_RAW);
            event.accept(ModRegistry.ALUMINUM_INGOT);
        }
    }

    @Mod.EventBusSubscriber(modid = "mwc", bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
