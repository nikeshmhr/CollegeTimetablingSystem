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

    public AddModuleDAO() throws SQLException, ClassNotFoundException {
        connection = DatabaseTool.getConnection();
    }

    public int addModule(Module module) throws SQLException, ClassNotFoundException {
        int rowsModified = 0;

        connection = DatabaseTool.getConnection();
        
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

    public int updateModule(Module m) throws SQLException, ClassNotFoundException {
        int updatedRows = 0;
        
        connection = DatabaseTool.getConnection();
        
        PreparedStatement statement = connection.prepareStatement("UPDATE modules SET moduleName = ? WHERE moduleCode = ?");
        statement.setString(1, m.getModuleName());
        statement.setString(2, m.getModuleCode());
        
        updatedRows = statement.executeUpdate();
        
        if(updatedRows == 0){
            return 0;
        }
        
        Set<ClassType> classes = m.getTypeOfClasses();
        
        String moduleCode = m.getModuleCode();
        for(ClassType type : classes){
            int typeId = type.getTypeId();
            double classHours = type.getClassHours();
            //System.out.println("Type: " + type.getTypeName() + " " + type.getClassHours() + " " + type.getTypeId());
            connection = DatabaseTool.getConnection();
            PreparedStatement s = connection.prepareStatement("UPDATE module_classes SET classHours=? WHERE typeId=? AND moduleCode=?");
            s.setDouble(1, classHours);
            s.setInt(2, typeId);
            s.setString(3, moduleCode);
            
            updatedRows = s.executeUpdate();
            if(updatedRows == 0){
                return 0;
            }
        }
        
        /*
        for (ClassType c : classes) {
            statement = connection.prepareCall("UPDATE module_classes SET ");
            statement.setInt(1, c.getTypeId());
            statement.setString(2, m.getModuleCode());
            statement.setDouble(3, c.getClassHours());
            updatedRows = DatabaseTool.updateQuery(statement);
            if(updatedRows == 0){
                return 0;
            }
        }*/
        
        return updatedRows;
    }
}
