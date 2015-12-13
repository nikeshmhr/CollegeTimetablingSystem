/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.dao.GroupModuleDAO;
import com.nikesh.scheduler.dao.RetrieveResources;
import com.nikesh.scheduler.model.Group;
import com.nikesh.scheduler.model.GroupModule;
import com.nikesh.scheduler.model.Module;
import com.nikesh.scheduler.model.ModuleAndItsType;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
public class GroupModuleController extends HttpServlet {

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

        String groupCode = request.getParameter("groupCode");
        String[] moduleIds = request.getParameterValues("moduleId");

        out.println(groupCode + "<br/>" + Arrays.toString(moduleIds));

        ArrayList<String> modulesAsList = new ArrayList<String>(Arrays.asList(moduleIds));

        out.println(groupCode + "<br/>");
        out.println(modulesAsList);

        GroupModuleDAO groupModuleDAO = new GroupModuleDAO();

        List<ModuleAndItsType> listOfM = new ArrayList<ModuleAndItsType>();
        GroupModule groupModule = new GroupModule();

        Group g = new Group();
        g.setGroupCode(groupCode);
        
        groupModule.setGroup(g);

        for (String module : modulesAsList) {

            Module m = new Module();
            ModuleAndItsType moduleAndItsType = new ModuleAndItsType();
            m.setModuleCode(module);
            try {
                m.setModuleName(RetrieveResources.getModuleName(module));
            } catch (SQLException ex) {
                Logger.getLogger(GroupModuleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            moduleAndItsType.setModule(m);
            moduleAndItsType.setIdentifier(g.getGroupCode() + m.getModuleCode());

            listOfM.add(moduleAndItsType);
        }
        groupModule.setListOfModulesAndItsType(listOfM);
        try {
            groupModuleDAO.addGroupModule(groupModule);
            request.setAttribute("message", "Relation created successfully.");
            request.setAttribute("status", "200");
        } catch (SQLException ex) {
            if (ex.toString().contains("Duplicate")) {
                if (ex.toString().contains("PRIMARY")) {
                    //System.out.println("PRIMARY KEY");
                    request.setAttribute("message", "Relation already exists.");
                }
            } else {
                request.setAttribute("message", ex.getMessage());
            }            
        }
        request.getRequestDispatcher("/groupModule.jsp").forward(request, response);
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
