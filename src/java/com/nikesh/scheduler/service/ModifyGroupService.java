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
    
    public ModifyGroupService(){
        dao = new ModifyGroupDAO();
    }
    
    public int deleteGroup(String groupCode) throws SQLException{
        return dao.deleteGroup(groupCode);
    }
    
    public int addModifiedGroup(Group g) throws SQLException{
        return dao.addModifiedGroup(g);
    }
    
}
