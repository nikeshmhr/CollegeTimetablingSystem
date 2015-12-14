package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.AddClassroomDAO;
import com.nikesh.scheduler.model.Classroom;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class AddClassroomService {
    
    private AddClassroomDAO dao;
    
    public AddClassroomService() throws SQLException, ClassNotFoundException{
        dao = new AddClassroomDAO();
    }
    
    public int addClassroom(Classroom room) throws SQLException, ClassNotFoundException{
        return dao.addClassroom(room);
    }
    
}
