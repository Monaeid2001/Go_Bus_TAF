package utils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Properties;

public class PropertyReader {
    public static Properties loadProperties(){
        try {
            Properties properties = new Properties();
            Collection<File> propertiesFiles;
            propertiesFiles = FileUtils.listFiles(new File("src/main/resources"), new String[]{"properties"}, true);
            propertiesFiles.forEach(file -> {
                try {
                    properties.load(new FileInputStream(file));
                } catch (Exception e) {
                    System.out.println("Exception occurred while loading properties from file: " +file.getName() + " - " + e.getMessage());
                }
                properties.putAll(System.getProperties());
                System.getProperties().putAll(properties);
            });
            return properties;
        }catch (Exception e){
            System.out.println("Exception occurred while loading properties: " + e.getMessage());
            return null;
        }
    }
    public static String getProperty(String key){
        try{
            return System.getProperty(key);
        }catch (Exception e){
            System.out.println("Exception occurred while getting property for key: " + key + " - " + e.getMessage());
            return "";
        }

    }
}