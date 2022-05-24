package to_do_list_with_mysql;

import org.springframework.stereotype.Component;

import javax.persistence.*;

//@Component
@Entity
@Table(name = "todo")
public class ToDoListWithDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private  String title;
    private  String body;

    public ToDoListWithDB() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
        this.title = body.substring(0, 15) + "...";
    }

    @Override
    public String toString() {
        return "ToDoListWithDB{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
