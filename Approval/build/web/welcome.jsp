<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        
        <%
           // HttpSession session=request.getSession();
            String n=String.valueOf(session.getAttribute("Employee"));
            int k=0;
            k=Integer.parseInt(n);
            String url = "jdbc:mysql://localhost:3306/";
            String db = "users";
            String driver = "com.mysql.jdbc.Driver";
            

            try {
            Class.forName(driver);
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
            }

            Connection con = null;
            Statement statement = null;
            ResultSet resultSet = null;
        %>
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
        
        <!--div id="info">
        <table width="60%"-->
             <%
                try{ 
                 con = DriverManager.getConnection(url+db,"root","defacto");
                statement=con.createStatement();
                String sql ="SELECT * FROM employee where empid='"+k+"'";

                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
            %>
             <div class="panel-heading" style="border-radius: 0 0 0px 0px; box-shadow: 0 0 0px  #00ff00;">
                      <center><p style="font-size:150%; margin-right: 85%;">Account Details</p></center>
                <hr/>
                <table>
                    <tr><td class="bold" style="font-size:150% ;"> Employee ID :</td><td style="font-size:150%; display:inline-block; 
       margin-left: 40%;"><%=resultSet.getInt("empid") %></td>
                    <tr><td class="bold" style="font-size:150% ;" > Name :</td><td style="font-size:150%; display:inline-block; 
       margin-left: 40%;"><%=resultSet.getString("first_name") %></td></tr><br/>
                    <tr><td class="bold" style="font-size:150%;" > Manager ID :</td><td style="font-size:150%;display:inline-block; 
       margin-left: 40%;"><%=resultSet.getInt("manid") %></td></tr>                    
                    <tr><td class="bold" style="font-size:150%;" > Email :</td><td style="font-size:150%;display:inline-block; 
       margin-left: 40%;"><%=resultSet.getString("email") %></td></tr>
                </table><br/>
            </div>
                
            <% 
                }

                } catch (Exception e) {
                e.printStackTrace();
                }
            %>
    
          
            
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
