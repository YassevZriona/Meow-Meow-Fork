package com.paneedah.mwc.datagen;

import com.paneedah.mwc.ModernWarfare;
import com.paneedah.mwc.things.ModRegistry;
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
        simpleItem(ModRegistry.GUNMETAL_INGOT, "ingot");
        simpleItem(ModRegistry.ALUMINUM_INGOT, "ingot");
        simpleItem(ModRegistry.LEAD_INGOT, "ingot");
        simpleItem(ModRegistry.STEEL_INGOT, "ingot");
        simpleItem(ModRegistry.OBSENUM_INGOT, "ingot");
        simpleItem(ModRegistry.URANIUM_INGOT, "ingot");
        simpleItem(ModRegistry.TITANIUM_INGOT, "ingot");
        simpleItem(ModRegistry.TUNGSTEN_INGOT, "ingot");

        // Nuggets
        simpleItem(ModRegistry.GUNMETAL_NUGGET, "nugget");
        simpleItem(ModRegistry.ALUMINUM_NUGGET, "nugget");
        simpleItem(ModRegistry.LEAD_NUGGET, "nugget");
        simpleItem(ModRegistry.STEEL_NUGGET, "nugget");
        simpleItem(ModRegistry.OBSENUM_NUGGET, "nugget");
        simpleItem(ModRegistry.URANIUM_NUGGET, "nugget");
        simpleItem(ModRegistry.TITANIUM_NUGGET, "nugget");
        simpleItem(ModRegistry.TUNGSTEN_NUGGET, "nugget");

        // Plates
        simpleItem(ModRegistry.GUNMETAL_PLATE, "plate");
        simpleItem(ModRegistry.ALUMINUM_PLATE, "plate");
        simpleItem(ModRegistry.LEAD_PLATE, "plate");
        simpleItem(ModRegistry.STEEL_PLATE, "plate");
        simpleItem(ModRegistry.OBSENUM_PLATE, "plate");
        simpleItem(ModRegistry.URANIUM_PLATE, "plate");
        simpleItem(ModRegistry.TITANIUM_PLATE, "plate");
        simpleItem(ModRegistry.TUNGSTEN_PLATE, "plate");

        // Raws
        simpleItem(ModRegistry.RAW_ALUMINUM, "raw");
        simpleItem(ModRegistry.RAW_LEAD, "raw");
        simpleItem(ModRegistry.RAW_POTASSIUM, "raw");
        simpleItem(ModRegistry.RAW_TITANIUM, "raw");
        simpleItem(ModRegistry.RAW_TUNGSTEN, "raw");
        simpleItem(ModRegistry.RAW_URANIUM, "raw");

        // Others
        simpleItem(ModRegistry.SULFUR, "other");
        simpleItem(ModRegistry.SALT_PETER, "other");
        simpleItem(ModRegistry.KEVLAR, "other");
        simpleItem(ModRegistry.SYNTHETIC_PLASTIC, "other");
        simpleItem(ModRegistry.SYNTHETIC_POLYMER_COMPOSITE, "other");
        simpleItem(ModRegistry.LENS, "other");
        simpleItem(ModRegistry.GRAPHITE, "other");

        // Tools
        handheldItem(ModRegistry.STIMPAK, "tool");
        handheldItem(ModRegistry.EMPTY_SYRINGE, "tool");
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String folder) {
        System.out.println(new ResourceLocation("item/generated"));
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0",new ResourceLocation(ModernWarfare.MODID,"item/"+ item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item, String folder) {
        System.out.println(new ResourceLocation("item/generated"));
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/handheld")).texture("layer0", new ResourceLocation(ModernWarfare.MODID,"item/"+ item.getId().getPath()));
    }
}
