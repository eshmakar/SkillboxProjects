package to_do_list;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("messages")
public class ControllerToDoList {

    @GetMapping()
    public List<ToDoList> getAllMessages() {
        System.out.println("get all message");
        return ManipulationsWithToDoList.getAllMessages();
    }

    @PostMapping()
    public int addNewMessage(String message) {
        System.out.println(message);
        return ManipulationsWithToDoList.addMessage(message);
    }

    @DeleteMapping()
    public AtomicBoolean deleteAllMessages() {
        System.out.println("Deleted all messages");
        return ManipulationsWithToDoList.deleteAllMessages();
    }

    @GetMapping("/{id}")
    public ToDoList getOneMessage(@PathVariable int id) {
        System.out.println("get one message");
        return ManipulationsWithToDoList.getMessageFromId(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ToDoList> postOneMessage(@PathVariable int id) {
        System.out.println("method not allowed");
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
    }

    @PutMapping("/{id}")
    public AtomicBoolean editOneMessage(@PathVariable int id, String message) {
        System.out.println("edit one message");
        return ManipulationsWithToDoList.editMessage(id, message);
    }

    @DeleteMapping("/{id}")
    public AtomicBoolean deleteMessage(@PathVariable int id) {
        System.out.println("delete message");
        return ManipulationsWithToDoList.deleteOneMessage(id);
    }
}
