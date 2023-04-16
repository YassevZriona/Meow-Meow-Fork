package com.paneedah.icbmvs.bases;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaseTab extends CreativeTabs {

	private final ItemStack par3ItemStack;

	public BaseTab(int par1, String par2Str, ItemStack par3ItemStack) {
		super(par1, par2Str);
		this.par3ItemStack = par3ItemStack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack createIcon() {
		return new ItemStack(par3ItemStack.getItem());
	}
}
