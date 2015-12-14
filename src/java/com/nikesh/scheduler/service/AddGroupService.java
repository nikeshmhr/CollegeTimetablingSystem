package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.AddGroupDAO;
import com.nikesh.scheduler.model.Group;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class AddGroupService {
    
    private AddGroupDAO dao;
    
    public AddGroupService() throws SQLException, ClassNotFoundException{
        dao = new AddGroupDAO();
    }
    
    public int addGroup(Group group) throws SQLException, ClassNotFoundException{
        return dao.addGroup(group);
    }
    
}
