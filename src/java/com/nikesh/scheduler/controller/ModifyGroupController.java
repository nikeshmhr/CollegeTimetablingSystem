package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.model.Group;
import com.nikesh.scheduler.service.ModifyGroupService;
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
public class ModifyGroupController extends HttpServlet {

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

        RequestDispatcher dispatch = request.getRequestDispatcher("editGroups.jsp");

        String groupCode = "";

        ModifyGroupService service;
        try {
            service = new ModifyGroupService();

            String action = request.getParameter("action");

            if (action.equalsIgnoreCase("update")) {
                try {
                    groupCode = request.getParameter("groupCode");
                    int noOfStudents = Integer.parseInt(request.getParameter("noOfStudents"));

                    Group g = new Group(groupCode, noOfStudents);

                    service.addModifiedGroup(g);
                    request.setAttribute("message", "Group: " + groupCode + " updated successfully.");
                    request.setAttribute("status", "200");
                } catch (SQLException ex) {
                    request.setAttribute("message", ex.getMessage());
                }
            } else if (action.equalsIgnoreCase("delete")) {
                groupCode = request.getParameter("id");
                try {
                    service.deleteGroup(groupCode);
                    request.setAttribute("message", "Group: " + groupCode + " deleted successfully.");
                    request.setAttribute("status", "200");
                } catch (SQLException ex) {
                    request.setAttribute("message", ex.getMessage());
                }
            }

            dispatch.forward(request, response);
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
