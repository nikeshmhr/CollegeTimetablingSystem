package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.factory.ClassTypeFactory;
import com.nikesh.scheduler.model.Classroom;
import com.nikesh.scheduler.service.AddClassroomService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikesh
 */
public class AddClassroomController extends HttpServlet {

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

        RequestDispatcher dispatch = request.getRequestDispatcher("addClassrooms.jsp");

        Classroom classRoom = getClassroomFormData(request, response);

        AddClassroomService service;
        try {
            service = new AddClassroomService();

            try {
                int rowsModified = service.addClassroom(classRoom);
                if (rowsModified > 0) {
                    request.setAttribute("message", "Classroom: " + classRoom.getRoomName() + " added successfully.");
                    request.setAttribute("status", "200");
                } else {
                    request.setAttribute("message", "Classroom was not added due to internal error.");
                }
            } catch (SQLException ex) {
                if (ex.toString().contains("Duplicate")) {
                    if (ex.toString().contains("PRIMARY")) {
                        //System.out.println("PRIMARY KEY");
                        request.setAttribute("message", "Classroom with same ID already exists.");
                    } else {
                        //System.out.println("DUPLICATE NAME");
                        request.setAttribute("message", "Classroom with same name already exists.");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private Classroom getClassroomFormData(HttpServletRequest req, HttpServletResponse res) {
        String roomCode = req.getParameter("classroomCode");
        String roomName = req.getParameter("classroomName");
        ClassType type = ClassTypeFactory.getClassType(req.getParameter("typeOfClassroom"));
        int capacity = Integer.parseInt(req.getParameter("classroomCapacity"));

        return new Classroom(roomCode, roomName, type, capacity);
    }

}
