/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.AddTeacherDAO;
import com.nikesh.scheduler.model.Teacher;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author Nikesh
 */
public class AddTeacherServices {
    
    private AddTeacherDAO dao;
    
    public AddTeacherServices() throws SQLException, ClassNotFoundException{
        dao = new AddTeacherDAO();
    }
    
    public boolean addTeachers(Set<Teacher> teachers) throws SQLException, ClassNotFoundException{
        return dao.addTeachers(teachers);
    }
    
}
