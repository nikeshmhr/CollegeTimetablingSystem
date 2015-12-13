package com.nikesh.scheduler.dao;

import com.nikesh.scheduler.util.DatabaseTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nikesh
 */
public class LoginDAO {

    private static Connection connection;

    public LoginDAO() {
        connection = DatabaseTool.getConnection();
    }

    public boolean validate(String username, String password) throws SQLException {
        boolean status = false;
        PreparedStatement st = connection.prepareStatement("SELECT * FROM login_info WHERE username=? AND password=MD5(?)");
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs = DatabaseTool.executeQuery(st);
        while (rs.next()) {
            status = true;
        }
        return status;
    }
}
