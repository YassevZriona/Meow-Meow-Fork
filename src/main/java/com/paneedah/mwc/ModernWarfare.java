package com.paneedah.mwc;

import com.paneedah.mwc.things.ModRegistry;
import com.paneedah.mwc.things.CreativeTabsRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModernWarfare.MODID)
public class ModernWarfare {
    public static final String MODID = "mwc";

    public ModernWarfare() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        ModRegistry.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLClientSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeTabsRegistry.BaseTab) {
            // INGOTS
            event.accept(ModRegistry.GUNMETAL_INGOT);
            event.accept(ModRegistry.STEEL_INGOT);
            event.accept(ModRegistry.ALUMINUM_INGOT);
            event.accept(ModRegistry.LEAD_INGOT);
            event.accept(ModRegistry.TITANIUM_INGOT);
            event.accept(ModRegistry.TUNGSTEN_INGOT);
            event.accept(ModRegistry.URANIUM_INGOT);
            event.accept(ModRegistry.OBSENUM_INGOT);

            // NUGGETS
            event.accept(ModRegistry.GUNMETAL_NUGGET);
            event.accept(ModRegistry.STEEL_NUGGET);
            event.accept(ModRegistry.ALUMINUM_NUGGET);
            event.accept(ModRegistry.LEAD_NUGGET);
            event.accept(ModRegistry.TITANIUM_NUGGET);
            event.accept(ModRegistry.TUNGSTEN_NUGGET);
            event.accept(ModRegistry.URANIUM_NUGGET);
            event.accept(ModRegistry.OBSENUM_NUGGET);

            // PLATES
            event.accept(ModRegistry.GUNMETAL_PLATE);
            event.accept(ModRegistry.STEEL_PLATE);
            event.accept(ModRegistry.ALUMINUM_PLATE);
            event.accept(ModRegistry.LEAD_PLATE);
            event.accept(ModRegistry.TITANIUM_PLATE);
            event.accept(ModRegistry.TUNGSTEN_PLATE);
            event.accept(ModRegistry.URANIUM_PLATE);
            event.accept(ModRegistry.OBSENUM_PLATE);

            // RAWS
            event.accept(ModRegistry.RAW_ALUMINUM);
            event.accept(ModRegistry.RAW_LEAD);
            event.accept(ModRegistry.RAW_TITANIUM);
            event.accept(ModRegistry.RAW_TUNGSTEN);
            event.accept(ModRegistry.RAW_URANIUM);
            event.accept(ModRegistry.RAW_POTASSIUM);

            // OTHER
            event.accept(ModRegistry.SULFUR);
            event.accept(ModRegistry.SALT_PETER);
            event.accept(ModRegistry.GRAPHITE);
            event.accept(ModRegistry.KEVLAR);
            event.accept(ModRegistry.LENS);
            event.accept(ModRegistry.SYNTHETIC_PLASTIC);
            event.accept(ModRegistry.SYNTHETIC_POLYMER_COMPOSITE);

            // TOOLS
            event.accept(ModRegistry.STIMPAK);
            event.accept(ModRegistry.EMPTY_SYRINGE);

            // ORES
            event.accept(ModRegistry.SULFUR_ORE);
            event.accept(ModRegistry.NITER_ORE);
            event.accept(ModRegistry.ALUMINUM_ORE);
            event.accept(ModRegistry.LEAD_ORE);
            event.accept(ModRegistry.GRAPHITE_ORE);
            event.accept(ModRegistry.TITANIUM_ORE);
            event.accept(ModRegistry.URANIUM_ORE);
            event.accept(ModRegistry.TUNGSTEN_ORE);
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
