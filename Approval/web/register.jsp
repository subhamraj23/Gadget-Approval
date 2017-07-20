<%-- 
    Document   : register
    Created on : May 22, 2017, 8:49:57 AM
    Author     : SUBHAM RAJ SINGH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <div id="outer">
        <jsp:include page="header.jsp"></jsp:include>
            <div id="info">
            <form method="post" action="save">
        <table width="60%">
            <tr><td><br></td></tr>
    <tr><td>Employee ID :</td><td><input type="text" name="empid" required/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>First Name :</td><td><input type="text" name="first_name" required/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>Last Name :</td><td><input type="text" name="last_name" required/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>Manager ID :</td><td><input type="password" name="manid" required/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>City :</td><td><input type="text" name="city"/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>State :</td><td><input type="text" name="state"/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>Zip :</td><td><input type="text" name="zip"/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>Password :</td><td><input type="password" name="password" required/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>Email :</td><td><input type="text" name="email" required/></td></tr>
    <tr><td><br></td></tr>
    <tr><td><br></td></tr>
    <tr><td>      </td><td><input  style="color:orangered;" type="submit" value="Submit"></td></tr>
    </table>
            </form>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
