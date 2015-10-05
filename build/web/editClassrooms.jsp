<%-- 
    Document   : editClassrooms
    Created on : Sep 30, 2015, 7:20:39 PM
    Author     : Nikesh
--%>

<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.model.Classroom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Edit Classrooms</title>
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

            <table class="table table-striped">
                <h2 class="text-primary" style="text-align: center">Edit Classrooms</h2>
                <thead>
                    <tr>
                        <th>Room Code</th>
                        <th>Name</th>
                        <th>Room Type</th>
                        <th>Capacity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Classroom> classrooms = RetrieveResources.getClassrooms();
                        for (Classroom c : classrooms) {
                    %>
                    <tr>
                        <td><%= (c.getRoomCode())%></td>
                        <td><%= (c.getRoomName())%></td>
                        <td><%= (c.getRoomType().getTypeName())%></td>
                        <td><%= (c.getCapacity())%></td>
                        <td>
                            <a href="#"><span class="glyphicon glyphicon-edit" title="Edit"></span></a> 
                            | 
                            <a href="#"><span class="glyphicon glyphicon-remove" title="Delete"></span></a>
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
