/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SUBHAM RAJ SINGH
 */
public class DBConnection {
 public static Connection createConnection()
 {
 Connection con = null;
 String url = "jdbc:mysql://localhost:3306/users";
 String username = "root";
 String password1 = "defacto";
  
 try
 {
 try
 {
 Class.forName("com.mysql.jdbc.Driver");
 } 
 catch (ClassNotFoundException e)
 {
 }
  con = DriverManager.getConnection(url, username, password1);
 } 
 catch (Exception e) 
 {
 }
 return con; 
 }
    
}
