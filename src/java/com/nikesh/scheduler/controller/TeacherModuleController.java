package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.dao.TeacherModuleDAO;
import com.nikesh.scheduler.factory.ClassTypeFactory;
import com.nikesh.scheduler.model.Module;
import com.nikesh.scheduler.model.ModuleAndItsType;
import com.nikesh.scheduler.model.Teacher;
import com.nikesh.scheduler.model.TeacherModule;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikesh
 */
public class TeacherModuleController extends HttpServlet {

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

        String teacherId = request.getParameter("teacherId");
        String[] modules = request.getParameterValues("moduleId");

        ArrayList<String> modulesAsList = new ArrayList<String>(Arrays.asList(modules));
        /*
         List<String> selectedClassList = new ArrayList<String>();
        
         for (String module : modules) {
         selectedClassList.add(module);
         out.println(module);
         }*/
        TeacherModule teacherModule = new TeacherModule();
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        teacherModule.setTeacher(teacher);
        System.out.println("Teacher ID: " + teacher.getTeacherId());
        for (int i = 0; i < modules.length; i++) {

            /**
             * Making object of each module and its class type available from
             * array *
             */
            ModuleAndItsType moduleAndItsType = new ModuleAndItsType();

            /**
             * Splitting the module code and class type *
             */
            String[] split = modules[i].split("_");

            String moduleCode = split[0];   // first parameter is a module code
            int classTypeId = Integer.parseInt(split[1]);   // second parameter is a classtype id

            ClassType classType = ClassTypeFactory.getClassType(classTypeId);   // creating classtype from the second parameter (classtypeid)

            /**
             * Creating module object from the first parameter (moduleCode) *
             */
            Module module = new Module();
            module.setModuleCode(moduleCode);

            moduleAndItsType.setModule(module);
            moduleAndItsType.setIdentifier(modules[i]);
            moduleAndItsType.setTypeOfClass(classType);

            /**
             * Adding moduleanditstype object to the teachermodule (in
             * listofmodulesanditstype arraylist) object *
             */
            teacherModule.getListOfModulesAndItsType().add(moduleAndItsType);
        }

        TeacherModuleDAO teacherModuleDAO = new TeacherModuleDAO();
        try {
            int rowsModified = teacherModuleDAO.addTeacherModule(teacherModule);

            request.setAttribute("message", "Relation created sucessfully.");

        } catch (SQLException ex) {
            request.setAttribute("message", ex.getMessage());
        } finally {
            request.getRequestDispatcher("/teacherModule.jsp").forward(request, response);
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
