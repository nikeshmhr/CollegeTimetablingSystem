package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.model.Module;
import com.nikesh.scheduler.model.concrete.Lab;
import com.nikesh.scheduler.model.concrete.Lecture;
import com.nikesh.scheduler.model.concrete.Tutorial;
import com.nikesh.scheduler.model.concrete.Workshop;
import com.nikesh.scheduler.service.AddModuleService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikesh
 */
public class AddModuleController extends HttpServlet {

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

        String dispatchLink = "";
        String operation = request.getParameter("operation");

        if (operation.equalsIgnoreCase("update")) {
            dispatchLink = "editModule.jsp";
        } else {
            dispatchLink = "addModule.jsp";
        }

        Module m = getModuleParam(request, response);

        /**
         * Service class for add module functionality *
         */
        AddModuleService service = new AddModuleService();

        int modifiedRows = 0;
        try {
            if (!operation.equalsIgnoreCase("update")) {
                modifiedRows = service.addModule(m);
                if (modifiedRows > 0) {
                    request.setAttribute("addMessage", "Module: " + m.getModuleName() + " added successfully.");
                } else {
                    request.setAttribute("addMessage", "Module: " + m.getModuleName() + " was not added due to internal error.");
                }
            } else if (operation.equalsIgnoreCase("update")) {
                modifiedRows = service.updateModule(m);
                if(modifiedRows > 0){
                    request.setAttribute("message", "Module updated successfully.");
                }else{
                    request.setAttribute("message", "Module was not updated.");
                }
            }
            request.getRequestDispatcher(dispatchLink).forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("addMessage", "Exception: " + ex.getMessage());
            request.getRequestDispatcher(dispatchLink).forward(request, response);
        }
        //out.println(modifiedRows);
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

    private Module getModuleParam(HttpServletRequest request, HttpServletResponse response) {
        Module m = new Module();
        m.setModuleCode(request.getParameter("moduleCode"));
        m.setModuleName(request.getParameter("moduleName"));

        DecimalFormat dfm = new DecimalFormat("#.##");

        String[] typesOfClasses = request.getParameterValues("typesOfClasses");
        for (String type : typesOfClasses) {
            int classTypeInt = Integer.parseInt(type);

            ClassType classType = null;

            double hours = 0;

            switch (classTypeInt) {
                case 1: // lecture
                    hours = Double.parseDouble(request.getParameter("lectureHours"));
                    hours = Double.parseDouble(dfm.format(hours));
                    classType = new Lecture(hours);
                    break;

                case 2: // tutorial
                    hours = Double.parseDouble(request.getParameter("tutorialHours"));
                    hours = Double.parseDouble(dfm.format(hours));
                    classType = new Tutorial(hours);
                    break;

                case 3: // lab
                    hours = Double.parseDouble(request.getParameter("labHours"));
                    hours = Double.parseDouble(dfm.format(hours));
                    classType = new Lab(hours);
                    break;

                case 4: // workshop
                    hours = Double.parseDouble(request.getParameter("workshopHours"));
                    hours = Double.parseDouble(dfm.format(hours));
                    classType = new Workshop(hours);
                    break;
            }
            m.getTypeOfClasses().add(classType);
        }
        /*out.println(m.getTypeOfClasses());
         out.println("<br/>");*/
        return m;
    }

}
