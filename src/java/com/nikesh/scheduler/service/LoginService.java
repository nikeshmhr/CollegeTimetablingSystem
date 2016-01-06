package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.LoginDAO;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class LoginService {
    
    private final LoginDAO dao;
    
    public LoginService() throws SQLException, ClassNotFoundException{
        dao = new LoginDAO();
    }
    
    public boolean validate(String username, String password) throws SQLException, ClassNotFoundException {
        return dao.validate(username, password);
    }
    
}
