package com.nikesh.scheduler.service;

import com.nikesh.scheduler.dao.LoginDAO;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class LoginService {
    
    private LoginDAO dao;
    
    public LoginService(){
        dao = new LoginDAO();
    }
    
    public boolean validate(String username, String password) throws SQLException {
        return dao.validate(username, password);
    }
    
}
