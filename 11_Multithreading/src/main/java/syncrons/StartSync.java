package syncrons;

public class StartSync {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(Sync::someHeavyMethod).start();
        }
    }
}
