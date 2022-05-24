import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Demo extends RecursiveTask<Long> {
    private long workLoad;
    public Demo(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected Long compute() {
        //if work is above threshold, break tasks up into smaller tasks
        //если работа выше порога, разбейте задачи на более мелкие задачи
        if (this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            List<Demo> subtasks = new ArrayList<>();
            subtasks.addAll(createSubtasks());

            for (Demo subtask : subtasks) {
                subtask.fork();
            }

            long result = 0;
            for (Demo subtask : subtasks) {
                result += subtask.join();
            }
            return result;

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
            return workLoad * 3;
        }
    }

    private List<Demo> createSubtasks() {
        List<Demo> subtasks = new ArrayList<>();
        Demo subtask1 = new Demo(this.workLoad / 2);
        Demo subtask2 = new Demo(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }














/*
However, besides being a dumb way to compute Fibonacci functions (there is a simple fast linear algorithm that you'd use in practice), this is likely to perform poorly because the smallest subtasks are too small to be worthwhile splitting up. Instead, as is the case for nearly all fork/join applications, you'd pick some minimum granularity size (for example 10 here) for which you always sequentially solve rather than subdividing.
Since:
1.7

*/


/*
Performs the given task, returning its result upon completion. If the computation encounters an unchecked Exception or Error, it is rethrown as the outcome of this invocation. Rethrown exceptions behave in the same way as regular exceptions, but, when possible, contain stack traces (as displayed for example using ex.printStackTrace()) of both the current thread as well as the thread actually encountering the exception; minimally only the latter

Выполняет заданную задачу, возвращая ее результат по завершении. Если вычисление
сталкивается с непроверенным исключением или ошибкой, оно повторно вызывается
как результат этого вызова. Повторно созданные исключения ведут себя так же,
как обычные исключения, но, когда это возможно, содержат трассировку стека
(как показано, например, с помощью ex.printStackTrace()) как текущего потока,
так и потока, фактически столкнувшегося с исключением; минимально только последнее
*/


    public static void main(String[] args) {
        Demo Demo = new Demo(128);
        ForkJoinPool forkJoinPool = new ForkJoinPool(4); //кол-во ядер, можно использовать Runtime.getRuntime().availableProcessors()

        //здесь получаем результат такого вида, который указали в дженерике класса RecursiveTask<Long>
        long mergedResult = forkJoinPool.invoke(Demo);

        System.out.println("mergedResult = " + mergedResult);
    }
}