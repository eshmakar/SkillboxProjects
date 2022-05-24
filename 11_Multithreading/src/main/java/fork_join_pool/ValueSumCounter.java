package fork_join_pool;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ValueSumCounter extends RecursiveTask<Integer> {
    private int[] array;
    public ValueSumCounter(int[] array) {
        this.array = array;
    }

    public static int[] getInitArray(int capacity) {
        int[] array = new int[capacity];
        double ran = 0;
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < 10; j++) {
                ran = Math.random();
            }
            array[i] = 3;
        }
        System.out.println(ran);
        return array;
    }

    @Override
    protected Integer compute() {
        if (array.length <= 2) {
            return Arrays.stream(array).sum();
        }
        int polovinaMassiva = array.length / 2;
        ValueSumCounter pervayaPolovina = new ValueSumCounter(Arrays.copyOfRange(array, 0, polovinaMassiva));//1-5000
        ValueSumCounter vtorayaPolovina = new ValueSumCounter(Arrays.copyOfRange(array, polovinaMassiva, array.length));//5001-10000
        pervayaPolovina.fork();
        vtorayaPolovina.fork();
        return pervayaPolovina.join() + vtorayaPolovina.join();
    }


    public static void main(String[] args) {
        int[] array = getInitArray(100_000_000);
        ValueSumCounter counter = new ValueSumCounter(array);
        System.out.println(new Date());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(counter));
        System.out.println(new Date());
    }

}
