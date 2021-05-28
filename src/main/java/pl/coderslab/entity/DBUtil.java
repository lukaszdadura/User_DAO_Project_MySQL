package pl.coderslab.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String DB_URL ="jdbc:mysql://localhost:3306/workshop2";
    private static final String DB_USER ="root";
    private static final String DB_PASS ="1234lukasz";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        return connection;
    }


}

