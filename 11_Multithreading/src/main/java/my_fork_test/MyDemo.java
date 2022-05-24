package my_fork_test;

import java.text.NumberFormat;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MyDemo {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        for (int i = 4; i < 10; i++) {
            ForkJoinTask<Long> task = pool.submit(new Fib(i));
            System.out.println(i + " -> " + NumberFormat.getInstance().format(task.join()));

        }
    }

    static class Fib extends RecursiveTask<Long> {
        private long value;

        public Fib(long value) {
            this.value = value;
        }

        @Override
        protected Long compute() {
            if (value <= 1) return value;
            Fib fib1 = new Fib(value - 1);
            Fib fib2 = new Fib(value - 2);
            fib1.fork();
            return fib2.compute() + fib1.join();
        }
    }
}
/*
39 - 1,6180339887498951409056791583151
31 - 1,61803398875054083938272198452
25 - 1,6180339889579020013802622498275
24 - 1,6180339882053250514708448197648

23 - 1,6180339901755970865563773925809

*/
