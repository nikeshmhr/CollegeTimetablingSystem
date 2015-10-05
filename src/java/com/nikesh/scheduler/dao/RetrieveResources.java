package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.factory.ClassTypeFactory;
import com.nikesh.scheduler.model.Classroom;
import com.nikesh.scheduler.model.Group;
import com.nikesh.scheduler.model.Module;
import com.nikesh.scheduler.model.Teacher;
import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikesh
 */
public class RetrieveResources {

    private static Connection connection;

    public static List<Module> getModules() throws SQLException {
        List<Module> listOfModules = new ArrayList<Module>();

        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM modules");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Module m = new Module();
            m.setModuleCode(rs.getString("moduleCode"));
            m.setModuleName(rs.getString("moduleName"));
            listOfModules.add(m);
        }

        for (Module m : listOfModules) {
            statement = connection.prepareStatement("SELECT * FROM module_classes WHERE moduleCode=?");
            statement.setString(1, m.getModuleCode());
            rs = statement.executeQuery();
            while (rs.next()) {
                ClassType type = ClassTypeFactory.getClassType(rs.getInt("typeId"));
                type.setClassHours(rs.getDouble("classHours"));
                m.getTypeOfClasses().add(type);
            }
        }
        return listOfModules;
    }

    public static List<Teacher> getTeachers() throws SQLException {
        List<Teacher> teachers = new ArrayList<Teacher>();

        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachers");
        ResultSet rs = DatabaseTool.executeQuery(statement);
        while (rs.next()) {
            Teacher t = new Teacher(rs.getString("teacherId"), rs.getString("teacherName"));
            teachers.add(t);
        }

        return teachers;
    }

    public static List<Classroom> getClassrooms() throws SQLException {
        List<Classroom> classrooms = new ArrayList<Classroom>();

        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM classrooms");
        ResultSet rs = DatabaseTool.executeQuery(statement);
        while (rs.next()) {
            ClassType type = ClassTypeFactory.getClassType(rs.getInt("typeId"));
            Classroom c = new Classroom(rs.getString("roomCode"), rs.getString("roomName"), type, rs.getInt("roomCapacity"));
            classrooms.add(c);
        }

        return classrooms;
    }

    public static List<Group> getGroups() throws SQLException {
        List<Group> groups = new ArrayList<Group>();
        
        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM groups");
        ResultSet rs = DatabaseTool.executeQuery(statement);
        while(rs.next()){
            Group g = new Group(rs.getString("groupCode"), rs.getInt("noOfStudents"));
            groups.add(g);
        }
        
        return groups;
        
    }

}
