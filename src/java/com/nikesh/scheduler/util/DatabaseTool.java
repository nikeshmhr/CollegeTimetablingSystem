package com.nikesh.scheduler.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class DatabaseTool {

    private static Connection connection;
    
    public DatabaseTool() {

    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            setConnection();
        }
        return connection;
    }

    private static void setConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/scheduler", "root", "");
    }

    public static ResultSet executeQuery(PreparedStatement statement) throws SQLException {
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public static int updateQuery(PreparedStatement statement) throws SQLException {
        int status = statement.executeUpdate();
        return status;
    }

}
