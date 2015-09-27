<%-- 
    Document   : editModules
    Created on : Sep 27, 2015, 9:31:11 PM
    Author     : Nikesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Edit Modules</title>
        <script>
            $(document).ready(function(){
                $("#editResource").addClass("active");
            });
        </script>
        
    </head>
    <body>
        <div class="container">
            <%@include file="includes/navigation.html" %>
        </div>
    </body>
</html>
