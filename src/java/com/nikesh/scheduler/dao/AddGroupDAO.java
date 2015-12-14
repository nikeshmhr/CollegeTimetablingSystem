package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.model.Group;
import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class AddGroupDAO {
    
    private static Connection connection;
    
    public AddGroupDAO() throws SQLException, ClassNotFoundException{
        connection = DatabaseTool.getConnection();
    }
    
    public int addGroup(Group g) throws SQLException, ClassNotFoundException{
        int rowsInserted = 0;
        
        connection = DatabaseTool.getConnection();
        
        PreparedStatement statement = connection.prepareStatement("INSERT INTO groups VALUES(?, ?)");
        statement.setString(1, g.getGroupCode());
        statement.setInt(2, g.getNoOfStudents());
        
        rowsInserted = DatabaseTool.updateQuery(statement);
        
        return rowsInserted;
    }
    
}
