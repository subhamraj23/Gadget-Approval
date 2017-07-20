<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request</title>
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
        <div id="info">
            <form method="post" action="RequestServlet">
                
          
        <table width="60%">
            <tr><td><br></td></tr>
            <tr><td style="color:navy;"><B> PRODUCT REQUEST</B><p>Please fill out the form below to request a product.</p></td></tr>
            <tr><td><br></td></tr>
            <tr><td>EMPLOYEE ID :</td><td><input type="text" name="empid" value="<%=String.valueOf(session.getAttribute("Employee"))%>" readonly /></td></tr>
    <tr><td><br></td></tr>
    
    <tr><td>PRODUCT :</td><td><input type="text" name="pname"/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>BUDGET :</td><td><input type="text" name="budget"/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>NEED :</td><td><input type="text" name="need"/></td></tr>
    <tr><td><br></td></tr>
    <tr><td>      </td><td><input  style="color:black;" type="submit" value="Send Request"></td></tr>
    <tr><td><br></td></tr>
    </table>
            </form>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>