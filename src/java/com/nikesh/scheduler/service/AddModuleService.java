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
    
    public AddModuleService(){
        dao = new AddModuleDAO();
    }
    
    public int addModule(Module module) throws SQLException{
        return dao.addModule(module);
    }

    public int updateModule(Module m) throws SQLException {
        return dao.updateModule(m);
    }
    
}
