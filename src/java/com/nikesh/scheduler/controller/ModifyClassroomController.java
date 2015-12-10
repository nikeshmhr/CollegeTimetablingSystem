package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.factory.ClassTypeFactory;
import com.nikesh.scheduler.model.Classroom;
import com.nikesh.scheduler.service.ModifyClassroomService;
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
public class ModifyClassroomController extends HttpServlet {

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
        
        RequestDispatcher dispatch = request.getRequestDispatcher("editClassrooms.jsp");
        
        String action = request.getParameter("action");
        String roomCode = "";
        
        ModifyClassroomService service = new ModifyClassroomService();
        
        if(action.equalsIgnoreCase("update")){
            try {
                roomCode = request.getParameter("roomCode");
                String roomName = request.getParameter("classroomName");
                ClassType type = ClassTypeFactory.getClassType(request.getParameter("typeOfClassroom"));
                int capacity = Integer.parseInt(request.getParameter("classroomCapacity"));
                
                System.out.println(roomCode + " " + roomName + " " + type.getTypeName() + " " + capacity);
                
                Classroom room = new Classroom(roomCode, roomName, type, capacity);
                
                service.addModifiedClassroom(room);
                
                request.setAttribute("message", "Classroom: " + roomCode + " updated successfully");
            } catch (SQLException ex) {
                request.setAttribute("message", ex.getMessage());
            } finally {
                dispatch.forward(request, response);
            }
        }else if(action.equalsIgnoreCase("delete")){
            roomCode = request.getParameter("id");
            try {
                service.deleteClassroom(roomCode);
                request.setAttribute("message", "Classroom: " + roomCode + " deleted successfully");
            } catch (SQLException ex) {
                request.setAttribute("message", ex.getMessage());
            }finally{
                dispatch.forward(request, response);
            }
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
