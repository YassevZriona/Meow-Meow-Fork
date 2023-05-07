package com.paneedah.mwc.content;

import com.paneedah.mwc.ModernWarfare;

import java.io.File;
import java.util.regex.Pattern;

public class ContentPackHandler {
    protected static Pattern zipJar = Pattern.compile("(.+)\\.(zip|jar)$");
    public static void loadContent() {
        ModernWarfare.log.info("Content pack loading started.");
        try {
            for(File file : ModernWarfare.contentFolder.listFiles()) {
                if(file.isDirectory() || zipJar.matcher(file.getName()).matches()) {
                    if(ModernWarfare.packs.containsKey(file.getName())) {
                        ModernWarfare.log.info("Skipping loading content pack as it is duplicate: " + file.getName());
                    } else {
                        ModernWarfare.log.info("Loading content pack: " + file.getName());
                        PackLoader pl = new PackLoader(file);
                    }
                }
            }
            ModernWarfare.log.info("Content pack loading ended.");
        } catch(NullPointerException e) {
            ModernWarfare.log.error("No content packs were loaded! If you believe this is incorrect then please contact mod developer/support.");
        }
    }
}
