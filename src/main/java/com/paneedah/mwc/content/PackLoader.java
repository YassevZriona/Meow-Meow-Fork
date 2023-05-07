package com.paneedah.mwc.content;

import com.paneedah.mwc.ModernWarfare;

import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class PackLoader {
    private File pack;

    public PackLoader(File pack) {
        this.pack = pack;
        registerPack();
    }

    public void registerPack() {
        try {
            if(pack.isDirectory()) {
                File packJson = new File(pack, "/pack.json");
                if(packJson.exists()) {
                    ModernWarfare.packs.put(pack.getName(), pack);
                    ModernWarfare.log.error("Pack successfully loaded");
                } else
                    ModernWarfare.log.error("A possible content pack in MWC folder, failed to load due to missing pack.json: " + pack.getName());
            }
            else if(ContentPackHandler.zipJar.matcher(pack.getName()).matches()) {
                ZipFile zip = new ZipFile(pack);
                ZipEntry entry = zip.getEntry("pack.json");

                if(entry != null && !entry.isDirectory()) {
                    ModernWarfare.packs.put(pack.getName(), pack);
                    ModernWarfare.log.error("Pack successfully loaded");
                } else
                    ModernWarfare.log.error("A possible content pack in MWC folder, failed to load due to missing pack.json: " + pack.getName());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
