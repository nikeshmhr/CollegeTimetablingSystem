package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.AddModuleDAO;
import com.nikesh.scheduler.model.Module;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class AddModuleService {
    
    private AddModuleDAO dao;
    
    public AddModuleService() throws SQLException, ClassNotFoundException{
        dao = new AddModuleDAO();
    }
    
    public int addModule(Module module) throws SQLException, ClassNotFoundException{
        return dao.addModule(module);
    }    
}
