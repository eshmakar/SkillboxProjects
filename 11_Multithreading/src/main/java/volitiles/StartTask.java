package volitiles;

import java.util.Scanner;

public class StartTask {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task).start();
        new Scanner(System.in).nextLine();
        task.stop();
        System.out.println("Main: " + task.getCount());
    }
}
