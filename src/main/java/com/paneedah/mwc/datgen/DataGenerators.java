package com.paneedah.mwc.datgen;

import com.paneedah.mwc.ModernWarfare;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModernWarfare.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new RecipeRegistry(packOutput));
        generator.addProvider(true, LootTableHandler.create(packOutput));
        generator.addProvider(true, new BlockStateGen(packOutput, fileHelper));
        generator.addProvider(true, new ItemModelGen(packOutput, fileHelper));
    }
}
