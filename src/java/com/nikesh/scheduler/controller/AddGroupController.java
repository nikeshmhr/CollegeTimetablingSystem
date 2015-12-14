package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.model.Group;
import com.nikesh.scheduler.service.AddGroupService;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AddGroupController extends HttpServlet {

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

        RequestDispatcher dispatch = request.getRequestDispatcher("addGroups.jsp");

        Group group = getGroupFormData(request, response);

        AddGroupService service;
        try {
            service = new AddGroupService();

            try {
                int rowsModified = service.addGroup(group);
                if (rowsModified > 0) {
                    request.setAttribute("message", "Group: " + group.getGroupCode() + " added successfully.");
                    request.setAttribute("status", "200");
                }
            } catch (SQLException ex) {
                if (ex.toString().contains("Duplicate")) {
                    if (ex.toString().contains("PRIMARY")) {
                        //System.out.println("PRIMARY KEY");
                        request.setAttribute("message", "Group with same ID already exists.");
                    }
                } else {
                    request.setAttribute("message", ex.getMessage());
                }
            } finally {
                dispatch.forward(request, response);
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

    private Group getGroupFormData(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("groupCode");
        int noOfStudents = Integer.parseInt(request.getParameter("noOfStudents"));

        return new Group(code, noOfStudents);
    }

}
