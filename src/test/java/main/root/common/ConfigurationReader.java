package main.root.common;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
//Commit Configuration Java
    //add
    public static Properties properties = new Properties();
//new
    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getProperty (String key){
        return properties.getProperty(key);
    }
}
