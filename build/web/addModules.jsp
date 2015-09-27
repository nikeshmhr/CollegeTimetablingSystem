<%-- 
    Document   : addModules
    Created on : Sep 27, 2015, 8:27:31 PM
    Author     : Nikesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Add Modules</title>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#addResource").addClass("active");
            });
        </script>
    </head>
    <body>
        <div class="container">
            <%@include file="includes/navigation.html" %>
        </div>
    </body>
</html>
