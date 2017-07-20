<%-- 
    Document   : index
    Created on : May 23, 2017, 9:29:50 AM
    Author     : SUBHAM RAJ SINGH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
         
    </head>
    <body>
        <div id="outer">
        <jsp:include page="header.jsp"></jsp:include>
        <div id="info">
        <form method="post" action="LoginServlet">
        <table width="60%">
        <tr><td><br></td></tr>
        <tr><td>Employee ID :</td><td><input type="text" class="form-control" name="username" placeholder="Enter employee id" required> </td></tr>
        <tr><td><br></td></tr>
        <tr><td>Password :</td><td><input type="password" class="form-control" name="password" placeholder="Enter Password" required></td></tr>
        <tr><td><br></td></tr>
        <tr>
        <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
        </tr> 
        <tr><td>      </td><td><input  style="color:green;" type="submit" value="Submit"></td></tr>
        <tr><td><br></td></tr>
        <tr><td>      </td><td><div class="col-md-9 col-md-offset-3">Not Registered?<a href="register.jsp">Register here</a></div>  </td></tr>
        </table>
        </form>
        </div>
        
         <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    </body>
</html>
