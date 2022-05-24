package to_do_list_with_mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepo extends CrudRepository<ToDoListWithDB, Integer> {

}
