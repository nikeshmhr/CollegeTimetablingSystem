package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.factory.ClassTypeFactory;
import com.nikesh.scheduler.model.Classroom;
import com.nikesh.scheduler.model.Group;
import com.nikesh.scheduler.model.GroupModule;
import com.nikesh.scheduler.model.Module;
import com.nikesh.scheduler.model.ModuleAndItsType;
import com.nikesh.scheduler.model.Teacher;
import com.nikesh.scheduler.model.TeacherModule;
import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikesh
 */
public class RetrieveResources {

    private static Connection connection;

    public static List<Module> getModules() throws SQLException, ClassNotFoundException {
        List<Module> listOfModules = new ArrayList<Module>();

        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM modules ORDER BY moduleCode, moduleName");
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

    public static List<Teacher> getTeachers() throws SQLException, ClassNotFoundException {
        List<Teacher> teachers = new ArrayList<Teacher>();

        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachers ORDER BY teacherName, teacherId");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Teacher t = new Teacher(rs.getString("teacherId"), rs.getString("teacherName"));
            teachers.add(t);
        }

        return teachers;
    }

    public static String getTeacherName(String teacherId) throws SQLException, ClassNotFoundException {
        String teacherName = "";

        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT teacherName FROM teachers WHERE teacherId=?");
        statement.setString(1, teacherId);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            teacherName = rs.getString("teacherName");
            break;
        }
        return teacherName;
    }

    public static List<Classroom> getClassrooms() throws SQLException, ClassNotFoundException {
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

    public static List<Group> getGroups() throws SQLException, ClassNotFoundException {
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
    public static List<String> getExistingIdentifier(String item) throws SQLException, ClassNotFoundException {
        ArrayList<String> existingIdentifier = new ArrayList<String>();

        connection = DatabaseTool.getConnection();

        PreparedStatement statement = null;

        if (item.equalsIgnoreCase("teacher_modules")) {
            statement = connection.prepareStatement("SELECT identifier FROM teacher_modules");
        } else if (item.equalsIgnoreCase("group_modules")) {
            statement = connection.prepareStatement("SELECT identifier FROM group_module");
        }

        ResultSet rs = DatabaseTool.executeQuery(statement);
        while (rs.next()) {
            String identifier = rs.getString("identifier");
            existingIdentifier.add(identifier);
        }

        return existingIdentifier;
    }

    public static List<TeacherModule> getTeacherModules() throws SQLException, ClassNotFoundException {
        connection = DatabaseTool.getConnection();

        List<TeacherModule> listOfTeacherModule = new ArrayList<TeacherModule>();

        PreparedStatement s = connection.prepareStatement("SELECT * FROM teacher_modules ORDER BY teacherId");
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            TeacherModule tM = new TeacherModule();

            Teacher t = new Teacher();
            t.setTeacherId(rs.getString("teacherId"));

            ModuleAndItsType moduleAndItsType = new ModuleAndItsType();

            Module m = new Module();
            m.setModuleCode(rs.getString("moduleCode"));
            ClassType classType = ClassTypeFactory.getClassType(rs.getInt("typeId"));
            String identifier = rs.getString("identifier");

            moduleAndItsType.setIdentifier(identifier);
            moduleAndItsType.setModule(m);
            moduleAndItsType.setTypeOfClass(classType);

            tM.setTeacher(t);
            tM.getListOfModulesAndItsType().add(moduleAndItsType);

            listOfTeacherModule.add(tM);
        }
        return listOfTeacherModule;
    }

    public static List<ClassType> getClassTypesForModule(String moduleId) throws SQLException, ClassNotFoundException {
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

    public static String getModuleName(String moduleCode) throws SQLException, ClassNotFoundException {
        String moduleName = "";

        connection = DatabaseTool.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT moduleName FROM modules WHERE moduleCode=?");
        statement.setString(1, moduleCode);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            moduleName = resultSet.getString("moduleName");
            break;
        }

        return moduleName;
    }

    public static List<GroupModule> getGroupModule() throws SQLException, ClassNotFoundException {
        List<GroupModule> groupModules = new ArrayList<GroupModule>();

        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM group_module ORDER BY groupCode");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
//            System.out.println(rs.getString("groupCode") + "<br/>" + rs.getString("moduleCode") + "<br/>" + rs.getString("identifier"));
            String groupCode = rs.getString("groupCode");
            int noOfStudents = 0;
            PreparedStatement s = connection.prepareStatement("SELECT noOfStudents FROM groups WHERE groupCode=?");
            s.setString(1, groupCode);
            ResultSet result = s.executeQuery();
            while (result.next()) {
                noOfStudents = result.getInt("noOfStudents");
                break;
            }

            Group group = new Group(groupCode, noOfStudents);
            String identifier = rs.getString("identifier");
            Module module = new Module();
            module.setModuleCode(rs.getString("moduleCode"));
            module.setModuleName(getModuleName(rs.getString("moduleCode")));

            List<ModuleAndItsType> moduleAndItsTypes = new ArrayList<ModuleAndItsType>();

            ModuleAndItsType moduleAndItsType = new ModuleAndItsType();
            moduleAndItsType.setIdentifier(identifier);
            moduleAndItsType.setModule(module);
            moduleAndItsTypes.add(moduleAndItsType);

            moduleAndItsTypes.add(moduleAndItsType);

            GroupModule groupModule = new GroupModule(group, moduleAndItsTypes);

            groupModules.add(groupModule);
        }

        return groupModules;
    }

    public static int getLastIDForTeacher() throws SQLException, ClassNotFoundException {
        int id = 0;
        connection = DatabaseTool.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachers ORDER BY teacherId DESC");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String idString = rs.getString("teacherId");
            
            id = Integer.parseInt(idString.substring(2));
            
            break;
        }
        System.out.println(id);
        return id;
    }
}
