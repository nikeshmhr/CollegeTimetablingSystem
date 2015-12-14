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

    public ModifyTeacherDAO() throws SQLException, ClassNotFoundException {
        connection = DatabaseTool.getConnection();
    }

    public int deleteTeacher(String teacherId) throws SQLException, ClassNotFoundException {
        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM teachers WHERE teacherId=?");
        statement.setString(1, teacherId);

        return statement.executeUpdate();

    }

    public int addModifiedTeacher(Teacher t) throws SQLException, ClassNotFoundException {
        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE teachers SET teacherName=? WHERE teacherId=?");
        statement.setString(1, t.getTeacherName());
        statement.setString(2, t.getTeacherId());

        System.out.println("ModifyTeacherDAO line no 36.");
        
        return statement.executeUpdate();
    }

}
