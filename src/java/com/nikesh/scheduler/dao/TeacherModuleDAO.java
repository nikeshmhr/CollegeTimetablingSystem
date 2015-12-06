package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.model.ModuleAndItsType;
import com.nikesh.scheduler.model.TeacherModule;
import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nikesh
 */
public class TeacherModuleDAO {

    private static Connection connection;

    public TeacherModuleDAO() {
        connection = DatabaseTool.getConnection();
    }

    public int addTeacherModule(TeacherModule teacherModule) throws SQLException {
        int rowsModified = 0;

        List<ModuleAndItsType> listOfModulesAndItsType = teacherModule.getListOfModulesAndItsType();
        for (ModuleAndItsType moduleAndItsType : listOfModulesAndItsType) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO teacher_modules VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, teacherModule.getTeacher().getTeacherId());
            preparedStatement.setString(2, moduleAndItsType.getModule().getModuleCode());
            preparedStatement.setInt(3, moduleAndItsType.getTypeOfClass().getTypeId());
            preparedStatement.setString(4, moduleAndItsType.getIdentifier());
            
            preparedStatement.executeUpdate();
            rowsModified++;
        }

        return rowsModified;
    }

}
