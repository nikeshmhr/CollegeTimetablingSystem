package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.model.Module;
import java.util.List;
import com.nikesh.scheduler.model.Teacher;
import com.nikesh.scheduler.dao.RetrieveResources;
import java.io.IOException;

public final class teacherModule_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Teacher-Module</title>\n");
      out.write("        ");
      out.write("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"styles/main.css\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/clock-icon.ico\" />");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                /** HIGHLIGHTS THE CURRENTLY ACTIVE NAVIGATION **/\n");
      out.write("                $(\"#addRelation\").addClass(\"active\");\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            function validateRelation() {\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write('\n');
      out.write("\n");
      out.write("        ");

            sessionCheck(request, response);
        
      out.write("\n");
      out.write("\n");
      out.write("        <!-- CONTAINER STARTS HERE -->\n");
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
      out.write("            <!-- DISPLAYS ANY MESSAGE PASSED WITH 'message' ATTRIBUTE -->\n");
      out.write("            <span\n");
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
      out.write("            <div class=\"row\">\n");
      out.write("                <!-- TABLE TO SHOW THE LIST OF ALREADY EXISTING CLASSROOMS -->\n");
      out.write("                <div class=\"col-md-5\">\n");
      out.write("                    <table class=\"table table-striped table-hover table-bordered table-responsive\">\n");
      out.write("                        <h2 class=\"text-primary\">Existing Relations</h2>\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Teacher ID</th>\n");
      out.write("                                <th>Teacher Name</th>\n");
      out.write("                                <th>Module Name</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>T123</td>\n");
      out.write("                                <td>Nikesh</td>\n");
      out.write("                                <td>\n");
      out.write("                                    values\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <!-- END OF CLASSROOM LIST -->\n");
      out.write("                <!-- START OF FORM TO ADD CLASSROOMS -->\n");
      out.write("                <div class=\"col-md-4 col-md-offset-1\">\n");
      out.write("                    <h2 class=\"text-primary\">Create new relation</h2>\n");
      out.write("                    <form action=\"TeacherModuleController\" method=\"post\" role=\"form\" onsubmit=\"return validateRelation()\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"forTeacherId\">Teacher Id: </label>\n");
      out.write("                            <select name=\"teacherId\" required class=\"form-control\">\n");
      out.write("                                <option value=\"\">Select ID</option>\n");
      out.write("                                ");

                                    List<Teacher> teachers = RetrieveResources.getTeachers();
                                    for (Teacher teacher : teachers) {
                                
      out.write("                                \n");
      out.write("                                <option value=\"");
      out.print( (teacher.getTeacherId()));
      out.write('"');
      out.write('>');
      out.print( (teacher.getTeacherName() + " " + "(" + teacher.getTeacherId() + ")"));
      out.write("</option>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"modulesList\">Select Modules: </label>\n");
      out.write("                            <select name=\"moduleId\" size=\"6\" required class=\"form-control\" multiple=\"multiple\">\n");
      out.write("                                ");

                                    List<Module> modules = RetrieveResources.getModules();
                                    for (Module module : modules) {
                                
      out.write("\n");
      out.write("                                <optgroup label=\"");
      out.print( (module.getModuleName() + " (" + module.getModuleCode() + ")"));
      out.write("\">\n");
      out.write("                                    ");

                                        List<ClassType> classTypes = RetrieveResources.getClassTypesForModule(module.getModuleCode());
                                        for (ClassType type : classTypes) {
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( module.getModuleCode() + "_" + type.getTypeId());
      out.write('"');
      out.write('>');
      out.print( type.getTypeName() + " (" + type.getClassHours() +")" );
      out.write("</option>\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\n");
      out.write("                                </optgroup>\n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <input type=\"submit\" name=\"createRelation\" value=\"Create\" class=\"btn btn-success\" />\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <!-- END OF ADD CLASSROOMS FORM -->\n");
      out.write("            </div>\n");
      out.write("            <!-- END OF ROW -->\n");
      out.write("        </div>\n");
      out.write("        <!-- CONTAINER ENDS HERE -->\n");
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
