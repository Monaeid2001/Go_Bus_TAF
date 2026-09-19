package utils;

import java.io.File;

public class FileUtils {
    private static final String USER_DIR= PropertyReader.getProperty("user.dir");
    private FileUtils() {
        // Private constructor to prevent instantiation
    }
    public static void createDirectory(String path){
        try{
            File file = new File(USER_DIR + path);
            if(!file.exists()){
                if(file.mkdirs()){
                    System.out.println("Directory created successfully: " + path);
                }
            }
        }catch (Exception e){
            System.out.println("Failed to create directory: " +path +"-"+ e.getMessage());
        }
    }
    public static void cleanDirectory(File file){
        try{
            org.apache.commons.io.FileUtils.deleteQuietly(file);
        }catch (Exception e){
            System.out.println("Failed to clean directory: " +file.getAbsolutePath() +"-"+ e.getMessage());
        }

    }
}
