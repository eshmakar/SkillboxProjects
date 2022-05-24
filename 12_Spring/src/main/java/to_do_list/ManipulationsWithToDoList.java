package to_do_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class ManipulationsWithToDoList {
    private static int idCount = 1;
    private static final List<ToDoList> allMessages = new ArrayList<>();


    public static int addMessage(String message) {
        ToDoList newMessage = new ToDoList();
        newMessage.setId(idCount++);
        newMessage.setBody(message);
        newMessage.setTitle(message.substring(0, 5));
        allMessages.add(newMessage);
        return newMessage.getId();
    }

    public static ToDoList getMessageFromId(int id) {
        return allMessages.stream()
                .filter(e -> e.getId() == id)
                .findFirst().get();
    }


    public static AtomicBoolean deleteOneMessage(int id) {
        AtomicBoolean isOk = new AtomicBoolean(false);

        Optional<ToDoList> first = allMessages.stream()
                .filter(e -> e.getId() == id)
                .findFirst();

        first.ifPresent(toDoList ->
        {
            allMessages.remove(toDoList);
            isOk.set(true);
        });
        return isOk;
    }


    public static AtomicBoolean deleteAllMessages() {
        AtomicBoolean isOk = new AtomicBoolean(false);
        allMessages.clear();
        isOk.set(true);
        return isOk;
    }

    public static AtomicBoolean editMessage(int id, String bodyOfMessage) {
        AtomicBoolean isOk = new AtomicBoolean(false);
        Optional<ToDoList> first = allMessages.stream()
                .filter(e -> e.getId() == id)
                .findFirst();

        first.ifPresent(mes -> {
                    mes.setBody(bodyOfMessage);
                    mes.setTitle(mes.getBody().substring(0, 10));
                    isOk.set(true);
                }
        );
        return isOk;
    }

    public static List<ToDoList> getAllMessages() {
        return allMessages;
    }

}
