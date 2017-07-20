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
           
                
          
        <table width="60%">
            <tr><td><br></td></tr>
            <tr><td style="color:green;"><p>Your file has been uploaded.Thank you for your response.</p></td></tr>
            <tr><td><br></td></tr>
         </table>
              
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
