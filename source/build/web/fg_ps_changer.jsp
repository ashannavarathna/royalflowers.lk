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
            <%            //df
                if (request.getSession().getAttribute("user-id") != null) {
                    response.sendRedirect("signin.jsp");
                } else {
                    if (request.getParameter("el") == null) {
                        if (request.getParameter("mcode") != null && !request.getParameter("mcode").isEmpty()) {
                            Session sesreqpsw = conn.connector.getSessionFactory().openSession();
                            Criteria crr_reqpsw = sesreqpsw.createCriteria(pojo.User.class);
                            crr_reqpsw.add(Restrictions.eq("email", request.getParameter("mcode")));
                            pojo.User userojb = (pojo.User) crr_reqpsw.uniqueResult();
                            if (userojb != null) {
                                String hashcode = classes._32CodeGen.codeGenarator(System.currentTimeMillis() + "");
                                classes._sendEmails.sendHTMLMail(request.getParameter("mcode"), "Verification Code", hashcode);
                                request.getSession().setAttribute("req_codex", hashcode);
                                request.getSession().setAttribute("req_uid", userojb.getIduser());
                                HttpSession hs = request.getSession();
                            } else {
                                response.sendRedirect("req_fgps_code.jsp?msg=404");
                            }

                        }
                    }
                }

            %>

            <div class="center_title_wrapper">
                <div class="center_title">
                    Request a Reset Code here
                </div>
            </div>
            <div>
                <form action="ps_changer" method="GET" onsubmit="return  fvlidation()" class="uupform">
                    <input type="hidden" name="fg" value="fgi_1289">
                    <label>Enter request code (received to your email)</label>
                    <input type="text" name="req_code" id="mcodx"/>
                    <label>Enter New Password</label>
                    <input type="password" name="ps1" id="emcode1"/>
                    <label>Confirm Password</label>
                    <input type="password" name="ps2" id="emcode2"/>
                    
                    <input type="submit" value="submit">

                    <div style="color: #0088cc;font-size: 13px;margin-top: 10px;">Resend code <a href="req_fgps_code.jsp"> click here </a></div>
                </form>
            </div>

            <%// sdfsf   
                if (request.getParameter(
                        "msg") != null) {

                    if (request.getParameter("msg").equals("4005")) {
                        out.write("<div style='color: red;font-size: 11px;height:10px;'>Entered code invalid  </div>");
                    } else if (request.getParameter("msg").equals("4002")) {
                        out.write("<div style='color: red;font-size: 11px;height:10px;'>Password not Match  </div>");
                    } else {

                    }

                }

            %>

        </div>
        <script type="text/javascript">
            function fvlidation() {
                var inputf1 = document.getElementById("emcode1").value;
                var inputf2 = document.getElementById("emcode2").value;
                var inputf3 = document.getElementById("mcodx").value;
                if (inputf1.length <= Number(0)) {
                    alert("Enter Your Password");
                    return false;
                } else if (inputf2.length <= Number(0)) {
                    alert("Enter Confirm Password");
                    return false;
                } else if (inputf3.length <= Number(0)) {
                    alert("Enter your verification code");
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
