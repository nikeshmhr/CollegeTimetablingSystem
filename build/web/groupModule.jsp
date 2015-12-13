<%-- 
    Document   : groupModule
    Created on : Dec 10, 2015, 7:13:01 PM
    Author     : Nikesh
--%>

<%@page import="com.nikesh.scheduler.model.Module"%>
<%@page import="com.nikesh.scheduler.model.Group"%>
<%@page import="com.nikesh.scheduler.model.GroupModule"%>
<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.model.TeacherModule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Group-Module</title>
        <%@include file="includes/headerInclude.html" %>
    </head>
    <body>
        <%@include file="includes/functions.jsp" %>
        <%
            sessionCheck(request, response);
        %>

        <!-- CONTAINER STARTS HERE -->
        <div class="container">
            <%@include file="includes/navigation.html" %>

            <h1 class="h1 text-success" style="text-align: center;">Group Module Relation</h1>

            <!-- DISPLAYS ANY MESSAGE PASSED WITH 'message' ATTRIBUTE -->
            <span
                <% if (request.getAttribute("message") != null) {
                        if (request.getAttribute("status") != null && request.getAttribute("status").equals("200")) {
                            out.println("class=\"label label-success\"");
                        } else {
                            out.println("class=\"label label-danger\"");
                        }
                    }%> >
                <%
                    if (request.getAttribute("message") == null) {
                        out.println("");
                    } else {
                        out.println(request.getAttribute("message"));
                    }
                %>
            </span>

            <%
                List<GroupModule> listOfGroupModule = RetrieveResources.getGroupModule();
                boolean isDataAvailable = false;

                if (!listOfGroupModule.isEmpty()) {
                    isDataAvailable = true;
                }
            %>

            <div class="row">
                <!-- TABLE TO SHOW THE LIST OF ALREADY EXISTING CLASSROOMS -->
                <div class="col-md-7">
                    <table class="table table-striped table-hover table-bordered table-responsive">
                        <h2 class="text-primary">Existing Relations</h2>
                        <thead>
                            <tr>
                                <th>Group Code</th>
                                <th>No of Students</th>
                                <th>Module Name</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (GroupModule groupModule : listOfGroupModule) {

                                    String groupCode = groupModule.getGroup().getGroupCode();
                                    int noOfStudents = groupModule.getGroup().getNoOfStudents();
                                    String identifier = groupModule.getListOfModulesAndItsType().get(0).getIdentifier();
                                    String moduleName = groupModule.getListOfModulesAndItsType().get(0).getModule().getModuleName();
                                    String moduleCode = groupModule.getListOfModulesAndItsType().get(0).getModule().getModuleCode();

                                    String module = moduleName + " (" + moduleCode + ")";

                                        //System.out.println("EXCEPTION FROM teacherModule.jsp " + exe.getMessage());

                            %>
                            <tr>
                                <td><%= (groupCode)%></td>
                                <td><%= (noOfStudents)%></td>
                                <td><%= (module)%></td>
                                <td><a href="DeleteGroupModuleController?id=<%= (identifier)%>"><span class="glyphicon glyphicon-remove" title="Delete"></span></a></td>
                            </tr>
                            <% } %>

                            <%
                                if (!isDataAvailable) {
                                    out.println("<tr><td colspan='4' align='center'>There are no group module relation.</td></tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <!-- END OF CLASSROOM LIST -->
                <!-- START OF FORM TO ADD CLASSROOMS -->
                <div class="col-md-4 col-md-offset-1">
                    <h2 class="text-primary">Create new relation</h2>
                    <form action="GroupModuleController" method="post" role="form">
                        <div class="form-group">
                            <label for="forGroupCode">Group Code: </label>
                            <select name="groupCode" required class="form-control">
                                <option value="">Select ID</option>
                                <%
                                    List<Group> groups = RetrieveResources.getGroups();
                                    for (Group group : groups) {
                                %>                                
                                <option value="<%= (group.getGroupCode())%>"><%= (group.getGroupCode() + " " + "(" + group.getNoOfStudents() + ")")%></option>
                                <% } %>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="modulesList">Select Modules: </label>
                            <select name="moduleId" size="10" required class="form-control" multiple="multiple">
                                <%
                                    List<Module> modules = RetrieveResources.getModules();
                                    if (modules == null || modules.isEmpty()) {
                                        out.println("<option disabled=''>No modules.</option>");
                                    }

                                    for (Module module : modules) {
                                %>

                                <%
                                    String relationString = "";

                                    relationString = module.getModuleCode();
                                %>
                                <option value="<%= relationString%>"><%= module.getModuleName() + " (" + module.getModuleCode() + ")"%></option>

                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div>
                            <%
                                if (!modules.isEmpty() || modules != null) {
                            %>
                            <input type="submit" name="createRelation" value="Create" class="btn btn-success" />
                            <% }%>
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
