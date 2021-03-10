<%-- 
    Document   : _error_500
    Created on : Oct 22, 2015, 8:02:13 PM
    Author     : x
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sever Busy...</title>
        <style type="text/css">
            .errmsg{
                font-size: 12px;
                font-family: 'consolas';
            }
        </style>
    </head>

    <body>
        <center>
        <h2>sorry..! Server is busy right now</h2>
        <h5>Dear user come back little later</h5>
        <img src="_images/_site/500.PNG"/>
        <%

            if (request.getParameter("errmsg") != null) {
                out.print("<p class='errmsg'>" + request.getParameter("errmsg") + "</p>");
            }
        %>
        </center>
    </body>
</html>
