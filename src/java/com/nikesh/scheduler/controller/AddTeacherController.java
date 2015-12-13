package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.model.Teacher;
import com.nikesh.scheduler.service.AddTeacherServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikesh
 */
public class AddTeacherController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        RequestDispatcher dispatch = request.getRequestDispatcher("addTeachers.jsp");

        /**
         * Extract value from form and convert it into objects, so that we can
         * pass it to the tools that inserts those data into database *
         */
        Set<Teacher> teachers = getTeachers(request, response);

        AddTeacherServices service = new AddTeacherServices();
        try {
            boolean isInserted = service.addTeachers(teachers);
            if (isInserted) {
                request.setAttribute("message", "Teacher(s) added successfully.");
                request.setAttribute("status", "200");
            }
        } catch (SQLException ex) {
            //System.err.println("Exception: " + ex.getMessage());
            if (ex.toString().contains("Duplicate")) {
                if (ex.toString().contains("PRIMARY")) {
                    //System.out.println("PRIMARY KEY");
                    request.setAttribute("message", "Teacher with same ID already exists.");
                }
            } else {
                request.setAttribute("message", ex.getMessage());
            }
        } finally {
            dispatch.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Set<Teacher> getTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * Data from form *
         */
        String[] teachers = (request.getParameter("teacherName")).split(",");
        String[] ids = (request.getParameter("teacherId")).split(",");
        
        if(teachers.length != ids.length){
            request.setAttribute("message", "No. of names doesn't match no. of ids.");
            request.getRequestDispatcher("addTeachers.jsp").forward(request, response);
        }

        /**
         * Data to object *
         */
        Set<Teacher> setOfTeachers = new HashSet<Teacher>();

        for (int i = 0; i < teachers.length; i++) {
            Teacher t = new Teacher(ids[i], teachers[i]);
            if (!setOfTeachers.contains(t)) {
                setOfTeachers.add(t);
            }
        }
        System.out.println(setOfTeachers);
        return setOfTeachers;
    }

}
