package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;
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

public final class product_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Products | Green Wood Furniture</title>\n");
      out.write("        <link href=\"_css/_custome_002.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("        <script type=\"text/javascript\" src=\"_script/_js/_custome_01.js\"></script>\n");
      out.write("        <script type = \"text/javascript\" src = \"_script/jquery-1.7.2.min.js\" charset = \"utf-8\" ></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"_script/jquery.easing.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"_script/jquery.easy-ticker.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function photoChanger(img_id) {\n");
      out.write("                var main_img = document.getElementById(\"main_img\");\n");
      out.write("                var sub_img = document.getElementById(img_id);\n");
      out.write("                //alert(main_img.src);\n");
      out.write("                main_img.src = sub_img.src;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /*add slidering*/\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var dd = $('.sun_ad_slider').easyTicker({\n");
      out.write("                    direction: 'up',\n");
      out.write("                    //easing: 'easeInOutBack',\n");
      out.write("                    speed: 'slow',\n");
      out.write("                    interval: 5000,\n");
      out.write("                    height: '465',\n");
      out.write("                    visible: 1,\n");
      out.write("                    mousePause: 0,\n");
      out.write("                }).data('easyTicker');\n");
      out.write("\n");
      out.write("            });\n");
      out.write("            var xmlhttp;\n");
      out.write("            function getxmlhttp() {\n");
      out.write("                if (window.XMLHttpRequest) {\n");
      out.write("                    xmlhttp = new XMLHttpRequest();\n");
      out.write("                    //alert(\"XMLHTTP\");\n");
      out.write("                } else {\n");
      out.write("                    xmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                    //alert(\"ActiveX\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function put_likes(status, pid, user_id) {\n");
      out.write("                try {\n");
      out.write("                    getxmlhttp();\n");
      out.write("                    var save_enable = true;\n");
      out.write("                    if (user_id === \"0\") {\n");
      out.write("                        save_enable = false;\n");
      out.write("                    }\n");
      out.write("                    if (save_enable) {\n");
      out.write("                        var url_pattern = \"?likestatusid=\" + status + \"&pid=\" + pid + \"&usr_id=\" + user_id;\n");
      out.write("                        xmlhttp.onreadystatechange = function () {\n");
      out.write("                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {\n");
      out.write("                                if (xmlhttp.responseText.split(\"_\")[0] === \"1\") {\n");
      out.write("                                    document.getElementById(\"likecdis\").innerHTML = xmlhttp.responseText.split(\"_\")[1].split(\",\")[0];\n");
      out.write("                                    document.getElementById(\"unlikecdis\").innerHTML = xmlhttp.responseText.split(\"_\")[1].split(\",\")[1];\n");
      out.write("                                } else {\n");
      out.write("                                    alert(xmlhttp.responseText.split(\"_\")[1]);\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                        };\n");
      out.write("                        xmlhttp.open(\"POST\", \"put_like\" + url_pattern, true);\n");
      out.write("                        xmlhttp.send();\n");
      out.write("                    } else {\n");
      out.write("                        alert(\"To rate this product you must login\");\n");
      out.write("                    }\n");
      out.write("                } catch (error) {\n");
      out.write("                    alert(error);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .sun_ad_slider ul{\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("        </style>\n");
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
      out.write("            ");
                //varibales
                int pid = 0;
                int qty = 0;
                double price = 0;
                double discount = 0;
                double weihgt = 0;

                String pcode = "";
                String brand = "";
                String desc = "";
                String pcolor = "";
                String name = "";
                String img_1 = "";
                String img_2 = "";
                String img_3 = "";
                String img_main_url = "";

                int brandidprolaod = 0;

                //check if product availbe
                if (request.getParameter("pcode") == null || request.getParameter("pcode").length() == 0) {
                    //no product code has passed
                    response.sendRedirect("index.jsp");
                } else {
                    Session sespro = conn.connector.getSessionFactory().openSession();

                    Criteria pcr = sespro.createCriteria(pojo.Product.class);
                    pcr.add(Restrictions.eq("productCode", request.getParameter("pcode")));

                    pojo.Product product = (pojo.Product) pcr.uniqueResult();
                    brandidprolaod = product.getBrand().getIdbrand();

                    if (product == null) {
                        // no prodcut avlible for the code
                        response.sendRedirect("index.jsp");
                    } else {
                        // product is availbe
                        pid = product.getIdproduct();
                        name = product.getName();
                        qty = product.getQty();
                        price = product.getPrice();
                        discount = product.getDiscount();
                        pcode = product.getProductCode();
                        pcolor = product.getProductColor().getColor();
                        weihgt = product.getWeight();
                        desc = product.getDescription();
                        brand = product.getBrand().getBrandName();
                        //img ulrs seeting up
                        if (product.getImageUrl1() != null) {
                            img_1 = "_images/product/category/products/" + product.getImageUrl1();
                        } else {
                            img_1 = "_images/_site/null_img.png";
                        }
                        if (product.getImageUrl2() != null) {
                            img_2 = "_images/product/category/products/" + product.getImageUrl2();
                        } else {
                            img_2 = "_images/_site/null_img.png";
                        }
                        if (product.getImageUrl3() != null) {
                            img_3 = "_images/product/category/products/" + product.getImageUrl3();
                        } else {
                            img_3 = "_images/_site/null_img.png";
                        }

                        img_main_url = img_1;
                    }
                    sespro.close();
                }

            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!--div class=\"center_title_wrapper\">\n");
      out.write("                <div class=\"center_title\">\n");
      out.write("                    All Products\n");
      out.write("                </div>\n");
      out.write("            </div-->\n");
      out.write("            <div class=\"product_detail_wrapper\">\n");
      out.write("                <div class=\"product_detail_container\">\n");
      out.write("                    <div class=\"product_detail_img\">\n");
      out.write("                        <div class=\"pro_big_img\">\n");
      out.write("                            <img src=\"");
      out.print(img_main_url);
      out.write("\" id=\"main_img\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"pro_mini_img\">\n");
      out.write("                            <img src=\"");
      out.print(img_1);
      out.write("\" onclick=\"photoChanger('sub_img_1')\" id=\"sub_img_1\"/>\n");
      out.write("                            <img src=\"");
      out.print(img_2);
      out.write("\" onclick=\"photoChanger('sub_img_2')\"  id=\"sub_img_2\"/>\n");
      out.write("                            <img src=\"");
      out.print(img_3);
      out.write("\"  onclick=\"photoChanger('sub_img_3')\" id=\"sub_img_3\"/>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"prodcut_detail_center\">\n");
      out.write("                        <div class=\"pro-details-title\">");
      out.print(name);
      out.write("</div>\n");
      out.write("                        <!--div class=\"pro-details-review\">Reviews : 45</div-->\n");
      out.write("                        <div class=\"pro-details-status\">Availability :\n");
      out.write("                            ");

                                if (qty > 0) {

                            
      out.write("\n");
      out.write("                            <span class=\"stock-status-msg-t\">In Stock</span>\n");
      out.write("                            ");
                            } else {
                            
      out.write("\n");
      out.write("                            <span class=\"stock-status-msg-f\">Out Of Stock</span>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <form action=\"addtocart\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"pid\" value=\"");
      out.print(pid);
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"pcode\" id=\"pcode\" value=\"");
      out.print(pcode);
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"pqty\" id=\"pqty\" value=\"");
      out.print(qty);
      out.write("\"/>\n");
      out.write("                            <div class=\"pro-details-price-box\">\n");
      out.write("                                <div class=\"pro-d-price\">Price :\n");
      out.write("                                    <span class=\"pro-p-old\" >Rs ");
      out.print(price);
      out.write("</span>\n");
      out.write("                                    <input type=\"hidden\" value=\"");
      out.print(price);
      out.write("\" id=\"pprice\" />\n");
      out.write("                                    <span class=\"pro-p-new\" >Rs ");
      out.print(price - discount);
      out.write("</span>\n");
      out.write("                                    <input type=\"hidden\" value=\"");
      out.print(discount);
      out.write("\" id=\"pdiscount\" />\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"pro-qty\">Quantity : <span class=\"pro-qty-dis\"><input type=\"text\" value=\"1\"  onkeypress='return (event.charCode >= 48 && event.charCode <= 57) || event.charCode === 0' value=\"0\"name=\"uqty\" onkeyup=\"setQty()\" id=\"uqty\"></span> <!--span class=\"pro-qty-up\"><img src=\"_images/_site/_arrows/arr_up.png\"></span><span class=\"pro-qty-down\"><img src=\"_images/_site/_arrows/arr_down.png\"></span--></div>\n");
      out.write("                                <div id=\"qty_msg\" style=\"color: red;font-size: 11px;padding: 0;margin-top: -10px;height: 10px; margin-bottom: 5px;\"></div>\n");
      out.write("                                <div class=\"pro-amt-dis\">\n");
      out.write("                                    <div class=\"pro-tot-amount\" id=\"tot-amount\">Total Amount : Rs ");
      out.print(price - discount * 1);
      out.write(" </div>\n");
      out.write("                                    <div class=\"pro-tot-saving\" id=\"tot-saving\">Total Saving : Rs  ");
      out.print(discount * 1);
      out.write(" </div>  \n");
      out.write("                                </div>\n");
      out.write("                                <!-- pass the submit type here-->\n");
      out.write("                                <div class=\"pro-chkout\" id=\"btn-add-cart\"><input type=\"submit\" value=\"Add to Cart\"><input type=\"submit\" value=\"Buy Now\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                        ");

                            Session sesadrate = conn.connector.getSessionFactory().openSession();
                            pojo.Product product = (pojo.Product) sesadrate.load(pojo.Product.class, pid);

                            int usrid = 0;
                            pojo.User usrx = null;
                            if (request.getSession().getAttribute("user-id") != null) {
                                usrid = (Integer) request.getSession().getAttribute("user-id");
                                usrx = (pojo.User) sesadrate.load(pojo.User.class, usrid);
                            }

                            //getting buyied user count
                            Criteria buyercr = sesadrate.createCriteria(pojo.ProductRating.class);
                            buyercr.add(Restrictions.eq("product", product));

                            int buyercount = 0;
                            int purchasecount = 0;
                            List<pojo.ProductRating> prlist = buyercr.list();
                            for (pojo.ProductRating pr : prlist) {
                                if (pr.getBoughtCount() != null && pr.getBoughtCount() > 0) {
                                    purchasecount += pr.getBoughtCount();
                                    buyercount++;
                                }
                            }

                            //getting all purcase count
                            //create likes
                            pojo.PVotes votelike = (pojo.PVotes) sesadrate.load(pojo.PVotes.class, 1);
                            pojo.PVotes voteunlike = (pojo.PVotes) sesadrate.load(pojo.PVotes.class, 2);

                            //get like count
                            Criteria likescr = sesadrate.createCriteria(pojo.ProductRating.class);
                            likescr.add(Restrictions.eq("PVotes", votelike));
                            likescr.add(Restrictions.eq("product", product));
                            int likecount = likescr.list().size();
                            //get unlike count

                            Criteria unlikescr = sesadrate.createCriteria(pojo.ProductRating.class);
                            unlikescr.add(Restrictions.eq("PVotes", voteunlike));
                            unlikescr.add(Restrictions.eq("product", product));
                            int unlikecount = unlikescr.list().size();
                        
      out.write("\n");
      out.write("                        <div class=\"p_ratings\" style=\"border: 1px solid #CCC; padding: 5px;\">\n");
      out.write("                            <div style=\"font-size: 13px;border-bottom: 1px solid #CCC;width: 200px;margin-bottom: 5px;\">This product Rating Level</div>\n");
      out.write("                            <div style=\"font-size: 12px;\"><span>Total count of buyers </span><span>");
      out.print(buyercount);
      out.write("  </span> </div>\n");
      out.write("                            <div style=\"font-size: 12px;\"><span>Total purchase count</span> <span>");
      out.print(purchasecount);
      out.write("  </span> </div>\n");
      out.write("                            <div style=\"font-size: 12px;margin-top: 5px;\"><span>Is this product good </span></div>\n");
      out.write("                            <div style=\"font-size: 12px;\"><span onclick=\"put_likes('1', '");
      out.print(pid);
      out.write("', '");
      out.print(usrid);
      out.write("')\" style=\"cursor: pointer;display: inline-block\" > like </span><span id=\"likecdis\">");
      out.print(likecount);
      out.write("</span> <span onclick=\"put_likes('2', '");
      out.print(pid);
      out.write("', '");
      out.print(usrid);
      out.write("')\" style=\"cursor: pointer;display: inline-block\"> unlike <span id=\"unlikecdis\">");
      out.print(unlikecount);
      out.write("</span></span></div>\n");
      out.write("                        </div>\n");
      out.write("                        ");
