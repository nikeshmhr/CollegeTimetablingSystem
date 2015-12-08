<%-- 
    Document   : teacherModule
    Created on : Oct 7, 2015, 7:03:37 AM
    Author     : Nikesh
--%>
<%@page import="com.nikesh.scheduler.model.ModuleAndItsType"%>
<%@page import="com.nikesh.scheduler.model.TeacherModule"%>
<%@page import="com.nikesh.scheduler.factory.ClassTypeFactory"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.nikesh.scheduler.util.DatabaseTool"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.nikesh.scheduler.abstractor.ClassType"%>
<%@page import="com.nikesh.scheduler.model.Module"%>
<%@page import="java.util.List"%>
<%@page import="com.nikesh.scheduler.model.Teacher"%>
<%@page import="com.nikesh.scheduler.dao.RetrieveResources"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher-Module</title>
        <%@include file="includes/headerInclude.html" %>
        <script type="text/javascript">
            $(document).ready(function () {
                /** HIGHLIGHTS THE CURRENTLY ACTIVE NAVIGATION **/
                $("#addRelation").addClass("active");
            });

            function validateRelation() {

            }
        </script>
    </head>
    <body>
        <%@include file="includes/functions.jsp" %>
        <%
            sessionCheck(request, response);
        %>


        <%
            /**
             * LIST OF classes that was sent from this page before *
             */
            List<String> selectedClasses = new ArrayList<String>();
            selectedClasses = (ArrayList) request.getAttribute("selectedClasses");

            //out.println(selectedClasses);
        %>

        <!-- CONTAINER STARTS HERE -->
        <div class="container">
            <%@include file="includes/navigation.html" %>

            <h1 class="h1 text-success" style="text-align: center;">Teacher Module Relation</h1>

            <!-- DISPLAYS ANY MESSAGE PASSED WITH 'message' ATTRIBUTE -->
            <span
                <% if (request.getAttribute("message") != null) {
                        out.println("class=\"label label-danger\"");
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
                Connection connection = DatabaseTool.getConnection();
                PreparedStatement s = connection.prepareStatement("SELECT * FROM teacher_modules");
                ResultSet rs = s.executeQuery();
                List<TeacherModule> listOfTeacherModule = new ArrayList<TeacherModule>();
                boolean isDataAvailable = false;
                while (rs.next()) {
                    TeacherModule tM = new TeacherModule();

                    Teacher t = new Teacher();
                    t.setTeacherId(rs.getString("teacherId"));

                    ModuleAndItsType moduleAndItsType = new ModuleAndItsType();

                    Module m = new Module();
                    m.setModuleCode(rs.getString("moduleCode"));
                    ClassType classType = ClassTypeFactory.getClassType(rs.getInt("typeId"));
                    String identifier = rs.getString("identifier");

                    moduleAndItsType.setIdentifier(identifier);
                    moduleAndItsType.setModule(m);
                    moduleAndItsType.setTypeOfClass(classType);

                    isDataAvailable = true;

                    tM.setTeacher(t);
                    tM.getListOfModulesAndItsType().add(moduleAndItsType);

                    listOfTeacherModule.add(tM);
                }
            %>

            <div class="row">
                <!-- TABLE TO SHOW THE LIST OF ALREADY EXISTING CLASSROOMS -->
                <div class="col-md-6">
                    <table class="table table-striped table-hover table-bordered table-responsive">
                        <h2 class="text-primary">Existing Relations</h2>
                        <thead>
                            <tr>
                                <th>Teacher ID</th>
                                <th>Teacher Name</th>
                                <th>Module Name (Type)</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (TeacherModule teacherModule : listOfTeacherModule) {

                                    String teacherId = teacherModule.getTeacher().getTeacherId();
                                    String teacherName = RetrieveResources.getTeacherName(teacherId);
                                    //List<Teacher> listOfTeachers = RetrieveResources.getTeachers();
                                    String moduleCode = teacherModule.getListOfModulesAndItsType().get(0).getModule().getModuleCode();
                                    String moduleName = RetrieveResources.getModuleName(moduleCode);
                                    int typeId = teacherModule.getListOfModulesAndItsType().get(0).getTypeOfClass().getTypeId();
                                    ClassType type = ClassTypeFactory.getClassType(typeId);
                                    moduleName = moduleName + " (" + type.getTypeName() + ")";
                                    String identifier = teacherModule.getListOfModulesAndItsType().get(0).getIdentifier();

                                        //System.out.println("EXCEPTION FROM teacherModule.jsp " + exe.getMessage());

                            %>
                            <tr>
                                <td><%= (teacherId)%></td>
                                <td><%= (teacherName)%></td>
                                <td><%= (moduleName)%></td>
                                <td><a href="DeleteTeacherModuleController?id=<%= (identifier)%>"><span class="glyphicon glyphicon-remove" title="Delete"></span></a></td>
                            </tr>
                            <% } %>

                            <%
                                if (!isDataAvailable) {
                                    out.println("<tr><td colspan='4' align='center'>There are no teacher module relation.</td></tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <!-- END OF CLASSROOM LIST -->
                <!-- START OF FORM TO ADD CLASSROOMS -->
                <div class="col-md-4 col-md-offset-1">
                    <h2 class="text-primary">Create new relation</h2>
                    <form action="TeacherModuleController" method="post" role="form" onsubmit="return validateRelation()">
                        <div class="form-group">
                            <label for="forTeacherId">Teacher Id: </label>
                            <select name="teacherId" required class="form-control">
                                <option value="">Select ID</option>
                                <%
                                    List<Teacher> teachers = RetrieveResources.getTeachers();
                                    for (Teacher teacher : teachers) {
                                %>                                
                                <option value="<%= (teacher.getTeacherId())%>"><%= (teacher.getTeacherName() + " " + "(" + teacher.getTeacherId() + ")")%></option>
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
                                    List<String> existingRelation = RetrieveResources.getExistingIdentifier();
                                    for (Module module : modules) {
                                %>
                                <optgroup label="<%= (module.getModuleName() + " (" + module.getModuleCode() + ")")%>">
                                    <%
                                        List<ClassType> classTypes = RetrieveResources.getClassTypesForModule(module.getModuleCode());
                                        String relationString = "";
                                        for (ClassType type : classTypes) {
                                            relationString = module.getModuleCode() + "_" + type.getTypeId();
                                            if (!existingRelation.contains(relationString)) {

                                    %>
                                    <option value="<%= relationString%>"><%= type.getTypeName() + " (" + type.getClassHours() + ")"%></option>
                                    <%
                                            }
                                        }
                                    %>
                                </optgroup>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div>
                            <% if (!modules.isEmpty()
                                        || modules != null) {%>
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
