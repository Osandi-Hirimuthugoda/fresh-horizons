/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.managment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DBUtil {
    public static Connection getConnection(){
        try{
        
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Define the connection URL
            String url = "jdbc:sqlserver://localhost:1433;databaseName=posdb;encrypt=true;trustServerCertificate=true";
            String username = "osandi";
            String password = "1234";
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    };
}
