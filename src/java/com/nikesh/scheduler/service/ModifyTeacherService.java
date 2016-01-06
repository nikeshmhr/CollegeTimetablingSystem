package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.ModifyTeacherDAO;
import com.nikesh.scheduler.model.Teacher;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class ModifyTeacherService {
    
    private final ModifyTeacherDAO dao;
    
    public ModifyTeacherService() throws SQLException, ClassNotFoundException{
        dao = new ModifyTeacherDAO();
    }
    
    public int deleteTeacher(String teacherId) throws SQLException, ClassNotFoundException{
        return dao.deleteTeacher(teacherId);
    }
    
    public int addModifiedTeacher(Teacher teacher) throws SQLException, ClassNotFoundException{
        return dao.addModifiedTeacher(teacher);
    }
    
}
