package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addModules_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"shortcut icon\" href=\"images/clock-icon.ico\" />");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/main.css\" type=\"text/css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/clock-icon.ico\" />\n");
      out.write("        <title>Add Modules</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                /** HIGHLIGHTS THE CURRENTLY ACTIVE NAVIGATION **/\n");
      out.write("                $(\"#addResource\").addClass(\"active\");\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            /** Check to see if everything is fine **/\n");
      out.write("            function validateAddModule() {\n");
      out.write("                var checkedList = getCheckedClasses();\n");
      out.write("\n");
      out.write("                for (var i = 0; i < checkedList.length; i++) {\n");
      out.write("                    var checkedValue = checkedList[i];\n");
      out.write("                    var checkedHourseValue = document.getElementById(\"classType\"+checkedValue).value;\n");
      out.write("                    if(checkedHourseValue <= 0){\n");
      out.write("                        document.getElementById(\"classType\"+checkedValue).focus();\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /** Returns value of all the checked items **/\n");
      out.write("            function getCheckedClasses() {\n");
      out.write("                var checked = Array();\n");
      out.write("                var i = document.getElementsByName(\"typesOfClasses\");\n");
      out.write("                var k = 0;\n");
      out.write("                for (var j = 0; j < i.length; j++) {\n");
      out.write("                    if (i[j].checked == true) {\n");
      out.write("                        checked[k++] = i[j].value;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                return checked;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Edit Resources<span class=\"caret\"></span></a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"editModules.jsp\">Edit Modules</a></li>\r\n");
      out.write("                        <li><a href=\"editTeachers.jsp\">Edit Teachers</a></li>\r\n");
      out.write("                        <li><a href=\"editClassrooms.jsp\">Edit Classrooms</a></li>\r\n");
      out.write("                        <li><a href=\"editGroups.jsp\">Edit Groups</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"dropdown\" id=\"addRelation\">\r\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Add Relation<span class=\"caret\"></span></a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"#\">Teacher-Module</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Group-Module</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\"><li><a href=\"LogoutController\" id=\"logout\">Logout</a></li></ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <!-- TABLE TO SHOW THE LIST OF ALREADY EXISTING MODULES -->\n");
      out.write("                <div class=\"col-md-5\">\n");
      out.write("                    <table class=\"table table-striped table-hover table-bordered table-responsive\">\n");
      out.write("                        <h2 class=\"text-primary\">List of Modules</h2>\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Module Code</th>\n");
      out.write("                                <th>Module Name</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>CC3005NI</td>\n");
      out.write("                                <td>Software Engineering II</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>CC3008NI</td>\n");
      out.write("                                <td>Current Developments</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <!-- END OF MODULES LIST -->\n");
      out.write("\n");
      out.write("                <!-- START OF FORM TO ADD MODULES -->\n");
      out.write("                <div class=\"col-md-4 col-md-offset-1\">\n");
      out.write("                    <h2 class=\"text-primary\">Add new module</h2>\n");
      out.write("                    <form action=\"AddModuleController\" name=\"addModulesForm\" method=\"post\" role=\"form\" onsubmit=\"return validateAddModule();\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"moduleCode\">Module Code</label>\n");
      out.write("                            <input type=\"text\" name=\"moduleCode\" id=\"moduleCode\" class=\"form-control\" maxlength=\"10\" required />\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"moduleName\">Module Name</label>\n");
      out.write("                            <input type=\"text\" name=\"moduleName\" id=\"moduleName\" class=\"form-control\" maxlength=\"50\" required />\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"classTypes\">Types of classes</label>\n");
      out.write("                            <div class=\"checkbox\">\n");
      out.write("                                <label><input class=\"checkbox-inline\" type=\"checkbox\" name=\"typesOfClasses\" value=\"1\" checked onclick=\"getCheckedClasses();\" required=\"true\"> Lecture</label>\n");
      out.write("                                <label><input class=\"checkbox-inline\" type=\"checkbox\" name=\"typesOfClasses\" value=\"2\" oncheck=\"getCheckedClasses();\"> Tutorial</label>\n");
      out.write("                                <label><input class=\"checkbox-inline\" type=\"checkbox\" name=\"typesOfClasses\" value=\"3\" onclick=\"getCheckedClasses();\"> Lab</label>\n");
      out.write("                                <label><input class=\"checkbox-inline\" type=\"checkbox\" name=\"typesOfClasses\" value=\"4\" onclick=\"getCheckedClasses();\"> Workshop</label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group form-inline\">\n");
      out.write("                            <label for=\"hoursOfClasses\">Hours of classes</label>\n");
      out.write("                            <blockquote>\n");
      out.write("                                <label>Lecture:</label>\n");
      out.write("                                <input type=\"number\" style=\"margin-bottom: 5px;\" class=\"form-control input-group col-md-4\" step=\"0.1\" min=\"1\" name=\"lectureHours\" placeholder=\"0\" id=\"classType1\" /><br/>\n");
      out.write("                                <label>Tutorial:</label>\n");
      out.write("                                <input type=\"number\" style=\"margin-bottom: 5px\" class=\"form-control input-group col-md-4\" step=\"0.1\" min=\"1\" name=\"tutorialHours\" placeholder=\"0\" id=\"classType2\" /><br/>\n");
      out.write("                                <label>Lab:</label>\n");
      out.write("                                <input type=\"number\" style=\"margin-bottom: 5px\" class=\"form-control input-group col-md-4\" step=\"0.1\" min=\"1\" name=\"labHours\" placeholder=\"0\" id=\"classType2\"  /><br/>\n");
      out.write("                                <label>Workshop:</label>\n");
      out.write("                                <input type=\"number\" style=\"margin-bottom: 5px\" class=\"form-control input-group col-md-4\" step=\"0.1\" min=\"1\" name=\"workshopHours\" placeholder=\"0\" id=\"classType4\" />\n");
      out.write("                            </blockquote>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <input type=\"submit\" name=\"addModule\" value=\"Add\" class=\"btn btn-success\" />\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <!-- END OF ADD MODULES FORM -->\n");
      out.write("            </div>\n");
      out.write("            <!-- END OF ROW -->\n");
      out.write("        </div>\n");
      out.write("        <!-- CONTAINER ENDS HERE -->\n");
      out.write("\n");
      out.write("        <!-- A FOOTER -->\n");
      out.write("        ");
      out.write("<footer class=\"navbar navbar-inverse col-md-12\" style=\"border-radius: 0;bottom:0;margin:0;position:relative;bottom:0;\"> <!-- style=\"margin-bottom: 0;margin-top:20px;position:absolute;width: 100%;bottom:0;border-radius:0\" -->\r\n");
      out.write("    <h4 style=\"display:block;text-align: center; color:#9d9d9d\"><span class=\"glyphicon glyphicon-copyright-mark\"></span> Nikesh Maharjan</h4>\r\n");
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
