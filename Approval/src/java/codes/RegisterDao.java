/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author SUBHAM RAJ SINGH
 */
public class RegisterDao {
     public String registerUser(RegisterBean registerBean)
 {
 String firstname= registerBean.getFirstName();
 String lastname= registerBean.getLastName();
 int manid= registerBean.getManagerId();
 int empid= registerBean.getEmployeeId();
 String city= registerBean.getCity();
 String state= registerBean.getState();
 int zip= registerBean.getZip();
 String passw= registerBean.getPassword();
 
 String email= registerBean.getEmail();
  
 Connection con = null;
 PreparedStatement ps= null;
  
 try
 {
 con = DBConnection.createConnection();
 String query = "insert into employee(first_name,last_name,manid,empid,city,state,zip,password,email) values (?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
 ps= con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
ps.setString(1, firstname);
ps.setString(2, lastname);
ps.setInt(3, manid);
ps.setInt(4, empid);
ps.setString(5, city);
ps.setString(6, state);
ps.setInt(7, zip);
ps.setString(8, passw);
ps.setString(9, email);
  
 int i= ps.executeUpdate();
  
 if (i!=0) 
 return "SUCCESS"; 
 }

 catch(SQLException e)
 {
 }
 return "Oops.. Something went wrong there..!";
 }
}

