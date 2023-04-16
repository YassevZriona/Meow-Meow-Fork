package com.paneedah.icbmvs;

import com.paneedah.icbmvs.bases.BaseTab;
import com.paneedah.icbmvs.utils.ModReference;
import com.paneedah.icbmvs.utils.Register;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModReference.id, name = ModReference.name, version = ModReference.version)
public class ICBMVS {

    @Mod.Instance(ModReference.id)
    public static ICBMVS INSTANCE;

    public static final Minecraft mc = Minecraft.getMinecraft();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent preInitializationEvent) {
        Register.preInit();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent postInitializationEvent) {
    }

}
