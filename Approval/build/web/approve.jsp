<%-- 
    Document   : approve
    Created on : May 26, 2017, 10:56:19 AM
    Author     : SUBHAM RAJ SINGH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>WELCOME TO APPROVAL GADGET SYSTEM</title> 
    <meta name="description" content="gamedrone app">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/cosmo/bootstrap.min.css"/>
    
</head>
<body> 
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
      <a class="navbar-brand col-md-offset-4" href="index.jsp">Home</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <div class="col-md-offset-2">
        <ul class="nav navbar-nav">
          <li><a href="dashboard.jsp" class="navbar-brand">Dashboard</a></li>
          <li><a href="profile.jsp" class="navbar-brand">Profile</a></li>
          <li><a href="request.jsp" class="navbar-brand">Request</a></li>
        </ul>
        </div>
    <!-- /.navbar-collapse -->
        <div class="col-md-offset-10">
           <ul class="nav navbar-nav">
           
          
               <li><a href="<%=request.getContextPath()%>/LogoutServlet">Log out</a></li> 
               <!--a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
               <!%=request.getAttribute("userName") %><span class="caret"></span></a>
             <!--ul class="dropdown-menu">
               <li><a href="<!%=request.getContextPath()%>/LogoutServlet">Log out</a></li>
             </ul-->
           
           </ul>
        </div>
    </div>
  </div><!-- /.container-fluid -->
</nav>
<div class="container" style=" margin-top: 100px ;">
    <div class="row">
      <!-- left column -->
      <!--div class="col-md-3">
        <div class="text-center">
          <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">
          <h6>Upload a different photo...</h6>
          
          <input type="file" class="form-control">
        </div>
      </div-->
      
      <!-- edit form column -->
      <div class="col-md-9 personal-info">
        <div class="alert alert-success alert-dismissable">
          <a class="panel-close close" data-dismiss="alert"></a> 
          <i class="fa fa-coffee"></i>
          Your product has been validated.
        </div>
      </div>
    </div>
</div>
    
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
</body> 
</html> 
