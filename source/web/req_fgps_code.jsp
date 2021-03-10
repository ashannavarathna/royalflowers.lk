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
        <script type="text/javascript" src="_script/_js/_custome_01.js"></script>
    </head>
    <body>
        <%@include file="_pages_container/top_header.jsp" %>
        <%@include file="_pages_container/_noscript.jsp"%>
        <div class="main-wrapper">
            <%@include file="_pages_container/navbar_top.jsp" %>
            <%                if (request.getSession().getAttribute("user-id") != null) {
                    response.sendRedirect("signin.jsp");
                }
            %>

            <div class="center_title_wrapper">
                <div class="center_title">
                    Request a Reset Code here
                </div>
            </div>
            <div>
                <form action="fg_ps_changer.jsp" method="POST" onsubmit="return  fvlidation()" class="uupform">
                    <label>Enter your email address</label>
                    <input type="email" name="mcode" id="emcode"/>
                    <div style="color: #0088cc;font-size: 11px">New request code will send this address use it change your password </div>
                    <input type="submit" value="submit">
                </form>
                <%
                    if(request.getParameter("msg")!=null){
                        if(request.getParameter("msg").equals("404")){
                            out.write("<div style='color: red;font-size: 11px'>Entered email is not valid  </div>");
                        }
                    }
                %>
            </div>



        </div>
        <script type="text/javascript">
            function fvlidation() {
                var inputf = document.getElementById("emcode").value;
                if (inputf.length <= Number(0)) {
                    alert("Enter Your Email");
                    return false;
                } else {
                    return true;
                }
            }
        </script>

        <style type="text/css">
            .uupform {
                font-size: 12px;
                margin: 0 auto;
                width: 400px;
                min-height: 200px;
            }
            .uupform label, .uupform input {
                display: block;
                padding: 5px 0;
                margin-top: 2px;
                width: 300px;
                font-size: 12px;

            }
            .uupform input[type=submit]{
                width: 100px;
                margin-top: 10px;
                padding: 3px 5px;
            }
            .uupform input[type=text],.uupform input[type=email]{
                border: 1px solid #CCC;
                color: #666;
                padding-left: 5px;
            } 
        </style>
        <%@include file="_pages_container/botom_footer.jsp" %>


    </body>
</html>
