<%-- 
    Document   : teacherModule
    Created on : Oct 7, 2015, 7:03:37 AM
    Author     : Nikesh
--%>
<%@page import="com.nikesh.scheduler.model.Module"%>
<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.model.Teacher"%>
<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher-Module</title>
        <%@include file="includes/headerInclude.html" %>
        <script type="text/javascript">
            $(document).ready(function () {
                /** HIGHLIGHTS THE CURRENTLY ACTIVE NAVIGATION **/
                $("#addRelation").addClass("active");
            });

            function validateRelation() {

            }
        </script>
    </head>
    <body>
        <%@include file="includes/functions.jsp" %>
        <%
            sessionCheck(request, response);
        %>

        <!-- CONTAINER STARTS HERE -->
        <div class="container">
            <%@include file="includes/navigation.html" %>

            <!-- DISPLAYS ANY MESSAGE PASSED WITH 'message' ATTRIBUTE -->
            <span
                <% if (request.getAttribute("message") != null) {
                        out.println("class=\"label label-danger\"");
                    }%> >
                <%
                    if (request.getAttribute("message") == null) {
                        out.println("");
                    } else {
                        out.println(request.getAttribute("message"));
                    }
                %>
            </span>

            <div class="row">
                <!-- TABLE TO SHOW THE LIST OF ALREADY EXISTING CLASSROOMS -->
                <div class="col-md-5">
                    <table class="table table-striped table-hover table-bordered table-responsive">
                        <h2 class="text-primary">Existing Relations</h2>
                        <thead>
                            <tr>
                                <th>Teacher ID</th>
                                <th>Teacher Name</th>
                                <th>Module Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>T123</td>
                                <td>Nikesh</td>
                                <td>
                                    values
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- END OF CLASSROOM LIST -->
                <!-- START OF FORM TO ADD CLASSROOMS -->
                <div class="col-md-4 col-md-offset-1">
                    <h2 class="text-primary">Create new relation</h2>
                    <form action="TeacherModuleController" method="post" role="form" onsubmit="return validateRelation()">
                        <div class="form-group">
                            <label for="forTeacherId">Teacher Id: </label>
                            <select name="teacherId" required class="form-control">
                                <option value="">Select ID</option>
                                <%
                                    List<Teacher> teachers = RetrieveResources.getTeachers();
                                    for (Teacher teacher : teachers) {
                                %>                                
                                <option value="<%= (teacher.getTeacherId())%>"><%= (teacher.getTeacherName() + " " + "(" + teacher.getTeacherId() + ")")%></option>
                                <% } %>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="modulesList">Select Modules: </label>
                            <select name="moduleId" required class="form-control" multiple="multiple">
                                <%
                                    List<Module> modules = RetrieveResources.getModules();
                                    for (Module module : modules) {
                                %>
                                <option value="<%= (module.getModuleCode())%>"><%= (module.getModuleName())%></option>
                                <% }%>
                            </select>
                        </div>
                        <div>
                            <input type="submit" name="createRelation" value="Create" class="btn btn-success" />
                        </div>
                    </form>
                </div>
                <!-- END OF ADD CLASSROOMS FORM -->
            </div>
            <!-- END OF ROW -->
        </div>
        <!-- CONTAINER ENDS HERE -->

        <!-- A FOOTER -->
        <%@include file="includes/footer.html" %>
    </body>
</html>
