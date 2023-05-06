package com.paneedah.mwc.content;

import com.paneedah.mwc.ModernWarfare;

import java.io.File;
import java.util.HashMap;
import java.util.regex.Pattern;

public class ContentPackHandler {
    private static HashMap<String, File> packs = new HashMap<String, File>();
    private static Pattern zipJar = Pattern.compile("(.+)\\.(zip|jar)$");
    public static void loadContent() {
        for(File file : ModernWarfare.contentFolder.listFiles())
        {
            //Load folders and valid zip files
            if(file.isDirectory() || zipJar.matcher(file.getName()).matches())
            {
                //Add the directory to the content pack list
                if(packs.containsKey(file.getName())) {
                    ModernWarfare.log.info("Skipping loading content pack as it is duplicate: " + file.getName());
                } else {
                    ModernWarfare.log.info("Loaded content pack: " + file.getName());
                    packs.put(file.getName(), file);
                }
            }
        }
        ModernWarfare.log.info("Loaded content pack list from Flan folder");
    }
}
