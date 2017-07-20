/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SUBHAM RAJ SINGH
 */
public class RegisterServlet extends HttpServlet {

    public RegisterServlet() {
    }
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             

        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             String firstname= request.getParameter("first_name");
             String lastname= request.getParameter("last_name");
             int manid=Integer.parseInt(request.getParameter("manid"));
             int empid=Integer.parseInt(request.getParameter("empid"));
             String city= request.getParameter("city");
             String state= request.getParameter("state");
             int zip=Integer.parseInt(request.getParameter("zip"));
             String passw= request.getParameter("password");
           
              
             // long contact=Long.parseLong(request.getParameter("contact"));
             
              String email= request.getParameter("email");
              RegisterBean registerBean = new RegisterBean();

                registerBean.setFirstName(firstname);
                registerBean.setLastName(lastname);
                registerBean.setManagerId(manid);
                registerBean.setEmployeeId(empid);
                registerBean.setCity(city);
                registerBean.setState(state);
                registerBean.setZip(zip);
                registerBean.setPassword(passw);
               
                registerBean.setEmail(email);
                
                RegisterDao registerDao = new RegisterDao();
                String userRegistered = registerDao.registerUser(registerBean);
                 if(userRegistered.equals("SUCCESS"))
                 {
                   request.getRequestDispatcher("/login.jsp").forward(request, response);
                 }
                 else  
                 {
                   request.setAttribute("errMessage", userRegistered);
                   request.getRequestDispatcher("/register.jsp").forward(request, response);
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
