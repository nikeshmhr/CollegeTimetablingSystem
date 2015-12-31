package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.model.Teacher;
import com.nikesh.scheduler.service.ModifyTeacherService;
import java.io.IOException;
import java.sql.SQLException;
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
public class ModifyTeacherController extends HttpServlet {

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
        RequestDispatcher dispatch = request.getRequestDispatcher("editTeachers.jsp");

        String action = request.getParameter("action");

        String teacherId = "";

        ModifyTeacherService service;
        try {
            service = new ModifyTeacherService();

            if (action.equalsIgnoreCase("delete")) {
                teacherId = request.getParameter("id");
                try {
                    if (service.deleteTeacher(teacherId) > 0) {
                        request.setAttribute("message", "Teacher: " + teacherId + " deleted successfully.");
                        request.setAttribute("status", "200");
                    }else{
                        request.setAttribute("message", "Could not delete.");
                    }

                } catch (SQLException ex) {
                    request.setAttribute("message", ex.getMessage());
                } finally {
                    dispatch.forward(request, response);
                }
            } else if (action.equalsIgnoreCase("update")) {
                teacherId = request.getParameter("teacherId");
                try {
                    Teacher t = new Teacher(teacherId, request.getParameter("teacherName"));
                    service.addModifiedTeacher(t);
                    request.setAttribute("message", "Teacher: " + teacherId + " modified successfully.");
                    request.setAttribute("status", "200");
                } catch (SQLException ex) {
                    request.setAttribute("message", ex.getMessage());
                } finally {
                    dispatch.forward(request, response);
                }
            }
        } catch (SQLException ex) {
            request.setAttribute("message", ex.getMessage());
            dispatch.forward(request, response);
        } catch (ClassNotFoundException ex) {
            request.setAttribute("message", ex.getMessage());
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

}
