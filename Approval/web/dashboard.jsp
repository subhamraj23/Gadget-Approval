<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
        <div id="outer">
        <jsp:include page="header.jsp"></jsp:include>
               <div id="nav">
               <ul>
               <li class="first">
                 <a href="profile.jsp">PROFILE</a></li>
                 <li><a href="request.jsp">REQUEST</a></li>
                 <li><a href="dashboard.jsp">DASHBOARD</a></li>
                 <li><a href="<%=request.getContextPath()%>/LogoutServlet">LOGOUT</a></li> 
                </ul>
                 <br class="clear" />
                 </div>
               <jsp:include page="/dash" />
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