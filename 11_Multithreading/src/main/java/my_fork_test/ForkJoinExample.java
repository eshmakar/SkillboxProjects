package my_fork_test;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {
    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            var value = scanner.nextInt();
            final ForkJoinTask<Long> result = forkJoinPool.submit(new Fibonacci(value));
            System.out.println(value + " -> " + NumberFormat.getInstance().format(result.join()));
        }
    } 

    static class Fibonacci extends RecursiveTask<Long> {
        private final long number;

        Fibonacci(long number) {
            this.number = number;
        }

        @Override
        protected Long compute() {
            if (number <= 1) return number;
            else {
                Fibonacci minus1 = new Fibonacci(number-1);
                Fibonacci minus2 = new Fibonacci(number-2);
                minus1.fork();
                return minus2.compute() + minus1.join();
            }
        }
    }
}

