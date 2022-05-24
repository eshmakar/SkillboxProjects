package homework2.copy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int threadCount = Runtime.getRuntime().availableProcessors();//кол-во ядер процессора
//        String url = "https://skillbox.ru/";
        String url = "https://vc.ru/";
        SiteMapGenerator siteMapGenerator = new SiteMapGenerator(url,url);
        String siteMap = new ForkJoinPool(threadCount).invoke(siteMapGenerator);
        writeFile(siteMap, "siteMapSkillBox.txt");
        System.out.println(siteMap);
    }

    public static void writeFile(String siteMap, String path){
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(siteMap);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
/*

*/
