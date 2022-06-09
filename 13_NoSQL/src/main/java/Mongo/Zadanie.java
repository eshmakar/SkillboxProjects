package Mongo;
/*
Напишите программу, которая получает на вход csv файл с данными о студентах: имя, возраст и список курсов через запятую, и вставляет эти данные в MongoDB
(csv файл приложен к этому уроку)
После этого программа должна получить из БД и вывести на экран:
— общее количество студентов в базе.
— количество студентов старше 40 лет.
— имя самого молодого студента.
— список курсов самого старого студента
*/

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Zadanie {
    public static void main(String[] args) throws IOException {
        printFromCsvFile("src/main/mongo.csv");

    }

    private static void printFromCsvFile(String pathToDocumentCsv) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(pathToDocumentCsv), StandardCharsets.UTF_8);

        MongoClient client = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = client.getDatabase("mymongo");
        MongoCollection<Document> students = database.getCollection("students");

        students.drop();

        for (String string : strings) {
            StringBuilder sb = new StringBuilder();

            String[] split = string.split(",", 3);

            sb.append("{Name: \"" + split[0] + "\", age: " + split[1] + ", courses: ");
            for (int i = 2; i < split.length; i++) {
                sb.append(split[i]);
            }
            sb.append("}\n");
            students.insertOne(Document.parse(sb.toString()));
        }

        System.out.println("Общее кол-во студентов в базе: " + students.countDocuments());
        System.out.println("Кол-во студентов старше 40 лет: " + students.countDocuments(BsonDocument.parse("{age: {$gt: 40}}")));

        String molodoi = Objects.requireNonNull(students
                .find(BsonDocument.parse("{age: {$lt: 90}}"))
                .sort(BsonDocument.parse("{age: 1}"))
                .limit(1).first()).getString("Name");
        System.out.println("Имя самого молодого студента: " + molodoi);


        String coursesOfOldStudent = Objects.requireNonNull(students
                .find(BsonDocument.parse("{age: {$gt: 15}}"))
                .sort(BsonDocument.parse("{age: -1}"))
                .limit(1).first()).getString("courses");
        System.out.println("Список курсов самого старого студента: " + coursesOfOldStudent);
    }
}

