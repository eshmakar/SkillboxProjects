package hiber;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "russian_names")
public class ImenaRussians {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Sex")
    private String sex;
    @Column(name = "PeoplesCount")
    private Integer peoplesCount;
    @Column(name = "WhenPeoplesCount")
    private Date whenPeoplesCount;
    @Column(name = "Source")
    private String source;

    public ImenaRussians() {
    }

    public ImenaRussians(Integer id, String name, String sex, Integer peoplesCount, Date whenPeoplesCount, String source) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.peoplesCount = peoplesCount;
        this.whenPeoplesCount = whenPeoplesCount;
        this.source = source;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPeoplesCount() {
        return peoplesCount;
    }

    public void setPeoplesCount(Integer peoplesCount) {
        this.peoplesCount = peoplesCount;
    }

    public Date getWhenPeoplesCount() {
        return whenPeoplesCount;
    }

    public void setWhenPeoplesCount(Date whenPeoplesCount) {
        this.whenPeoplesCount = whenPeoplesCount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    @Override
    public String toString() {
        return "ImenaRussians{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", peoplesCount=" + peoplesCount +
                ", whenPeoplesCount=" + whenPeoplesCount +
                ", source='" + source + '\'' +
                '}';
    }
}
