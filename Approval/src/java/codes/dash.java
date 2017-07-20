/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SUBHAM RAJ SINGH
 */
public class dash extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
       response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session=request.getSession(false);
            String n=String.valueOf(session.getAttribute("Employee"));
            Connection con = null;
            Statement stmt = null;
            Statement st = null;
             ResultSet rs = null;
            ResultSet rr=null;
            try{
                con = DBConnection.createConnection();
         
                 stmt=con.createStatement();
                 st=con.createStatement();
                
                  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Dashboard</title>");   
            out.println("</head>");
            out.println("<body>");
           
            out.println("<div class=\"container\" style=\" margin-top: 10px ;\">");
            out.println("<h2>Gadgets</h2>");
            out.println("<table style=\"color:black\" border='2'>");
         
            out.println("<tr bgcolor='darkblue' style=\"color:yellow;\" ><td>Serial Number</td><td>Gadget Name</td><td>Employee ID</td><td>Gadget's Cost</td><td>Request Raise Date</td>");
            out.println("<td>Need for this Gadget</td><td>Status</td><td>Decision</td><td>Decision Date</td>");
            out.println("<td>Remark</td><td>File Upload</td><td>Options</td>");
        
            int e=0,s=0,m=0,c=0;
            String gname="";
            String gcost="";
            String gneed="";
            String d="";
            String rem="";
            String dd="";
            String deci="";
            int k=0;
            k=Integer.parseInt(n);
            rs=stmt.executeQuery("select * from product"); 
            while(rs.next())
            {
                e=rs.getInt("empid");     
                s=rs.getInt("SRNO");     
                gname=rs.getString("pname");
                gcost=rs.getString("budget");
                gneed=rs.getString("need");
                d=rs.getString("raise_date");
                c=rs.getInt("status");
                deci=rs.getString("decision");     
                rem=rs.getString("remark");
                dd=rs.getString("decdate");
                out.println("<tr><td>"+s+"</td><td>"+gname+"</td><td>"+e+"</td><td>"+gcost+"</td><td>"+d+"</td><td>"+gneed+"</td>");
                if(c==1)
                {
                    out.println("<td bgcolor='yellow'>REQUEST</td>");
                }
                else if(c==2)
                {
                    out.println("<td bgcolor='red'>APPPROVED</td>");
                }
                else if(c==3)
                {
                    out.println("<td bgcolor='purple'>REJECTED</td>");
                }
                else if(c==4)
                {
                    out.println("<td bgcolor='greenyellow'>UPLOADED</td>");
                }
                 else if(c==5)
                {
                    out.println("<td bgcolor='red'>APPROVED</td>");
                }
                 rr=st.executeQuery("select manid from employee where empid='"+e+"'"); 
                 int flag=0;
                 while(rr.next())
                 {
                    m=rr.getInt("manid");
                    if(m==k)
                    {
                            if(deci == null)
                               {
                               out.println("<form action=\"approve\" method=\"post\">");
                               out.println("<input type='hidden' name='sr' value='"+s+"'");
                               out.println("<td>--</td>");                               
                               out.println("<td><select name=\"decide\" id=\"decide\">\n" +
                               "<option value=\"APPROVE\">APPROVE</option>\n" +
                               "<option value=\"DISAPPROVE\">DISAPPROVE</option>\n" +
                                
                                
                               "</select></td>");
                             
                               out.println("<td>--</td>");                               
                               out.println("<td><input type=\"text\" class=\"form-control\" name=\"rem\" id=\"rem\"></td>");
                               out.println("<td>--</td>");
                               out.println("<td><input type=\"submit\" style=\"color:purple;\" value=\"Submit\"></td>");
                               out.println("</form>");
                               }
                        else  if(c==2)
                               {
                                   out.println("<td>"+deci+"</td>");
                                   out.println("<td>"+dd+"</td>");
                                   out.println("<td>"+rem+"</td>");
                                  // if(c==2)
                                   out.println("<td>FILE NOT UPLOADED</td>");
                                   out.println("<td>--</td>");
                               }
//Download the file functn will be here
                         else if(c==4)
                                   {
                                   
                               out.println("<td>"+deci+"</td>");
                               out.println("<td>"+dd+"</td>");
                               out.println("<td>"+rem+"</td>");         
                               out.println("<form action='DownloadServlet' method='POST'>");
                              out.println("<input type='hidden' name='sr' value='"+s+"'");
                              out.println("<td>--</td>");
                              //out.println("<td><input type='SUBMIT' name='SUBMIT' value='DOWNLOAD' class=\\\"btn btn-info\\\"></td></form>");
                              out.println("<td><input type=\"submit\" style=\"color:green;\" value=\"Download Bill\" /></td></form>");   
                              out.println("<td>--</td>");
                              }
                         else if(c==3){
                                  out.println("<td>"+deci+"</td>");
                                   out.println("<td>"+dd+"</td>");
                                   out.println("<td>"+rem+"</td>");
                                   out.println("<td>--</td>");
                                   out.println("<td>--</td>");
                                }
                       /*  else if(c==5)
                         {
                                   out.println("<td>"+deci+"</td>");
                                   out.println("<td>"+dd+"</td>");
                                   out.println("<td>"+rem+"</td>");
                                   out.println("<td><input type=\"submit\" style=\"color:green;\" value=\"Download Bill\" /></td>");
                                   out.println("<td>--</td>"); 
                         }*/
                     
                      }
                    }
                 if(k==e)
                       {
//                         out.println("mit");
                          if(c==1)
                          {
                              out.println("<form action='Cancellation' method='POST'>");
                              out.println("<input type='hidden' name='sr' value='"+s+"'");
                              out.println("<td>--</td>");
                              out.println("<td>--</td>");
                              out.println("<td>--</td>");
                              out.println("<td>--</td>");
                              out.println("<td>--</td>");
                         //   out.println("<td><a href='s2.jsp'>Cancel</a></td>");
                              out.println("<td><input type='SUBMIT' style=\"color:green;\" name='SUBMIT' value='CANCEL'></td></form>");
                              
                          }
                          if(c==2)
                          {
                              out.println("<td>Approved</td>");
                              if(dd==null)
                                  out.println("<td>--</td>");
                              else
                              out.println("<td>"+dd+"</td>");
                              if(rem==null)
                                  out.println("<td>--</td>");
                              else
                              out.println("<td>"+rem+"</td>");
                              out.println("<form action='UploadServlet' method='POST' enctype=\"multipart/form-data\">");
                               out.println("<input type='hidden' name='sr' value='"+s+"'");
                              out.println("<td></td>");
                              out.println("<td><input type='file' name='filet' id='filet' style=\"color:blue;\"></td>"); 
                             out.println("<td><input type=\"submit\" value=\"Upload Bill\" style=\"color:purple;\"/></td>");
                              out.println("</form>");
                          }
                          if(c==3)
                          {
                              out.println("<td>Disapproved</td>");
                              if(dd==null)
                                  out.println("<td>--</td>");
                              else
                              out.println("<td>"+dd+"</td>");
                              if(rem==null)
                                  out.println("<td>--</td>");
                              else
                              out.println("<td>"+rem+"</td>");
                              out.println("<td>--</td>");
                              out.println("<form action='Cancellation' method='POST'>");
                            //  out.println("<input type='hidden' name='sr' value='"+s+"'");
                              out.println("<td><input type='SUBMIT' style=\"color:green;\" name='SUBMIT' value='CANCEL'></td></form>");
                          }
                          if(c==4)
                          {
                              out.println("<td>Approved</td>");
                              if(dd==null)
                                  out.println("<td>--</td>");
                              else
                              out.println("<td>"+dd+"</td>");
                              if(rem==null)
                                  out.println("<td>--</td>");
                              else
                              out.println("<td>"+rem+"</td>");
                              out.println("<td>FILE UPLOADED</td>");
                              out.println("<td>--</td>");                              
                          }
                         /* if(c==5)
                          {
                              out.println("<td>Approved</td>");
                              if(dd==null)
                                  out.println("<td>--</td>");
                              else
                              out.println("<td>"+dd+"</td>");
                              if(rem==null)
                                  out.println("<td>--</td>");
                              else
                              out.println("<td>"+rem+"</td>");
                              out.println("<td>FILE UPLOADED</td>");
                              out.println("<td>--</td>");  
                          }*/
                       }
                 else if((k!=e)&&(k!=m))
                       {
                              if(deci==null)
                                  out.println("<td>--</td>");
                              else
                              out.println("<td>"+deci+"</td>");
                              if(dd==null)
                                  out.println("<td>--</td>");
                              else
                              out.println("<td>"+dd+"</td>");
                              if(rem==null)
                                  out.println("<td>--</td>");
                              else
                            out.println("<td>"+rem+"</td>");                           
                            out.println("<td>--</td>");
                            out.println("<td>--</td>");
                       }
                  out.println("</tr>");
                 }
              
                 
                
         
            }

            
            catch (Exception e)
            {}
            finally
            {
            try
            {con.close();}
            catch(Exception ee)
            {}
            out.println("<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
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
        } catch (SQLException ex) {
            Logger.getLogger(dash.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(dash.class.getName()).log(Level.SEVERE, null, ex);
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
