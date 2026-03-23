package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // driver
    private  final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    // url
    private final static String URL = "jdbc:aws-wrapper:mysql://localhost:3306/";
    // user name
    private final static String USER = "root";
    // password
    private final static String PASS = "123456@";

    public static Connection openConnection() {
        Connection con = null;

        // khai báo cho class biết driver
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e ) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
