<%-- 
    Document   : datepicTst
    Created on : Jan 23, 2016, 11:33:48 AM
    Author     : Ashan Nawarathna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="jquery-ui.css" rel="stylesheet"/>
        <script src="jquery.js"></script>
        <script src="jquery-ui.js"></script>

        <script type="text/javascript">
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
    </head>
    <body>
        <input type="text" id="datepicker">
    </body>
</html>
