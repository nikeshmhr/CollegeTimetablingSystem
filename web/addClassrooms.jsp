<%-- 
    Document   : addClassrooms
    Created on : Sep 30, 2015, 6:36:42 PM
    Author     : Nikesh
--%>

<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.model.Classroom"%>
<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page import="com.nikesh.scheduler.factory.ClassTypeFactory"%>
<%@page import="com.nikesh.scheduler.abstractor.ClassType"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.nikesh.scheduler.util.DatabaseTool"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Add Classrooms</title>
        <script type="text/javascript">
            $(document).ready(function () {
                /** HIGHLIGHTS THE CURRENTLY ACTIVE NAVIGATION **/
                $("#addResource").addClass("active");
            });

            function validateAddClassroom() {

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
                List<Classroom> classrooms = RetrieveResources.getClassrooms();

            %>

            <div class="row">
                <!-- TABLE TO SHOW THE LIST OF ALREADY EXISTING CLASSROOMS -->
                <div class="col-md-5">
                    <table class="table table-striped table-hover table-bordered table-responsive">
                        <h2 class="text-primary">List of Classrooms</h2>
                        <thead>
                            <tr>
                                <th>Room Code</th>
                                <th>Name</th>
                                <th>Room Type</th>
                                <th>Capacity</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%                                boolean isDataAvailable = false;
                                for (Classroom room : classrooms) {
                                    isDataAvailable = true;
                                    String roomCode = room.getRoomCode();
                                    String roomName = room.getRoomName();
                                    int roomCapacity = room.getCapacity();
                                    String roomType = room.getRoomType().getTypeName();
                            %>
                            <tr>
                                <td><%= (roomCode)%></td>
                                <td><%= (roomName)%></td>
                                <td><%= (roomType)%></td>
                                <td><%= (roomCapacity)%></td>
                            </tr>
                            <% } %>
                            <%
                                if (!isDataAvailable) {
                                    out.println("<tr><td colspan='4' align='center'>There are no classrooms.</td></tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <!-- END OF CLASSROOM LIST -->
                <!-- START OF FORM TO ADD CLASSROOMS -->
                <div class="col-md-4 col-md-offset-1">
                    <h2 class="text-primary">Add new classroom</h2>
                    <form action="AddClassroomController" method="post" role="form" onsubmit="return validateAddClassroom()">
                        <div class="form-group">
                            <label for="classroomCode">Code</label>
                            <input type="text" name="classroomCode" id="classroomCode" class="form-control" maxlength="10" required />
                        </div>

                        <div class="form-group">
                            <label for="classroomName">Name</label>
                            <input type="text" name="classroomName" id="classroomName" class="form-control" maxlength="50" required />
                        </div>
                        <div class="form-group">
                            <label for="typeOfClassroom">Type of classroom</label>
                            <div class="radio">
                                <label><input class="radio-inline" type="radio" name="typeOfClassroom" value="Lecture" checked> Lecture</label>
                                <label><input class="radio-inline" type="radio" name="typeOfClassroom" value="Tutorial"> Tutorial</label>
                                <label><input class="radio-inline" type="radio" name="typeOfClassroom" value="Lab"> Lab</label>
                                <label><input class="radio-inline" type="radio" name="typeOfClassroom" value="Workshop"> Workshop</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="classroomCapacity">Capacity</label>
                            <input class="form-control" type="number" value="10" name="classroomCapacity" min="10" required />
                        </div>
                        <div>
                            <input type="submit" name="addClassroom" value="Add" class="btn btn-success" />
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
