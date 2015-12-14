package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.ModifyModuleDAO;
import com.nikesh.scheduler.model.Module;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class ModifyModuleService {
    
    private ModifyModuleDAO dao;
    
    public ModifyModuleService() throws SQLException, ClassNotFoundException{
        dao = new ModifyModuleDAO();
    }
    
    public int deleteModule(String moduleCode) throws SQLException, ClassNotFoundException{
        return dao.deleteModule(moduleCode);
    }
    
    /*public int addModifiedModule(Module module) throws SQLException{
        return dao.addModifiedModule(module);
    }*/
    
}
