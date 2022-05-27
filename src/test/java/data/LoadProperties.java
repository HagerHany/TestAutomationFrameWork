package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    public static Properties userInfo= loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\UserData");

    private static Properties loadProperties(String path){
              Properties pro=new Properties();
              //open stream to read file
        try {
            FileInputStream stream=new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR Occurred:"+e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR Occurred:"+e.getMessage());        }


    return pro;
    }
}
