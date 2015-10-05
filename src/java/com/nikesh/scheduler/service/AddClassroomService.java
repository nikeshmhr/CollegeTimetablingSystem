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
    
    public AddClassroomService(){
        dao = new AddClassroomDAO();
    }
    
    public int addClassroom(Classroom room) throws SQLException{
        return dao.addClassroom(room);
    }
    
}
