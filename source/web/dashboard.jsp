<%-- 
    Document   : dashboard
    Created on : Sep 7, 2015, 10:48:55 PM
    Author     : Ashna Nawarathna
--%>

<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="_css/admin_panel.css" type="text/css" rel="stylesheet">
        <link href="_css/admin_panel_subpages.css" type="text/css" rel="stylesheet">
        <link href="_css/jquery.custom-scrollbar.css" type="text/css" rel="stylesheet">

        <script type="text/javascript" src="_script/_js/admin_data_controll.js"></script>
        <script type="text/javascript" src="_script/_js/admin_panel_subpage_loder.js"></script>


        <title>Dashboard</title>
    </head>
    <body onload="load_hash_content()">
        <%
            boolean flagsadmin = false;
            if (request.getSession().getAttribute("user-id") != null) {
                Integer uid = (Integer) request.getSession().getAttribute("user-id");
                Session sesulogcpl = conn.connector.getSessionFactory().openSession();

                pojo.User user = (pojo.User) sesulogcpl.load(pojo.User.class, uid);

                if (user.getUserType().getIduserType() == 1) {
                    //admin
                    flagsadmin = false;

                } else if (user.getUserType().getIduserType() == 3) {
                    //super admin
                    flagsadmin = true;

                } else {
                    //normal user
                    flagsadmin = false;
                    response.sendRedirect("cpanel.jsp?serverMsg=0_1550");

                }
                sesulogcpl.close();
            } else {
                response.sendRedirect("signin.jsp");

            }
        %>
        <%@include file="_pages_container/_noscript.jsp"%>
        <div class="main-wrapper">
            <div class="top_text">Dash Board</div>
            <div class="left_container">
                <div class="left-wrapper">
                    <div class="top_title_bar">
                        SIDE NAVIGATION
                    </div>
                    <div class="left_side_nav">
                        <ul class="left_nav">
                            <li onclick="load_hash_content()"><div class="left_link"># Content</div></li>                            
                            <li onclick="load_product_registration()"><div class="left_link">Product Registration</div></li>
                            <li onclick="load_stock_managment()"><div class="left_link">Stock Management</div></li>
                            <li onclick="load_delivery_managment()"><div class="left_link">Deliver Management</div></li>
                                <%
                                    if (flagsadmin) {
                                %>
                            <li onclick="load_user_managment()"><div class="left_link">User Account Management</div></li>
                                <%
                                    }
                                %>
                            <li onclick="load_salses()"><div class="left_link">Sales Reports</div></li>
                            <li onclick=" load_advertisemetn_panel()"><div class="left_link">Advertisement</div></li>
                            <li><div class="left_link">Massages</div></li>
                            <li><div class="left_link">Oder Management</div></li>
                            <li ><a href="index.jsp" class="left_link">visit home </a></li>

                        </ul>
                    </div>
                </div>
                <div class="quick_access_wrapper">
                    <div class="top_title_bar">
                        QUICK ACCESS
                    </div>
                    <div class="quick_access_content">
                        <div class="min_box_quick">
                            <img src="_images/_site/_admin_pnl/_quick_mini/qa-messages.gif" width="40px" height="37px" />
                            <div class="mini_box_text">Mail</div>
                        </div>
                        <!--div class="min_box_quick">
                            <img src="_images/_site/_admin_pnl/_quick_mini/qa-media.gif" width="40px" height="37px" />
                            <div class="mini_box_text">Media</div>
                        </div-->
                        <%if (flagsadmin){%>
                        <div class="min_box_quick">
                            <img src="_images/_site/_admin_pnl/_quick_mini/qa-databases.gif" width="40px" height="37px" />
                            <div class="mini_box_text">DataBase</div>
                        </div>
                        <%}%>
                        <!--div class="min_box_quick">
                            <img src="_images/_site/_admin_pnl/_quick_mini/qa-photos.gif" width="40px" height="37px" />
                            <div class="mini_box_text">Photos</div>
                        </div-->
                        <!--div class="min_box_quick">
                            <img src="_images/_site/_admin_pnl/_quick_mini/qa-users.gif" width="40px" height="37px" />
                            <div class="mini_box_text">User</div>
                        </div-->
                        <div class="min_box_quick">
                            <img src="_images/_site/_admin_pnl/_quick_mini/qa-settings.gif" width="40px" height="37px" />
                            <div class="mini_box_text">Settings</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="center-warapper">
                <div class="top_title_bar" id="top-title-subpages">
                    PAGE NAVIGATION
                </div>
                <div class="center_content_dashb" id="center_content_con">

                </div>
            </div>
            <div class="footer-wrapper"></div>
        </div>
    </body>
</html>
