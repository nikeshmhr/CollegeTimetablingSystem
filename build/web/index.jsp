<%-- 
    Document   : index
    Created on : Sep 27, 2015, 6:44:19 PM
    Author     : Nikesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css" />
        <link rel="stylesheet" href="styles/main.css" type="text/css" />
        <title>College Timetabling System</title>
    </head>
    <body>
        <div class="container">
            <!-- HELPS TO CENTER THE LOGIN FORM -->
            <div class="col-md-3">
                &nbsp;
            </div>
            
            <!-- LOGIN FROM STARTS FROM HERE -->
            <div class="col-md-5 well">
                <form action="" method="post" role="form" style="padding: 20px;">
                    
                    <h1 class="caption">Login</h1>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <input type="text" name="username" placeholder="Username" required class="form-control input-lg" />

                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-md-12 form-group">

                                <input type="password" name="password" placeholder="Password" required class="form-control input-lg" />
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <input type="submit" name="login" value="Login" class="btn btn-success form-control" />
                            </div>
                        </div>
                    
                </form>
            </div>
            <!-- LOGIN FORM ENDS HERE -->
        </div>
    </body>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</html>
