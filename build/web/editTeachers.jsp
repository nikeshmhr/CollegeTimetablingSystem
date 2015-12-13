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

            <table class="table table-striped">
                <h2 class="text-primary" style="text-align: center">Edit Teachers</h2>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Teacher> teachers = RetrieveResources.getTeachers();
                        for (Teacher t : teachers) {
                    %>
                    <tr>
                        <td><%= (t.getTeacherId())%></td>
                        <td><%= (t.getTeacherName())%></td>
                        <td>
                            <a href="#<%= (t.getTeacherId())%>" data-toggle="modal"><span class="glyphicon glyphicon-edit" title="Edit"></span></a> 
                            | 
                            <a href="ModifyTeacherController?action=delete&id=<%= (t.getTeacherId())%>"><span class="glyphicon glyphicon-remove" title="Delete"></span></a>
                        </td>
                    </tr>
                <div class="modal fade" tabindex="-1" role="dialog" id="<%= (t.getTeacherId())%>">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="ModifyTeacherController" method="post">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Edit Teacher</h4>
                                </div>

                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="teacherId">ID</label>
                                        <input type="text" disabled="true" id="teacherId" class="form-control" maxlength="10" value="<%= (t.getTeacherId())%>" required />
                                        <input type="hidden" name="teacherId" value="<%= (t.getTeacherId())%>" />
                                    </div>

                                    <div class="form-group">
                                        <label for="teacherName">Name</label>
                                        <input type="text" name="teacherName" id="teacherName" class="form-control" maxlength="50" value="<%= (t.getTeacherName())%>" required />
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
                </div>
                <% } %>

                <% if (teachers == null || teachers.isEmpty()) { %>
                <tr>
                    <td colspan="3" style="text-align: center;">There are no teachers.</td>
                </tr>
                <% }%>
                </tbody>
            </table>
        </div>
        <!-- END OF CONTAINER -->

        <!-- A FOOTER -->
        <%@include file="includes/footer.html" %>
    </body>
</html>
