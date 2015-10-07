package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.model.Teacher;
import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class ModifyTeacherDAO {
    
    private static Connection connection;
    
    public ModifyTeacherDAO(){
        connection = DatabaseTool.getConnection();
    }
    
    public int deleteTeacher(String teacherId) throws SQLException{
        
        PreparedStatement statement = connection.prepareStatement("DELETE FROM teachers WHERE teacherId=?");
        statement.setString(1, teacherId);
        
        return DatabaseTool.updateQuery(statement);
        
    }
    
    public int addModifiedTeacher(Teacher t) throws SQLException{
        PreparedStatement statement = connection.prepareStatement("UPDATE teachers SET teacherName=? WHERE teacherId=?");
        statement.setString(1, t.getTeacherName());
        statement.setString(2, t.getTeacherId());
        
        return DatabaseTool.updateQuery(statement);
    }
    
}