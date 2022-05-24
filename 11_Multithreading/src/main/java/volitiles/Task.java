package volitiles;

public class Task implements Runnable {
    private long count;
    private volatile boolean isRunning;

    Task() {
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning)
            count++;
        System.out.println("volitiles.Task: " + count);
    }

    public long getCount() {
        return count;
    }
}
