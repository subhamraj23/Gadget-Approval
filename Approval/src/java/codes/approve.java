/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import static java.time.Instant.now;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SUBHAM RAJ SINGH
 */
public class approve extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             String selectedValue=request.getParameter("decide");
        String remark=request.getParameter("rem");
        int n=Integer.parseInt(request.getParameter("sr"));
       //  System.out.println("Selected Value is: "+n);
      //  System.out.println("Selected Value is: "+selectedValue);
        int state = 0;
        if(selectedValue.equals("APPROVE"))
            state=2;
        else if(selectedValue.equals("DISAPPROVE"))
            state=3;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps= null;
        String url = "jdbc:mysql://localhost:3306/";
        String db = "users";
        String driver = "com.mysql.jdbc.Driver";
        try{
          Class.forName(driver);
          con = DriverManager.getConnection(url+db,"root","defacto");
          try{
          Statement st = con.createStatement();
          String query="UPDATE product SET status=?,decision=?,remark=?,decdate=now() where SRNO='"+n+"'";
           ps= con.prepareStatement(query);
           ps.setInt(1, state);
           ps.setString(2, selectedValue);
           ps.setString(3, remark);
         int val=ps.executeUpdate();
          if(val!=0)
          {
               request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
          }
        //  else { request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
        //  }
          }
           catch (SQLException s){
           System.out.println("SQL statement is not executed!");
          }
          }
        catch(Exception e){}
            
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
        processRequest(request, response);
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
        processRequest(request, response);
       
    
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
