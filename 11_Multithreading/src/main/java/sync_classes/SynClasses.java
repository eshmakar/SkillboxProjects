package sync_classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SynClasses {

    public static void main(String[] args) {
        Collection<Object> objects = Collections.synchronizedCollection(new ArrayList<>());
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 1_000_000; j++) {
                    objects.add("c");
                }
                System.out.println(objects.size());
            }));
        }
        threads.forEach(Thread::start);

    }


}
