package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class config {
    public static Connection connectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:db.db");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}