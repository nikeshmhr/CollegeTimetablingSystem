package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.model.Module;
import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class ModifyModuleDAO {
    
    private static Connection connection;
    
    public ModifyModuleDAO() throws SQLException, ClassNotFoundException{
        connection = DatabaseTool.getConnection();
    }
    
    public int deleteModule(String moduleId) throws SQLException, ClassNotFoundException{
        connection = DatabaseTool.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM modules WHERE moduleCode=?");
        statement.setString(1, moduleId);
        return DatabaseTool.updateQuery(statement);
    }
    
    /*public int addModifiedModule(Module module) throws SQLException{
        PreparedStatement statement = connection.prepareStatement("UPDATE modules SET moduleName=? WHERE moduleCode=?");
        statement.setString(1, module.getModuleName());
        statement.setString(2, module.getModuleCode());
        
        return DatabaseTool.updateQuery(statement);
    }*/
    
}
