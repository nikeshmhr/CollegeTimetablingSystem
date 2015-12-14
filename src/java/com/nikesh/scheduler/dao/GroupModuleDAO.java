/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.model.GroupModule;
import com.nikesh.scheduler.model.ModuleAndItsType;
import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nikesh
 */
public class GroupModuleDAO {

    private static Connection connection;

    public GroupModuleDAO() throws SQLException, ClassNotFoundException {
        connection = DatabaseTool.getConnection();
    }

    public int addGroupModule(GroupModule groupModule) throws SQLException, ClassNotFoundException {
        int rowsModified = 0;

        connection = DatabaseTool.getConnection();
        List<ModuleAndItsType> listOfModules = groupModule.getListOfModulesAndItsType();
        
        for (ModuleAndItsType mAndType : listOfModules) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO group_module VALUES(?, ?, ?)");
            String groupCode = groupModule.getGroup().getGroupCode();
            String moduleCode = mAndType.getModule().getModuleCode();
            String identifier = mAndType.getIdentifier();
            
            System.out.println(groupCode + ", " + moduleCode + ", " + identifier);

            statement.setString(1, groupCode);
            statement.setString(2, moduleCode);
            statement.setString(3, identifier);

            rowsModified = statement.executeUpdate();
        }

        return rowsModified;
    }
    
    public int deleteGroupModule(String identifier) throws SQLException, ClassNotFoundException {
        int rowsDeleted = 0;
        
        connection = DatabaseTool.getConnection();
        PreparedStatement st = connection.prepareStatement("DELETE FROM group_module WHERE identifier=?");
        st.setString(1, identifier);
        
        rowsDeleted = st.executeUpdate();
        
        return rowsDeleted;
    }

}
