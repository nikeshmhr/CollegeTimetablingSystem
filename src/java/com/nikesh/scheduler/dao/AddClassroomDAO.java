package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.model.Classroom;
import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class AddClassroomDAO {
    
    private static Connection connection;
    
    public AddClassroomDAO(){
        connection = DatabaseTool.getConnection();
    }
    
    public int addClassroom(Classroom classroom) throws SQLException{
        int rowsInserted = 0;
        
        PreparedStatement statement = connection.prepareStatement("INSERT INTO classrooms VALUES(?, ?, ?, ?)");
        statement.setString(1, classroom.getRoomCode());
        statement.setString(2, classroom.getRoomName());
        statement.setInt(3, classroom.getCapacity());
        statement.setInt(4, classroom.getRoomType().getTypeId());
        
        rowsInserted = DatabaseTool.updateQuery(statement);
        
        return rowsInserted;       
    }
    
}
