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
    
    public AddGroupDAO(){
        connection = DatabaseTool.getConnection();
    }
    
    public int addGroup(Group g) throws SQLException{
        int rowsInserted = 0;
        
        PreparedStatement statement = connection.prepareStatement("INSERT INTO groups VALUES(?, ?)");
        statement.setString(1, g.getGroupCode());
        statement.setInt(2, g.getNoOfStudents());
        
        rowsInserted = DatabaseTool.updateQuery(statement);
        
        return rowsInserted;
    }
    
}
