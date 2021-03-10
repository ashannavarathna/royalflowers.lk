package org.apache.jsp._005fadmin_005fpages.advertisement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class ad_005fcontroll_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"m_container\">\n");
      out.write("    <div class=\"content_row\">\n");
      out.write("        <div class=\"col\">\n");
      out.write("            <div style=\"background-color: #333;color: #FFF;padding: 3px;font-weight: bold;\">Advertising Categories</div>\n");
      out.write("            <form class=\"sv_form\" >\n");
      out.write("                <label>Add Category</label>\n");
      out.write("                <input type=\"text\" name=\"add_cat\" id=\"addver_Cat\">\n");
      out.write("                <input type=\"button\" value=\"add\" onclick=\"save_advertise_category('addver_Cat', 'sv_form_msg')\">\n");
      out.write("            </form>\n");
      out.write("            <div id=\"sv_form_msg\"></div>\n");
      out.write("            <table>\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                    <td style=\"background-color: #777;color: #FFF;width: 20%;display: inline-block;\">ID</td>\n");
      out.write("                    <td style=\"background-color: #777;color: #FFF;width: 76.4%;display: inline-block;\">Category</td>                   \n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
 /*comment */

                        Session ses = conn.connector.getSessionFactory().openSession();
                        DecimalFormat df = new DecimalFormat("0.00");
                        Criteria cry = ses.createCriteria(pojo.AdvertisingCategory.class);
                        pojo.AdvertisingStatus adstate = (pojo.AdvertisingStatus) ses.load(pojo.AdvertisingStatus.class, 1); // get the active state
                        cry.add(Restrictions.eq("advertisingStatus", adstate));
                        List<pojo.AdvertisingCategory> adclist = cry.list();
                        for (pojo.AdvertisingCategory adx : adclist) {

                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                    <td class=\"tbd_cl1\">");
      out.print(adx.getIdadvertisingCategory());
      out.write("</td>\n");
      out.write("                    <td class=\"tbd_cl2\">");
      out.print(adx.getCategory());
      out.write("<span onclick=\"remove_ad_category('");
      out.print(adx.getIdadvertisingCategory());
      out.write("', 'sv_form_msg')\">remove</span></td>                   \n");
      out.write("                    </tr>\n");
      out.write("                    ");
}

                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col\">\n");
      out.write("            <div style=\"background-color: #333;color: #FFF;padding: 3px;font-weight: bold;\">Update advertising location details </div>\n");
      out.write("            <label>Select Location <span style=\"font-size: 11px;\">(image size per define. )</span></label>\n");
      out.write("            <select style=\"width: 300px;display: inline-block;\" name=\"ad_loc_cmb\" id=\"ad_loc_cmb_admin\" onchange=\"load_ad_loc_details()\">\n");
      out.write("                <option value=\"0\">select location</option>\n");
      out.write("                ");
