<%-- 
    Document   : editTeachers
    Created on : Sep 30, 2015, 7:14:24 PM
    Author     : Nikesh
--%>

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
        <div class="container">
            <%@include file="includes/navigation.html" %>
            
            <table class="table table-striped">
                <h2 class="text-primary" style="text-align: center">Edit Teachers</h2>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Abhinav Dahal</td>
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
