package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.ModifyTeacherDAO;
import com.nikesh.scheduler.model.Teacher;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class ModifyTeacherService {
    
    private ModifyTeacherDAO dao;
    
    public ModifyTeacherService(){
        dao = new ModifyTeacherDAO();
    }
    
    public int deleteTeacher(String teacherId) throws SQLException{
        return dao.deleteTeacher(teacherId);
    }
    
    public int addModifiedTeacher(Teacher teacher) throws SQLException{
        return dao.addModifiedTeacher(teacher);
    }
    
}
