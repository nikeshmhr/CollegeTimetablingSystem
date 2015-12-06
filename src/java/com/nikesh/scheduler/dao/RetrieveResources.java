package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.factory.ClassTypeFactory;
import com.nikesh.scheduler.model.Classroom;
import com.nikesh.scheduler.model.Group;
import com.nikesh.scheduler.model.Module;
import com.nikesh.scheduler.model.Teacher;
import com.nikesh.scheduler.model.TeacherModule;
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

    public static String getTeacherName(String teacherId) throws SQLException {
        String teacherName = "";

        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT teacherName FROM teachers WHERE teacherId=?");
        statement.setString(1, teacherId);

        ResultSet rs = DatabaseTool.executeQuery(statement);

        teacherName = rs.getString("teacherName");

        return teacherName;
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
        while (rs.next()) {
            Group g = new Group(rs.getString("groupCode"), rs.getInt("noOfStudents"));
            groups.add(g);
        }

        return groups;

    }

    /**
     * Existing Identifier means the combination of module and class type that
     * are already reserved
     *
     * @return
     */
    public static List<String> getExistingIdentifier() throws SQLException {
        ArrayList<String> existingIdentifier = new ArrayList<String>();

        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT identifier FROM teacher_modules");
        ResultSet rs = DatabaseTool.executeQuery(statement);
        while (rs.next()) {
            String identifier = rs.getString("identifier");
            existingIdentifier.add(identifier);
        }

        return existingIdentifier;
    }
    /*
     public static List<TeacherModule> getTeacherModules() throws SQLException {
     List<TeacherModule> teacherModules = new ArrayList<TeacherModule>();
        
     connection = DatabaseTool.getConnection();
     PreparedStatement statement = connection.prepareStatement("SELECT * FROM teacher_modules");
     ResultSet rs = DatabaseTool.executeQuery(statement);
     while(rs.next()){
     TeacherModule teacherModule = new TeacherModule();
     Teacher teacher = new Teacher();
     List<Module> listOfModules = new ArrayList<Module>();
            
     String teacherId = rs.getString("teacherId");
            
     // Extracting info about teacher 
     statement = connection.prepareStatement("SELECT * FROM teachers WHERE teacherId=?");
     statement.setString(1, teacherId);
     ResultSet teachersRs = statement.executeQuery();
     while(teachersRs.next()){
     teacher.setTeacherId(teachersRs.getString("teacherId"));
     teacher.setTeacherName(teachersRs.getString("teacherName"));
     }
            
     // Extractig modules for specific teacher
            
     }
        
     return teacherModules;
     }
    
     public static List<Module> getModulesFromTeacherId(String teacherId) throws SQLException{
     List<Module> modules = new ArrayList<Module>();
        
     connection = DatabaseTool.getConnection();
        
     PreparedStatement statement = connection.prepareStatement("SELECT moduleCode FROM teacher_modules WHERE teacherId=?");
     statement.setString(1, teacherId);
     ResultSet rs = statement.executeQuery();
     while(rs.next()){
     Module m = new Module();
     }
        
     return modules;
     }
     */

    public static List<ClassType> getClassTypesForModule(String moduleId) throws SQLException {
        List<ClassType> classTypes = new ArrayList<ClassType>();

        connection = DatabaseTool.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM module_classes WHERE moduleCode=?");
        statement.setString(1, moduleId);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int typeId = rs.getInt("typeId");
            ClassType type = ClassTypeFactory.getClassType(typeId);
            type.setClassHours(rs.getDouble("classHours"));
            classTypes.add(type);
        }

        return classTypes;
    }

    public static String getModuleName(String moduleCode) throws SQLException {
        String moduleName = "";

        connection = DatabaseTool.getConnection();
        
        PreparedStatement statement = connection.prepareStatement("SELECT moduleName FROM modules WHERE moduleCode=?");
        statement.setString(1, moduleCode);
        
        ResultSet rs = DatabaseTool.executeQuery(statement);
        
        moduleName = rs.getString("moduleName");
        
        
        return moduleName;
    }
}
