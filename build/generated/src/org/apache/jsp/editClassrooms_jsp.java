package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nikesh.scheduler.dao.RetrieveResources;
import java.util.List;
import com.nikesh.scheduler.model.Classroom;
import java.io.IOException;

public final class editClassrooms_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    void sessionCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
        /**
         * CHECK IF SESSION EXISTS *
         */
        HttpSession session = request.getSession(false);
        String user = (String) session.getAttribute("user");
        if (user == null || user.equals("")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            //out.println(user);
        }
    }

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/includes/headerInclude.html");
    _jspx_dependants.add("/includes/functions.jsp");
    _jspx_dependants.add("/includes/navigation.html");
    _jspx_dependants.add("/includes/footer.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"styles/main.css\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/clock-icon.ico\" />");
      out.write("\n");
      out.write("        <title>Edit Classrooms</title>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#editResource\").addClass(\"active\");\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
      out.write('\n');
      out.write("\n");
      out.write("        ");

            sessionCheck(request, response);
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      out.write("\r\n");
      out.write("<div class=\"navbar navbar-inverse\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <button type=\"button\" \r\n");
      out.write("                    class=\"navbar-toggle\"\r\n");
      out.write("                    data-toggle=\"collapse\" \r\n");
      out.write("                    data-target=\"#mynavbar-content\">\r\n");
      out.write("                <span  class=\"icon-bar\"></span>\r\n");
      out.write("                <span  class=\"icon-bar\"></span>\r\n");
      out.write("                <span  class=\"icon-bar\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"home.jsp\" title=\"Home\"><span class=\"glyphicon glyphicon-home\"></span></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"mynavbar-content\">\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("                <li class=\"dropdown\" id=\"addResource\">\r\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Add Resources<span class=\"caret\"></span></a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"addModules.jsp\">Add Modules</a></li>\r\n");
      out.write("                        <li><a href=\"addTeachers.jsp\">Add Teachers</a></li>\r\n");
      out.write("                        <li><a href=\"addClassrooms.jsp\">Add Classrooms</a></li>\r\n");
      out.write("                        <li><a href=\"addGroups.jsp\">Add Groups</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"dropdown\" id=\"editResource\">\r\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Modify Resources<span class=\"caret\"></span></a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"editModules.jsp\">Modify Modules</a></li>\r\n");
      out.write("                        <li><a href=\"editTeachers.jsp\">Modify Teachers</a></li>\r\n");
      out.write("                        <li><a href=\"editClassrooms.jsp\">Modify Classrooms</a></li>\r\n");
      out.write("                        <li><a href=\"editGroups.jsp\">Modify Groups</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"dropdown\" id=\"addRelation\">\r\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Add Relation<span class=\"caret\"></span></a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"teacherModule.jsp\">Teacher-Module</a></li>\r\n");
      out.write("                        <li><a href=\"groupModule.jsp\">Group-Module</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\"><li><a href=\"LogoutController\" id=\"logout\">Logout</a></li></ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>");
      out.write("\n");
      out.write("\n");
      out.write("            <span \n");
      out.write("                ");
 if (request.getAttribute("message") != null) {
                        out.println("class=\"label label-danger\"");
                    }
      out.write(" >\n");
      out.write("                ");

                    if (request.getAttribute("message") == null) {
                        out.println("");
                    } else {
                        out.println(request.getAttribute("message"));
                    }
                
      out.write("\n");
      out.write("            </span>\n");
      out.write("\n");
      out.write("            <table class=\"table table-striped\">\n");
      out.write("                <h2 class=\"text-primary\" style=\"text-align: center\">Edit Classrooms</h2>\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Room Code</th>\n");
      out.write("                        <th>Name</th>\n");
      out.write("                        <th>Room Type</th>\n");
      out.write("                        <th>Capacity</th>\n");
      out.write("                        <th>Action</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        List<Classroom> classrooms = RetrieveResources.getClassrooms();
                        for (Classroom c : classrooms) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( (c.getRoomCode()));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( (c.getRoomName()));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( (c.getRoomType().getTypeName()));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( (c.getCapacity()));
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <a href=\"#");
      out.print( (c.getRoomCode()));
      out.write("\" data-toggle=\"modal\"><span class=\"glyphicon glyphicon-edit\" title=\"Edit\"></span></a> \n");
      out.write("                            | \n");
      out.write("                            <a href=\"ModifyClassroomController?action=delete&id=");
      out.print( (c.getRoomCode()));
      out.write("\"><span class=\"glyphicon glyphicon-remove\" title=\"Delete\"></span></a>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                <div class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" id=\"");
      out.print( (c.getRoomCode()));
      out.write("\">\n");
      out.write("                    <div class=\"modal-dialog\">\n");
      out.write("                        <div class=\"modal-content\">\n");
      out.write("                            <form action=\"ModifyClassroomController\" method=\"post\">\n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                                    <h4 class=\"modal-title\">Edit Classroom</h4>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"classroomId\">Room Code</label>\n");
      out.write("                                        <input type=\"text\" name=\"roomCode\" id=\"classroomCode\" disabled=\"true\" class=\"form-control\" maxlength=\"10\" value=\"");
      out.print( (c.getRoomCode()));
      out.write("\" />");
      out.print( (c.getRoomCode()));
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"classroomName\">Module Name</label>\n");
      out.write("                                        <input type=\"text\" name=\"classroomName\" id=\"classroomName\" class=\"form-control\" maxlength=\"50\" value=\"");
      out.print( (c.getRoomName()));
      out.write("\" required />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"typeOfClassroom\">Type of classroom</label>\n");
      out.write("                                        <div class=\"radio\">\n");
      out.write("                                            <label><input class=\"radio-inline\" type=\"radio\" name=\"typeOfClassroom\" value=\"Lecture\" ");
 if(c.getRoomType().getTypeName().equalsIgnoreCase("lecture")) out.print("checked"); 
      out.write("> Lecture</label>\n");
      out.write("                                            <label><input class=\"radio-inline\" type=\"radio\" name=\"typeOfClassroom\" value=\"Tutorial\" ");
 if(c.getRoomType().getTypeName().equalsIgnoreCase("tutorial")) out.print("checked"); 
      out.write("> Tutorial</label>\n");
      out.write("                                            <label><input class=\"radio-inline\" type=\"radio\" name=\"typeOfClassroom\" value=\"Lab\" ");
 if(c.getRoomType().getTypeName().equalsIgnoreCase("lab")) out.print("checked"); 
      out.write("> Lab</label>\n");
      out.write("                                            <label><input class=\"radio-inline\" type=\"radio\" name=\"typeOfClassroom\" value=\"Workshop\" ");
 if(c.getRoomType().getTypeName().equalsIgnoreCase("workshop")) out.print("checked"); 
      out.write("> Workshop</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"classroomCapacity\">Capacity</label>\n");
      out.write("                                        <input class=\"form-control\" type=\"number\" value=\"");
      out.print( (c.getCapacity()) );
      out.write("\" name=\"classroomCapacity\" min=\"10\" required />\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-footer\">\n");
      out.write("                                    <input type=\"hidden\" name=\"action\" value=\"update\" />\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                    <input type=\"submit\" value=\"Save changes\" class=\"btn btn-success\" />\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                ");
 if (classrooms == null || classrooms.isEmpty()) {
      out.write(" \n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"5\" style=\"text-align:center\">There are no classrooms.</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <!-- END OF CONTAINER -->\n");
      out.write("\n");
      out.write("        <!-- A FOOTER -->\n");
      out.write("        ");
      out.write("<footer class=\"navbar navbar-inverse col-md-12\" style=\"border-radius: 0;bottom:0;margin:0;position:relative;bottom:0;\"> <!-- style=\"margin-bottom: 0;margin-top:20px;position:absolute;width: 100%;bottom:0;border-radius:0\" -->\r\n");
      out.write("    <h4 style=\"display:block;text-align: center; color:#9d9d9d\">&copy; Nikesh Maharjan</h4>\r\n");
      out.write("</footer>");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}