/*loading ad location*/
                    Criteria cryadloc = ses.createCriteria(pojo.AdvertisingLocation.class);
                    List<pojo.AdvertisingLocation> adloclist = cryadloc.list();
                    String fstvalimgsize = ""; // getting the img size of first vale in db
                    for (pojo.AdvertisingLocation adloc : adloclist) {
                        if (fstvalimgsize == "") {
                            fstvalimgsize = adloc.getImgSize();
                        }
                        out.write("<option value='" + adloc.getIdadvertisingLocation() + "'>" + adloc.getLocation() + "</option>");
                    }
                
      out.write("\n");
      out.write("            </select><label style=\"display: inline-block;border: 1px dotted #CCC;width: 120px;padding: 6px;margin-left: 10px;background-color: #F0F0F0;margin-top: 0;text-align: center;\"id=\"adloc_imgsize_admin\" >width x height (px)</label>\n");
      out.write("            <label>Location Cost <span style=\"font-size: 11px;\">(LKR)</span></label>\n");
      out.write("            <input type=\"text\" name=\"ad_loc_price\" id=\"ad_loc_price_admin\" style=\"display: inline-block;width: 100px;text-align: right;padding: 5px;border: 1px solid #CCC;\" placeholder=\"0.00\">\n");
      out.write("            <label>Discount <span style=\"font-size: 11px;\">(LKR)</span></label>\n");
      out.write("            <input type=\"text\" name=\"ad_loc_dscnt\" id=\"ad_loc_dscnt_admin\" style=\"display: inline-block;width: 100px;text-align: right;padding: 5px;border: 1px solid #CCC;\" placeholder=\"0.00\">\n");
      out.write("            <br/><br/> <input type=\"button\" value=\"update\" style=\"padding: 3px; width: 115px;\" onclick=\"update_ad_loc_data()\">\n");
      out.write("            <div id=\"adloc_msg_admin\" style=\"font-size: 11px;padding: 5px;\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div class=\"content_row\" style=\"min-height: 350px;\">\n");
      out.write("        <div class=\"col\" style=\"border:none;width: 350px;\">\n");
      out.write("            <div style=\"background-color: #333;color: #FFF;padding: 3px;font-weight: bold;\">Update advertising date plans </div>\n");
      out.write("            <label>Package Name <span style=\"font-size: 11px;\">(to update type pkg name and press enter)</span></label>\n");
      out.write("            <input type=\"text\"  name=\"ad_pkg_name\" id=\"ad_pkg_name_admin\" style=\"display: inline-block;width: 300px;text-align: left;padding: 5px;border: 1px solid #CCC;\">\n");
      out.write("            <label>Date Count <span style=\"font-size: 11px;\">(ad display date range)</span></label>\n");
      out.write("            <input type=\"text\" name=\"ad_pkg_dcount\" id=\"ad_pkg_dcount_admin\" onkeypress='return (event.charCode >= 48 && event.charCode <= 57) || event.charCode === 0' style=\"display: inline-block;width: 100px;text-align: right;padding: 5px;border: 1px solid #CCC;\" placeholder=\"0\">\n");
      out.write("            <label>Package Cost <span style=\"font-size: 11px;\">(LKR)</span></label>\n");
      out.write("            <input type=\"text\" name=\"ad_pkg_price\" id=\"ad_pkg_price_admin\" style=\"display: inline-block;width: 100px;text-align: right;padding: 5px;border: 1px solid #CCC;\" placeholder=\"0.00\">\n");
      out.write("            <label>Discount<span style=\"font-size: 11px;\">(LKR)</span></label>\n");
      out.write("            <input type=\"text\" name=\"ad_pkg_dscount\" id=\"ad_pkg_dscount_admin\" style=\"display: inline-block;width: 100px;text-align: right;padding: 5px;border: 1px solid #CCC;\" placeholder=\"0.00\">\n");
      out.write("            <label><span style=\"font-size: 11px;\">your prices will update</span></label>\n");
      out.write("            <input type=\"button\" value=\"save & update\" style=\"padding: 3px; width: 120px;\" onclick=\"save_and_update_date_palans()\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"col\" style=\"width: 570px;padding-top:0;border:none;\">\n");
      out.write("            <div id=\"sv_form_msg\"></div>\n");
      out.write("            <table style=\"height:320px;margin-top: 0;border: none;\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                    <td style=\"background-color: #777;color: #FFF;width: 50px;display: inline-block;\">ID</td>\n");
      out.write("                    <td style=\"background-color: #777;color: #FFF;width: 220px;display: inline-block;\">Package Name</td>\n");
      out.write("                    <td style=\"background-color: #777;color: #FFF;width: 55px;display: inline-block;\">D-Cnt</td>\n");
      out.write("                    <td style=\"background-color: #777;color: #FFF;width: 90px;display: inline-block;\">Price</td>\n");
      out.write("                    <td style=\"background-color: #777;color: #FFF;width: 90px;display: inline-block;\">Dscnt</td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                </thead>\n");
      out.write("                <tbody style=\"height: 300px;\">\n");
      out.write("                    ");
 /*comment */

                        Criteria cryadplan = ses.createCriteria(pojo.AdvertisingDatePlans.class);

                        cryadplan.add(Restrictions.eq("advertisingStatus", adstate));
                        List<pojo.AdvertisingDatePlans> adplanlist = cryadplan.list();
                        for (pojo.AdvertisingDatePlans addplan : adplanlist) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                    <td class=\"tbd_cl1\" style=\"width: 50px;\">");
      out.print(addplan.getIdadvertisingDatePlans());
      out.write("</td>\n");
      out.write("                    <td class=\"tbd_cl1\" style=\"width: 220px;\">");
      out.print(addplan.getPakage());
      out.write("<span onclick=\"remove_ad_pkgplan('");
      out.print(addplan.getIdadvertisingDatePlans());
      out.write("')\">remove</span></td>                   \n");
      out.write("                    <td class=\"tbd_cl1\" style=\"width: 55px;text-align: right;\">");
      out.print(addplan.getDateCount());
      out.write("</td>\n");
      out.write("                    <td class=\"tbd_cl1\" style=\"width: 85px;text-align: right;\">");
      out.print(df.format(addplan.getPrice()));
      out.write("</td>\n");
      out.write("                    <td class=\"tbd_cl1\" style=\"width: 80px;text-align: right;\">");
      out.print(df.format(addplan.getDiscount()));
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
                        ses.close();
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("    .m_container{\n");
      out.write("        width: 970px;\n");
      out.write("        /*border: 1px solid #CCC;*/\n");
      out.write("        min-height: 500px;\n");
      out.write("        padding: 5px;\n");
      out.write("    }\n");
      out.write("    .content_row{\n");
      out.write("        padding: 5px;\n");
      out.write("        border: 1px dotted #CCC;\n");
      out.write("        min-height: 300px;\n");
      out.write("        margin-bottom: 5px;\n");
      out.write("    }\n");
      out.write("    .col{   \n");
      out.write("        padding: 5px;\n");
      out.write("        width: 48%;\n");
      out.write("        margin-left: 5px;\n");
      out.write("        min-height: 280px;\n");
      out.write("        border: 1px solid #CCC;\n");
      out.write("        float: left;\n");
      out.write("        position: relative;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    .col .sv_form label{\n");
      out.write("        display: inline-block;\n");
      out.write("        padding: 5px;\n");
      out.write("        width: 100px;\n");
      out.write("    }\n");
      out.write("    .col .sv_form input[type=text]{\n");
      out.write("        display: inline-block;\n");
      out.write("        padding: 5px;\n");
      out.write("        width: 229px;\n");
      out.write("        border: 1px solid #CCC;\n");
      out.write("    }\n");
      out.write("    .col .sv_form input[type=button]{\n");
      out.write("        padding: 3px;\n");
      out.write("        width: 100px;\n");
      out.write("    }\n");
      out.write("    .col table{\n");
      out.write("        width: 100%;\n");
      out.write("        border: 1px solid #CCC;\n");
      out.write("        padding: 3px;\n");
      out.write("        margin-top: 10px;\n");
      out.write("    }\n");
      out.write("    .col table td{\n");
      out.write("        padding: 3px;\n");
      out.write("    }\n");
      out.write("    .col table td span{\n");
      out.write("        display: block;\n");
      out.write("        font-size: 11px;\n");
      out.write("        color: #333;\n");
      out.write("        text-decoration: underline;\n");
      out.write("        cursor: pointer;\n");
      out.write("    }\n");
      out.write("    .col table thead{\n");
      out.write("        display: block;\n");
      out.write("        width: 100%;\n");
      out.write("    }\n");
      out.write("    .col table thead tr{\n");
      out.write("        width: 100%;\n");
      out.write("        /*background: #005580;*/\n");
      out.write("        display: inline-block;\n");
      out.write("    }\n");
      out.write("    .col table tbody{\n");
      out.write("        width: 100%;\n");
      out.write("        height: 170px;\n");
      out.write("        display: block;\n");
      out.write("        overflow-y: auto;\n");
      out.write("\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    .col table tbody tr{\n");
      out.write("        display:block;\n");
      out.write("        /*background-color: #0088CC;*/\n");
      out.write("    }\n");
      out.write("    .col table tbody td{\n");
      out.write("        /*background: #006600;*/\n");
      out.write("    }\n");
      out.write("    .col table tbody tr .tbd_cl1{\n");
      out.write("        width: 21%;\n");
      out.write("        display: inline-block;\n");
      out.write("        height: 30px;\n");
      out.write("    }\n");
      out.write("    .col table tbody .tbd_cl2{\n");
      out.write("        width: 75%;\n");
      out.write("        display: inline-block;\n");
      out.write("        height: 30px;\n");
      out.write("    }\n");
      out.write("    .col label{\n");
      out.write("        display: block;\n");
      out.write("        margin-top: 10px;\n");
      out.write("        margin-bottom: 5px;\n");
      out.write("        font-size: 13px;\n");
      out.write("        font-weight: bold;\n");
      out.write("        color: #504b4b;\n");
      out.write("        padding-left: 1px;\n");
      out.write("    }\n");
      out.write("    .col select{\n");
      out.write("        width: 350px;\n");
      out.write("        border: 1px solid #CCC;\n");
      out.write("    }\n");
      out.write("    .col select option {\n");
      out.write("        padding: 5px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</style>\n");
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
