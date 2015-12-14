package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.model.Teacher;
import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author Nikesh
 */
public class AddTeacherDAO {
    
    private static Connection connection;
    
    public AddTeacherDAO() throws SQLException, ClassNotFoundException{
        connection = DatabaseTool.getConnection();
    }
    
    public boolean addTeachers(Set<Teacher> teachers) throws SQLException, ClassNotFoundException{
        boolean flag = false;
        
        connection = DatabaseTool.getConnection();
        
        PreparedStatement statement;
        
        for(Teacher teacher : teachers){
            statement = connection.prepareStatement("INSERT INTO teachers VALUES(?, ?)");
            statement.setString(1, teacher.getTeacherId());
            statement.setString(2, teacher.getTeacherName());
            int rowsInserted = DatabaseTool.updateQuery(statement);
            if(rowsInserted == 0){
                flag = false;
                return flag;
            }else{
                flag = true;
            }
        }
        return flag;
        
    }
    
}
