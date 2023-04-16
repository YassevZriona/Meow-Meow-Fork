package com.paneedah.icbmvs.utils;

import com.paneedah.icbmvs.bases.BaseTab;
import com.paneedah.icbmvs.bases.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class Register {

    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final List<Item> ITEMS = new ArrayList<Item>();

    // Creative Tabs
    public static final CreativeTabs OthersTab = new BaseTab(CreativeTabs.getNextID(), "OthersTab", new ItemStack(Register.URANIUM_INGOT));
    public static final CreativeTabs ResourcesTab = new BaseTab(CreativeTabs.getNextID(), "ResourcesTab", new ItemStack(Items.AIR));
    public static final CreativeTabs PlanesTab = new BaseTab(CreativeTabs.getNextID(), "PlanesTab", new ItemStack(Items.AIR));
    public static final CreativeTabs JetsTab = new BaseTab(CreativeTabs.getNextID(), "JetsTab", new ItemStack(Items.AIR));
    public static final CreativeTabs NavyTab = new BaseTab(CreativeTabs.getNextID(), "NavyTab", new ItemStack(Items.AIR));
    public static final CreativeTabs GroundVehiclesTab = new BaseTab(CreativeTabs.getNextID(), "GroundVehiclesTab", new ItemStack(Items.AIR));

    // Items
    public static final Item URANIUM_INGOT = new ItemBase("uranium_ingot", OthersTab);

    // Blocks




    // Entities

    // Guis

    public static void preInit() {
        for (Block block : BLOCKS) {
            ForgeRegistries.BLOCKS.register(block);

            ResourceLocation registryName = block.getRegistryName();
            ItemBlock itemBlock = new ItemBlock(block);
            assert registryName != null;
            itemBlock.setRegistryName(registryName);

            ForgeRegistries.ITEMS.register(itemBlock);
            ModelLoader.setCustomModelResourceLocation(itemBlock, 0, new ModelResourceLocation(registryName, "inventory"));
        }

        for (Item item : ITEMS) {
            ForgeRegistries.ITEMS.register(item);
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}
