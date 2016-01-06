<%-- 
    Document   : generate
    Created on : Dec 28, 2015, 8:12:12 PM
    Author     : Nikesh Maharjan
--%>

<%@page import="com.nikesh.scheduler.model.Timetabler"%>
<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.model.Timeslot"%>
<%@page import="com.nikesh.scheduler.factory.ClassTypeFactory"%>
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
        <title>Generate Timetable</title>
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

            <form action="generate.jsp" method="POST">
                <button type="submit" name="generate" class="btn btn-primary btn-toolbar" value="generate">Generate <span class="glyphicon glyphicon-lamp"></span></button>
            </form>


            <div class="row">
                <!-- TABLE TO SHOW THE GENERATED TIMETABLE -->
                <table class="table table-striped table-hover">
                    <h2 class="text-primary" style="text-align: center">Timetable</h2>
                    <thead>
                        <tr>
                            <th>Day</th>
                            <th>Time</th>
                            <th>Class Type</th>
                            <th>Module Code</th>
                            <th>Module Title</th>
                            <th>Lecturer</th>
                            <th>Group</th>
                            <th>Room</th>
                        </tr>
                    </thead>

                    <%
                        Timetabler generator = new Timetabler();
                        if (request.getParameter("generate") != null && request.getParameter("generate").toString().equals("generate")) {
                            List<Timeslot> generatedTimeslots = generator.getTimeslots();
                            System.out.println("GEEEEEE:  " + generatedTimeslots);
                    %>
                    <tbody>
                        <%
                            for (Timeslot t : generatedTimeslots) {
                                //int day = t.getDay();
                                String day = t.getDayString().substring(0, 3);
                                String time = t.getStartTimeString() + " - " + t.getEndTimeString();
                                String classType = ClassTypeFactory.getClassType(t.getClassType()).getTypeName();
                                String moduleCode = t.getModuleCode();
                                String moduleName = RetrieveResources.getModuleName(t.getModuleCode());
                                String teacherName = RetrieveResources.getTeacherName(t.getTeacherId());
                                String groups = t.getGroupCode();
                                String classroom = RetrieveResources.getClassroomName(t.getRoomCode());
                        %>
                        <tr>
                            <td><%= (day)%></td>
                            <td><%= (time)%></td>
                            <td><%= (classType)%></td>
                            <td><%= (moduleCode)%></td>
                            <td><%= (moduleName)%></td>
                            <td><%= (teacherName)%></td>
                            <td><%= (groups)%></td>
                            <td><%= (classroom)%></td>
                        </tr>
                        <%
                                }
                            }else{
                        %>
                    <td colspan="8" style="text-align: center;">No timetable yet.</td>
                        <%}%>
                    </tbody>
                </table>
            </div>
            <!-- END OF ROW -->
        </div>
        <!-- CONTAINER ENDS HERE -->

        <!-- A FOOTER -->
        <%@include file="includes/footer.html" %>
    </body>
</html>
