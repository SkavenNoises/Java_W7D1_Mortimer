package Exercise3;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // DB properties
        String dbURL = "jdbc:mysql://172.17.0.2:3306/university";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password","ratbox94");

        try {
            // Connecting to DB
            Connection connection = DriverManager.getConnection(dbURL, properties);
            connection.setAutoCommit(true);

            // Initialising statement object instance
            Statement statement = connection.createStatement();

            // SQL statement to pull table
            String sqlStatement = "SELECT * FROM students";

            // Getting the meta data for numColumns and their names
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            // Printing out all the column names
            System.out.println("Column names:");
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.println(String.format("Column %s name: %s, of type: %s", i, resultSetMetaData.getColumnLabel(i), resultSetMetaData.getColumnTypeName(i)));
            }

            // Finding the name of the table
            System.out.println("\nTable name: " + resultSetMetaData.getTableName(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
