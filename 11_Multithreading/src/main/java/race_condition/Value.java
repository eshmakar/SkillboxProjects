package race_condition;

import java.util.concurrent.atomic.AtomicInteger;

public class Value {
    private static AtomicInteger value = new AtomicInteger();
    public static int getValue() {
        return value.intValue();
    }

    public static void incrementValue(){
        value.incrementAndGet();
    }
}
