package jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/imena";
        String user = "root";
        String pass = "root";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM imena.russian_names where Name = 'антон'");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }

            connection.close();
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