sesadrate.close();
      out.write("\n");
      out.write("                        <div class=\"pro-details-sub-header\">QUICK OVERVIEW</div>\n");
      out.write("                        <div class=\"pro-details-desc\">\n");
      out.write("                            ");
      out.print(desc);
      out.write("<br/><br/>\n");
      out.write("                            Weight : ");
      out.print(weihgt + "g");
      out.write("<br/>\n");
      out.write("                            Color  : ");
      out.print(pcolor);
      out.write(" <br/>\n");
      out.write("                            Brand  : ");
      out.print(brand);
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"prodcut_detail_right\">\n");
      out.write("                        <div class=\"crt_add_lnk\">Advertising <a href=\"add_create.jsp\">Create Ad</a></div>\n");
      out.write("                        <div class=\"sun_ad_slider\">\n");
      out.write("                            <ul>\n");
      out.write("                                ");
/*ad loading */

                                    Session sesadds = conn.connector.getSessionFactory().openSession();
                                    pojo.AdvertisingStatus adstatus = (pojo.AdvertisingStatus) sesadds.load(pojo.AdvertisingStatus.class, 1);
                                    pojo.AdvertisingLocation adloc = (pojo.AdvertisingLocation) sesadds.load(pojo.AdvertisingLocation.class, 2);
                                    Criteria crads = sesadds.createCriteria(pojo.Advertising.class);
                                    crads.add(Restrictions.eq("advertisingStatus", adstatus));
                                    crads.add(Restrictions.eq("advertisingLocation", adloc));

                                    List<pojo.Advertising> adlist = crads.list();
                                    if (adlist.size() == 0) {
                                
      out.write(" \n");
      out.write("                                <li>\n");
      out.write("                                    <div class=\"prd_adds\">\n");
      out.write("\n");
      out.write("                                        <img src=\"_images/_add/_sub_page/ad_default_sub.jpg\" >\n");
      out.write("                                        <div class=\"prd_adds_title\">Advertising plannig</div>\n");
      out.write("                                        <div class=\"prd_adds_lnk\"><a href=\"#\">www.royalfolwers.com</a></div>\n");
      out.write("                                        <div class=\"prd_adds_descc\">reach out more customer with us</div> \n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <div class=\"prd_adds\">\n");
      out.write("\n");
      out.write("                                        <img src=\"_images/_add/_sub_page/ad_default2_sub.jpg\" >\n");
      out.write("                                        <div class=\"prd_adds_title\">Adverting plannig</div>\n");
      out.write("                                        <div class=\"prd_adds_lnk\"><a href=\"#\">www.royalfolwers.com</a></div>\n");
      out.write("                                        <div class=\"prd_adds_descc\">make your business wider </div> \n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                ");

                                } else if (adlist.size() == 1) {
                                    pojo.Advertising ad = adlist.get(0);
                                
      out.write("\n");
      out.write("                                <li>\n");
      out.write("                                    <div class=\"prd_adds\">\n");
      out.write("\n");
      out.write("                                        <img src=\"_images/_add/_sub_page/");
      out.print(ad.getImgUrl());
      out.write("\" >\n");
      out.write("                                        <div class=\"prd_adds_title\">");
      out.print(ad.getAddTitle());
      out.write(" </div>\n");
      out.write("                                        <div class=\"prd_adds_lnk\"><a href=\"");
      out.print(ad.getWebsiteUrl());
      out.write('"');
      out.write('>');
      out.print(ad.getWebsiteUrl());
      out.write("</a></div>\n");
      out.write("                                        <div class=\"prd_adds_descc\">");
      out.print(ad.getDescription());
      out.write("</div> \n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <div class=\"prd_adds\">\n");
      out.write("\n");
      out.write("                                        <img src=\"_images/_add/_sub_page/ad_default_sub.jpg\" >\n");
      out.write("                                        <div class=\"prd_adds_title\">Adverting plannig</div>\n");
      out.write("                                        <div class=\"prd_adds_lnk\"><a href=\"#\">www.royalfolwers.com</a></div>\n");
      out.write("                                        <div class=\"prd_adds_descc\">make your business wider</div> \n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                ");

                                } else {

                                    for (pojo.Advertising ad : adlist) {
                                
      out.write("\n");
      out.write("                                <li>\n");
      out.write("                                    <div class=\"prd_adds\">\n");
      out.write("\n");
      out.write("                                        <img src=\"_images/_add/_sub_page/");
      out.print(ad.getImgUrl());
      out.write("\" >\n");
      out.write("                                        <div class=\"prd_adds_title\">");
      out.print(ad.getAddTitle());
      out.write(" </div>\n");
      out.write("                                        <div class=\"prd_adds_lnk\"><a href=\"");
      out.print(ad.getWebsiteUrl());
      out.write('"');
      out.write('>');
      out.print(ad.getWebsiteUrl());
      out.write("</a></div>\n");
      out.write("                                        <div class=\"prd_adds_descc\">");
      out.print(ad.getDescription());
      out.write("</div> \n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                ");

                                        }
                                    }
                                    sesadds.close();

                                
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
                        if (request.getParameter("err") != null) {
                    
      out.write("\n");
      out.write("                    <div class=\"prodcut_detail_footer\">\n");
      out.write("                        <div id=\"pdata-msg\" style=\"color: red; font-size: 11px;padding: 5px;\">\n");
      out.write("                            ");

                                String errcode = request.getParameter("err");
                                if (errcode.equals("2201")) {
                                    out.write("Entered invalid quantity re enter the quantity");
                                } else if (errcode.equals("2202")) {
                                    out.write("The request product is not available right now try other one <br/> <a href='index.jsp'>click here</a>");
                                } else if (errcode.equals("2203")) {
                                    out.write("Minimum quantuty must be 1 ");
                                } else if (errcode.equals("2204")) {
                                    out.write("The request quantity is not available <br/>");
                                    out.write("Available quantity is : " + qty);
                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");

                        }//30a7e14945b32d758a4d71593b6d34c4.jpg

      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div></div>\n");
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
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        var quatity = document.getElementById(\"pqty\");\n");
      out.write("        getCurrentQuantityFromDb();\n");
      out.write("        function setQty() {\n");
      out.write("            var qtyval = document.getElementById('uqty').value;\n");
      out.write("            getCurrentQuantityFromDb();\n");
      out.write("            if (qtyval === \"\") {\n");
      out.write("                document.getElementById(\"qty_msg\").innerHTML = \"quantity can not be empty\";\n");
      out.write("                //document.getElementById('uqty').value = 1;\n");
      out.write("                document.getElementById('btn-add-cart').style = \"pointer-events:none\";\n");
      out.write("                document.getElementById(\"tot-amount\").innerHTML = \"Total Amount : Rs 00.0\";\n");
      out.write("                document.getElementById(\"tot-saving\").innerHTML = \"Total Saving : Rs 00.0\";\n");
      out.write("            } else {\n");
      out.write("                if (isNaN(qtyval)) {\n");
      out.write("                    document.getElementById(\"qty_msg\").innerHTML = \"invaild number format\";\n");
      out.write("                    // document.getElementById('uqty').value = \"\";\n");
      out.write("                    document.getElementById('btn-add-cart').style = \"pointer-events:none\";\n");
      out.write("                    document.getElementById(\"tot-amount\").innerHTML = \"Total Amount : Rs 00.0\";\n");
      out.write("                    document.getElementById(\"tot-saving\").innerHTML = \"Total Saving : Rs 00.0\";\n");
      out.write("                } else {\n");
      out.write("                    if (qtyval <= 0) {\n");
      out.write("                        document.getElementById(\"qty_msg\").innerHTML = \"minimum qty is : 1\";\n");
      out.write("                        //document.getElementById('uqty').value = 1;\n");
      out.write("                        document.getElementById('btn-add-cart').style = \"pointer-events:none\";\n");
      out.write("                        document.getElementById(\"tot-amount\").innerHTML = \"Total Amount : Rs 00.0\";\n");
      out.write("                        document.getElementById(\"tot-saving\").innerHTML = \"Total Saving : Rs 00.0\";\n");
      out.write("\n");
      out.write("                    } else if (Number(qtyval) > Number(this.quatity)) {\n");
      out.write("\n");
      out.write("                        document.getElementById(\"qty_msg\").innerHTML = \"Request quantity not available. Currently Available : \" + quatity;\n");
      out.write("                        document.getElementById('btn-add-cart').style = \"pointer-events:none\";\n");
      out.write("                        // document.getElementById('uqty').value = 15;\n");
      out.write("                        document.getElementById(\"tot-amount\").innerHTML = \"Total Amount : Rs 00.0\";\n");
      out.write("                        document.getElementById(\"tot-saving\").innerHTML = \"Total Saving : Rs 00.0\";\n");
      out.write("\n");
      out.write("                    } else {\n");
      out.write("                        var price = document.getElementById(\"pprice\").value;\n");
      out.write("                        var pdcnt = document.getElementById(\"pdiscount\").value;\n");
      out.write("\n");
      out.write("                        document.getElementById(\"tot-amount\").innerHTML = \"Total Amount : Rs \" + (price - pdcnt) * qtyval;\n");
      out.write("                        document.getElementById(\"tot-saving\").innerHTML = \"Total Saving : Rs \" + pdcnt * qtyval;\n");
      out.write("                        document.getElementById(\"qty_msg\").innerHTML = \"\";\n");
      out.write("                        document.getElementById('btn-add-cart').style = \"pointer-events:click\";\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function getCurrentQuantityFromDb() {\n");
      out.write("            getxmlhttp();\n");
      out.write("            var pcode = document.getElementById('pcode').value;\n");
      out.write("            xmlhttp.onreadystatechange = function () {\n");
      out.write("                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {\n");
      out.write("                    quatity = xmlhttp.responseText;\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            xmlhttp.open(\"POST\", \"getCurrentQuantity?pcode=\" + pcode, true);\n");
      out.write("            xmlhttp.send();\n");
      out.write("\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
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
