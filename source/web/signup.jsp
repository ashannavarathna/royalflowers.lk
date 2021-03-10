<%-- 
    Document   : index
    Created on : Sep 13, 2015, 10:31:27 AM
    Author     : Ashna Nawarathna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products | Green Wood Furniture</title>
        <link href="_css/_custome_002.css" type="text/css" rel="stylesheet">
        <link href="_css/_form_field.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="_script/_js/_custome_01.js"></script>
    </head>
    <body>
        <%
    if (request.getSession().getAttribute("user-id") != null) {
        response.sendRedirect("index.jsp");
    }
        %>
        <%@include file="_pages_container/top_header.jsp" %>
        <%@include file="_pages_container/_noscript.jsp"%>
        <div class="main-wrapper">
            <%@include file="_pages_container/navbar_top.jsp" %>

            <div class="center_title_wrapper">
                <div class="center_title">
                    Create Your Account | Enjoy Shopping
                </div>
            </div>
            <%@include file="_pages_container/_signup_form.jsp" %>


        </div>

        <%@include file="_pages_container/botom_footer.jsp" %>


    </body>
</html>
