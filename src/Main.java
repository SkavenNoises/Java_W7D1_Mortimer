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

            // Setting auto commit to true so each commit is sent immediately
            connection.setAutoCommit(true);

            // Checking to see if the database has been connected to
            if (!connection.isClosed()) {
                System.out.println("Connection Established...\n");
            }

            // Creating the QUERY statement object instance
            Statement statement = connection.createStatement();

            // Storing the SQL statement you wish to pass
            String sqlStatement = "SELECT * FROM students ORDER BY students.name ASC";

            // Executing the statement and storing the return in an ResultSet
            ResultSet resultSet = statement.executeQuery(sqlStatement);

            // Creating the output list header
            String studentListHeader = String.format("%3s %20s", "ID", "Name");
            System.out.println("-".repeat(studentListHeader.length()));
            System.out.println(studentListHeader);
            System.out.println("-".repeat(studentListHeader.length()));


            // Iterating through the result set that has been returned
            while (resultSet.next()) {
                // Passing the info into variables
                String studentName = resultSet.getString("name");
                int studentID = resultSet.getInt("id");

                System.out.println(String.format("%3s %20s", studentID, studentName));
            }

            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
