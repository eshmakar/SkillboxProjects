/*
1. Напишите генератор «красивых» автомобильных номеров и методы поиска элементов в коллекциях:
прямым перебором по ArrayList,
бинарным поиском по сортированному ArrayList,
поиском в HashSet,
поиском в TreeSet.
2. Измерьте и сравните длительность каждого метода поиска.
Формат вывода результатов поиска:
Поиск перебором: номер найден/не найден, поиск занял 34нс
Бинарный поиск: номер найден/не найден, поиск занял 34нс
Поиск в HashSet: номер найден/не найден, поиск занял 34нс
Поиск в TreeSet: номер найден/не найден, поиск занял 34нс
*/

import java.util.*;

//скорость выполнения поиска по обычному поиску, по бинарному, по хэшсету и по треесет

public class GosNomera {
    private static final char[] BUKVY = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private static ArrayList<String> LIST = new ArrayList<>();
    private static ArrayList<String> LIST_OF_BINARY_SEARCH = new ArrayList<>();
    private static HashSet<String> HASH_SET_LIST = new HashSet<>();
    private static TreeSet<String> TREE_SET_LIST = new TreeSet<>();


    static {
        System.out.println("Генерация данных...");
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    for (int l = 0; l <= 9; l++) {
                        if (!(k == j && l == j))
                            continue;
                        for (int m = 0; m < 12; m++) {
                            for (int n = 0; n < 12; n++) {
                                for (int o = 1; o <= 199; o++) {
                                    String raw = String.format("%c%d%d%d%c%c%02d", BUKVY[i], j, k, l, BUKVY[m], BUKVY[n], o);
                                    LIST.add(raw);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        LIST_OF_BINARY_SEARCH.addAll(LIST);
        Collections.sort(LIST_OF_BINARY_SEARCH);
    }

    static {
        HASH_SET_LIST.addAll(LIST);
    }

    static {
        TREE_SET_LIST.addAll(LIST);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер для проверки");
            String valueFromUser = scanner.nextLine();
            if (valueFromUser.equals("0"))
                break;
            pryamojPerebor(valueFromUser);
            binarySearch(valueFromUser);
            hashSetSearch(valueFromUser);
            treeSetSearch(valueFromUser);
        }
    }


    public static void pryamojPerebor(String value) {
        System.out.print("Поиск перебором: ");
        long start = System.nanoTime();

        boolean isContains = LIST.contains(value.toUpperCase());
        long stop = System.nanoTime();

        if (isContains) System.out.println("номер найден, поиск занял " + (stop - start) + "нс");
        else System.out.println("номер не найден, поиск занял " + (stop - start) + "нс");
    }

    public static void binarySearch(String value) {
        System.out.print("Бинарный поиск: ");
        long start = System.nanoTime();

        int resultCode = Collections.binarySearch(LIST_OF_BINARY_SEARCH, value.toUpperCase());
        long stop = System.nanoTime();
        if (resultCode >= 0) System.out.println("номер найден, поиск занял " + (stop - start) + "нс");
        else System.out.println("номер не найден, поиск занял " + (stop - start) + "нс");

    }

    public static void hashSetSearch(String value) {
        System.out.print("Поиск в HASHSET: ");
        long start = System.nanoTime();

        boolean isContains = HASH_SET_LIST.contains(value.toUpperCase());
        long stop = System.nanoTime();

        if (isContains) System.out.println("номер найден, поиск занял " + (stop - start) + "нс");
        else System.out.println("номер не найден, поиск занял " + (stop - start) + "нс");
    }

    public static void treeSetSearch(String value) {
        System.out.print("Поиск в TREESET: ");
        long start = System.nanoTime();

        boolean isContains = TREE_SET_LIST.contains(value.toUpperCase());
        long stop = System.nanoTime();

        if (isContains) System.out.println("номер найден, поиск занял " + (stop - start) + "нс");
        else System.out.println("номер не найден, поиск занял " + (stop - start) + "нс");
    }
}