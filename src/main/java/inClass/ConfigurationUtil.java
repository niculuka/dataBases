package inClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConfigurationUtil {
    private static String pass = "";
    public static Connection getConnection() {
        pass();
        String url = "jdbc:mysql://localhost:3306/coffee_store";
        String user = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successfully!");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }







    public static void pass() {
        File file = new File("C:/Users/ACASA/IdeaProjects/pass.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                pass = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}