package com.paneedah.icbmvs.bases;

import com.paneedah.icbmvs.utils.Register;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String name, CreativeTabs creativeTabs) {
        super();
        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(creativeTabs);

        Register.ITEMS.add(this);
    }
}
