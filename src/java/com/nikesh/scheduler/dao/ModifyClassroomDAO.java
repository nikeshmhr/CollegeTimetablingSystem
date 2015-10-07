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
public class ModifyClassroomDAO {
    
    private static Connection connection;
    
    public ModifyClassroomDAO(){
        connection = DatabaseTool.getConnection();
    }
    
    public int deleteClassroom(String roomCode) throws SQLException{        
        PreparedStatement statement = connection.prepareStatement("DELETE FROM classrooms WHERE roomCode=?");
        statement.setString(1, roomCode);
        return DatabaseTool.updateQuery(statement);
    }
    
    public int addModifiedClassroom(Classroom room) throws SQLException{
        PreparedStatement statement = connection.prepareStatement("UPDATE classrooms SET roomName=?, roomCapacity=?, typeId=? WHERE roomCode=?");
        statement.setString(1, room.getRoomName());
        statement.setInt(2, room.getCapacity());
        statement.setInt(3, room.getRoomType().getTypeId());
        statement.setString(4, room.getRoomCode());
        
        return DatabaseTool.updateQuery(statement);
    }
    
}
