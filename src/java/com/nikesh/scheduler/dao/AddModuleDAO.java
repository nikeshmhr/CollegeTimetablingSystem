package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.model.Module;
import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author Nikesh
 */
public class AddModuleDAO {

    private static Connection connection;

    public AddModuleDAO() {
        connection = DatabaseTool.getConnection();
    }

    public int addModule(Module module) throws SQLException {
        int rowsModified = 0;

        PreparedStatement statement = connection.prepareCall("INSERT INTO modules VALUES(?, ?)");
        statement.setString(1, module.getModuleCode());
        statement.setString(2, module.getModuleName());

        rowsModified = DatabaseTool.updateQuery(statement);

        if(rowsModified == 0){
            return 0;
        }
        
        Set<ClassType> classes = module.getTypeOfClasses();
        for (ClassType c : classes) {
            statement = connection.prepareCall("INSERT INTO module_classes VALUES(?, ?, ?)");
            statement.setInt(1, c.getTypeId());
            statement.setString(2, module.getModuleCode());
            statement.setDouble(3, c.getClassHours());
            rowsModified = DatabaseTool.updateQuery(statement);
            if(rowsModified == 0){
                return 0;
            }
        }

        return rowsModified;
    }
}