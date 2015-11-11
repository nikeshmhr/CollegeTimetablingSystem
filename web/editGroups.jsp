<%-- 
    Document   : editGroups
    Created on : Sep 30, 2015, 7:30:18 PM
    Author     : Nikesh
--%>

<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.model.Group"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Edit Groups</title>
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
                <h2 class="text-primary" style="text-align: center">Edit Groups</h2>
                <thead>
                    <tr>
                        <th>Group Code</th>
                        <th>Number Of Students</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Group> groups = RetrieveResources.getGroups();
                        for (Group g : groups) {
                    %>
                    <tr>
                        <td><%= (g.getGroupCode()) %></td>
                        <td><%= (g.getNoOfStudents()) %></td>
                        <td>
                            <a href="ModifyGroupController?action=edit&id=<%=(g.getGroupCode())%>"><span class="glyphicon glyphicon-edit" title="Edit"></span></a> 
                            | 
                            <a href="ModifyGroupController?action=delete&id=<%=(g.getGroupCode())%>"><span class="glyphicon glyphicon-remove" title="Delete"></span></a>
                        </td>
                    </tr>
                    <% } %>
                    
                    <% if(groups == null || groups.isEmpty()){ %> 
                    <tr>
                        <td colspan="3" style="text-align: center;">There are no groups.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        <!-- END OF CONTAINER -->
        
        <%@include file="includes/footer.html" %>
        
    </body>
</html>
