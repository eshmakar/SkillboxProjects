package race_condition;

public class StartRaceCondition {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100_000; j++) {
                    Value.incrementValue();
                }
                System.out.println(Value.getValue());
            }).start();
        }
    }
}
