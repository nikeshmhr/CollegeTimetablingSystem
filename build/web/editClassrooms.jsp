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
        <!--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
     Launch modal
     </button>
        <div class="modal fade" id="myModal">
          <div class="modal-dialog">
              <div class="modal-content">
                 
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Welcome Back!</h4>
                  </div>
                  
                  <div class="modal-body">
                      <h1>Hello Readers!</h1>
                  </div>
                  
                  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                      <button type="button" class="btn btn-primary">Save changes</button>
                  </div>
              </div>
          </div>
      </div>-->
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
                            <a href="ModifyClassroomController?action=edit&id=<%= (c.getRoomCode()) %>"><span class="glyphicon glyphicon-edit" title="Edit"></span></a> 
                            | 
                            <a href="ModifyClassroomController?action=delete&id=<%= (c.getRoomCode()) %>"><span class="glyphicon glyphicon-remove" title="Delete"></span></a>
                        </td>
                    </tr>
                    <% } %>
                    
                    <% if(classrooms == null || classrooms.isEmpty()){%> 
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
