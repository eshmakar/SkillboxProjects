package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public class StartWithHiber {
    public static void main(String[] args) {
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Names name1 = new Names();
//        name1.setName("Vlad");
//        session.saveOrUpdate(name1);
//        session.getTransaction().commit();
//        sessionFactory.close();


//        session.save(new Student("gener", Days.MONDAY));
//        session.save(new Student("Max", Days.FRIDAY, new Date()));

//        Student load = session.load(Student.class, 4);//достаем по id, если такого значения нет, выбрасится ObjectNotFoundException
//        System.out.println(load.getName());//выводим имя объекта
//        Student get = session.get(Student.class, 7);//если такого значения нет, выбрасится NullPointerException
//        System.out.println(get.getIdPlusAge());

//        Student st = new Student("Max");
//        st.setAddress(new Address("Lenina", 45));//добавляем адрес студента
//        session.save(st);

        //@OneToOne
//       HomeAddress homeAddress = new HomeAddress("Pushkina");
//        Person person = new Person("Max", homeAddress);
//        homeAddress.setPerson(person);
//        session.persist(person);//persist - это тоже самое что и session.save
//        session.persist(homeAddress);

        //@OneToMany
//        HomeAddress homeAddress = new HomeAddress("Pushkina");
//        List<HomeAddress> list = new ArrayList<>();
//        list.add(homeAddress);
//        Person person = new Person("Max", list);
//        homeAddress.setPerson(person);
//        session.persist(homeAddress);
//        session.persist(person);

        //@ManyToMany
//        HomeAddress homeAddress = new HomeAddress("Sovetskii");
//        List<HomeAddress> list = new ArrayList<>();
//        list.add(homeAddress);
//
//        Person person = new Person("Nikolai", list);
//        List<Person> people = new ArrayList<>();
//        people.add(person);
//        homeAddress.setPerson(people);
//
//        session.persist(homeAddress);
//        session.persist(person);
//
//        session.getTransaction().commit();
//        session.close();





    }
}
