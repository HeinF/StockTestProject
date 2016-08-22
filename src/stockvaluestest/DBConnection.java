/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockvaluestest;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String dbPath = "jdbc:mysql://localhost:3306/northfinancedb";
    private static String dbLogin = "exam";
    private static String dbPass = "finance";
    private static String dbDriver = "com.mysql.jdbc.Driver";

    private DBConnection() {

    }

    public static void init() {
        try {
            if (dbDriver != null) {
                Class.forName(dbDriver);
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return (Connection) DriverManager.getConnection(dbPath, dbLogin, dbPass);
        } catch (SQLException ex) {
            
            return null;
        }
    }
}