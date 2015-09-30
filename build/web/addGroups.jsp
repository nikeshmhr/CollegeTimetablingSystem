<%-- 
    Document   : addGroups
    Created on : Sep 30, 2015, 6:36:42 PM
    Author     : Nikesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Add Groups</title>
        <script type="text/javascript">
            $(document).ready(function () {
                /** HIGHLIGHTS THE CURRENTLY ACTIVE NAVIGATION **/
                $("#addResource").addClass("active");
            });

            function validateAddGroups() {

            }
        </script>
    </head>
    <body>
        <!-- CONTAINER STARTS HERE -->
        <div class="container">
            <%@include file="includes/navigation.html" %>

            <div class="row">
                <!-- TABLE TO SHOW THE LIST OF ALREADY EXISTING GROUPS -->
                <div class="col-md-5">
                    <table class="table table-striped table-hover table-bordered table-responsive">
                        <h2 class="text-primary">List of Groups</h2>
                        <thead>
                            <tr>
                                <th>Group Code</th>
                                <th>No. of Students</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>L1C1</td>
                                <td>32</td>
                            </tr>
                            <tr>
                                <td>L3C4</td>
                                <td>40</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- END OF GROUPS LIST -->
                <!-- START OF FORM TO ADD GROUPS -->
                <div class="col-md-4 col-md-offset-1">
                    <h2 class="text-primary">Add new groups</h2>
                    <form action="#" method="post" role="form" onsubmit="return validateAddGroups()">
                        <div class="form-group">
                            <label for="groupCode">Group Code</label>
                            <input type="text" name="groupCode" id="groupCode" class="form-control" maxlength="10" required />
                        </div>

                        <div class="form-group">
                            <label for="noOfStudents">No. of Students</label>
                            <input type="number" name="noOfStudents" id="noOfStudents" class="form-control" min="10" max="50" required />
                        </div>
                        <div>
                            <input type="submit" name="addGroup" value="Add" class="btn btn-success" />
                        </div>
                    </form>
                </div>
                <!-- END OF ADD GROUPS FORM -->
            </div>
            <!-- END OF ROW -->
        </div>
        <!-- CONTAINER ENDS HERE -->

        <!-- A FOOTER -->
        <%@include file="includes/footer.html" %>
    </body>
</html>
