package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Properties properties = new Properties();

    static
    {
        try {
            FileInputStream file =
                    new FileInputStream("config.properties");

            properties.load(file);

        } catch (IOException e) {
            System.out.println("Could not load config file");
        }
    }

    public static String getBaseUrl(){
        return properties.getProperty("base.url");
    }
    public static String getUnits(){
        return properties.getProperty("units");
    }
    public static String getAPI(){
        return properties.getProperty("api.key");
    }


}