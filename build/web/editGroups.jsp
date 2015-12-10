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
                        <td><%= (g.getGroupCode())%></td>
                        <td><%= (g.getNoOfStudents())%></td>
                        <td>
                            <a href="#<%=(g.getGroupCode())%>" data-toggle="modal"><span class="glyphicon glyphicon-edit" title="Edit"></span></a> 
                            | 
                            <a href="ModifyGroupController?action=delete&id=<%=(g.getGroupCode())%>"><span class="glyphicon glyphicon-remove" title="Delete"></span></a>
                        </td>
                    </tr>
                <div class="modal fade" tabindex="-1" role="dialog" id="<%= (g.getGroupCode())%>">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="ModifyGroupController" method="post">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Edit Group</h4>
                                </div>

                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="groupCode">Group Code</label>
                                        <input type="text" id="groupCode" disabled="true" class="form-control" maxlength="10" value="<%= (g.getGroupCode())%>" />
                                        <input type="hidden" name="groupCode" value="<%= (g.getGroupCode())%>" />
                                    </div>
                                    <div class="form-group">
                                        <label for="noOfStudents">No. of Students</label>
                                        <input type="number" name="noOfStudents" id="noOfStudents" class="form-control" min="10" max="50" value="<%= (g.getNoOfStudents()) %>" required />
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="action" value="update" />
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                    <input type="submit" value="Save changes" class="btn btn-success" />
                                </div>
                            </form>
                        </div>
                    </div>
                    <% } %>

                    <% if (groups == null || groups.isEmpty()) { %> 
                    <tr>
                        <td colspan="3" style="text-align: center;">There are no groups.</td>
                    </tr>
                    <% }%>
                    </tbody>
            </table>
        </div>
        <!-- END OF CONTAINER -->

        <%@include file="includes/footer.html" %>

    </body>
</html>
