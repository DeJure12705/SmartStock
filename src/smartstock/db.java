/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    // Method to establish a database connection
    public static Connection mycon() {
        Connection con = null;
        try {
            // Loading the JDBC driver for MySQL
            Class.forName("com.mysql.jdbc.Driver");
            // Establishing a connection to the database named "smartstock" on localhost with username "root" and no password
            con = DriverManager.getConnection("jdbc:mysql://localhost/smartstock", "root", "");
            // Returning the connection object
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            // Handling exceptions related to driver loading or connection establishment
            System.out.println(e);
            return null;
        }
    }
}
