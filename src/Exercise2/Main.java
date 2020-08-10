package Exercise2;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Database properties
        final String databaseURL = "jdbc:mysql://172.17.0.2:3306/university";
        final Properties mProperties = new Properties();
        mProperties.put("user", "root");
        mProperties.put("password", "ratbox94");

        try {
            Connection connection = DriverManager.getConnection(databaseURL, mProperties);

            // Setting auto commit
            connection.setAutoCommit(true);

            // Creating the statement object instance
            Statement statement = connection.createStatement();

            boolean endLoop = false;
            while (!endLoop) {

                // Menu header
                System.out.println("\nUniversity Teacher Console");
                System.out.println("1) Student Details");
                System.out.println("2) Course Details");
                System.out.println("0) Quit");
                System.out.println("\nPlease make your selection...");

                // Scanning for user input
                Scanner scanner = new Scanner(System.in);
                try { // Catching any invalid menu selections
                    String scannerSelection = scanner.next();
                    if (Integer.parseInt(scannerSelection) <= 2 && Integer.parseInt(scannerSelection) >= 0) {
                        System.out.println(scannerSelection);
                        // Switching to different behaviour depending on user selection
                        switch (Integer.parseInt(scannerSelection)) {
                            case 0: // Quit program
                                System.out.println("Shutting down...");

                                connection.close();

                                endLoop = true;

                                break;

                            case 1: // Student Details
                                String sql_getStudentInfo = "SELECT * FROM university.students";
                                ResultSet resultSet = statement.executeQuery(sql_getStudentInfo);

                                // Creating the output list header
                                String studentListHeader = String.format("%3s %20s %20s", "ID", "Name", "Address");
                                System.out.println("\n");
                                System.out.println("-".repeat(studentListHeader.length()));
                                System.out.println(studentListHeader);
                                System.out.println("-".repeat(studentListHeader.length()));

                                while (resultSet.next()) {
                                    int studentID = resultSet.getInt("id");
                                    String studentName = resultSet.getString("name");
                                    String studentAddress = resultSet.getString("address");

                                    System.out.println(String.format("%3s %20s %20s", studentID, studentName, studentAddress));
                                }

                                break;

                            case 2: // Course Details

                                break;

                        }

                    } else {
                        throw new NumberFormatException();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Please make a valid selection");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
