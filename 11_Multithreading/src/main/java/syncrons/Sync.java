package syncrons;

import java.util.ArrayList;

public class Sync {
    private static final ArrayList<Double> numbers = new ArrayList<>();

    //    public static synchronized void someHeavyMethod() {
    public static void someHeavyMethod() {
        for (int i = 0; i < 5_000_000; i++) {
            double value = Math.random() / Math.random();
            synchronized (numbers) {
                numbers.add(value);
            }
        }
        System.out.println(numbers.size());
        numbers.clear();
    }
}
