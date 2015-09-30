<%-- 
    Document   : editClassrooms
    Created on : Sep 30, 2015, 7:20:39 PM
    Author     : Nikesh
--%>

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
                    <tr>
                        <td>TR-102</td>
                        <td>Keinsington Palace</td>
                        <td>Lecture</td>
                        <td>100</td>
                        <td>
                            <a href="#"><span class="glyphicon glyphicon-edit" title="Edit"></span></a> 
                            | 
                            <a href="#"><span class="glyphicon glyphicon-remove" title="Delete"></span></a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- END OF CONTAINER -->
        
        <!-- A FOOTER -->
        <%@include file="includes/footer.html" %>
    </body>
</html>
