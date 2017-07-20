/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SUBHAM RAJ SINGH
 */
public class LoginDao {
    public String authenticateUser(LoginBean loginBean) throws SQLException
 {
 
String userName = loginBean.getUserName(); //Keeping user entered values in temporary variables.
String password = loginBean.getPassword();
 
Connection con = null;
Statement statement = null;

ResultSet resultSet = null;
 
String userNameDB = "";
String passwordDB = "";
 


 con = DBConnection.createConnection(); //establishing connection

 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
 resultSet = statement.executeQuery("select empid,password from employee"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
 
while(resultSet.next()) // Until next row is present otherwise it return false
 {
  userNameDB = resultSet.getString("empid"); //fetch the values present in database
  passwordDB = resultSet.getString("password");
 
   if(userName.equals(userNameDB) && password.equals(passwordDB))
   {
      return "Employee"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
   }
 }
 return "Invalid user credentials"; // Just returning appropriate message otherwise
 }
    
}
