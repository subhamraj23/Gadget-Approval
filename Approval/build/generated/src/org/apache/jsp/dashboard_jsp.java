package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\n");
      out.write("    <title>WELCOME TO APPROVAL GADGET SYSTEM</title> \n");
      out.write("    <meta name=\"description\" content=\"gamedrone app\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/cosmo/bootstrap.min.css\"/>\n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("<body> \n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-top\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("          <button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar-main\">\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("          </button>\n");
      out.write("      <a class=\"navbar-brand col-md-offset-4\" href=\"index.jsp\">Home</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("        <div class=\"col-md-offset-2\">\n");
      out.write("        <ul class=\"nav navbar-nav\">\n");
      out.write("          <li><a href=\"dashboard.jsp\" class=\"navbar-brand\">Dashboard</a></li>\n");
      out.write("          <li><a href=\"profile.jsp\" class=\"navbar-brand\">Profile</a></li>\n");
      out.write("          <li><a href=\"request.jsp\" class=\"navbar-brand\">Request</a></li>\n");
      out.write("        </ul>\n");
      out.write("        </div>\n");
      out.write("    <!-- /.navbar-collapse -->\n");
      out.write("        <div class=\"col-md-offset-10\">\n");
      out.write("           <ul class=\"nav navbar-nav\">\n");
      out.write("              <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/LogoutServlet\">Log out</a></li> \n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("  </div><!-- /.container-fluid -->\n");
      out.write("</nav>\n");
      out.write("<div class=\"container\" style=\" margin-top: 100px ;\">\n");
      out.write("  <h2>Products</h2>                                                                                   \n");
      out.write(" <div class=\"table-inverse\">  \n");
      out.write("    \n");
      out.write("    <table class=\"table table-bordered  table-striped\" align=\"center\">\n");
      out.write("        <thead class=\"thead-default\">\n");
      out.write("          <tr>\n");
      out.write("            <th>Product</th>\n");
      out.write("            <th>Employee Id</th>\n");
      out.write("            <th>Manager Id</th>\n");
      out.write("            <th>Status</th>\n");
      out.write("            <th>Action</th>\n");
      out.write("            <th>Upload</th>\n");
      out.write("            <th>Cancel</th>\n");
      out.write("          </tr>\n");
      out.write("        </thead>\n");
      out.write("        <br>\n");
      out.write("        <tbody\n");
      out.write("            ");
 
               try{
                    Class.forName("com.mysql.jdbc.Driver"); 
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","defacto");
                    String Query="Select * from product";
                    Statement stm=con.createStatement();
                    ResultSet rs=stm.executeQuery(Query);
                    while(rs.next())
                    {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                        <td>");
      out.print(rs.getString("pname"));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getInt("empid"));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getInt("manid"));
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <button class=\"btn btn-danger\">Request</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <!--div class=\"dropdown\">\n");
      out.write("                            <button class=\"btn btn-primary dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Select Option\n");
      out.write("                            <span class=\"caret\"></span></button>\n");
      out.write("                            <ul class=\"dropdown-menu\" disabled=\"disabled\">\n");
      out.write("                              <li><a href=\"dashboard.jsp\">Approve</a></li>\n");
      out.write("                              <li><a href=\"dashboard.jsp\">Pending</a></li>\n");
      out.write("                            \n");
      out.write("                            </ul>\n");
      out.write("                            </div-->\n");
      out.write("                            <input type=\"button\" value=\"Approve\" class=\"btn btn-danger\"/>\n");
      out.write("                            <br>\n");
      out.write("                            <input type=\"button\" value=\"Pending\" class=\"btn btn-warning\"/>\n");
      out.write("                            \n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <!--div class=\"form-group\">\n");
      out.write("                            <label for=\"exampleInputFile\">File input</label>\n");
      out.write("                            <input type=\"file\" id=\"exampleInputFile\">\n");
      out.write("                            <p class=\"help-block\">Example block-level help text here.</p>\n");
      out.write("                            </div-->\n");
      out.write("                            <input  type=\"file\" name='attach' id='attach' class=\"btn btn-primary btn-file\" required=\"required\" hidden/>\n");
      out.write("                            <br>\n");
      out.write("                            <input type=\"submit\" value=\"Upload Bill\" class=\"btn btn-info\"/>\n");
      out.write("\n");
      out.write("\t\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <form>\n");
      out.write("                               <input type=\"reset\" value=\"Cancel\" class=\"btn btn-success\"/>\t\n");
      out.write("                            </form>    \n");
      out.write("                        </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                    }
               }
               catch(Exception ex)
               {
                   out.println("Exception:"+ex.getMessage());
                   ex.printStackTrace();
               }
            
      out.write(" \n");
      out.write("        </tbody>  \n");
      out.write("\n");
      out.write("          \n");
      out.write("           \n");
      out.write("        \n");
      out.write("    </table>  \n");
      out.write(" </div>\n");
      out.write("</div>            \n");
      out.write("            \n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>    \n");
      out.write("</body> \n");
      out.write("</html> ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
