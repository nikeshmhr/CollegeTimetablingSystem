<%-- 
    Document   : addTeachers
    Created on : Sep 28, 2015, 9:54:26 PM
    Author     : Nikesh
--%>

<%@page import="com.nikesh.scheduler.model.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.nikesh.scheduler.util.DatabaseTool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Add Teachers</title>
        <script type="text/javascript">
            $(document).ready(function () {
                /** HIGHLIGHTS THE CURRENTLY ACTIVE NAVIGATION **/
                $("#addResource").addClass("active");
            });
            function validateAddTeachers() {
                var values = document.getElementById("teacherName").value;
                var regEx = /[^abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ,]/g;
                var result = values.match(regEx);

                /*var splited = values.split(",");
                 
                 for(var i = 0; i < splited.length; i++){
                 document.write(splited[i] + "<br/>");
                 }*/

                if (result.length <= 0) { // VALID
                    return true;
                }
                document.getElementById("errorMessage").innerHTML = "Invalid input. Only use alphabets, commas and spaces.";
                return false;
            }
        </script>
    </head>
    <body>
        <%@include file="includes/functions.jsp" %>
        <%
            sessionCheck(request, response);
        %>
        <div class="container">
            <%@include file="includes/navigation.html" %>

            <span 
                <% if (request.getAttribute("message") != null) {
                        if (request.getAttribute("status") != null && request.getAttribute("status").equals("200")) {
                            out.println("class=\"label label-success\"");
                        } else {
                            out.println("class=\"label label-danger\"");
                        }
                    }%> >
                <%
                    if (request.getAttribute("message") == null) {
                        out.println("");
                    } else {
                        out.println(request.getAttribute("message"));
                    }
                %>
            </span>

            <%
                List<Teacher> teachers = RetrieveResources.getTeachers();

            %>

            <div class="row">
                <!-- TABLE FOR LIST OF TEACHERS -->
                <div class="col-md-5">
                    <table class="table table-striped table-hover table-bordered table-responsive">
                        <h2 class="text-primary">List of Teachers</h2>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%                                
                                boolean isDataAvailable = false;
                                for (Teacher t : teachers) {
                                    isDataAvailable = true;
                                    String teacherId = t.getTeacherId();
                                    String teacherName = t.getTeacherName();
                            %>
                            <tr>
                                <td><%= (teacherId)%></td>
                                <td><%= (teacherName)%></td>
                            </tr>
                            <% } %>
                            <%
                                if (!isDataAvailable) {
                                    out.println("<tr><td colspan='2' align='center'>There are no teachers.</td></tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <!-- END OF TABLE -->

                <!-- FORM TO ADD TEACHERS -->
                <div class="col-md-4 col-md-offset-1">
                    <h2 class="text-primary">Add teachers</h2>
                    <small style="font-size: 80%" class="text-danger">NOTE: Use comma separate names add multiple teachers at once.</small>
                    <form action="AddTeacherController" method="post" role="form" onsubmit="return validateAddTeachers();">
                        <div class="form-group">
                            <label for="teacherName">Name(s)</label>
                            <input type="text" name="teacherName" id="teacherName" class="form-control" maxlength="500" required />
                        </div>
                        <!--<div class="form-group">
                            <label for="teacherId">Id(s)</label>
                            <input type="text" name="teacherId" id="teacherId" class="form-control" maxlength="500" required /><span class="text-danger" id="errorMessage"></span>
                        </div>-->
                        <div class="">
                            <input type="submit" name="addTeacher" value="Add" class="btn btn-success" />
                        </div>
                    </form>
                </div>
                <!-- END OF FORM -->
            </div>
            <!-- END OF ROW -->
        </div>
        <!-- END OF CONTAINER -->

        <!-- A FOOTER -->
        <%@include file="includes/footer.html" %>
    </body>
</html>
