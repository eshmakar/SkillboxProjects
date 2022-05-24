package copy_fibonacci_from_site;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FibParsing {
    public static void main(String[] args) throws IOException {
        String url = "http://www.protocol5.com/Fibonacci/";
        String selectPath = "/html/body/div[1]/ul/li[6]/div";
        String path = "E://fib.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
        for (int i = 1; i <= 50_000; i++) {
            Document document = Jsoup.connect(url + i + ".htm").maxBodySize(0).get();
            writer.write(i + " -> " + document.selectXpath(selectPath).text()+"\n");
            writer.flush();
            System.out.println(i);
        }
        writer.close();
    }
}
