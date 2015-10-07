package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.ModifyClassroomDAO;
import com.nikesh.scheduler.model.Classroom;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class ModifyClassroomService {
    
    private ModifyClassroomDAO dao;
    
    public ModifyClassroomService(){
        dao = new ModifyClassroomDAO();
    }
    
    public int deleteClassroom(String code) throws SQLException{
        return dao.deleteClassroom(code);
    }
    
    public int addModifiedClassroom(Classroom room) throws SQLException{
        return dao.addModifiedClassroom(room);
    }
    
}
