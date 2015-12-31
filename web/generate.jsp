<%-- 
    Document   : generate
    Created on : Dec 28, 2015, 8:12:12 PM
    Author     : nilu
--%>

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

            <form action="#" method="POST">
                <button type="submit" class="btn btn-primary btn-toolbar">Generate <span class="glyphicon glyphicon-lamp"></span></button>
            </form>
            
            <div class="row">
                <!-- TABLE TO SHOW THE GENERATED TIMETABLE -->
                <table class="table table-striped table-hover">
                    <h2 class="text-primary" style="text-align: center">Timetable</h2>
                    <caption>Computing Year 1</caption>
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

                    <tbody>
                        <tr>
                            <td>SUN</td>
                            <td>7:00 AM - 8:30 AM</td>
                            <td>Lecture</td>
                            <td>CC3006NI</td>
                            <td>Current Developments</td>
                            <td>Abhinav Dahal</td>
                            <td>C4+C5</td>
                            <td>Tower Bridge</td>
                        </tr>
                        <tr>
                            <td>SUN</td>
                            <td>9:00 AM - 10:30 AM</td>
                            <td>Lecture</td>
                            <td>CC3004NI</td>
                            <td>Software Engineering 2</td>
                            <td>Prakash Shrestha</td>
                            <td>C4+C5</td>
                            <td>Tower Bridge</td>
                        </tr>
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
