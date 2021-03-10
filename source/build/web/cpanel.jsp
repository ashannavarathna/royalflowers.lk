<%-- 
    Document   : cpanel
    Created on : Sep 12, 2015, 10:04:00 PM
    Author     : Ashna Nawarathna
--%>

<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cPanel</title>
        <link href="_css/_cpnel.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <%
            if (request.getSession().getAttribute("user-id") == null) {
                response.sendRedirect("signin.jsp");
            }
        %>

        <%@include file="_pages_container/_noscript.jsp"%>
        <div>
        </div>
        <div class="main-wrapper">
            <div class="top_header">
                <div class="top_title">
                    welcome
                </div>
            </div>
            <div class="main_content">
                <form action="admin_login" method="POST">
                    <div class="form_cotent">

                        <input type="text" id="uname" name="unadmin" placeholder="username" />

                        <input type="password" id="psw" name="upswadmin" placeholder="password" />
                    </div>
                    <div class="submit_content">
                        <input type="hidden" name="ixadminreq" value="s-success">
                        <input type="submit" value="Log In"/>
                    </div>
                </form>
                <div class="reseter">
                    <div class="r_list">
                        <!--a href="#">Can not access your account</a-->
                    </div>
                </div>
            </div>
        </div>
        <%
            if (request.getParameter("serverMsg") != null) {
                String msg = request.getParameter("serverMsg");
                int m_code = Integer.parseInt(msg.substring(2));
                String msg_disply = "";
                switch (m_code) {
                    case 1542:
                        msg_disply = "user name or password err...";
                        break;
                    case 1544:
                        msg_disply = "user name or password empty";
                        break;
                    case 1550:
                        msg_disply = "Access Denied";
                        break;
                    default:
                        msg_disply = "undefine err";
                        break;
                }
        %>
        <div class="server-msg">
            <%
                if (msg.charAt(0) == '1') {

                    out.print("<div class='success-msg'>" + msg_disply + "</div>");
                } else {
                    out.print("<div class='err-msg'>" + msg_disply + "</div>");
                }
            %>
        </div>
        <%
            }
        %>

        <style type="text/css">
            .server-msg{
                width: 330px;
                //padding: 10px;
                margin: 0 auto;
                margin-top: 20px;
                font-size: 12px;
            }
            .success-msg{
                padding: 5px;
                color: green;
                border: 1px dotted green;
                border-radius: 2px;
            }
            .err-msg{
                padding: 5px;
                color: #b94a48;
                border: 1px dotted red;
                border-radius: 2px;
            }
        </style>
    </body>
</html>
