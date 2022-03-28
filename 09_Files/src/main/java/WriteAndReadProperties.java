import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteAndReadProperties {
    public static void main(String[] args) throws IOException {
        //save properties to disk
        Properties properties = new Properties();
        properties.setProperty("timeout", "30_000");
        properties.setProperty("cacheSize", "10_000");
        properties.store(new FileOutputStream("config.properties"), "");

        //load and read properties from disk
        Properties loading = new Properties();
        loading.load(new FileInputStream("config.properties"));
        System.out.println(loading);
    }
}
