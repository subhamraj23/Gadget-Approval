/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author SUBHAM RAJ SINGH
 */
public class RequestDao {
 public String requestProduct(RequestBean requestBean)
 {
     
 String prodname= requestBean.getProdName();
 int empid= requestBean.getEmployeeId();
 //int manid= requestBean.getManagerId();
 //String email= requestBean.getEmail();
// String contact= requestBean.getContact();
 String budget= requestBean.getBudget();
  String need= requestBean.getNeed();
 Connection con = null;
 PreparedStatement ps= null;
 try
 {
 con = DBConnection.createConnection();
 
 
 
 String query = "insert into product(pname,empid,budget,need,raise_date,status) values (?,?,?,?,now(),1)";
 ps= con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
ps.setString(1, prodname);
ps.setInt(2, empid);
//ps.setInt(3, manid);
//ps.setString(4, email);
//ps.setString(5, contact);
ps.setString(3, budget);
ps.setString(4, need);
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
