package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String getApiKey() {
        Properties properties = new Properties();

        try {
            FileInputStream file =
                    new FileInputStream("config.properties");

            properties.load(file);

            return properties.getProperty("api.key");

        } catch (IOException e) {
            System.out.println("Could not load config file");
            return null;
        }
    }
}