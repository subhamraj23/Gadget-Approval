/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SUBHAM RAJ SINGH
 */
public class Cancellation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                   HttpSession session=request.getSession(false);
                  String n=String.valueOf(session.getAttribute("Employee"));
                   int k=Integer.parseInt(n);
                   String from="";
                    Connection con1 = null;
                    PreparedStatement ps= null;
                    ResultSet rr=null;
                    String url = "jdbc:mysql://localhost:3306/";
                    String db = "users";
                    String driver = "com.mysql.jdbc.Driver";
                    Class.forName(driver);
                    con1 = DriverManager.getConnection(url+db,"root","defacto");
                    Statement st = con1.createStatement();
                    rr=st.executeQuery("select email from employee where empid='"+k+"'");     
                    while(rr.next())
                    {
                        from=rr.getString("email");
                    }
            System.out.println(from);
            
            
         final String username="jsrsingh2018@gmail.com"; 
         final String password="defactoraj2015";
          Properties props = new Properties(); 
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.starttls.enable", "true");
          props.put("mail.smtp.host", "smtp.gmail.com");           
          props.put("mail.smtp.port", "587");
          Session session1 = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
            }
          });
          try{
              
       
         Message message = new MimeMessage(session1); // Create a default MimeMessage object.
         message.setFrom(new InternetAddress("jsrsingh2018@gmail.com"));  // Set From: header field of the header.
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(from)); // Set To: header field of the header.
          message.setSubject("Product Rejected"); 
          message.setText("Dear Sir, "
                  +"\n"
                  +"\n"
                  + "This is to inform you that the product requested by you has been disapproved due to certain discrepancies in the product."
                  + "We are sorry for the inconvenience.");
          Transport.send(message);
          System.out.println("Was the email sent :Done");
             RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dashboard.jsp");
           requestDispatcher.forward(request, response);
          }
           catch (MessagingException mex)
          {
             mex.printStackTrace();
          }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cancellation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cancellation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cancellation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cancellation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
