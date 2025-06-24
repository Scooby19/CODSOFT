package EduManager.controller;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:db/edu_db.sqlite";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            System.out.println(" Database connection failed: " + e.getMessage());
            return null;
        }
    }
}
