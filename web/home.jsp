<%-- 
    Document   : home
    Created on : Sep 27, 2015, 8:29:52 PM
    Author     : Nikesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/headerInclude.html" %>
        <title>Scheduler</title>
    </head>
    <body>
        <%@include file="includes/functions.jsp" %>
        <%
            sessionCheck(request, response);
        %>
        <div class="container">
            <%@include file="includes/navigation.html" %>
            <div class="jumbotron">
                <h1>Scheduler</h1>
                <p>A Scheduler is a simple college timetabling system that carries out the scheduling activity of course timetables.</p>
            </div>

            <div class="panel-group" id="accordion">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1" class="accordion-dropdown">
                                How to use?
                            </a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <h4>Step 1: Add resources (for all)</h4>
                            <p>Add the resources that are available in the college like rooms, groups, modules, teachers.</p>
                            
                            <h4>Step 2: Edit resources (only if any)</h4>
                            <p>This step is only required if you have anything to change from the existing resources. Otherwise please proceed to the next step.</p>
                            
                            <h4>Step 3: Add relation</h4>
                            <p>The two kinds of relation you can add. <i>TeacherModule</i> to create a relation between teacher and module he/she taughts. <i>GroupModule</i> to create a relation between group and module that they are studying.</p>
                            
                            <h4>Step 4: Generate</h4>
                            <p>After all the resources are added and relations are mapped for them. The final step is to navigate through generate menu and generate the timetable.</p>
                        </div>
                    </div>
                </div>
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2" class="accordion-dropdown">
                                Watch</a>
                        </h4>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        <div class="panel-body">
                            <video src=""></video>
                        </div>
                    </div>
                </div>
                <!--<div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse3" class="accordion-dropdown">
                                Collapsible Group 3</a>
                        </h4>
                    </div>
                    <div id="collapse3" class="panel-collapse collapse">
                        <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
                            minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                            commodo consequat.</div>
                    </div>
                </div>-->
            </div>
        </div>
        <%@include file="includes/footer.html" %>


    </body>
</html>
