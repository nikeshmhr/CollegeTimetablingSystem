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
                /** HIGHLIGHTS THE CURRENTLY ACTIVE NAVIGATION **/
                $("#addResource").addClass("active");
            });
            function validateAddModule() {
                var code = $("#moduleCode").val();
                var name = $("#moduleName").val();

                if (code.empty()) {

                }
                if (name.empty()) {

                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <%@include file="includes/navigation.html" %>


            <div class="col-md-5">
                <table class="table table-striped table-hover table-bordered table-responsive">
                    <h2 class="text-primary">List of Modules</h2>
                    <thead>
                        <tr>
                            <th>Module Code</th>
                            <th>Module Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>CC3005NI</td>
                            <td>Software Engineering II</td>
                        </tr>
                        <tr>
                            <td>CC3008NI</td>
                            <td>Current Developments</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-4 col-md-offset-1">
                <h2 class="text-primary">Add new module</h2>
                <form action="#" method="post" role="form" onsubmit="return validateAddModule()">
                    <div class="form-group">
                        <label for="moduleCode">Module Code</label>
                        <input type="text" name="moduleCode" id="moduleCode" class="form-control" maxlength="10" required />
                    </div>

                    <div class="form-group">
                        <label for="moduleName">Module Name</label>
                        <input type="text" name="moduleName" id="moduleName" class="form-control" maxlength="50" required />
                    </div>
                    <div class="form-group">
                        <label for="typesOfClasses">Types of classes</label>
                        <div class="checkbox">
                            <label><input class="checkbox-inline" type="checkbox" name="typesOfClasses" value="lecture"> Lecture</label>
                            <label><input class="checkbox-inline" type="checkbox" name="typesOfClasses" value="tutorial"> Tutorial</label>
                            <label><input class="checkbox-inline" type="checkbox" name="typesOfClasses" value="lab"> Lab</label>
                            <label><input class="checkbox-inline" type="checkbox" name="typesOfClasses" value="workshop"> Workshop</label>
                        </div>
                    </div>
                    
                    <div class="form-group form-inline">
                        <label for="hoursOfClasses">Hours of classes</label>
                        <blockquote>
                            <label>Lecture:</label>
                            <input type="number" style="margin-bottom: 5px;" class="form-control-static input-group col-md-4" step="0.01" min="1" name="lectureHours" id="lectureHours" /><br/>
                            <label>Tutorial:</label>
                            <input type="number" style="margin-bottom: 5px" class="form-control-static input-group col-md-4" step="0.01" min="1" name="tutorialHours" /><br/>
                            <label>Workshop:</label>
                            <input type="number" style="margin-bottom: 5px" class="form-control-static input-group col-md-4" step="0.01" min="1" name="workshopHours" /><br/>
                            <label>Lab:</label>
                            <input type="number" style="margin-bottom: 5px" class="form-control-static input-group col-md-4" step="0.01" min="1" name="labHours" />
                        </blockquote>
                    </div>
                    <div>
                        <input type="submit" name="addModule" value="Add" class="btn btn-success" />
                    </div>
                </form>
            </div>
        </div>
        <p style="height:0;padding:0;margin:0;clear: both;" />
        <%@include file="includes/footer.html" %>
    </body>
</html>
