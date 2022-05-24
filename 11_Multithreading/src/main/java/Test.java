import java.util.stream.IntStream;

public class Test {
    void parallel() {
        int result = IntStream.range(0, 3)
                .parallel()
                .peek(it -> System.out.printf("Thread [%s] peek: %d\n",
                        Thread.currentThread().getName(), it))
                .sum();
        System.out.println("sum: " + result);
    }

    public static void main(String[] args) {
        new Test().parallel();
    }
}
