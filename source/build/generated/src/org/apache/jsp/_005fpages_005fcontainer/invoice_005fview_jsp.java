package org.apache.jsp._005fpages_005fcontainer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class invoice_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
Session sesloadtypeadmin = conn.connector.getSessionFactory().openSession();
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"jquery_date_pic/jquery-ui.css\" rel=\"stylesheet\"/>\n");
      out.write("        <script src=\"jquery_date_pic/jquery.js\"></script>\n");
      out.write("        <script src=\"jquery_date_pic/jquery-ui.js\"></script>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#datepicker_1\").datepicker();\n");
      out.write("                $(\"#datepicker_2\").datepicker();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div style=\"width:980px;\">\n");
      out.write("\n");
      out.write("            <div class=\"admin_sub_content\">\n");
      out.write("                <div style=\"background-color: #333;color: #FFF;padding: 5px;\"> Invoice </div>\n");
      out.write("                <div class=\"a_field\">\n");
      out.write("                    <label>Invoice Num</label>\n");
      out.write("                    <input type=\"text\" name=\"vl1\" id=\"vl1\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"a_field\">\n");
      out.write("                    <label>Date To :</label>\n");
      out.write("                    <input type=\"text\" name=\"vl2\" id=\"vl2\" >\n");
      out.write("                    <label>Date From :</label>\n");
      out.write("                    <input type=\"text\" name=\"vl3\" id=\"vl3\">\n");
      out.write("                    <input type=\"submit\" value=\"search\" id=\"a_field_submit\" onclick=\"load_a_html_with_para('postc', '_pages_container/invoice_view.jsp')\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"b_col\">\n");
      out.write("                    <table>\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th style=\"width:140px;\">Invoice Num</th>\n");
      out.write("                                <th style=\"width:130px;\">Date</th>\n");
      out.write("                                <th style=\"width: 50px;\">Items</th>\n");
      out.write("                                <th style=\"width:100px;\">Total</th>\n");
      out.write("                                <th style=\"width: 50px;\">Cart ID</th>\n");
      out.write("                                <!--th>#</th-->\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
  //comment              
                                Criteria cruserlist = sesloadtypeadmin.createCriteria(pojo.Invoice.class);
                                int x = (Integer) request.getSession().getAttribute("user-id");
                                pojo.User userbbs = (pojo.User) sesloadtypeadmin.load(pojo.User.class, x);

                                boolean fst_val = false;
                                boolean snd_val = false;
                                //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                // Date date = new Date();
                                // system.out.println((dateFormat.format(date)));
                                // String valuee = "2015-12-17 07:00:00";
                                // String valuee2 = "2015-12-19 23:59:59";
                                // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                // Date currentDate2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(valuee);
                                //System.out.println(currentDate2);
                                //cruserlist.add(Restrictions.between("timeDate", currentDate, currentDate2));
                                if (request.getParameter("vl1") != null && !request.getParameter("vl1").isEmpty()) {
                                    cruserlist.add(Restrictions.eq("invoiceNum", request.getParameter("vl1")));
                                    fst_val = true;
                                }
                                if (request.getParameter("vl2") != null && !request.getParameter("vl2").isEmpty()) {
                                    String valuee = "2015-12-27";
                                    java.sql.Date date = java.sql.Date.valueOf(valuee);
                                    cruserlist.add(Restrictions.like("timeDate", date+"", MatchMode.ANYWHERE));
                                    snd_val = true;
                                }
                                if (fst_val && snd_val) {
                                    //                        //both value true
                                    //
                                }
                                //
                                List<pojo.Invoice> involist = cruserlist.list();
                                double totlaamount = 0;
                                DecimalFormat df = new DecimalFormat("0.00");
                                for (pojo.Invoice invo : involist) {
                                    // Criteria cart = sesloadtypeadmin.createCriteria(pojo.Cart.class);
                                    // cart.add(Restrictions.eq("invoice", invo));
                                    //  pojo.TransactionDetails transd = (pojo.TransactionDetails) transdata.uniqueResult();
                                    out.write("<tr>");
                                    out.write("<td style='font-size:13px;width:140px;'>" + invo.getInvoiceNum() + "</td>");
                                    out.write("<td style='font-size:12px;width:130px;'>" + invo.getTimeDate() + "</td>");
                                    out.write("<td style='font-size:13px;text-align:center;width:50px;'>" + invo.getCart().getProductCount() + "</td>");
                                    out.write("<td style='font-size:12px;text-align:right;width:100px;'>" + df.format(invo.getCart().getTotalAmount()) + "</td>");
                                    totlaamount += invo.getCart().getTotalAmount();

                                    out.write("<td style='font-size:13px;text-align:center;width:50px;'>" + invo.getCart().getIdcart() + "</td>");

                                    out.write("</tr>");
                                }

                                sesloadtypeadmin.close();
                            
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div style=\"margin-left: 30px;font-size: 20px;margin-top: 20px;\">Your Total : ");
      out.print(df.format(totlaamount));
      out.write("  </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <style>\n");
      out.write("                .admin_sub_content{\n");
      out.write("                    width: 550px;\n");
      out.write("                    min-height: 300px;\n");
      out.write("                    padding: 10px;\n");
      out.write("                    border: 1px dotted #CCC;\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                .a_field{\n");
      out.write("                    width: 530px;\n");
      out.write("                    padding: 5px;\n");
      out.write("                }\n");
      out.write("                .a_field label{\n");
      out.write("                    display: inline-block;\n");
      out.write("                    width: 120px;\n");
      out.write("                    //border: 1px solid #CCC;\n");
      out.write("                    padding: 3px 5px;\n");
      out.write("                }\n");
      out.write("                .a_field input[type=text],.a_field input[type=email]{\n");
      out.write("                    display: inline-block;\n");
      out.write("                    width: 260px;\n");
      out.write("                    padding: 5px 5px;\n");
      out.write("                    border: 1px solid #CCC;\n");
      out.write("                }\n");
      out.write("                .a_field select{\n");
      out.write("                    width: 150px;\n");
      out.write("                    padding: 2px;\n");
      out.write("                    border: 1px solid #CCC;\n");
      out.write("                }\n");
      out.write("                .a_field select option{\n");
      out.write("                    width: 140px;\n");
      out.write("                    padding: 3px;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                #a_field_submit{\n");
      out.write("                    padding: 3px 5px;\n");
      out.write("                    width: 107px;\n");
      out.write("                }\n");
      out.write("                .b_col{\n");
      out.write("                    padding: 10px;\n");
      out.write("                    width: 540px;\n");
      out.write("                    /*border: 1px solid #CCC;*/\n");
      out.write("                    height: 270px;\n");
      out.write("                    overflow: auto;\n");
      out.write("                }\n");
      out.write("                .b_col table{\n");
      out.write("                    width: 540px;\n");
      out.write("                    //border: 1px solid #CCC;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .b_col table th{\n");
      out.write("                    text-align: left;\n");
      out.write("                    border: 1px solid #777;\n");
      out.write("                    padding-left: 3px;\n");
      out.write("                }\n");
      out.write("                .b_col table td{\n");
      out.write("\n");
      out.write("                    padding-left: 3px;\n");
      out.write("                }\n");
      out.write("                .c_col{\n");
      out.write("                    min-height: 200px;\n");
      out.write("                    width: 380px;\n");
      out.write("                    min-width: 200px;\n");
      out.write("                    border: 1px dotted #CCC;\n");
      out.write("                    float: right;\n");
      out.write("                    padding: 10px;\n");
      out.write("                }\n");
      out.write("                .b_field{\n");
      out.write("                    width: 330px;\n");
      out.write("                    padding: 5px;\n");
      out.write("                }\n");
      out.write("                .b_field label{\n");
      out.write("                    display: block;\n");
      out.write("                    width: 120px;\n");
      out.write("                    //border: 1px solid #CCC;\n");
      out.write("                    padding: 3px 5px;\n");
      out.write("                }\n");
      out.write("                .b_field input[type=text],.b_field input[type=email]{\n");
      out.write("                    display: inline-block;\n");
      out.write("                    width: 260px;\n");
      out.write("                    padding: 5px 5px;\n");
      out.write("                    border: 1px solid #CCC;\n");
      out.write("                }\n");
      out.write("                .b_field select{\n");
      out.write("                    width: 200px;\n");
      out.write("                    padding: 2px;\n");
      out.write("                    border: 1px solid #CCC;\n");
      out.write("                }\n");
      out.write("                .b_field select option{\n");
      out.write("                    width: 180px;\n");
      out.write("                    padding: 3px;\n");
      out.write("                }\n");
      out.write("                #b_field_submit_uptype, #b_field_submit_upstate{\n");
      out.write("                    padding: 3px 5px;\n");
      out.write("                    width: 107px;\n");
      out.write("                    margin-left: 5px;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .r_msg{\n");
      out.write("                    color: #985f0d;\n");
      out.write("                    font-size: 11px;\n");
      out.write("                    margin-left: 10px;\n");
      out.write("                }\n");
      out.write("                table thead{\n");
      out.write("                    display: block;\n");
      out.write("                }\n");
      out.write("                table tbody{\n");
      out.write("                    display: block;\n");
      out.write("                    overflow-y:  auto;\n");
      out.write("                    height: 250px;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("\n");
      out.write("            </style>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
