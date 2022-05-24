package homework2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ParseSkillboxForLinks {
    public static void main(String[] args) throws IOException {
//        String url = "https://skillbox.ru/";
        String url = "https://lenta.ru";
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("a");
        String href = "href=\"/";
        Set<String> links = elements.stream()
                .map(e -> e.toString().replaceAll("\n", ""))
                .filter(e -> e.contains(href))
                .map(e -> url + e.substring(e.indexOf(href) + 6, e.indexOf("\">")))
                .collect(Collectors.toCollection(TreeSet::new));

//        links.forEach(System.out::println);

        links.stream()
                .map(e -> {
                    try {
                        Document doc = Jsoup.connect(e).get();
                        Elements elems = doc.select("a");
                        elems.stream()
                                .map(e2 -> e2.toString().replaceAll("\n", ""))
                                .filter(e2 -> e2.contains(href))
                                .map(e2 -> url + e2.substring(e2.indexOf(href) + 6, e2.indexOf("\">")))
                                .forEach(System.out::println);

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.toList());
//                .forEach(System.out::println);


    }
}
