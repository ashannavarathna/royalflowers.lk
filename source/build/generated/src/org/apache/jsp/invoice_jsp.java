package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class invoice_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>invoice</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body >\r\n");
      out.write("\t<div class=\"main-content\" style=\"width:60%;margin-left:20%\" >\r\n");
      out.write("  \t\t<div class=\"header-content\" style=\"height:120px;border-bottom:solid #777 1px;width:80%;margin-left:10%\">\r\n");
      out.write("  \t\t\t  \t<div class=\"address-content\" style=\"float:right;line-height:10px;padding:5px;font-size:15px;font-family:Constantia;\">\r\n");
      out.write("  \t\t\t\t\t<p>X_Y Company</p>\r\n");
      out.write("  \t\t\t\t\t<p>Kandy RD</p>\r\n");
      out.write("  \t\t\t\t\t<p>Kurunegala</p>\r\n");
      out.write("  \t\t\t\t\t<p>Reg:3445LT</p>\r\n");
      out.write("  \t\t\t\t</div>\r\n");
      out.write("  \t\t\t<div class=\"logo-content\" style=\"width:200px;\">\r\n");
      out.write("                            <img src=\"_images/logos/logo-gwf.jpg\" width=\"200px\" height=\"118px\"/>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"mid-content\" style=\"margin-left:10%;line-height:20px;padding:5px;font-size:15px;font-family:Constantia;\">\r\n");
      out.write("\t\t\t<div class=\"bill-data\" style=\"width:50%;\">\r\n");
      out.write("\t\t\t\t<div><span style=\"width:200px;\">Chaier </span> <span id=\"\" style=\"margin-left:70px;text-align:right;font-family:consolas;\">Ashan Nawarathna</span></div>\r\n");
      out.write("\t\t\t\t<div><span style=\"width:200px;\">Customer </span> <span id=\"\" style=\"margin-left:49px;font-family:consolas;\">Locahna</span></div>\r\n");
      out.write("\t\t\t\t<div><span style=\"width:200px;\">Time </span> <span id=\"\" style=\"margin-left:80px;font-family:consolas;\">01/08/2015</span></div>\r\n");
      out.write("\t\t\t\t<div><span style=\"width:200px;\">Date </span> <span id=\"\" style=\"margin-left:83px;font-family:consolas;\">15:55:15 GTM</span></div>\r\n");
      out.write("\t\t\t\t<div><span style=\"width:200px;\">Payment Type </span> <span id=\"\" style=\"margin-left:22px;font-family:consolas;\">cash</span></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"invoice-number\" style=\"width:60%;margin-left:20%;\">\r\n");
      out.write("\t\t\t<p id=\"invoice-no\" style=\"font-size:20px;font-family:arial;text-align:center;\">INVOICE |<span id=\"in-number\" style=\"font-family:consolas;font-weight:normal;\"> NRT344005</span> </p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"table-header\" style=\"width:90%;margin-left:5%;background-color:#444;border-radius:3px;height:50px;\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t<table id=\"tbl-header\" style=\"width:100%;color:#FFF; padding:10px;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"width:30%\">Item</th>\r\n");
      out.write("\t\t\t\t<th style=\"width:10%;text-align:right;\">Quantity</th>\r\n");
      out.write("\t\t\t\t<th style=\"width:10%;text-align:right;\">Price</th>\r\n");
      out.write("\t\t\t\t<th style=\"width:10%;text-align:right;\">Discount</th>\r\n");
      out.write("\t\t\t\t<th style=\"width:10%;text-align:right;\">Tax</th>\r\n");
      out.write("\t\t\t\t<th style=\"width:10%;text-align:right;\">Total</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"table-body\" style=\"width:90%;margin-left:5%;background-color:#FFF;border-radius:0px;height:30px;\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t<table id=\"tbl-body\" style=\"width:100%;color:#333; padding:5px;font-size:15px;font-family:tahoma;\">\r\n");
      out.write("\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t<td style=\"width:30%;text-align:center;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr style=\"\">\r\n");
      out.write("\t\t\t\t\t<td style=\"width:30%;text-align:center;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t<td style=\"width:30%;text-align:center;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t<td style=\"width:30%;text-align:center;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t<td style=\"width:30%;text-align:center;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align:right;width:10%;\">Empty Cell</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"invoice-detials\" style=\"float:right;width:40%;text-align:right;padding:5px;font-size:15px;font-weight:bold;font-family:Constantia;width:30%;\">\r\n");
      out.write("\t\t\t\t<div style=\"padding:5px;\"><sapn style=\"text-align:left;\">Subtotal </span><span style=\"text-align:right;margin-left:60px;font-family:Elephant;\" >00000.000</span></div>\r\n");
      out.write("\t\t\t\t<div style=\"padding:5px;\"><sapn style=\"text-align:left;\">Discount </span><span style=\"text-align:right;margin-left:60px;font-family:Elephant;\" >00000.000</span></div>\r\n");
      out.write("\t\t\t\t<div style=\"padding:5px;background-color:#333;color:#FFF\"><sapn style=\"text-align:left;\">Net Amount </span><span style=\"text-align:right;margin-left:60px;font-family:Elephant;\" >00000.000</span></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"clear:both;margin-left:20%;width:60%;height:20px;text-align:center;padding:5px;font-size:12px;font-family:Tahoma;\">\r\n");
      out.write("\t\t\t\t<p>Thank your for shopping with us</p>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
