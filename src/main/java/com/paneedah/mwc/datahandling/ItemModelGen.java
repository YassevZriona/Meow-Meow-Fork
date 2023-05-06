package com.paneedah.mwc.datahandling;

import com.paneedah.mwc.ModernWarfare;
import com.paneedah.mwc.content.ModRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModernWarfare.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Ingots
        simpleItem(ModRegistry.GUNMETAL_INGOT);
        simpleItem(ModRegistry.ALUMINUM_INGOT);
        simpleItem(ModRegistry.LEAD_INGOT);
        simpleItem(ModRegistry.STEEL_INGOT);
        simpleItem(ModRegistry.OBSENUM_INGOT);
        simpleItem(ModRegistry.URANIUM_INGOT);
        simpleItem(ModRegistry.TITANIUM_INGOT);
        simpleItem(ModRegistry.TUNGSTEN_INGOT);

        // Nuggets
        simpleItem(ModRegistry.GUNMETAL_NUGGET);
        simpleItem(ModRegistry.ALUMINUM_NUGGET);
        simpleItem(ModRegistry.LEAD_NUGGET);
        simpleItem(ModRegistry.STEEL_NUGGET);
        simpleItem(ModRegistry.OBSENUM_NUGGET);
        simpleItem(ModRegistry.URANIUM_NUGGET);
        simpleItem(ModRegistry.TITANIUM_NUGGET);
        simpleItem(ModRegistry.TUNGSTEN_NUGGET);

        // Plates
        simpleItem(ModRegistry.GUNMETAL_PLATE);
        simpleItem(ModRegistry.ALUMINUM_PLATE);
        simpleItem(ModRegistry.LEAD_PLATE);
        simpleItem(ModRegistry.STEEL_PLATE);
        simpleItem(ModRegistry.OBSENUM_PLATE);
        simpleItem(ModRegistry.URANIUM_PLATE);
        simpleItem(ModRegistry.TITANIUM_PLATE);
        simpleItem(ModRegistry.TUNGSTEN_PLATE);

        // Raws
        simpleItem(ModRegistry.RAW_ALUMINUM);
        simpleItem(ModRegistry.RAW_LEAD);
        simpleItem(ModRegistry.RAW_POTASSIUM);
        simpleItem(ModRegistry.RAW_TITANIUM);
        simpleItem(ModRegistry.RAW_TUNGSTEN);
        simpleItem(ModRegistry.RAW_URANIUM);

        // Others
        simpleItem(ModRegistry.SULFUR);
        simpleItem(ModRegistry.SALT_PETER);
        simpleItem(ModRegistry.KEVLAR);
        simpleItem(ModRegistry.SYNTHETIC_PLASTIC);
        simpleItem(ModRegistry.SYNTHETIC_POLYMER_COMPOSITE);
        simpleItem(ModRegistry.LENS);
        simpleItem(ModRegistry.GRAPHITE);

        // Tools
        simpleItem(ModRegistry.STIMPAK);
        simpleItem(ModRegistry.EMPTY_SYRINGE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation(ModernWarfare.MODID, "item/material")).texture("layer0",new ResourceLocation(ModernWarfare.MODID,"item/"+ item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation(ModernWarfare.MODID, "item/handheld")).texture("layer0", new ResourceLocation(ModernWarfare.MODID,"item/"+ item.getId().getPath()));
    }
}
