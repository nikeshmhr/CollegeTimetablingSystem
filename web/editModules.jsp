<%-- 
    Document   : editModules
    Created on : Sep 27, 2015, 9:31:11 PM
    Author     : Nikesh
--%>

<%@page import="com.nikesh.scheduler.abstractor.ClassType"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page import="com.nikesh.scheduler.model.Module"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Edit Modules</title>
        <script>
            $(document).ready(function () {
                $("#editResource").addClass("active");
            });
        </script>

    </head>
    <body>
        <%@include file="includes/functions.jsp" %>
        <%
            sessionCheck(request, response);
        %>
        <div class="container">
            <%@include file="includes/navigation.html" %>

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

            <table class="table table-striped">
                <h2 class="text-primary" style="text-align: center">Edit Modules</h2>
                <thead>
                    <tr>
                        <th>Module Code</th>
                        <th>Module Name</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        List<Module> modules = RetrieveResources.getModules();
                        for (Module m : modules) {
                    %>
                    <tr>
                        <%
                            Set<ClassType> classTypes = m.getTypeOfClasses();
                            String infoString = "";
                            for (ClassType t : classTypes) {
                                infoString += t.getTypeName() + " (" + t.getClassHours() + ") ";
                            }
                        %>
                        <td><%= (m.getModuleCode())%></td>
                        <td><%= (m.getModuleName())%> <span class="text-primary" style="font-style: italic;font-size:90%"><%= (infoString)%></span></td>

                        <td>
                            <a href="#<%= (m.getModuleCode())%>" data-toggle="modal"><span class="glyphicon glyphicon-edit" title="Edit"></span></a> 
                            | 
                            <a href="ModifyModuleController?action=delete&id=<%= (m.getModuleCode())%>"><span class="glyphicon glyphicon-remove" title="Delete"></span></a>
                        </td>
                    </tr>

                <div class="modal fade" tabindex="-1" role="dialog" id="<%= (m.getModuleCode())%>">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="AddModuleController" method="post">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Edit Module</h4>
                                </div>

                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="moduleCode">Module Code</label>
                                        <input type="text" id="moduleCode" class="form-control" maxlength="10" value="<%= (m.getModuleCode())%>" disabled="true" required />
                                        <input type="hidden" name="moduleCode" value="<%= (m.getModuleCode())%>" />
                                    </div>

                                    <div class="form-group">
                                        <label for="moduleName">Module Name</label>
                                        <input type="text" name="moduleName" id="moduleName" class="form-control" maxlength="50" value="<%= (m.getModuleName())%>" required />
                                    </div>
                                    <div class="form-group form-inline">
                                        <label for="hoursOfClasses">Hours of classes</label>
                                        <blockquote>
                                            <%
                                                Set<ClassType> typeOfClasses = m.getTypeOfClasses();
                                                for (ClassType type : typeOfClasses) {
                                            %>
                                            <label><%= (type.getTypeName())%>:</label>
                                            <input type="number" style="margin-bottom: 5px;" class="form-control input-group col-md-4" step="0.1" min="1" name="<%= (type.getTypeName().toLowerCase()) + "Hours"%>" placeholder="0" value="<%= (type.getClassHours())%>" /><br/>
                                            <%
                                                }
                                            %>

                                        </blockquote>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="operation" value="update" />
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                    <input type="submit" value="Save changes" class="btn btn-success" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <% } %>

                <% if (modules == null || modules.isEmpty()) {%>
                <tr>
                    <td colspan="3" style="text-align: center">There are no modules.</td>
                </tr>
                <% }%>
                </tbody>
            </table>

        </div>
        <!-- END OF CONTAINER -->

        <%@include file="includes/footer.html" %>
    </body>
</html>
