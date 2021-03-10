package org.apache.jsp._005fadmin_005fpages._005fproducts_005fmanagement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class vendors_005fproreq_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<div class=\"container_pro_vend\">\n");
      out.write("    <div class=\"rows\">\n");
      out.write("        <div class=\"col\" style=\"width: 63%\">\n");
      out.write("            <div class='header-col'>List - Vendors notifications settings</div>\n");
      out.write("            <div>Sort by Status : \n");
      out.write("                <select>\n");
      out.write("                    <option value=\"0\">-select-</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <table class=\"p_ven_list\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                    <td>Product</td>\n");
      out.write("                    <td>PCode</td>\n");
      out.write("                    <td>Vendor</td>\n");
      out.write("                    <td>Req. Quantity</td>\n");
      out.write("                    <td>Avl. Quantity</td>\n");
      out.write("                    <td>Req. Status</td>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody></tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col\" style=\"width: 25%\">\n");
      out.write("            <div class='header-col'>Update Details</div>\n");
      out.write("            <div>Search By Email : <input type=\"text\"> </div>\n");
      out.write("            <div>\n");
      out.write("                <lable>Product Code</lable>\n");
      out.write("                <input type=\"text\">\n");
      out.write("                <lable>Vendor Email</lable>\n");
      out.write("                <input type=\"text\">\n");
      out.write("                <lable>Request Quantity</lable>\n");
      out.write("                <input type=\"text\">\n");
      out.write("                <lable>Request Status</lable>\n");
      out.write("                <select>\n");
      out.write("                    <option value=\"0\">-select-</option>\n");
      out.write("                </select>\n");
      out.write("                <input type=\"button\" value=\"Updates\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"rows\">\n");
      out.write("        <div class=\"col\" style=\"width: 63%\">\n");
      out.write("            <div class='header-col'>List - Vendors</div>\n");
      out.write("            <table class=\"ven_list\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                    <td>Name</td>\n");
      out.write("                    <td>Email</td>\n");
      out.write("                    <td>Address</td>\n");
      out.write("                    <td>Contact</td>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody></tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col\" style=\"width: 25%\">\n");
      out.write("            <div class='header-col'>Update Details</div>\n");
      out.write("            <div>\n");
      out.write("                <lable>Vendor Email</lable>\n");
      out.write("                <input type=\"text\">\n");
      out.write("                <lable>Name</lable>\n");
      out.write("                <input type=\"text\">\n");
      out.write("                <lable>Address</lable>\n");
      out.write("                <input type=\"text\">\n");
      out.write("                <lable>Contact</lable>\n");
      out.write("                <input type=\"text\">\n");
      out.write("                <input type=\"button\" value=\"Updates\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("    .container_pro_vend{\n");
      out.write("        width: 1000px;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    .rows{\n");
      out.write("        min-height: 300px;\n");
      out.write("        padding: 5px;\n");
      out.write("        /*border: 1px solid #CCC;*/\n");
      out.write("        margin-top: 5px;\n");
      out.write("    }\n");
      out.write("    .col{\n");
      out.write("        width: 44%;\n");
      out.write("        min-height: 300px;\n");
      out.write("        border: 1px solid silver;\n");
      out.write("        float: left;\n");
      out.write("        margin-left: 5px;\n");
      out.write("        padding: 5px;\n");
      out.write("    }\n");
      out.write("    .col lable{\n");
      out.write("        display: block;\n");
      out.write("        margin-top: 3px;\n");
      out.write("    }\n");
      out.write("    .col input{\n");
      out.write("        display: block;\n");
      out.write("    }\n");
      out.write("    .col input[type='text']{\n");
      out.write("        width: 235px;\n");
      out.write("        padding: 5px;\n");
      out.write("        border: 1px solid #CCC;\n");
      out.write("    }\n");
      out.write("    .p_ven_list thead tr td{\n");
      out.write("        border:1px solid #CCC;\n");
      out.write("        padding: 0 5px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .ven_list thead tr td{\n");
      out.write("        border:1px solid #CCC;\n");
      out.write("        padding: 0 5px;\n");
      out.write("    }\n");
      out.write("    .col input[type='button']{\n");
      out.write("        padding: 3px;\n");
      out.write("        margin-top: 5px;\n");
      out.write("        width: 100px;\n");
      out.write("    }\n");
      out.write("    .header-col{\n");
      out.write("        background-color: #444;\n");
      out.write("        color: #FFF;\n");
      out.write("        padding: 3px;\n");
      out.write("        font-weight: bold;\n");
      out.write("        margin-bottom: 4px;\n");
      out.write("    }\n");
      out.write("    .col select{\n");
      out.write("        min-width: 100px;\n");
      out.write("    }\n");
      out.write("    .col select option{\n");
      out.write("        padding: 3px;\n");
      out.write("    }\n");
      out.write("    .col tbody, .col thead{\n");
      out.write("        display: block;\n");
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
