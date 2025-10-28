package se.sprinto.hakan.adventuregame.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppInfo {
    private static AppInfo instance;
    private Properties properties;

    private AppInfo(){
        properties = new Properties();
        try {
            FileReader reader = new FileReader("info.properties");
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppInfo getInstance(){
        if (instance == null){
            instance = new AppInfo();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
