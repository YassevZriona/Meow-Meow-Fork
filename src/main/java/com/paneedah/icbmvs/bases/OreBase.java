package com.paneedah.icbmvs.bases;

import net.minecraft.block.BlockOre;
import com.paneedah.icbmvs.utils.Register;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;


public class OreBase extends BlockOre {

    private final Item itemDrop;

    public OreBase(String name, Item itemDrop, float hardness, float resistance, String harvest, int harvestLevel, CreativeTabs creativeTabs) {
        setHardness(hardness);
        setResistance(resistance);

        setRegistryName(name);
        setTranslationKey(name);

        setHarvestLevel(harvest, harvestLevel);
        setCreativeTab(creativeTabs);

        this.itemDrop = itemDrop;

        Register.BLOCKS.add(this);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return itemDrop;
    }
}
