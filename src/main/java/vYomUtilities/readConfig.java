package vYomUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readConfig {

    Properties prop;

    public readConfig() throws IOException {

        prop = new Properties();

        FileInputStream fis =
                new FileInputStream("src/test/resources/config.properties");

        prop.load(fis);
    }

    public String getUrl() {
        return prop.getProperty("url");
    }

    public String getEmail() {
        return prop.getProperty("email");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }
}