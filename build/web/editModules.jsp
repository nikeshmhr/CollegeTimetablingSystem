<%-- 
    Document   : editModules
    Created on : Sep 27, 2015, 9:31:11 PM
    Author     : Nikesh
--%>

<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page import="com.nikesh.scheduler.model.Module"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Edit Modules</title>
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
                <h2 class="text-primary" style="text-align: center">Edit Modules</h2>
                <thead>
                    <tr>
                        <th>Module Code</th>
                        <th>Module Name</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>
                    <% 
                        List<Module> modules = RetrieveResources.getModules();
                        for(Module m : modules){
                    %>
                    <tr>
                        <td><%= (m.getModuleCode()) %></td>
                        <td><%= (m.getModuleName()) %></td>
                        <td>
                            <a href="#moduleCode=<%= (m.getModuleCode())%> "><span class="glyphicon glyphicon-edit" title="Edit"></span></a> 
                            | 
                            <a href="#"><span class="glyphicon glyphicon-remove" title="Delete"></span></a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

        </div>
        <!-- END OF CONTAINER -->

        <%@include file="includes/footer.html" %>
    </body>
</html>
