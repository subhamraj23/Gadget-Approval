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
        <title>Home Page</title>
        <link rel="Stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <div id="outer">
            <div id="header">
                <div id="logo">
                  <table>
                      <tr><td><img src="images/tata.jpe" alt="" width="95" height="84" /></td><td>     </td>
                    <td><h1>TATA TECHNOLOGIES LIMITED</h1>
                    <h2>GADGET APPROVAL SYSTEM</h2></td></tr>
                </table>
                </div>
            </div>
            
            <table>
                <tr><img src="images/gadget.jpg" alt=""  width="1080" height="350"/></tr>
            </table>
        <div id="nav">
            <ul>
            <li class="first">
    <a href="login.jsp">LOGIN</a></li>
    <li><a href="register.jsp">USER REGISTRATION</a></li>
    <li><a href="login.jsp">REQUEST</a></li>
    <li><a href="login.jsp">DASHBOARD</a></li>
    </ul>
    <br class="clear" />
    </div>
            
                                        <% 
					if(request.getAttribute("notlogin_msg")!=null){
					out.print("<font size='2' color='red' m>");
					out.print(request.getAttribute("notlogin_msg"));
					out.print("</font>");
					}
					%>
                                        

				
				
				
                                        <% 
					if(request.getAttribute("Error")!=null){
					out.print("<font size='2' color='red' m>");
					out.print(request.getAttribute("Error"));
					out.print("</font>");
					}
					%>
        <!--div id="info">
    <form method="post" action="Login Process.jsp">    
    <table>
    <tr><td><br></td></tr>
    <tr><td style="color:navy;"><B> Login Form</B></td></tr>
    <tr><td><br></td></tr>
    <tr><td>Employee ID:</td><td><input type="text" name="empid"/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>Password:</td><td><input type="password" name="userpass"/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>      </td><td><input  style="color:orangered;" type="submit" value="Sign in"></td></tr>
    
    <tr><td><br></td></tr>
    </table>
    </form>
            </div-->
        <br>
        <div id="footer">
            <table width="90%">
                <tr><td>TATA TECHNOLOGY</td><td> COMPANY</td><td> RESOURCES</td></tr>
                <tr><td><br></td></tr>
            <tr><td>The Tata Technologies Platform </td><td>  Contact Us</td><td>Support </td></tr>
            <tr><td><br></td></tr>
            <tr><td>Provides employee meeting tools and</td><td>  Customer</td><td>FAQ </td></tr>
            <tr><td><br></td></tr>
            <tr><td>workplace analytics to improve</td><td> Company</td><td> Blog</td></tr>
            <tr><td><br></td></tr>
            <tr><td>how people,places and</td><td>Security </td><td>White Papers </td></tr>
            <tr><td><br></td></tr>
            <tr><td> Technology works together.</td><td>Careers </td><td>Press </td></tr>
            <tr><td><br></td></tr>
            
            
            </table>
        </div>
            </div>
    </body>
</html>
