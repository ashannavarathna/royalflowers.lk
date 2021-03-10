package org.apache.jsp._005fpages_005fcontainer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class usr_005fadviewer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<div style=\"width:650px;\">\n");
      out.write("\n");
      out.write("    <table style=\"height:320px;margin-top: 0;border: none;\">\n");
      out.write("        <thead style=\"border: 1px solid #CCC;\">\n");
      out.write("            <tr>\n");
      out.write("            <td style=\"background-color: #777;color: #FFF;width: 50px;display: inline-block;\">ID</td>\n");
      out.write("            <td style=\"background-color: #777;color: #FFF;width: 220px;display: inline-block;\">Ad Title</td>\n");
      out.write("            <td style=\"background-color: #777;color: #FFF;width: 55px;display: inline-block;\">On Date</td>\n");
      out.write("            <td style=\"background-color: #777;color: #FFF;width: 90px;display: inline-block;\">Price</td>\n");
      out.write("            <td style=\"background-color: #777;color: #FFF;width: 179px;display: inline-block;\">User</td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("        </thead>\n");
      out.write("        <tbody style=\"height: 350px;border: 1px solid #CCC;\" id=\"ad_details_on_adview\">\n");
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("\n");
      out.write("\n");
      out.write("    table{\n");
      out.write("        width: 100%;\n");
      out.write("        border: 1px solid #CCC;\n");
      out.write("        padding: 3px;\n");
      out.write("        margin-top: 10px;\n");
      out.write("    }\n");
      out.write("    table td{\n");
      out.write("        padding: 3px;\n");
      out.write("    }\n");
      out.write("    table td span{\n");
      out.write("        display: block;\n");
      out.write("        font-size: 11px;\n");
      out.write("        color: #333;\n");
      out.write("        text-decoration: underline;\n");
      out.write("        cursor: pointer;\n");
      out.write("    }\n");
      out.write("    table thead{\n");
      out.write("        display: block;\n");
      out.write("        width: 100%;\n");
      out.write("    }\n");
      out.write("    table thead tr{\n");
      out.write("        width: 100%;\n");
      out.write("        /*background: #005580;*/\n");
      out.write("        display: inline-block;\n");
      out.write("    }\n");
      out.write("    table tbody{\n");
      out.write("        width: 100%;\n");
      out.write("        height: 170px;\n");
      out.write("        display: block;\n");
      out.write("        overflow-y: auto;\n");
      out.write("\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    table tbody tr{\n");
      out.write("        display:block;\n");
      out.write("        /*background-color: #0088CC;*/\n");
      out.write("    }\n");
      out.write("    table tbody td{\n");
      out.write("        /*background: #006600;*/\n");
      out.write("    }\n");
      out.write("    table tbody tr .tbd_cl1{\n");
      out.write("        width: 21%;\n");
      out.write("        display: inline-block;\n");
      out.write("        height: 30px;\n");
      out.write("    }\n");
      out.write("    table tbody .tbd_cl2{\n");
      out.write("        width: 75%;\n");
      out.write("        display: inline-block;\n");
      out.write("        height: 30px;\n");
      out.write("    }\n");
      out.write("</style>");
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
