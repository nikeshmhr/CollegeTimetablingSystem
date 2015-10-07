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
public class ModifyGroupDAO {
    
    private static Connection connection;
    
    public ModifyGroupDAO(){
        connection = DatabaseTool.getConnection();
    }
    
    public int deleteGroup(String groupId) throws SQLException{
        PreparedStatement statement = connection.prepareStatement("DELETE FROM groups WHERE groupCode=?");
        statement.setString(1, groupId);
        
        return DatabaseTool.updateQuery(statement);
    }
    
    public int addModifiedGroup(Group group) throws SQLException{
        PreparedStatement statement = connection.prepareStatement("UPDATE groups SET noOfStudents=? WHERE groupCode=?");
        statement.setInt(1, group.getNoOfStudents());
        statement.setString(2, group.getGroupCode());
        return DatabaseTool.updateQuery(statement);
    }
    
}
