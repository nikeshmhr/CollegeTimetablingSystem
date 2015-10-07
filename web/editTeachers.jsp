<%-- 
    Document   : editTeachers
    Created on : Sep 30, 2015, 7:14:24 PM
    Author     : Nikesh
--%>

<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.model.Teacher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Edit Teachers</title>
        <script>
            $(document).ready(function () {
                $("#editResource").addClass("active");
            });
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
            
            <table class="table table-striped">
                <h2 class="text-primary" style="text-align: center">Edit Teachers</h2>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<Teacher> teachers = RetrieveResources.getTeachers();
                        for(Teacher t : teachers){
                    %>
                    <tr>
                        <td><%= (t.getTeacherName())%></td>
                        <td>
                            <a href="ModifyTeacherController?action=edit&id=<%= (t.getTeacherId())%>"><span class="glyphicon glyphicon-edit" title="Edit"></span></a> 
                            | 
                            <a href="ModifyTeacherController?action=delete&id=<%= (t.getTeacherId())%>"><span class="glyphicon glyphicon-remove" title="Delete"></span></a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        <!-- END OF CONTAINER -->
        
        <!-- A FOOTER -->
        <%@include file="includes/footer.html" %>
    </body>
</html>
