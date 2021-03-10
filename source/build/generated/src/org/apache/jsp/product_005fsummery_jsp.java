package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.Session;
import java.util.ArrayList;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public final class product_005fsummery_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/_pages_container/top_header.jsp");
    _jspx_dependants.add("/_pages_container/_noscript.jsp");
    _jspx_dependants.add("/_pages_container/navbar_top.jsp");
    _jspx_dependants.add("/_pages_container/botom_footer.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Product_Summary | Royal Flowers</title>\n");
      out.write("        <link href=\"_css/_custome_002.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("        <script type=\"text/javascript\" src=\"_script/_js/_custome_01.js\"></script>\n");
      out.write("        <script src=\"http://maps.google.com/maps?file=api&v=2&key=ABQIAAAA7j_Q-rshuWkc8HyFI4V2HxQYPm-xtd00hTQOC0OXpAMO40FHAxT29dNBGfxqMPq5zwdeiDSHEPL89A\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"page_top_content\">\n");
      out.write("    <div class=\"top_content_wapper\">\n");
      out.write("        <div class=\"top_brand\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"top_right_nav\">\n");
      out.write("            <ul>\n");
      out.write("\n");
      out.write("                <li><a href=\"index.jsp\"><span id=\"top_nav_link\">home</span></a></li>\n");
      out.write("                <li>|</li>\n");
      out.write("                <li><a href=\"#\"><span id=\"top_nav_link\">Contact</span></a></li>\n");
      out.write("                <li>|</li>\n");
      out.write("                    ");

                        if (request.getSession().getAttribute("user-id") != null) {
                            Session sesulog = conn.connector.getSessionFactory().openSession();

                            Integer userid = (Integer) request.getSession().getAttribute("user-id");
                            pojo.User user = (pojo.User) sesulog.load(pojo.User.class, userid);
                    
      out.write("\n");
      out.write("                <li><a href=\"user_profile.jsp\">Hello <span id=\"top_log_user\">");
      out.print(user.getEmail());
      out.write("</span></a></li>    \n");
      out.write("                        ");

                            sesulog.close();
                        } else {
                        
      out.write("\n");
      out.write("                <li><a href=\"signin.jsp\"><span id=\"top_log_user\">Log in</span></a></li>\n");
      out.write("                    ");

                        }

                    
      out.write("\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("        ");
      out.write("<div>\n");
      out.write("    <noscript>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        .main-wrapper {          \n");
      out.write("            pointer-events: none;\n");
      out.write("            display: none;\n");
      out.write("        }\n");
      out.write("        .noscriptmsg{\n");
      out.write("            font-family: \"Trebuchet MS\",Arial,Helvetica,sans-serif;\n");
      out.write("            position: relative;\n");
      out.write("            top: 50px;\n");
      out.write("            background-color: #FFF;\n");
      out.write("            margin: 0 auto;\n");
      out.write("            height: 200px;\n");
      out.write("            width: 500px;\n");
      out.write("            margin-bottom: 200px;\n");
      out.write("            border-radius: 3px;\n");
      out.write("            border: 1px solid #064E5A;\n");
      out.write("            padding: 30px 20px;\n");
      out.write("            font-size: 13px;\n");
      out.write("        }\n");
      out.write("        .noscriptingmsghead{\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            border-bottom: 1px solid #777;\n");
      out.write("            padding-bottom: 5px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            font-weight: 800;\n");
      out.write("        }\n");
      out.write("        #relaod-btn{\n");
      out.write("            float: right;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            display: inline-block;\n");
      out.write("            width: 100px;\n");
      out.write("            height: 20px;\n");
      out.write("            color: #777;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 3px 10px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            border-radius: 2px;\n");
      out.write("        }\n");
      out.write("        #relaod-btn:hover{\n");
      out.write("            background-color:  #dff0d8;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    <div class=\"noscriptmsg\">\n");
      out.write("        <div class=\"noscriptingmsghead\">\n");
      out.write("            Java Script Required\n");
      out.write("        </div>\n");
      out.write("        We're sorry, but \n");
      out.write("        <span style=\"font-weight: 800;color: #449d44;\" >Royal Flowers</span>\n");
      out.write("        does not  work properly without Java Script enabled or with java script unsupported browsers.<br/>enable <span style=\"color: #777;\"> java script </span> and <span style=\"text-decoration: underline;\">reload</span> the page or try java Script supported browser \n");
      out.write("\n");
      out.write("        <a href=\"_page_reloader?uri_this=");
      out.print(request.getRequestURI());
      out.write("\" id=\"relaod-btn\">Reload Page</a>\n");
      out.write("    </div>\n");
      out.write("    </noscript>\n");
      out.write("</div>");
      out.write("\n");
      out.write("        <div class=\"main-wrapper\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"top_navbar_wrapper\">\n");
      out.write("\n");
      out.write("    <style >\n");
      out.write("        .main-logo{\n");
      out.write("            /*border: 1px solid #999;*/\n");
      out.write("            width: 250px;\n");
      out.write("            height: 130px;\n");
      out.write("            float: left;\n");
      out.write("            padding: 5px;\n");
      out.write("        }\n");
      out.write("        .main-cnt-dis{\n");
      out.write("            /*border: 1px solid #999;*/\n");
      out.write("            width: 200px;\n");
      out.write("            height: 130px;\n");
      out.write("            float: left;\n");
      out.write("            padding: 5px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        #main-cnt-num , #main-cnt-desc{\n");
      out.write("            display: block;\n");
      out.write("            color: #555;\n");
      out.write("        }\n");
      out.write("        #main-cnt-num{\n");
      out.write("            margin-top: 50px;\n");
      out.write("            font-size: 20px;\n");
      out.write("            font-weight: bolder;\n");
      out.write("        }\n");
      out.write("        #main-cnt-desc{\n");
      out.write("            font-size: 12px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .main-search{\n");
      out.write("            /*border: 1px solid #999;*/\n");
      out.write("            width: 300px;\n");
      out.write("            height: 130px;\n");
      out.write("            float: left;\n");
      out.write("            padding: 5px;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .main-search input[type=text]{\n");
      out.write("            margin-top: 50px;\n");
      out.write("            width: 200px;\n");
      out.write("            padding: 5px;\n");
      out.write("            border: 1px solid #CCC;\n");
      out.write("        }\n");
      out.write("        .main-search input[type=text]:focus{\n");
      out.write("            border: 1px solid #CCC;\n");
      out.write("        }\n");
      out.write("        .main-search input[type=submit]{            \n");
      out.write("            width: 83px;\n");
      out.write("            padding: 3px 5px;\n");
      out.write("            background-color: #777;\n");
      out.write("            color: #FFF;\n");
      out.write("            border: 1px solid #222;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        .main-search input[type=submit]:hover {\n");
      out.write("            border: 1px solid #777;\n");
      out.write("        }\n");
      out.write("        .main-search a{\n");
      out.write("            font-size: 12px;\n");
      out.write("            color: #777;\n");
      out.write("            margin-left: 3px;\n");
      out.write("        }\n");
      out.write("        /*cart style */\n");
      out.write("        .main-cart-dis{\n");
      out.write("            /*border: 1px solid #999;*/\n");
      out.write("            width: 200px;\n");
      out.write("            height: 130px;\n");
      out.write("            float: left;\n");
      out.write("            padding: 5px;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        #cart-img {\n");
      out.write("            float: left;\n");
      out.write("            margin-right: 5px;\n");
      out.write("            height: 60px;\n");
      out.write("            width: 50px;\n");
      out.write("            margin-left: 15px;\n");
      out.write("            margin-top: 8px;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        #cart-img img{\n");
      out.write("            margin-top: 10px;\n");
      out.write("            width: 50px;\n");
      out.write("            height: 50px;\n");
      out.write("        }\n");
      out.write("        #cart-cont{\n");
      out.write("            color: #777;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            float: left;\n");
      out.write("            width: 115px;\n");
      out.write("            font-size: 12px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("        #cart-name{\n");
      out.write("            padding: 2px 3px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        #cnm {\n");
      out.write("            display: inline-block;            \n");
      out.write("        }\n");
      out.write("        #cnimg{\n");
      out.write("            display: inline-block;\n");
      out.write("            margin-left: 5px;\n");
      out.write("        }\n");
      out.write("        #cnimg img{\n");
      out.write("            width: 15px;\n");
      out.write("            height: 15px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #cart-item{\n");
      out.write("\n");
      out.write("            padding: 2px 3px;\n");
      out.write("            font-size: 13px;\n");
      out.write("        }\n");
      out.write("        #cart-total{\n");
      out.write("\n");
      out.write("            padding: 2px 3px;\n");
      out.write("            font-size: 13px;\n");
      out.write("        }\n");
      out.write("        #view-cart a{\n");
      out.write("            display: block;\n");
      out.write("            border: 1px solid #222;\n");
      out.write("            clear: both;\n");
      out.write("            padding: 3px;\n");
      out.write("            text-align: center;\n");
      out.write("            background-color: #777;\n");
      out.write("            width: 110px;\n");
      out.write("            margin-left: 50px;\n");
      out.write("\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        #view-cart a{\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: #FFF;\n");
      out.write("            font-weight: bolder;\n");
      out.write("            font-size: 13px;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /*end cart style*/\n");
      out.write("        .main_navigation{\n");
      out.write("            clear: both;\n");
      out.write("        }\n");
      out.write("        .main_navigation ul{\n");
      out.write("            padding: 0;\n");
      out.write("            margin-left: 10px;\n");
      out.write("            border-bottom: 1px solid #ccc;\n");
      out.write("        }\n");
      out.write("        .main_navigation ul li{\n");
      out.write("            display: inline-block;\n");
      out.write("            list-style: none;\n");
      out.write("            margin-left: 35px;\n");
      out.write("            width: 100px;\n");
      out.write("            //border: 1px solid #222;\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 10px 10px;\n");
      out.write("            position: relative;\n");
      out.write("            -webkit-transition: all 0.2s;\n");
      out.write("            -moz-transition: all 0.2s;\n");
      out.write("            -ms-transition: all 0.2s;\n");
      out.write("            -o-transition: all 0.2s;\n");
      out.write("            transition: all 0.2s;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .main_navigation ul li a{\n");
      out.write("            text-decoration: none;\n");
      out.write("            text-align: center;\n");
      out.write("            color: #333;\n");
      out.write("            font-weight: bold;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("        .main_navigation ul li a:hover{\n");
      out.write("            color: #999;\n");
      out.write("        }\n");
      out.write("        /*sub naivagion (drowdown)*/\n");
      out.write("        .main_navigation ul li ul{\n");
      out.write("            padding: 5px;\n");
      out.write("            position: absolute;\n");
      out.write("            border-bottom: none;\n");
      out.write("            top: 39px;\n");
      out.write("            left: 0;\n");
      out.write("            width: 180px;\n");
      out.write("\n");
      out.write("            display: none;\n");
      out.write("            opacity: 0;\n");
      out.write("            visibility: hidden;\n");
      out.write("            -webkit-transiton: opacity 0.2s;\n");
      out.write("            -moz-transition: opacity 0.2s;\n");
      out.write("            -ms-transition: opacity 0.2s;\n");
      out.write("            -o-transition: opacity 0.2s;\n");
      out.write("            -transition: opacity 0.2s;\n");
      out.write("            font-size: 13px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .main_navigation ul li ul li{\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-left: 0;\n");
      out.write("            text-align: justify;\n");
      out.write("            display: block;           \n");
      out.write("            width: 160px;\n");
      out.write("            border-bottom: 1px solid #CCC;\n");
      out.write("        }\n");
      out.write("        .main_navigation ul li ul li a{\n");
      out.write("            font-size: 12px;\n");
      out.write("            font-weight: normal;\n");
      out.write("        }\n");
      out.write("        .main_navigation ul li ul li a:hover{\n");
      out.write("            color: #0e90d2;\n");
      out.write("        }\n");
      out.write("        .main_navigation ul li:hover ul{\n");
      out.write("            display: block;\n");
      out.write("            opacity: 1;\n");
      out.write("            visibility: visible;\n");
      out.write("            z-index: 1000;\n");
      out.write("            background-color: #F3F3EE;\n");
      out.write("            border: 1px solid #CCC;\n");
      out.write("            //border-top: none;\n");
      out.write("        } \n");
      out.write("        .main_navigation ul li ul li:hover{\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("        /* crumb navigation */\n");
      out.write("\n");
      out.write("        .crumb-nav ul{\n");
      out.write("            padding: 0;\n");
      out.write("            margin-left: 30px;\n");
      out.write("            margin-top: -10px;\n");
      out.write("        }\n");
      out.write("        .crumb-nav ul li{\n");
      out.write("            display: inline-block;\n");
      out.write("            list-style: none;\n");
      out.write("        }\n");
      out.write("        .crumb-nav ul li a{\n");
      out.write("            text-decoration: none;\n");
      out.write("            text-align: center;\n");
      out.write("            color: #999;\n");
      out.write("            font-size: 13px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <div class=\"main-logo\">\n");
      out.write("        <a href=\"index.jsp\">\n");
      out.write("            <img src=\"_images/logos/logo.png\">\n");
      out.write("        </a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"main-cnt-dis\">\n");
      out.write("        <div>\n");
      out.write("            <span id=\"main-cnt-num\">094 71 753 336 8</span><span id=\"main-cnt-desc\">24 hours per day 7 day per week</span>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"main-search\">\n");
      out.write("        <form action=\"products.jsp\" method=\"POST\"  onsubmit=\"return searchnameFieldValidation()\">\n");
      out.write("            <input type=\"text\" id=\"pname\" name=\"vl2\" />\n");
      out.write("            <input type=\"submit\" value=\"search\" />\n");
      out.write("            <a href=\"products.jsp?vl2=search\" >filter search</a>\n");
      out.write("            <br/>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        function searchnameFieldValidation() {\n");
      out.write("            var inputf = document.getElementById(\"pname\").value;\n");
      out.write("            if (inputf.length <= Number(0)) {\n");
      out.write("                alert(\"Enter name for search\");\n");
      out.write("                return false;\n");
      out.write("            } else {\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    <div class=\"main-cart-dis\">\n");
      out.write("        <div id=\"cart-img\">\n");
      out.write("            <img src=\"_images/_site/Basket.png\">\n");
      out.write("        </div>\n");
      out.write("        <div id=\"cart-cont\">\n");
      out.write("            <div id=\"cart-name\">\n");
      out.write("                <span id=\"cnm\">your basket</span><span id=\"cnimg\"><img src=\"_images/_site/arrow.png\"></span>\n");
      out.write("            </div>\n");
      out.write("            ");

                int itemcountmincart = 0;
                int totalmincart = 0;
                if (request.getSession().getAttribute("s_cart") != null) {
                    Session sesp = conn.connector.getSessionFactory().openSession();

                    List<int[]> cart = (ArrayList) request.getSession().getAttribute("s_cart");
                    itemcountmincart = cart.size();
                    pojo.Product product = null;
                    for (int x = 0; x < cart.size(); x++) {
                        int item[] = cart.get(x);
                        product = (pojo.Product) sesp.load(pojo.Product.class, item[0]);
                        totalmincart += (product.getPrice() - product.getDiscount()) * item[1];
                    }

                }
            
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"cart-item\">Items : ");
      out.print(itemcountmincart);
      out.write("</div>\n");
      out.write("            <div id=\"cart-total\">Total : ");
      out.print(totalmincart);
      out.write(" (LKR) </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"view-cart\">\n");
      out.write("            <a href=\"cart.jsp\">View Basket</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"main_navigation\">\n");
      out.write("        <ul>\n");
      out.write("            ");

                Session ses = conn.connector.getSessionFactory().openSession();
                Criteria ccrxtt = ses.createCriteria(pojo.Catagory.class);

                List<pojo.Catagory> lst = ccrxtt.list();

                for (pojo.Catagory cat : lst) {
            
      out.write("\n");
      out.write("            <li><a href=\"#\">");
      out.print(cat.getCatagory());
      out.write("</a>\n");
      out.write("                <ul>\n");
      out.write("                    ");

                        pojo.Catagory mcat = (pojo.Catagory) ses.load(pojo.Catagory.class, cat.getIdcatagory());
                        Criteria csub = ses.createCriteria(pojo.SubCategory.class);
                        csub.add(Restrictions.eq("catagory", mcat));

                        List< pojo.SubCategory> subcat = csub.list();
                        if (subcat.size() > 0) {
                            for (pojo.SubCategory sb : subcat) {
                    
      out.write("\n");
      out.write("                    <li><a href=\"products.jsp?vl6=");
      out.print(sb.getIdsubCategory());
      out.write('"');
      out.write('>');
      out.print(sb.getSubCategory());
      out.write("</a></li>\n");
      out.write("                        ");

                                }
                            }
                        
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            ");

                }
                ses.close();
            
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"center_title_wrapper\">\n");
      out.write("                <div class=\"center_title\">\n");
      out.write("                    Review Summary\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"summary_p_display\">\n");
      out.write("                    <div class=\"pdcontent\" style=\"height: 40px;\">\n");
      out.write("\n");
      out.write("                        <div class=\"pdcntd\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li class=\"pdimgdh\">#</li>\n");
      out.write("                                <li class=\"pdnameh\">Product Name</li>\n");
      out.write("                                <li class=\"pdcodeh\">Product Code</li>\n");
      out.write("                                <li class=\"pdcnth\">Qty</li>\n");
      out.write("                                <li class=\"pdtoth\">Total Amount</li>\n");
      out.write("                                <li class=\"pdwgth\">Total Weight</li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
                    try {

                            if (request.getSession().getAttribute("user-id") == null) {
                                out.write("<div style='height:200px;padding:10px;'>");
                                out.write("Your need to log to procede check out <a href='signin.jsp'>log here</a>");
                                out.write("</div>");
                            } else {
                                Integer userid = (Integer) request.getSession().getAttribute("user-id");
                                Session sespd = conn.connector.getSessionFactory().openSession();
                                pojo.User user = (pojo.User) sespd.load(pojo.User.class, userid);
                                if (user.getUserState().getIduserState() == 1) {
                                    //active user
                                    if (request.getSession().getAttribute("s_cart") == null || ((ArrayList) request.getSession().getAttribute("s_cart")).isEmpty()) {
                                        //your cart is empty
                                        out.write("<div style='height:200px;padding:10px;'>");
                                        out.write("Cart is Empty... please add prodcut <a href='products.jsp'>click to buy</a");
                                        out.write("</div>");
                                    } else {
                                        //your have products
                                        List<int[]> cart = (ArrayList) request.getSession().getAttribute("s_cart");

                                        Criteria crr = sespd.createCriteria(pojo.Product.class);
                                        List<pojo.Product> plist = crr.list();
                                        pojo.Product product = null;
                                        // int readindex = 0;
                                        String murl = "";
                                        int itemcount = cart.size();
                                        double total = 0;
                                        double totaldisocunt = 0;
                                        double totalweight = 0;

                                        for (int rx = 0; rx < cart.size(); rx++) {
                                            int[] sprdt = cart.get(rx);
                                            for (pojo.Product p : plist) {

                                                if (p.getIdproduct() == sprdt[0]) {
                                                    //
                                                    product = p;
                                                    total += p.getPrice() * sprdt[1];
                                                    totaldisocunt += p.getDiscount() * sprdt[1];
                                                    totalweight += p.getWeight() * sprdt[1];
                                                    if (product.getImageUrl1() != null) {
                                                        murl = "_images/product/category/products/" + product.getImageUrl1();
                                                    } else {
                                                        murl = "_images/_site/null_img.png";
                                                    }

                    
      out.write("\n");
      out.write("                    <div class=\"pdcontent\">\n");
      out.write("                        <div class=\"pdimgd\">\n");
      out.write("                            <img src=\"");
      out.print(murl);
      out.write("\" width=\"40\" height=\"40\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"pdcntd\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li class=\"pdname\">");
      out.print(p.getName());
      out.write("</li>\n");
      out.write("                                <li class=\"pdcode\">");
      out.print(p.getProductCode());
      out.write("</li>\n");
      out.write("                                <li class=\"pdcnt\">");
      out.print(sprdt[1]);
      out.write("</li>\n");
      out.write("                                <li class=\"pdtot\">");
      out.print(sprdt[1] * (p.getPrice() - p.getDiscount()));
      out.write("(LKR)</li>\n");
      out.write("                                <li class=\"pdwgt\">");
      out.print(sprdt[1] * p.getWeight());
      out.write("g</li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
                                                }
                            }

                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        String errMSG = "";
                        String style = "display:none";
                        int ecode = 0;
                        if (request.getParameter("eco") != null && !request.getParameter("eco").isEmpty()) {
                            style = "border:1px dotted red;pdding:10px;maring-bottom:-40px;font-size:12px;";
                            ecode = Integer.valueOf(request.getParameter("eco").split("_")[1]);
                            if (ecode == 7788) {
                                errMSG = "select a delivery plan";
                            } else if (ecode == 7789) {
                                errMSG = "Enter your delivary address";
                            } else if (ecode == 7790) {
                                errMSG = "no such delivery plan found";
                            } else if (ecode == 7791) {
                                errMSG = "sorry the request product not available";
                            }

                        } else {

                        }

                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div id=\"psum_msg\" style=\"");
      out.print(style);
      out.write('"');
      out.write('>');
      out.print(errMSG);
      out.write("</div>\n");
      out.write("                    <div class=\"shipping_controll\">\n");
      out.write("\n");
      out.write("                        <div class=\"summary_payments\">\n");
      out.write("                            <form method=\"POST\" action=\"invoice\">\n");
      out.write("                                <input type=\"hidden\" value=\"p300_postal\" name=\"gcode\"/>\n");
      out.write("                                <input type=\"hidden\" value=\"vld1265dix\" name=\"pgx_sumid\"/>\n");
      out.write("                                <div id=\"sp_head\">Payment Details</div>\n");
      out.write("                                <div class=\"sp_it\"><span class=\"sp_it_nm\">Item Count</span>:<span class=\"sp_id_dt\">");
      out.print(itemcount);
      out.write("</span> </div>\n");
      out.write("                                <div class=\"sp_it\"><span class=\"sp_it_nm\">Amount</span>:<span class=\"sp_id_dt\">");
      out.print(total);
      out.write(" </span>(LKR)</div>\n");
      out.write("                                <div class=\"sp_it\"><span class=\"sp_it_nm\">Total Discount</span>:<span class=\"sp_id_dt\">");
      out.print(totaldisocunt);
      out.write("   </span>(LKR) </div>\n");
      out.write("                                <div class=\"sp_it\"><span class=\"sp_it_nm\">Net Amount</span>:<span class=\"sp_id_dt\">");
      out.print(total - totaldisocunt);
      out.write(" </span>(LKR)</div>\n");
      out.write("                                <input type=\"hidden\" value=\"");
      out.print(total - totaldisocunt);
      out.write("\" name=\"in_tamount\" id=\"in_tamount\">\n");
      out.write("                                <div id=\"sp_divd\"></div>\n");
      out.write("                                <div class=\"sp_it\"><span class=\"sp_it_nm\">Total Weight</span>:<span class=\"sp_id_dt\">");
      out.print(totalweight);
      out.write(" </span>(g)</div>\n");
      out.write("                                <input type=\"hidden\" value=\"");
      out.print(totalweight);
      out.write("\" id=\"in_tdsnt\" name=\"in_tdsnt\" >\n");
      out.write("                                <div class=\"sp_it\"><span class=\"sp_it_nm\">Distance</span>:<span class=\"sp_id_dt\" id=\"t-dsnt\"></span>(KM)</div>\n");
      out.write("                                <div class=\"sp_it\"><span class=\"sp_it_nm\">per kilometer</span>:<span class=\"sp_id_dt\" id=\"dpl-cost\"></span>(LKR)</div>\n");
      out.write("                                <div class=\"sp_it\"><span class=\"sp_it_nm\">Delivery Cost</span>:<span class=\"sp_id_dt\" id=\"dt-cost\"></span>(LKR)</div>\n");
      out.write("                                <div id=\"sp_divd\"></div>\n");
      out.write("                                <div class=\"sp_it\" style=\"border: 1px solid #777;font-size: 13px;background-color: darkkhaki;color: #FFF;\" ><span class=\"sp_it_nm\">Total Amount</span>:<span class=\"sp_id_dt\" id=\"tt-cost\" style=\"font-weight: bolder;font-size: 15px;\"></span>(LKR)</div>\n");
      out.write("                                <input type=\"hidden\" name=\"dlpack_code\" value=\"\" id=\"pck_code\">\n");
      out.write("                                <input type=\"hidden\" name=\"dldsnt_ln\" value=\"\" id=\"pcdsnt\">\n");
      out.write("                                <input type=\"hidden\" name=\"fname\" value=\"\" id=\"fname\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"lname\" value=\"\" id=\"lname\">\n");
      out.write("                                <input type=\"hidden\" name=\"add1\" value=\"\" id=\"add1\">\n");
      out.write("                                <input type=\"hidden\" name=\"add2\" value=\"\" id=\"add2\">\n");
      out.write("                                <input type=\"hidden\" name=\"a_city\" value=\"\" id=\"a_city\">\n");
      out.write("                                <input type=\"hidden\" name=\"ps_code\" value=\"\" id=\"ps_code\">\n");
      out.write("                                <input type=\"submit\" value=\"Check out\" id=\"chkout\" disabled />\n");
      out.write("                            </form>\n");
      out.write("                            <div style=\"font-size: 11px; color: #0088cc;margin-bottom: 10px;\">click check out to buy your product and transaction will be made. <br/>\n");
      out.write("                                you will be agree to our terms and condition.<br/><a href=\"#\">terms & condition</a></div>\n");
      out.write("                            <img src=\"_images/_site/paypal-icon_png.jpeg\" width=\"270\" height=\"50\">\n");
      out.write("                        </div>\n");
      out.write("                        Delivery Details\n");
      out.write("                        <form name=\"del_data\" id=\"del_data\">\n");
      out.write("                            <label>First Name</label>\n");
      out.write("                            <input type=\"text\" name=\"s_fname\" id=\"s_fname\" onkeyup=\"document.getElementById('fname').value = document.getElementById('s_fname').value\"/>\n");
      out.write("                            <label>Last Name</label>\n");
      out.write("                            <input type=\"text\" name=\"s_lname\" id=\"s_lname\" onkeyup=\"document.getElementById('lname').value = document.getElementById('s_lname').value\"/>\n");
      out.write("                            <label>Address Line 1</label>\n");
      out.write("                            <input type=\"text\" name=\"s_addl_1\" id=\"s_add1\" onkeyup=\"document.getElementById('add1').value = document.getElementById('s_add1').value\"/>\n");
      out.write("                            <label>Address Line 2</label>\n");
      out.write("                            <input type=\"text\" name=\"s_addl_2\" id=\"s_add2\" onkeyup=\"document.getElementById('add2').value = document.getElementById('s_add2').value\"/>\n");
      out.write("                            <label>City - (delivery on this )</label>\n");
      out.write("                            <input type=\"text\" name=\"s_city\" id=\"s_city\" onkeyup=\"document.getElementById('a_city').value = document.getElementById('s_city').value\" />\n");
      out.write("                            <label id=\"s_err_msg\"></label>\n");
      out.write("                            <label>Postal Code</label>\n");
      out.write("                            <input type=\"text\" name=\"s_distric\" id=\"s_pscode\" onkeyup=\"document.getElementById('ps_code').value = document.getElementById('s_pscode').value\"/>\n");
      out.write("                            <label>Country</label>\n");
      out.write("                            <input type=\"text\" name=\"s_country\" value=\"Sri Lanka\" disabled>\n");
      out.write("                            <input type=\"hidden\" name=\"s_cntry\" value=\"LK\"/>\n");
      out.write("                            <label>Select a delivery method</label>\n");
      out.write("                            <select id=\"dplans\" name=\"dplans\">\n");
      out.write("                                ");

                                    Session sesdplan = conn.connector.getSessionFactory().openSession();

                                    Criteria c = sesdplan.createCriteria(pojo.DeliveryPlan.class);
                                    List<pojo.DeliveryPlan> dlist = c.list();
                                    for (pojo.DeliveryPlan dplan : dlist) {
                                
      out.write("\n");
      out.write("                                <option name value=\"");
      out.print(dplan.getIddeliveryPlan());
      out.write("\"> ");
      out.print(dplan.getName());
      out.write("</option>\n");
      out.write("                                ");

                                    }
                                    sesdplan.close();
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("\n");
      out.write("                            <input type=\"button\" value=\"Calculate\" onclick=\"validateDeliveryForm()\">\n");
      out.write("                        </form>\n");
      out.write("                        <div id=\"sd_form_msg\"></div>\n");
      out.write("                        <div style=\"background-color: #0088cc;color: #FFF;padding: 5px;font-size: 12px;font-weight: bolder; \">We are delivery only inside Sri Lanka. Do not enter any foreign Cities </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                                    }
                                } else {
                                    response.sendRedirect("user_login?usrxttp=522_1254");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"footer_wrapper\">\n");
      out.write("    <div class=\"footer_container\">\n");
      out.write("        <ul>\n");
      out.write("            ");

                Session sesfoot = conn.connector.getSessionFactory().openSession();
                Criteria ccrfoot = sesfoot.createCriteria(pojo.Catagory.class);

                List<pojo.Catagory> lstxxx = ccrfoot.list();

                for (pojo.Catagory cat : lstxxx) {
            
      out.write("\n");
      out.write("            <li><a href=\"#\">");
      out.print(cat.getCatagory());
      out.write("</a>\n");
      out.write("                <ul>\n");
      out.write("                    ");

                        pojo.Catagory mcatx = (pojo.Catagory) sesfoot.load(pojo.Catagory.class, cat.getIdcatagory());
                        Criteria csub = sesfoot.createCriteria(pojo.SubCategory.class);
                        csub.add(Restrictions.eq("catagory", mcatx));

                        List< pojo.SubCategory> subcat = csub.list();
                        if (subcat.size() > 0) {
                            for (pojo.SubCategory sb : subcat) {
                    
      out.write("\n");
      out.write("                    <li><a href=\"products.jsp?vl6=");
      out.print(sb.getIdsubCategory());
      out.write('"');
      out.write('>');
      out.print(sb.getSubCategory());
      out.write("</a></li>\n");
      out.write("                        ");

                                }
                            }
                        
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            ");

                }
                sesfoot.close();
            
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"newslttr\">\n");
      out.write("            <input type=\"email\" name=\"newsmail\" placeholder=\"example@host.com\">\n");
      out.write("            <input type=\"submit\" value=\"subcribe\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"foot-navg\">\n");
      out.write("            <div id=\"right-ex\">Alright reserved @ <a href=\"index.jsp\">royal flowers</a> | developed & design @ CARTS.solutions </div>\n");
      out.write("            <div id=\"ex-nav\">\n");
      out.write("                <ul >\n");
      out.write("                    <li><a href=\"index.jsp\">home</a></li>\n");
      out.write("                    <li><a href=\"#\">about</a></li>\n");
      out.write("                    <li><a href=\"#\">contact</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        .footer_container{\n");
      out.write("            padding-top: 30px;\n");
      out.write("        }\n");
      out.write("        .footer_container ul li a{\n");
      out.write("            color: #CCC;\n");
      out.write("        }\n");
      out.write("        .footer_container ul{\n");
      out.write("            padding: 0;\n");
      out.write("            /*margin-top: 200px;*/\n");
      out.write("            font-size: 13px;\n");
      out.write("            margin-left: 200px;\n");
      out.write("            text-align: justify;\n");
      out.write("            font-weight: bolder;\n");
      out.write("        }\n");
      out.write("        .footer_container ul li{\n");
      out.write("            display: inline-block;\n");
      out.write("            margin-left: 10px;\n");
      out.write("            /*border: 1px solid #777;*/\n");
      out.write("            width: 170px;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        .footer_container ul li ul{\n");
      out.write("            margin-top: 0;\n");
      out.write("            position: absolute;\n");
      out.write("            margin-left: 0;\n");
      out.write("        }\n");
      out.write("        .footer_container ul li ul li{\n");
      out.write("            display: block;\n");
      out.write("            margin-left: 0;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        .footer_container ul li ul li a:hover{\n");
      out.write("            color: #FFF;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        .footer_container ul li ul li a{\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("        .newslttr{\n");
      out.write("            /*border: 1px solid #777;*/\n");
      out.write("            position: relative;\n");
      out.write("            margin-top: 100px;\n");
      out.write("            width: 400px;\n");
      out.write("            margin-left: 210px;\n");
      out.write("        }\n");
      out.write("        .newslttr input[type=email]{\n");
      out.write("            width: 300px;\n");
      out.write("            padding: 5px 3px;\n");
      out.write("        }\n");
      out.write("        .newslttr input[type=submit]{\n");
      out.write("           \n");
      out.write("            padding: 3px 3px;\n");
      out.write("        }\n");
      out.write("        #ex-nav{\n");
      out.write("            float: right;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        #ex-nav ul li{\n");
      out.write("            margin-left: -130px;\n");
      out.write("        }\n");
      out.write("        #ex-nav ul li a{\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("        #right-ex{\n");
      out.write("            float: left;\n");
      out.write("            margin-left: 210px;\n");
      out.write("            margin-top: 35px;\n");
      out.write("            font-size: 13px;\n");
      out.write("            color: #FFF;\n");
      out.write("        }\n");
      out.write("        #right-ex a{\n");
      out.write("            color: #FFF;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        .summary_p_display{\n");
      out.write("            font-size: 12px;\n");
      out.write("            width: 950px;\n");
      out.write("            /*height: 200px;*/\n");
      out.write("            /*border: 1px solid #777;*/\n");
      out.write("            padding: 5px;\n");
      out.write("            margin-left: 20px;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            float: left;\n");
      out.write("        }\n");
      out.write("        .summary_p_display ul{\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        .summary_p_display .pdimgd{\n");
      out.write("            clear: left;\n");
      out.write("            float: left;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .summary_p_display ul li{\n");
      out.write("            display: inline-block;\n");
      out.write("            list-style: none;\n");
      out.write("        }\n");
      out.write("        .pdname, .pdcnt, .pdtot , .pdwgt ,.pdcode{\n");
      out.write("            /*border: 1px solid #777;*/\n");
      out.write("            padding: 10px 3px;\n");
      out.write("            margin-left: 19px;\n");
      out.write("            margin-top: 1px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .pdcode{\n");
      out.write("            width: 150px;\n");
      out.write("        }\n");
      out.write("        .pdname {\n");
      out.write("            width: 350px;\n");
      out.write("        }\n");
      out.write("        .pdcnt{\n");
      out.write("            width: 20px;\n");
      out.write("        }\n");
      out.write("        .pdtot{\n");
      out.write("            width: 100px;\n");
      out.write("        }\n");
      out.write("        .pdwgt{\n");
      out.write("            width: 100px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .pdcontent{\n");
      out.write("            border-bottom: 1px dotted #CCC;\n");
      out.write("        }\n");
      out.write("        .pdnameh, .pdcnth, .pdtoth , .pdwgth, .pdimgdh, .pdcodeh{\n");
      out.write("            /*border: 1px solid #777;*/\n");
      out.write("            padding: 10px 3px;\n");
      out.write("            margin-left: 20px;\n");
      out.write("            margin-top: 1px;\n");
      out.write("            text-align: center;\n");
      out.write("            font-weight: bolder;\n");
      out.write("        }\n");
      out.write("        .pdimgdh{\n");
      out.write("            width: 20px;\n");
      out.write("            margin-left: 10px;\n");
      out.write("        }\n");
      out.write("        .pdcodeh{\n");
      out.write("            width: 150px;\n");
      out.write("        }\n");
      out.write("        .pdnameh {\n");
      out.write("            width: 350px;\n");
      out.write("        }\n");
      out.write("        .pdcnth{\n");
      out.write("            width: 20px;\n");
      out.write("        }\n");
      out.write("        .pdtoth{\n");
      out.write("            width: 100px;\n");
      out.write("        }\n");
      out.write("        .pdwgth{\n");
      out.write("            width: 100px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .shipping_controll{\n");
      out.write("            margin-top: 50px;\n");
      out.write("        }\n");
      out.write("        .shipping_controll{\n");
      out.write("            width: 650px;\n");
      out.write("            padding: 10px;\n");
      out.write("            border: 1px solid #CCC;\n");
      out.write("        }\n");
      out.write("        .shipping_controll form label{\n");
      out.write("            display: block;\n");
      out.write("        }\n");
      out.write("        .shipping_controll form{\n");
      out.write("            padding: 5px;\n");
      out.write("        }\n");
      out.write("        .shipping_controll form input[type=text]{\n");
      out.write("            display: block;\n");
      out.write("            width: 250px;\n");
      out.write("            padding: 3px;\n");
      out.write("            margin-top: 5px;\n");
      out.write("            margin-bottom: 5px;\n");
      out.write("            border: 1px solid #CCC;\n");
      out.write("        }\n");
      out.write("        .shipping_controll form input[type=button]{\n");
      out.write("            display: block;\n");
      out.write("            width: 100px;\n");
      out.write("            padding: 2px;\n");
      out.write("            margin-top: 5px;\n");
      out.write("        }\n");
      out.write("        .shipping_controll form select{\n");
      out.write("            display: block;\n");
      out.write("            width: 150px;\n");
      out.write("            padding: 3px;\n");
      out.write("            margin-top: 5px;\n");
      out.write("        }\n");
      out.write("        .summary_payments{\n");
      out.write("            font-size: 12px;\n");
      out.write("            width: 270px;\n");
      out.write("            height: 200px;\n");
      out.write("            /*border: 1px solid #777;*/\n");
      out.write("            padding: 5px;\n");
      out.write("            float: right;\n");
      out.write("            margin-top: -5px;\n");
      out.write("        }\n");
      out.write("        .summary_payments #sp_head{\n");
      out.write("            font-size: 14px;\n");
      out.write("        }\n");
      out.write("        .summary_payments #sp_divd{\n");
      out.write("            padding: 2px 3px;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .summary_payments .sp_it{\n");
      out.write("            font-size: 13px;\n");
      out.write("            padding: 1px 3px;\n");
      out.write("            font-family: consolas;\n");
      out.write("        }\n");
      out.write("        .summary_payments .sp_it .sp_it_nm{\n");
      out.write("            width: 110px;\n");
      out.write("            display: inline-block;\n");
      out.write("        }\n");
      out.write("        .summary_payments .sp_it .sp_id_dt{\n");
      out.write("            padding: 0 3px;\n");
      out.write("            display: inline-block;\n");
      out.write("\n");
      out.write("            /*border: 1px solid #777;*/\n");
      out.write("            width: 80px;\n");
      out.write("        }\n");
      out.write("        .summary_payments form input[type='submit']{\n");
      out.write("            margin-top: 10px;\n");
      out.write("            //background-color: #777;\n");
      out.write("            //border: 1px solid #666;\n");
      out.write("            width: 250px;\n");
      out.write("            padding: 3px;\n");
      out.write("            margin-left: 5px;\n");
      out.write("            //box-shadow: 0px 0px 10px -3px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        //global verialbels\n");
      out.write("        var perkilometeramount = 0;\n");
      out.write("        var totaldistance = 0;\n");
      out.write("        var deliveryt_cost = 0;\n");
      out.write("        var netamount = 0;\n");
      out.write("        var totalcost = 0;\n");
      out.write("\n");
      out.write("        var totalweight = 0;\n");
      out.write("\n");
      out.write("        var checkout = false;\n");
      out.write("        enable_checkout();\n");
      out.write("        function enable_checkout() {\n");
      out.write("            if (checkout) {\n");
      out.write("                document.getElementById(\"chkout\").disabled = false;\n");
      out.write("            } else {\n");
      out.write("                document.getElementById(\"chkout\").disabled = true;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function validateDeliveryForm() {\n");
      out.write("            var form = document.getElementById(\"del_data\");\n");
      out.write("            var validated = true;\n");
      out.write("            for (var i = 0; i < form.length; i++) {\n");
      out.write("                if (form[i].type !== 'button') {\n");
      out.write("                    if (form[i].value === \"\") {\n");
      out.write("                        form[i].style = \"border:1px dotted red;\";\n");
      out.write("                        validated = false;\n");
      out.write("\n");
      out.write("                        if (form[4].value === \"\") {\n");
      out.write("                            document.getElementById(\"s_err_msg\").innerHTML = \"Enter your city\";\n");
      out.write("                            document.getElementById(\"s_err_msg\").style = \"color:red;font-size:11px;\";\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    } else {\n");
      out.write("                        form[i].style = \"border:1px solid #CCC;\";\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            if (validated) {\n");
      out.write("                showLocation();\n");
      out.write("                document.getElementById(\"psum_msg\").innerHTML = \"\";\n");
      out.write("                document.getElementById(\"psum_msg\").style = \"display:none;\";\n");
      out.write("\n");
      out.write("            } else {\n");
      out.write("                document.getElementById(\"psum_msg\").innerHTML = \"error... delivery address invalid\";\n");
      out.write("                document.getElementById(\"psum_msg\").style = \"color:red;border:1px dotted red;font-size: 12px; padding: 10px 5px; margin: 10px 0 -45px 0;\";\n");
      out.write("                document.getElementById('dpl-cost').innerHTML = \"invalid\";\n");
      out.write("                document.getElementById('dt-cost').innerHTML = \"invalid\";\n");
      out.write("                document.getElementById('tt-cost').innerHTML = \"invalid\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function showLocation() {\n");
      out.write("            try {\n");
      out.write("                // alert('initializing...');\n");
      out.write("                geocoder = new GClientGeocoder();\n");
      out.write("                //  alert(\"initialized...\");\n");
      out.write("                geocoder.getLocations('Kurunegala', function (response) {\n");
      out.write("                    //alert('2');\n");
      out.write("                    if (!response || response.Status.code !== 200) {\n");
      out.write("                        alert(\"Sorry, we were unable to geocode the first address\");\n");
      out.write("                    } else {\n");
      out.write("                        // alert('3');\n");
      out.write("                        location1 = {lat: response.Placemark[0].Point.coordinates[1], lon: response.Placemark[0].Point.coordinates[0], address: response.Placemark[0].address};\n");
      out.write("                        geocoder.getLocations(document.getElementById('s_city').value, function (response) {\n");
      out.write("                            //alert('getting location 2..');\n");
      out.write("                            if (!response || response.Status.code !== 200) {\n");
      out.write("                                alert(\"Sorry, we were unable to geocode the second address\");\n");
      out.write("                            } else {\n");
      out.write("                                location2 = {lat: response.Placemark[0].Point.coordinates[1], lon: response.Placemark[0].Point.coordinates[0], address: response.Placemark[0].address};\n");
      out.write("                                calculateDistance();\n");
      out.write("                                // alert('getting location finished');\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            } catch (error) {\n");
      out.write("                alert(error);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // getperkilometer amount\n");
      out.write("\n");
      out.write("\n");
      out.write("        function calculateDistance() {\n");
      out.write("            try {\n");
      out.write("                var glatlng1 = new GLatLng(location1.lat, location1.lon);\n");
      out.write("                var glatlng2 = new GLatLng(location2.lat, location2.lon);\n");
      out.write("                var miledistance = glatlng1.distanceFrom(glatlng2, 3959).toFixed(1);\n");
      out.write("                var kmdistance = (miledistance * 1.609344).toFixed(1);\n");
      out.write("                //alert(kmdistance);\n");
      out.write("\n");
      out.write("                if (Number(kmdistance) > 250) {\n");
      out.write("                    document.getElementById('s_err_msg').innerHTML = \"Out of srilanka... please select a city in srilanka\";\n");
      out.write("                    document.getElementById('s_err_msg').style = \"color:red;font-size:11px;\";\n");
      out.write("                    document.getElementById('t-dsnt').innerHTML = \"Out Of Range\";\n");
      out.write("                    document.getElementById('t-dsnt').style = \"color:red;\";\n");
      out.write("                    document.getElementById('dpl-cost').innerHTML = \"invalid\";\n");
      out.write("                    document.getElementById('dt-cost').innerHTML = \"invalid\";\n");
      out.write("                    document.getElementById('tt-cost').innerHTML = \"invalid\";\n");
      out.write("                    checkout = false;\n");
      out.write("                    enable_checkout();\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById('s_err_msg').innerHTML = \"We will delivery to this location\";\n");
      out.write("                    document.getElementById('s_err_msg').style = \"color:green;font-size:11px;\";\n");
      out.write("                    document.getElementById('t-dsnt').innerHTML = kmdistance;\n");
      out.write("                    document.getElementById('pcdsnt').value = kmdistance;\n");
      out.write("                    document.getElementById('pck_code').value = document.getElementById('dplans').value;\n");
      out.write("                    totaldistance = kmdistance;\n");
      out.write("                    document.getElementById('t-dsnt').style = \"color:green;\";\n");
      out.write("                    getCostPerKm();\n");
      out.write("                }\n");
      out.write("            } catch (error) {\n");
      out.write("                alert(error);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function getCostPerKm() {\n");
      out.write("            getxmlhttp();\n");
      out.write("            var deliver_planid = document.getElementById('dplans').value;\n");
      out.write("            xmlhttp.onreadystatechange = function () {\n");
      out.write("                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {\n");
      out.write("                    perkilometeramount = xmlhttp.responseText;\n");
      out.write("                    document.getElementById('dpl-cost').innerHTML = perkilometeramount;\n");
      out.write("\n");
      out.write("                    totalweight = document.getElementById('in_tdsnt').value;\n");
      out.write("                    netamount = document.getElementById(\"in_tamount\").value;\n");
      out.write("\n");
      out.write("                    deliveryt_cost = ((Number(perkilometeramount) / Number(1000)) * Number(totalweight) * Number(totaldistance)).toFixed(2);\n");
      out.write("                    totalcost = Number(netamount) + Number(deliveryt_cost);\n");
      out.write("                    document.getElementById('dt-cost').innerHTML = Number(deliveryt_cost);\n");
      out.write("                    document.getElementById('tt-cost').innerHTML = Number(totalcost);\n");
      out.write("                    checkout = true;\n");
      out.write("                    enable_checkout();\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            xmlhttp.open(\"POST\", \"getDeliveryPerkmCosting?dplnid=\" + deliver_planid + \"&dsnt=\" + totaldistance, true);\n");
      out.write("            xmlhttp.send();\n");
      out.write("\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("</html>\n");
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
