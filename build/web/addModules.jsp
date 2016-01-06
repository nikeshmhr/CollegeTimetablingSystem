<%-- 
    Document   : addModules
    Created on : Sep 27, 2015, 8:27:31 PM
    Author     : Nikesh
--%>

<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.model.Module"%>
<%@page import="java.util.Set"%>
<%@page import="com.nikesh.scheduler.abstractor.ClassType"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.nikesh.scheduler.util.DatabaseTool"%>
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

                $("#classType2").hide();
                $("#classType3").hide();
                $("#classType4").hide();
            });

            /** Check to see if everything is fine **/
            function validateAddModule() {
                var checkedList = getCheckedClasses();

                for (var i = 0; i < checkedList.length; i++) {
                    var checkedValue = checkedList[i];
                    var checkedHourseValue = document.getElementById("classType" + checkedValue).value;
                    if (checkedHourseValue <= 0) {
                        document.getElementById("classType" + checkedValue).focus();
                        return false;
                    }
                }
                return true;
            }

            /** Returns value of all the checked items (currently) **/
            function getCheckedClasses(obj) {
                /*var checked = Array();
                 var i = document.getElementsByName("typesOfClasses");
                 var k = 0;
                 for (var j = 0; j < i.length; j++) {
                 if (i[j].checked === true) {
                 checked[k++] = i[j].value;
                 }
                 }*/

                //var classes = {"classType1", "classType2", "classType3", "classType4"};
                var item = obj.value;
                switch (item) {
                    case "2":
                        if (obj.checked) {
                            $("#classType2").show();
                        } else {
                            $("#classType2").hide();
                        }
                        break;

                    case "3":
                        if (obj.checked) {
                            $("#classType3").show();
                        } else {
                            $("#classType3").hide();
                        }
                        break;

                    case "4":
                        if (obj.checked) {
                            $("#classType4").show();
                        } else {
                            $("#classType4").hide();
                        }
                        break;
                }

                //return checked;
            }
        </script>
    </head>
    <body>
        <%@include file="includes/functions.jsp" %>
        <%
            sessionCheck(request, response);
        %>      
        <!-- CONTAINER STARTS HERE -->
        <div class="container">
            <%@include file="includes/navigation.html" %>

            <span <% if (request.getAttribute("addMessage") != null) {
                    if (request.getAttribute("status") != null && request.getAttribute("status").equals("200")) {
                        out.println("class=\"label label-success\"");
                    } else {  
                        out.println("class=\"label label-danger\"");
                    }
                }%> >
                <%
                    if (request.getAttribute("addMessage") == null) {
                        out.println("");
                    } else {
                        out.println(request.getAttribute("addMessage"));
                    }
                %>
            </span>

            <%
                List<Module> modules = RetrieveResources.getModules();
            %>

            <div class="row">
                <!-- TABLE TO SHOW THE LIST OF ALREADY EXISTING MODULES -->
                <div class="col-md-6">
                    <table class="table table-striped table-hover table-bordered table-responsive">
                        <h2 class="text-primary">List of Modules</h2>
                        <thead>
                            <tr>
                                <th>Year</th>
                                <th>Sem</th>
                                <th>Module Code</th>
                                <th>Module Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%                                
                                boolean isEmpty = modules.isEmpty();
                                for (Module m : modules) {
                                    String moduleCode = m.getModuleCode();
                                    String moduleName = m.getModuleName();
                                    int year = m.getYear();
                                    int sem = m.getSem();
                            %>
                            <tr>
                                <%
                                    Set<ClassType> classTypes = m.getTypeOfClasses();
                                    String infoString = "";
                                    for (ClassType t : classTypes) {
                                        infoString += t.getTypeName() + " (" + t.getClassHours() + ") ";
                                    }
                                %>
                                <td><%= (year) %></td>
                                <td><%= (sem) %></td>
                                <td><%= (moduleCode)%></td>
                                <td><%= (moduleName)%> <span class="text-primary" style="font-style: italic;font-size:90%"><%= (infoString)%></span></td>
                            </tr>
                            <% }%>

                            <%
                                if (isEmpty) {
                                    out.println("<tr><td colspan='2' align='center'>There are no modules.</td></tr>");
                                }
                            %>
                            <!--<tr>
                                <td>CC3008NI</td>
                                <td>Current Developments</td>
                            </tr>-->
                        </tbody>
                    </table>
                </div>
                <!-- END OF MODULES LIST -->

                <!-- START OF FORM TO ADD MODULES -->
                <div class="col-md-4 col-md-offset-1">
                    <h2 class="text-primary">Add new module</h2>
                    <form action="AddModuleController" name="addModulesForm" method="post" role="form" onsubmit="return validateAddModule();">
                        <div class="form-group">
                            <label for="year">Year</label>
                            <input type="number" id="year" class="form-control" min="1" max="3" value="3" disabled="disabled" required />
                            <input type="hidden" name="year" value="3" />
                        </div>
                        
                        <div class="form-group">
                            <label for="semester">Semester</label>
                            <input type="number" name="semester" id="semester" class="form-control" min="1" max="2" required />
                        </div>
                        
                        <div class="form-group">
                            <label for="moduleCode">Module Code</label>
                            <input type="text" name="moduleCode" id="moduleCode" class="form-control" maxlength="10" required />
                        </div>

                        <div class="form-group">
                            <label for="moduleName">Module Name</label>
                            <input type="text" name="moduleName" id="moduleName" class="form-control" maxlength="50" required />
                        </div>
                        <div class="form-group">
                            <label for="classTypes">Types of classes</label>
                            <div class="checkbox">
                                <label><input class="checkbox-inline" type="checkbox" name="typesOfClasses" value="1" required checked onclick="getCheckedClasses(this);"> Lecture</label>
                                <label><input class="checkbox-inline" type="checkbox" name="typesOfClasses" value="2" onclick="getCheckedClasses(this);"> Tutorial</label>
                                <label><input class="checkbox-inline" type="checkbox" name="typesOfClasses" value="3" onclick="getCheckedClasses(this);"> Lab</label>
                                <label><input class="checkbox-inline" type="checkbox" name="typesOfClasses" value="4" onclick="getCheckedClasses(this);"> Workshop</label>
                            </div>
                        </div>

                        <div class="form-group form-inline">
                            <label for="hoursOfClasses">Hours of classes</label>
                            <blockquote>
                                <label id="classType1">Lecture:</label>
                                <input type="number" style="margin-bottom: 5px;" class="form-control input-group col-md-4" step="0.1" min="1" name="lectureHours" placeholder="0" required  />
                                <div id="classType2">
                                    <label>Tutorial:</label>
                                    <input type="number" style="margin-bottom: 5px" class="form-control input-group col-md-4" step="0.1" min="1" name="tutorialHours" placeholder="0"  />
                                </div>
                                <div id="classType3">
                                    <label>Lab:</label>
                                    <input type="number" style="margin-bottom: 5px" class="form-control input-group col-md-4" step="0.1" min="1" name="labHours" placeholder="0"   />
                                </div>
                                <div id="classType4">
                                    <label>Workshop:</label>
                                    <input type="number" style="margin-bottom: 5px" class="form-control input-group col-md-4" step="0.1" min="1" name="workshopHours" placeholder="0" />
                                </div>
                            </blockquote>
                        </div>
                        <div>
                            <input type="submit" name="addModule" value="Add" class="btn btn-success" />
                        </div>
                    </form>
                </div>
                <!-- END OF ADD MODULES FORM -->
            </div>
            <!-- END OF ROW -->
        </div>
        <!-- CONTAINER ENDS HERE -->

        <!-- A FOOTER -->
        <%@include file="includes/footer.html" %>
    </body>
</html>
