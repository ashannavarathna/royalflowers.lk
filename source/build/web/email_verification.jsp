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
        <title>Account Activation | Royal Flowers </title>
        <link href="_css/_custome_002.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="_script/_js/_custome_01.js"></script>


    </head>
    <body>
        <%@include file="_pages_container/top_header.jsp" %>
        <div class="main-wrapper">
            <%@include file="_pages_container/navbar_top.jsp" %>
            <%                if (request.getSession().getAttribute("user-id") != null) {
                    Integer userid = (Integer) request.getSession().getAttribute("user-id");
                    Session sesulog = conn.connector.getSessionFactory().openSession();
                    pojo.User user = (pojo.User) sesulog.load(pojo.User.class, userid);

                    if (user.getUserState().getIduserState() == 2) {
                        //logged not active
%>
            <div class="center_title_wrapper">
                <div class="center_title">
                    Activate Your Account
                </div>
                <div class="vrf-wrapper">
                    <div class="vrf-container">
                        <div class="vrf-title">We have send a activation code to your email... please check your <span style="color: #0074cc;">e-mail</span></div>
                        <form  method="POST" class="vrf-form">
                            <label class="lbl-field-name"> Enter Activation Code </label>
                            <input type="text" name="mail_code" id="eml_code"/>
                            <input type="button" value="Activate" id="sub_acc" onclick="activateAccount()"/>
                            <input type="hidden" name="fname" id="fnm" value="<%=user.getFname()%>"/>
                            <input type="hidden" name="email" id="eml" value="<%=user.getEmail()%>">
                        </form>
                        <div class="vrf-cnfrm-msg" id="vrf-msg"></div>
                        <div class="vrf-resender"> If not received <span style="color: #298939;">  re-send </span>  activation code <a href="#" onclick="activationcoderesend()" id="cod_rsnd">here</a></div>
                        <div class="vrf-success-msg">
                            <div class="vrf-act-heading" id="vrf-head">
                                actiation your accotutn
                            </div>
                            <div class="vrf-success-content" id="vrf-cont">
                                <div>Activation</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                function activationcoderesend() {
                    getxmlhttp();
                    document.getElementById("vrf-msg").innerHTML = "please wait...";
                    document.getElementById("vrf-msg").style.color = "#000";
                    document.getElementById('cod_rsnd').style.pointerEvents = 'none';
                    var fname = document.getElementById("fnm").value;
                    var email = document.getElementById("eml").value;
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            document.getElementById('cod_rsnd').style.pointerEvents = 'auto';
                            if (xmlhttp.responseText === "success") {
                                document.getElementById("vrf-msg").innerHTML = "New activation code send to your email";
                                document.getElementById("vrf-msg").style.color = "green";
                            } else {
                                document.getElementById("vrf-msg").innerHTML = "Resend Activation code failed";
                                document.getElementById("vrf-msg").style.color = "red";
                            }
                        }
                    };
                    xmlhttp.open("POST", "activatecode_resender?fname=" + fname + "&email=" + email, true);
                    xmlhttp.send();

                }

                function activateAccount() {
                    getxmlhttp();
                    var mailcode = document.getElementById('eml_code').value;
                    var email = document.getElementById('eml').value;
                   // alert(mailcode);
                    var v_head = document.getElementById("vrf-head");
                    var v_cont = document.getElementById("vrf-cont");
                    document.getElementById("sub_acc").disabled = true;
                    v_head.innerHTML = "Please wait...";
                    v_cont.innerHTML = "Your account will activate in few moments";
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            //alert(xmlhttp.responseText);
                            var outcode = Number(xmlhttp.responseText);
                            if (Number(outcode) === Number(200451)) {
                                document.getElementById("sub_acc").disabled = true;
                                v_head.innerHTML = "Activation success";
                                v_cont.innerHTML = "Your account successfuly activated <a href='user_profile.jsp'>vist your account<a/>";
                                v_head.style.color = "green";
                                v_cont.style.color = "black";
                            } else if (Number(outcode) === Number(200450)) {
                                v_head.innerHTML = "Activaion failed";
                                v_cont.innerHTML = "Code not vaild.. re enter the code";
                                v_head.style.color = "red";
                                v_cont.style.color = "red";
                                document.getElementById(eml_code).value = "";
                                document.getElementById("sub_acc").disabled = false;
                            } else if (Number(outcode) === Number(200452)) {
                                v_head.innerHTML = "Activaion failed";
                                v_cont.innerHTML = "Code not match.. re enter the code";
                                document.getElementById("sub_acc").disabled = false;
                                v_head.style.color = "red";
                                v_cont.style.color = "red";
                                document.getElementById(eml_code).value = "";

                            } else if (Number(outcode) === Number(200453)) {
                                v_head.innerHTML = "Account Already Activated";
                                v_cont.innerHTML = "<a href='user_profile.jsp'>vist your account<a/>";
                                v_head.style.color = "red";
                                v_cont.style.color = "red";
                                document.getElementById(eml_code).value = "";
                                document.getElementById("sub_acc").disabled = true;
                            }
                        }

                    };
                    xmlhttp.open("GET", "user_activate?mail_code=" + mailcode + "&email=" + email, true);
                    xmlhttp.send();

                }
            </script>
            <%@include file="_pages_container/_activateUser.jsp" %>

            <%                                } else if (user.getUserState().getIduserState() == 3) {
                        response.sendRedirect("user_login?usrxttp=15522_1566");
                    } else {
                        //active use id must be 1
                    }

                } else {
                    response.sendRedirect("index.jsp");
                }

            %>

        </div>
        <%@include file="_pages_container/botom_footer.jsp" %>


    </body>
    <style type="text/css">
        .vrf-wrapper{
            /*border: 1px solid #000;*/
            padding: 5px;
            font-size: 12px;
            height: 320px;
        }
        .vrf-container{
            margin: 0 auto;
            /*border: 1px solid #000;*/
            width: 500px;
            padding: 5px;

        }
        .vrf-form .lbl-field-name{
            display: block;
        }
        .vrf-form input[type=text]{
            width: 250px;
            padding: 3px 5px;
            font-size: 12px;
            color: #333;
        }
        .vrf-form input[type=submit]{
            padding: 0px 5px;
            padding-top: 1px;

        }
        .vrf-title{
            margin-bottom: 5px;
        }
        .vrf-cnfrm-msg{
            color: #c50000;
            font-size: 10px;
        }
        .vrf-resender{
            color: #444;
            font-weight: bold;

        }
        .vrf-resender a{
            font-family: "consolas";
            color: #6d3b6a;
        }
        .vrf-success-msg{
            margin-top: 10px;
            /*border:1px solid #777;*/
            height: 200px;
            /*padding: 5px;*/

        }
        .vrf-act-heading{
            font-size: 15px;
            color: #06396a;
            border-bottom: 1px solid #CCC;
            padding-bottom: 5px;
            font-weight: 800;

        }

    </style>
</html>
