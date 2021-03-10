package org.apache.jsp._005fpages_005fcontainer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class delivery_005fusr_jsp extends org.apache.jasper.runtime.HttpJspBase
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
Session sesloadtypeadmin = conn.connector.getSessionFactory().openSession();
      out.write("\n");
      out.write("<div style=\"width:980px;\">\n");
      out.write("    <div class=\"c_col\">\n");
      out.write("        Update Delivery (invoice num)\n");
      out.write("        <div class=\"b_field\">\n");
      out.write("            <label>Delivery CODE</label>\n");
      out.write("            <input type=\"text\" name=\"dcode\" id=\"dcode\">\n");
      out.write("        </div>\n");
      out.write("        <input type=\"submit\" value=\"Update\" id=\"b_field_submit_upstate\"  onclick=\"update_Delivery()\">\n");
      out.write("        <div id=\"up_msg\" class=\"r_msg\"></div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"admin_sub_content\">\n");
      out.write("        Delivery Details\n");
      out.write("\n");
      out.write("        <div class=\"b_col\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                <th>Number</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Status</th>\n");
      out.write("                <th>Postal Code</th>\n");
      out.write("                <th>Shipping date</th>\n");
      out.write("                <th>Invoice</th>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                ");
  //comment   
                    int user_id = (Integer) request.getSession().getAttribute("user-id");
                    pojo.User user = (pojo.User) sesloadtypeadmin.load(pojo.User.class, user_id);

                    Criteria cruserlist = sesloadtypeadmin.createCriteria(pojo.Delivery.class);
                    cruserlist.add(Restrictions.eq("user", user));
                    if (request.getParameter("vl1") != null && !request.getParameter("vl1").isEmpty()) {
                        cruserlist.add(Restrictions.like("state", request.getParameter("vl1"), MatchMode.ANYWHERE));
                    }

                    List<pojo.Delivery> dlist = cruserlist.list();

                    for (pojo.Delivery dlv : dlist) {
                        out.write("<tr>");
                        out.write("<td>" + dlv.getIddelivery() + "</td>");
                        out.write("<td>" + dlv.getName() + "</td>");
                        out.write("<td>" + dlv.getState() + "</td>");
                        out.write("<td>" + dlv.getPostalCode() + "</td>");
                        out.write("<td>" + dlv.getShippingDate() + "</td>");
                        // pojo.Invoice invo = (pojo.Invoice) sesloadtypeadmin.load(pojo.Invoice.class, dlv.getInvoice().getIdinvoice());
                        out.write("<td>" + dlv.getInvoice().getInvoiceNum() + "</td>");
                        out.write("</tr>");

                    }

                    sesloadtypeadmin.close();
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"a_field\">\n");
      out.write("            <label>Note Status : </label>\n");
      out.write("            <select name=\"vl1\" id=\"vl1\">\n");
      out.write("                <option value=\"pending\">PENDING</option>\n");
      out.write("                <option value=\"deliverd\">DELIVERD</option>\n");
      out.write("            </select>\n");
      out.write("            <input type=\"submit\" value=\"search\" id=\"a_field_submit\" onclick=\"document.getElementById('usr_delivery_btn').click();\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <script type=\"text/javascript\" >\n");
      out.write("        function update_Delivery() {\n");
      out.write("            try {\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("                var dcode = document.getElementById(\"dcode\").value;\n");
      out.write("                var msgdiv = document.getElementById(\"up_msg\");\n");
      out.write("                if (dcode === \"\") {\n");
      out.write("                    alert(\"Enter invoice number\");\n");
      out.write("                }\n");
      out.write("                var url_patten = \"?dcode=\" + dcode;\n");
      out.write("                xhr.onreadystatechange = function () {\n");
      out.write("                    //alert(xhr.readyState +\" : \"+xhr.status );\n");
      out.write("                    if (xhr.readyState === 4 && xhr.status === 200) {\n");
      out.write("                        msgdiv.innerHTML = xhr.responseText;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.open(\"POST\", \"Update_delivery\" + url_patten, true);\n");
      out.write("                xhr.send();\n");
      out.write("            } catch (error) {\n");
      out.write("                alert(error);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        .admin_sub_content{\n");
      out.write("            width: 650px;\n");
      out.write("            min-height: 300px;\n");
      out.write("            padding: 10px;\n");
      out.write("            border: 1px dotted #CCC;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .a_field{\n");
      out.write("            width: 530px;\n");
      out.write("            padding: 5px;\n");
      out.write("        }\n");
      out.write("        .a_field label{\n");
      out.write("            display: inline-block;\n");
      out.write("            width: 120px;\n");
      out.write("            //border: 1px solid #CCC;\n");
      out.write("            padding: 3px 5px;\n");
      out.write("        }\n");
      out.write("        .a_field input[type=text],.a_field input[type=email]{\n");
      out.write("            display: inline-block;\n");
      out.write("            width: 260px;\n");
      out.write("            padding: 5px 5px;\n");
      out.write("            border: 1px solid #CCC;\n");
      out.write("        }\n");
      out.write("        .a_field select{\n");
      out.write("            width: 150px;\n");
      out.write("            padding: 2px;\n");
      out.write("            border: 1px solid #CCC;\n");
      out.write("        }\n");
      out.write("        .a_field select option{\n");
      out.write("            width: 140px;\n");
      out.write("            padding: 3px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #a_field_submit{\n");
      out.write("            padding: 3px 5px;\n");
      out.write("            width: 107px;\n");
      out.write("        }\n");
      out.write("        .b_col{\n");
      out.write("            padding: 10px;\n");
      out.write("            width:600px;\n");
      out.write("            /*border: 1px solid #CCC;*/\n");
      out.write("            height: 270px;\n");
      out.write("            overflow: auto;\n");
      out.write("        }\n");
      out.write("        .b_col table{\n");
      out.write("            width: 600px;\n");
      out.write("            //border: 1px solid #CCC;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .b_col table th{\n");
      out.write("            text-align: left;\n");
      out.write("            border: 1px solid #777;\n");
      out.write("            padding-left: 3px;\n");
      out.write("        }\n");
      out.write("        .b_col table td{\n");
      out.write("\n");
      out.write("            padding-left: 3px;\n");
      out.write("        }\n");
      out.write("        .c_col{\n");
      out.write("            min-height: 200px;\n");
      out.write("            width: 280px;\n");
      out.write("            min-width: 200px;\n");
      out.write("            border: 1px dotted #CCC;\n");
      out.write("            float: right;\n");
      out.write("            padding: 10px;\n");
      out.write("        }\n");
      out.write("        .b_field{\n");
      out.write("            width: 250px;\n");
      out.write("            padding: 5px;\n");
      out.write("        }\n");
      out.write("        .b_field label{\n");
      out.write("            display: block;\n");
      out.write("            width: 120px;\n");
      out.write("            //border: 1px solid #CCC;\n");
      out.write("            padding: 3px 5px;\n");
      out.write("        }\n");
      out.write("        .b_field input[type=text],.b_field input[type=email]{\n");
      out.write("            display: inline-block;\n");
      out.write("            width: 260px;\n");
      out.write("            padding: 5px 5px;\n");
      out.write("            border: 1px solid #CCC;\n");
      out.write("        }\n");
      out.write("        .b_field select{\n");
      out.write("            width: 200px;\n");
      out.write("            padding: 2px;\n");
      out.write("            border: 1px solid #CCC;\n");
      out.write("        }\n");
      out.write("        .b_field select option{\n");
      out.write("            width: 180px;\n");
      out.write("            padding: 3px;\n");
      out.write("        }\n");
      out.write("        #b_field_submit_uptype, #b_field_submit_upstate{\n");
      out.write("            padding: 3px 5px;\n");
      out.write("            width: 107px;\n");
      out.write("            margin-left: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .r_msg{\n");
      out.write("            color: #985f0d;\n");
      out.write("            font-size: 11px;\n");
      out.write("            margin-left: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</div>");
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
