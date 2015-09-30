<%-- 
    Document   : addClassrooms
    Created on : Sep 30, 2015, 6:36:42 PM
    Author     : Nikesh
--%>

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
            
            function validateAddClassroom(){
                
            }
        </script>
    </head>
    <body>
        <!-- CONTAINER STARTS HERE -->
        <div class="container">
            <%@include file="includes/navigation.html" %>

            <div class="row">
                <!-- TABLE TO SHOW THE LIST OF ALREADY EXISTING CLASSROOMS -->
                <div class="col-md-5">
                    <table class="table table-striped table-hover table-bordered table-responsive">
                        <h2 class="text-primary">List of Classrooms</h2>
                        <thead>
                            <tr>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Capacity</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>TR-10</td>
                                <td>Westminister Palace</td>
                                <td>100</td>
                            </tr>
                            <tr>
                                <td>TR-12</td>
                                <td>Buckingham Palace</td>
                                <td>100</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- END OF CLASSROOM LIST -->
                <!-- START OF FORM TO ADD CLASSROOMS -->
                <div class="col-md-4 col-md-offset-1">
                    <h2 class="text-primary">Add new classroom</h2>
                    <form action="#" method="post" role="form" onsubmit="return validateAddClassroom()">
                        <div class="form-group">
                            <label for="classroomCode">Code</label>
                            <input type="text" name="classroomCode" id="classroomCode" class="form-control" maxlength="10" required />
                        </div>

                        <div class="form-group">
                            <label for="classroomName">Name</label>
                            <input type="text" name="classroomName" id="classroomName" class="form-control" maxlength="50" required />
                        </div>
                        <div class="form-group">
                            <label for="typesOfClassroom">Types of classroom</label>
                            <div class="checkbox">
                                <label><input class="checkbox-inline" type="checkbox" name="typesOfClassroom" value="lecture" checked> Lecture</label>
                                <label><input class="checkbox-inline" type="checkbox" name="typesOfClassroom" value="tutorial"> Tutorial</label>
                                <label><input class="checkbox-inline" type="checkbox" name="typesOfClassroom" value="lab"> Lab</label>
                                <label><input class="checkbox-inline" type="checkbox" name="typesOfClassroom" value="workshop"> Workshop</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="classroomCapacity">Capacity</label>
                            <input class="form-control" type="number" name="classroomCapacity" min="10" required />
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
