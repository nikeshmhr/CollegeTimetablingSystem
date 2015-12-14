package com.nikesh.scheduler.controller;

import com.nikesh.scheduler.service.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nikesh
 */
public class LoginController extends HttpServlet {

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

        String u = request.getParameter("username");
        String p = request.getParameter("password");

        LoginService service = null;
        try {
            service = new LoginService();
            try {
                if (service.validate(u, p)) { // if username and password is correct.
                    /**
                     * Setting session *
                     */
                    HttpSession session = request.getSession();
                    session.setAttribute("user", u);
                    session.setMaxInactiveInterval(24 * 60 * 60);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                } else { // if incorrect add message and forward request and response to the index.jsp page.
                    request.setAttribute("message", "Username or password incorrect.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                request.setAttribute("message", "Login failed. ");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ClassNotFoundException ex) {
                request.setAttribute("message", "Login failed due to internal error.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("message", "Could not login beacause of closed communication link. (DATABASE SERVER MIGHT NOT BE UP)");
            request.getRequestDispatcher("includes/footer.html").forward(request, response);
        } catch (ClassNotFoundException ex) {
            request.setAttribute("message", "Login failed due to internal error.");
            request.getRequestDispatcher("includes/footer.html").forward(request, response);
            System.out.println("INTERNAL SERVER ERROR");
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
