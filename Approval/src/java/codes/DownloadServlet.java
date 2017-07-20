/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.and;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/**
 *
 * @author SUBHAM RAJ SINGH
 */
public class DownloadServlet extends HttpServlet {

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
            HttpSession session=request.getSession(false);
            String n=String.valueOf(session.getAttribute("Employee"));
            int t=Integer.parseInt(request.getParameter("sr"));
            System.out.println("Selected Value is: "+t);
            File file = new File("C:/Users/SUBHAM RAJ SINGH/Documents/NetBeansProjects/Approval/web/uploads/");
            File[] files = file.listFiles();
            long date;
            for (File file1 : files) {
               String name = file1.getName();
               String path = file1.getPath();
              //   System.out.println(name); 
               String s2="";  char ch;
              //   System.out.println(name.length()); 
                 for(int j=0;j<name.length();j++)
                 {
                     ch=name.charAt(j);
                     if(ch!='_')
                       s2+=ch;
                     if(ch!='_') break;
                 }
            //    System.out.println("aman"); 
                                   
                 int op=Integer.parseInt(s2);
                date = file1.lastModified();
               //  System.out.println(s2); 
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               String date1=sdf.format(file1.lastModified());
               System.out.println(date1);
              //  System.out.println(s1);
                  System.out.println(op);
                  System.out.println(t);
               //    System.out.println(dd);
                if(op==t)
                {
           
                    String fileName=name;
                    String filePath="C:\\Users\\SUBHAM RAJ SINGH\\Documents\\NetBeansProjects\\Approval\\web\\uploads";
                    System.out.println(filePath);
                    response.setContentType("APPLICATION/OCTET-STREAM");
                    response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
                    FileInputStream fi=new FileInputStream(filePath+fileName);
                    int i;
                    while((i=fi.read())!=-1)
                    {
                       out.write(i);
                    }    
                    out.close();
                    fi.close();
                    
                }
            
              
                  
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
            Logger.getLogger(DownloadServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DownloadServlet.class.getName()).log(Level.SEVERE, null, ex);
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
