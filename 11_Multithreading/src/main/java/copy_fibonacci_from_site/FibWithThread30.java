package copy_fibonacci_from_site;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FibWithThread30 {
    private static final String URL = "http://www.protocol5.com/Fibonacci/";
    private static final String selectPath = "/html/body/div[1]/ul/li[6]/div";
    private static final String path = "E://fib.txt";

    public static void withJsoup(int number) {
        Document document;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            document = Jsoup.connect(URL + number + ".htm").maxBodySize(0).get();
            writer.write(number + " -> " + document.selectXpath(selectPath).text()+"\n");
            writer.flush();
            System.out.println(number);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public static void clckCod1() {
        for (int i = 0; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod2() {
        for (int i = 1; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod3() {
        for (int i = 2; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod4() {
        for (int i = 3; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod5() {
        for (int i = 4; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod6() {
        for (int i = 5; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod7() {
        for (int i = 6; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod8() {
        for (int i = 7; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod9() {
        for (int i = 8; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod10() {
        for (int i = 9; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod11() {
        for (int i = 10; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod12() {
        for (int i = 11; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod13() {
        for (int i = 12; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod14() {
        for (int i = 13; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod15() {
        for (int i = 14; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod16() {
        for (int i = 15; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod17() {
        for (int i = 16; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod18() {
        for (int i = 17; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod19() {
        for (int i = 18; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod20() {
        for (int i = 19; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod21() {
        for (int i = 20; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod22() {
        for (int i = 21; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod23() {
        for (int i = 22; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod24() {
        for (int i = 23; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod25() {
        for (int i = 24; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod26() {
        for (int i = 25; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod27() {
        for (int i = 26; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod28() {
        for (int i = 27; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod29() {
        for (int i = 28; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod30() {
        for (int i = 29; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod31() {
        for (int i = 30; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod32() {
        for (int i = 31; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod33() {
        for (int i = 32; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod34() {
        for (int i = 33; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod35() {
        for (int i = 34; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod36() {
        for (int i = 35; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod37() {
        for (int i = 36; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod38() {
        for (int i = 37; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod39() {
        for (int i = 38; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod40() {
        for (int i = 39; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod41() {
        for (int i = 40; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod42() {
        for (int i = 41; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod43() {
        for (int i = 42; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod44() {
        for (int i = 43; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod45() {
        for (int i = 44; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod46() {
        for (int i = 45; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod47() {
        for (int i = 46; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod48() {
        for (int i = 47; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod49() {
        for (int i = 48; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }

    public static void clckCod50() {
        for (int i = 49; i <= 50_000; i += 50) {
            withJsoup(i);
        }
    }


    public static void main(String[] args) {
        System.out.println("Работу начал...");
        int kolvoPotokov = 50;//самое интересное, здесь по умолчанию стоит 30 потоков!
        ExecutorService service = Executors.newFixedThreadPool(kolvoPotokov);//с помощью ExecutorService создаем 30 потоков

        service.submit(new Thread(FibWithThread30::clckCod1));
        service.submit(new Thread(FibWithThread30::clckCod2));
        service.submit(new Thread(FibWithThread30::clckCod3));
        service.submit(new Thread(FibWithThread30::clckCod4));
        service.submit(new Thread(FibWithThread30::clckCod5));
        service.submit(new Thread(FibWithThread30::clckCod6));
        service.submit(new Thread(FibWithThread30::clckCod7));
        service.submit(new Thread(FibWithThread30::clckCod8));
        service.submit(new Thread(FibWithThread30::clckCod9));
        service.submit(new Thread(FibWithThread30::clckCod10));

        service.submit(new Thread(FibWithThread30::clckCod11));
        service.submit(new Thread(FibWithThread30::clckCod12));
        service.submit(new Thread(FibWithThread30::clckCod13));
        service.submit(new Thread(FibWithThread30::clckCod14));
        service.submit(new Thread(FibWithThread30::clckCod15));
        service.submit(new Thread(FibWithThread30::clckCod16));
        service.submit(new Thread(FibWithThread30::clckCod17));
        service.submit(new Thread(FibWithThread30::clckCod18));
        service.submit(new Thread(FibWithThread30::clckCod19));
        service.submit(new Thread(FibWithThread30::clckCod20));

        service.submit(new Thread(FibWithThread30::clckCod21));
        service.submit(new Thread(FibWithThread30::clckCod22));
        service.submit(new Thread(FibWithThread30::clckCod23));
        service.submit(new Thread(FibWithThread30::clckCod24));
        service.submit(new Thread(FibWithThread30::clckCod25));
        service.submit(new Thread(FibWithThread30::clckCod26));
        service.submit(new Thread(FibWithThread30::clckCod27));
        service.submit(new Thread(FibWithThread30::clckCod28));
        service.submit(new Thread(FibWithThread30::clckCod29));
        service.submit(new Thread(FibWithThread30::clckCod30));

        service.submit(new Thread(FibWithThread30::clckCod31));
        service.submit(new Thread(FibWithThread30::clckCod32));
        service.submit(new Thread(FibWithThread30::clckCod33));
        service.submit(new Thread(FibWithThread30::clckCod34));
        service.submit(new Thread(FibWithThread30::clckCod35));
        service.submit(new Thread(FibWithThread30::clckCod36));
        service.submit(new Thread(FibWithThread30::clckCod37));
        service.submit(new Thread(FibWithThread30::clckCod38));
        service.submit(new Thread(FibWithThread30::clckCod39));
        service.submit(new Thread(FibWithThread30::clckCod40));

        service.submit(new Thread(FibWithThread30::clckCod41));
        service.submit(new Thread(FibWithThread30::clckCod42));
        service.submit(new Thread(FibWithThread30::clckCod43));
        service.submit(new Thread(FibWithThread30::clckCod44));
        service.submit(new Thread(FibWithThread30::clckCod45));
        service.submit(new Thread(FibWithThread30::clckCod46));
        service.submit(new Thread(FibWithThread30::clckCod47));
        service.submit(new Thread(FibWithThread30::clckCod48));
        service.submit(new Thread(FibWithThread30::clckCod49));
        service.submit(new Thread(FibWithThread30::clckCod50));

        service.shutdown();

    }
}
