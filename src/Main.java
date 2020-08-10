import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        // Database properties
        final String dbURLString = "jdbc:mysql://172.17.0.2:3306/university";
        Properties mProperties = new Properties();
        mProperties.put("user", "root");
        mProperties.put("password", "ratbox94");

        try {
            // Connecting to the DB
            Connection connection = DriverManager.getConnection(dbURLString, mProperties);

            // Setting auto commmit to true so each commit is sent immediately
            connection.setAutoCommit(true);

            // Checking to see if the database has been connected to
            if (!connection.isClosed()) {
                System.out.println("Connection Established...");
            }

            // Creating the QUERY statement object instance
            Statement statement = connection.createStatement();

            // Storing the SQL statement you wish to pass
            String sqlStatement = "SELECT * FROM students";

            // Executing the statement and storing the return in an ResultSet
            ResultSet resultSet = statement.executeQuery(sqlStatement);

            // Iterating through the result set that has been returned
            while (resultSet.next()) {
                String studentName = resultSet.getString("name");

                System.out.println(studentName);



            }

            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
