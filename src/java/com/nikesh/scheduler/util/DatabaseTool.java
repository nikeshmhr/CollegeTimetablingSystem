package com.nikesh.scheduler.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikesh
 */
public class DatabaseTool {
    
    private static Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public DatabaseTool() {
        
    }
    
    public static Connection getConnection(){
        if(connection == null){
            setConnection();
        }
        return connection;
    }
    
    private static void setConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/scheduler", "user", "nikesh");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public static ResultSet executeQuery(PreparedStatement statement) throws SQLException{
        ResultSet rs = null;
        rs = statement.executeQuery();
        return rs;
    }
    
    
    public static int updateQuery(PreparedStatement statement) throws SQLException{
        int status = 0;
        
        status = statement.executeUpdate();
        
        return status;
    }
    
}