package Exercise2;

import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Database properties
        final String databaseURL = "jdbc:mysql://172.17.0.2:3306/university";
        final Properties mProperties = new Properties();
        mProperties.put("user", "root");
        mProperties.put("password", "ratbox94");

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
                        case 0:
                            System.out.println("Shutting down...");
                            //connection.close();
                            endLoop = true;
                            break;

                        case 1:

                            break;

                        case 2:

                            break;

                    }

                } else {
                    throw new NumberFormatException();
                }

            } catch (NumberFormatException e) {
                System.out.println("Please make a valid selection");
            }
        }
    }
}
