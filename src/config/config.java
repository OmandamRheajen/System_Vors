package config;

import java.sql.*;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class config {
    
    
    public static Connection connectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            
            return DriverManager.getConnection("jdbc:sqlite:db.db");
        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
            return null;
        }
    }

    
    public void displayData(String sql, JTable table) {
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
           
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException e) {
            System.out.println("Query Error: " + e.getMessage());
        }
    }
}
