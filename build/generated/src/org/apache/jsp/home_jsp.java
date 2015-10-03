package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/includes/headerInclude.html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"styles/main.css\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"clock-icon.ico\" />");
      out.write("\n");
      out.write("        <title>Scheduler</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String user = (String) session.getAttribute("user");
            if (user == null || user.equals("")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                //out.println(user);
            }
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../bootstrap/css/bootstrap.min.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../styles/main.css\"/>\r\n");
      out.write("        <script src=\"../bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"../js/jquery.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"navbar navbar-inverse\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <button type=\"button\" \r\n");
      out.write("                            class=\"navbar-toggle\"\r\n");
      out.write("                            data-toggle=\"collapse\" \r\n");
      out.write("                            data-target=\"#mynavbar-content\">\r\n");
      out.write("                        <span  class=\"icon-bar\"></span>\r\n");
      out.write("                        <span  class=\"icon-bar\"></span>\r\n");
      out.write("                        <span  class=\"icon-bar\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"home.jsp\" title=\"Home\"><span class=\"glyphicon glyphicon-home\"></span></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"mynavbar-content\">\r\n");
      out.write("                    <ul class=\"nav navbar-nav\">\r\n");
      out.write("                        <li class=\"dropdown\" id=\"addResource\">\r\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Add Resources<span class=\"caret\"></span></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu\">\r\n");
      out.write("                                <li><a href=\"addModules.jsp\">Add Modules</a></li>\r\n");
      out.write("                                <li><a href=\"addTeachers.jsp\">Add Teachers</a></li>\r\n");
      out.write("                                <li><a href=\"addClassrooms.jsp\">Add Classrooms</a></li>\r\n");
      out.write("                                <li><a href=\"addGroups.jsp\">Add Groups</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"dropdown\" id=\"editResource\">\r\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Edit Resources<span class=\"caret\"></span></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu\">\r\n");
      out.write("                                <li><a href=\"editModules.jsp\">Edit Modules</a></li>\r\n");
      out.write("                                <li><a href=\"editTeachers.jsp\">Edit Teachers</a></li>\r\n");
      out.write("                                <li><a href=\"editClassrooms.jsp\">Edit Classrooms</a></li>\r\n");
      out.write("                                <li><a href=\"editGroups.jsp\">Edit Groups</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"dropdown\" id=\"addRelation\">\r\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Add Relation<span class=\"caret\"></span></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu\">\r\n");
      out.write("                                <li><a href=\"#\">Teacher-Module</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Group-Module</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\"><li><a href=\"LogoutController\" id=\"logout\">Logout</a></li></ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("            <div class=\"jumbotron\">\n");
      out.write("                <h1>Scheduler</h1>\n");
      out.write("                <p>A Scheduler is a simple college timetabling system that carries out the scheduling activity of course timetables.</p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"panel-group\" id=\"accordion\">\n");
      out.write("                <div class=\"panel panel-success\">\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("                        <h4 class=\"panel-title\">\n");
      out.write("                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse1\" class=\"accordion-dropdown\">\n");
      out.write("                                How to use?\n");
      out.write("                            </a>\n");
      out.write("                        </h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"collapse1\" class=\"panel-collapse collapse in\">\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            Lorem ipsum dolor sit amet, consectetur adipisicing elit,\n");
      out.write("                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad\n");
      out.write("                            minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea\n");
      out.write("                            commodo consequat.\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel panel-success\">\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("                        <h4 class=\"panel-title\">\n");
      out.write("                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse2\" class=\"accordion-dropdown\">\n");
      out.write("                                Collapsible Group 2</a>\n");
      out.write("                        </h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"collapse2\" class=\"panel-collapse collapse\">\n");
      out.write("                        <div class=\"panel-body\">Lorem ipsum dolor sit amet, consectetur adipisicing elit,\n");
      out.write("                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad\n");
      out.write("                            minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea\n");
      out.write("                            commodo consequat.</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel panel-success\">\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("                        <h4 class=\"panel-title\">\n");
      out.write("                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse3\" class=\"accordion-dropdown\">\n");
      out.write("                                Collapsible Group 3</a>\n");
      out.write("                        </h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"collapse3\" class=\"panel-collapse collapse\">\n");
      out.write("                        <div class=\"panel-body\">Lorem ipsum dolor sit amet, consectetur adipisicing elit,\n");
      out.write("                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad\n");
      out.write("                            minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea\n");
      out.write("                            commodo consequat.</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("<footer class=\"navbar navbar-inverse col-md-12\" style=\"border-radius: 0;bottom:0;margin:0;position:relative;bottom:0;\"> <!-- style=\"margin-bottom: 0;margin-top:20px;position:absolute;width: 100%;bottom:0;border-radius:0\" -->\r\n");
      out.write("    <h4 style=\"display:block;text-align: center; color:#9d9d9d\"><span class=\"glyphicon glyphicon-copyright-mark\"></span> Nikesh Maharjan</h4>\r\n");
      out.write("</footer>");
      out.write("\n");
      out.write("\n");
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
