<%-- 
    Document   : addTeachers
    Created on : Sep 28, 2015, 9:54:26 PM
    Author     : Nikesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Add Teachers</title>
        <script type="text/javascript">
            $(document).ready(function () {
                /** HIGHLIGHTS THE CURRENTLY ACTIVE NAVIGATION **/
                $("#addResource").addClass("active");
            });
            function validateAddTeachers() {

            }
        </script>
    </head>
    <body>
        
        <div class="container">
            <%@include file="includes/navigation.html" %>

            <div class="row">
                <!-- TABLE FOR LIST OF TEACHERS -->
                <div class="col-md-5">
                    <table class="table table-striped table-hover table-bordered table-responsive">
                        <h2 class="text-primary">List of Teachers</h2>
                        <thead>
                            <tr>
                                <th>Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Prakash Shrestha</td>
                            </tr>
                            <tr>
                                <td>Abhinav Dahal</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- END OF TABLE -->
                
                <!-- FORM TO ADD TEACHERS -->
                <div class="col-md-4 col-md-offset-1">
                    <h2 class="text-primary">Add teachers</h2>
                    <small style="font-size: 80%" class="text-danger">NOTE: Use comma seperate names to add multiple teachers at once.</small>
                    <form action="#" method="post" role="form" onsubmit="return validateAddTeachers()">
                        <div class="form-group">
                            <label for="teacherName">Name(s)</label>
                            <input type="text" name="teacherName" id="moduleCode" class="form-control" maxlength="200" required />
                        </div>
                        <div class="">
                            <input type="submit" name="addTeacher" value="Add" class="btn btn-success" />
                        </div>
                    </form>
                </div>
                <!-- END OF FORM -->
            </div>
            <!-- END OF ROW -->
        </div>
        <!-- END OF CONTAINER -->
        
        <!-- A FOOTER -->
        <%@include file="includes/footer.html" %>
    </body>
</html>
