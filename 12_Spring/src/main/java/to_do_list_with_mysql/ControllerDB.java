package to_do_list_with_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("messages")
public class ControllerDB {
    @Autowired
    private ToDoListRepo toDoListRepo;


    @GetMapping
    public List<ToDoListWithDB> getAll() {
        List<ToDoListWithDB> allList = new ArrayList<>();
        Iterable<ToDoListWithDB> all = toDoListRepo.findAll();
        all.forEach(allList::add);
        return allList;
    }

    @GetMapping("/{id}")
    public ToDoListWithDB getById(@PathVariable int id) {
        Optional<ToDoListWithDB> byId = toDoListRepo.findById(id);
        return byId.orElse(null);
    }

    @PostMapping
    public int addNewMessage(@RequestParam String message) {
        ToDoListWithDB newMessage = new ToDoListWithDB();
        newMessage.setBody(message);
//        newMessage.setTitle(message.substring(0, 15) + "...");
        toDoListRepo.save(newMessage);
        return newMessage.getId();
    }

    @DeleteMapping("/{id}")
    public AtomicBoolean deleteOne(@PathVariable int id) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (toDoListRepo.existsById(id)) {
            toDoListRepo.deleteById(id);
            atomicBoolean.set(true);
        }
        return atomicBoolean;
    }

    @DeleteMapping
    public AtomicBoolean deleteAll() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        toDoListRepo.deleteAll();
        if (toDoListRepo.count() == 0)
            atomicBoolean.set(true);

        return atomicBoolean;
    }

    @PutMapping("/{id}")
    public ToDoListWithDB editMessageById(@PathVariable int id, String message) {
        Optional<ToDoListWithDB> byId = toDoListRepo.findById(id);
        if (byId.isPresent()) {
            ToDoListWithDB editedMessage = byId.get();
            editedMessage.setBody(message);
            toDoListRepo.save(editedMessage);
            return editedMessage;
        }

        else return null;
    }

}








