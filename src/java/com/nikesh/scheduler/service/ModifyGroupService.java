package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.ModifyGroupDAO;
import com.nikesh.scheduler.model.Group;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class ModifyGroupService {
    
    private ModifyGroupDAO dao;
    
    public ModifyGroupService() throws SQLException, ClassNotFoundException{
        dao = new ModifyGroupDAO();
    }
    
    public int deleteGroup(String groupCode) throws SQLException, ClassNotFoundException{
        return dao.deleteGroup(groupCode);
    }
    
    public int addModifiedGroup(Group g) throws SQLException, ClassNotFoundException{
        return dao.addModifiedGroup(g);
    }
    
}
