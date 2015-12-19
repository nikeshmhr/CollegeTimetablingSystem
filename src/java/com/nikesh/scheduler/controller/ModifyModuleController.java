package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.model.Module;
import com.nikesh.scheduler.model.concrete.Lab;
import com.nikesh.scheduler.model.concrete.Lecture;
import com.nikesh.scheduler.model.concrete.Tutorial;
import com.nikesh.scheduler.model.concrete.Workshop;
import com.nikesh.scheduler.service.ModifyModuleService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
public class ModifyModuleController extends HttpServlet {

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
        RequestDispatcher dispatch = request.getRequestDispatcher("editModules.jsp");

        String action = request.getParameter("action");
        String moduleCode = request.getParameter("id");

        ModifyModuleService service;
        try {
            service = new ModifyModuleService();

            if (action.equalsIgnoreCase("delete")) {
                try {
                    service.deleteModule(moduleCode);
                    request.setAttribute("message", "Module: " + moduleCode + " deleted successfully.");
                    request.setAttribute("status", "200");
                } catch (SQLException ex) {
                    request.setAttribute("message", ex.getMessage());
                } finally {
                    dispatch.forward(request, response);
                }
            } else if (action.equalsIgnoreCase("update")) {
                try {
                    int modifiedRows = 0;
                    Module m = getModuleParamUpdate(request, response);
                    modifiedRows = service.addModifiedModule(m);
                    if (modifiedRows > 0) {
                        request.setAttribute("message", "Module updated successfully.");
                        request.setAttribute("status", "200");
                    } else {
                        request.setAttribute("message", "Module was not updated.");
                    }
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private Module getModuleParamUpdate(HttpServletRequest request, HttpServletResponse response) {
        Module m = new Module();
        m.setModuleCode(request.getParameter("moduleCode"));
        m.setModuleName(request.getParameter("moduleName"));

        ArrayList<String> typesOfClasses = new ArrayList<String>();

        if (request.getParameter("lectureHours") != null) {
            typesOfClasses.add("1");
        }
        if (request.getParameter("tutorialHours") != null) {
            typesOfClasses.add("2");
        }
        if (request.getParameter("labHours") != null) {
            typesOfClasses.add("3");
        }
        if (request.getParameter("workshopHours") != null) {
            typesOfClasses.add("4");
        }

        //System.out.println("PARAMETER EXISTS: "+ request.getParameter("testParameter"));
        for (String type : typesOfClasses) {    // 4 possible types of class
            ClassType classType = extractClassType(type, request, response);
            m.getTypeOfClasses().add(classType);
        }
        return m;
    }

    private ClassType extractClassType(String type, HttpServletRequest request, HttpServletResponse response) {
        int classTypeInt = Integer.parseInt(type);

        DecimalFormat dfm = new DecimalFormat("#.##");

        ClassType classType = null;

        double hours = 0;

        switch (classTypeInt) {
            case 1: // lecture
                hours = Double.parseDouble(request.getParameter("lectureHours"));
                System.out.println("LEC: " + hours);
                hours = Double.parseDouble(dfm.format(hours));
                classType = new Lecture(hours);
                break;

            case 2: // tutorial
                hours = Double.parseDouble(request.getParameter("tutorialHours"));
                System.out.println("TUT: " + hours);
                hours = Double.parseDouble(dfm.format(hours));
                classType = new Tutorial(hours);
                break;

            case 3: // lab
                hours = Double.parseDouble(request.getParameter("labHours"));
                System.out.println("LAB: " + hours);
                hours = Double.parseDouble(dfm.format(hours));
                classType = new Lab(hours);
                break;

            case 4: // workshop
                hours = Double.parseDouble(request.getParameter("workshopHours"));
                System.out.println("WORK: " + hours);
                hours = Double.parseDouble(dfm.format(hours));
                classType = new Workshop(hours);
                break;
        }
        //System.out.println("HOURS TEST: " + hours);
        return classType;
    }

}
