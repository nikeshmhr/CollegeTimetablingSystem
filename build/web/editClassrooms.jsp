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
                            <a href="#<%= (c.getRoomCode())%>" data-toggle="modal"><span class="glyphicon glyphicon-edit" title="Edit"></span></a> 
                            | 
                            <a href="ModifyClassroomController?action=delete&id=<%= (c.getRoomCode())%>"><span class="glyphicon glyphicon-remove" title="Delete"></span></a>
                        </td>
                    </tr>
                <div class="modal fade" tabindex="-1" role="dialog" id="<%= (c.getRoomCode())%>">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="ModifyClassroomController" method="post">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Edit Classroom</h4>
                                </div>

                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="roomCode">Room Code</label>
                                        <input type="text" id="classroomCode" disabled="true" class="form-control" maxlength="10" value="<%= (c.getRoomCode())%>" />
                                        <input type="hidden" name="roomCode" value="<%= (c.getRoomCode())%>" />
                                    </div>

                                    <div class="form-group">
                                        <label for="classroomName">Module Name</label>
                                        <input type="text" name="classroomName" id="classroomName" class="form-control" maxlength="50" value="<%= (c.getRoomName())%>" required />
                                    </div>
                                    <div class="form-group">
                                        <label for="typeOfClassroom">Type of classroom</label>
                                        <div class="radio">
                                            <label><input class="radio-inline" type="radio" name="typeOfClassroom" value="Lecture" <% if (c.getRoomType().getTypeName().equalsIgnoreCase("lecture")) {
                                                    out.print("checked");
                                                } %>> Lecture</label>
                                            <label><input class="radio-inline" type="radio" name="typeOfClassroom" value="Tutorial" <% if (c.getRoomType().getTypeName().equalsIgnoreCase("tutorial")) {
                                                    out.print("checked");
                                                } %>> Tutorial</label>
                                            <label><input class="radio-inline" type="radio" name="typeOfClassroom" value="Lab" <% if (c.getRoomType().getTypeName().equalsIgnoreCase("lab")) {
                                                    out.print("checked");
                                                } %>> Lab</label>
                                            <label><input class="radio-inline" type="radio" name="typeOfClassroom" value="Workshop" <% if (c.getRoomType().getTypeName().equalsIgnoreCase("workshop")) {
                                                    out.print("checked");
                                                }%>> Workshop</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="classroomCapacity">Capacity</label>
                                        <input class="form-control" type="number" value="<%= (c.getCapacity())%>" name="classroomCapacity" min="10" required />
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

                <% if (classrooms == null || classrooms.isEmpty()) {%> 
                <tr>
                    <td colspan="5" style="text-align:center">There are no classrooms.</td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
        <!-- END OF CONTAINER -->

        <!-- A FOOTER -->
        <%@include file="includes/footer.html" %>
    </body>
</html>
