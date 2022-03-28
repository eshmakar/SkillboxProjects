import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParsingAllImages {
    private static final String PATH = "images";

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 3; i++) {
            System.err.println("Page N" + i);
            String siteToDownloadAllImages = "https://habr.com/ru/all/page" + i;

            File directory = new File(PATH);
            if (!directory.exists())
                directory.mkdirs();

            Elements link = Jsoup.connect(siteToDownloadAllImages).get().select("img");
            link.forEach(e ->
                    {
                        String src = e.absUrl("src");
                        String nameOfImage = src.substring(src.lastIndexOf('/') + 1);
                        try {
                            InputStream in = new URL(src).openStream();
                            Path target = Paths.get(PATH + File.separator + nameOfImage);
                            Files.copy(in, target);
                            File file = new File(String.valueOf(target));
                            long length = file.length();
                            if (length > 25534)
                                System.out.println(length + " - " + nameOfImage);
                            else
                                new File(String.valueOf(file)).delete();
                        } catch (Exception ignored) {
                        }
                    }
            );
        }
    }
}