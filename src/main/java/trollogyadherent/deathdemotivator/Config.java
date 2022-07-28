package trollogyadherent.deathdemotivator;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class Config {
    
    private static class Defaults {
        public static final String message = "§a%name%§r's IP is revealed because they died :) §d%ip%";
    }

    private static class Categories {
        public static final String general = "general";
    }
    
    public static String message = Defaults.message;

    public static void syncronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);
        configuration.load();
        
        Property messageProperty = configuration.get(Categories.general, "greeting", Defaults.message, "Message displayed, variables: %name%, %ip%");
        message = messageProperty.getString();

        if(configuration.hasChanged()) {
            configuration.save();
        }
    }
}