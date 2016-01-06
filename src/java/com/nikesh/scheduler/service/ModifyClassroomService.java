package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.ModifyClassroomDAO;
import com.nikesh.scheduler.model.Classroom;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class ModifyClassroomService {
    
    private final ModifyClassroomDAO dao;
    
    public ModifyClassroomService() throws SQLException, ClassNotFoundException{
        dao = new ModifyClassroomDAO();
    }
    
    public int deleteClassroom(String code) throws SQLException, ClassNotFoundException{
        return dao.deleteClassroom(code);
    }
    
    public int addModifiedClassroom(Classroom room) throws SQLException, ClassNotFoundException{
        return dao.addModifiedClassroom(room);
    }
    
}
