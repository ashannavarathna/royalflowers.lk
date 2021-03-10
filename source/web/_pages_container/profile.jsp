<div id="wrapper">
    <div id="header-wrapper">
        <div id="header">
            <div id="logo">
                <h1><a href="#">Your Profile </a></h1>
                <p>main tain your profile activities </p>
            </div>
            <div id="menu">
                <ul>
                    <li><a href="#">Settings</a></li>
                    <li><a href="user_logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- end #header -->
    <div id="page">
        <div id="page-bgtop">
            <div id="page-bgbtm">
                <div id="content">
                    <div class="post" id="postc">
                        <%

                            if (request.getParameter("msg") != null) {
                                out.write(request.getParameter("msg"));
                            }
                        %>
                    </div>
                </div>
                <!-- end #content -->
                <div id="sidebar">
                    <ul>
                        <li>
                            <div id="search" >
                                <div>
                                    <img src='_images/_site/user_temp.png' width='180' height='160'>
                                </div>
                            </div>
                            <div style="clear: both;">&nbsp;</div>
                        </li>
                        <li>
                        <h2>About You</h2>
                        <p>about.</p>
                        </li>
                        <li>
                        <h2>Personal stuff</h2>
                        <ul>
                            <li onclick="load_a_html('postc', '_pages_container/user_personal_data.jsp')">Bio Data</li>
                            <li onclick="load_a_html('postc', '_pages_container/user_account_data.jsp')">Change Password</li>
                            <li>Photos</li>

                        </ul>
                        </li>
                        <li>
                        <h2>Account Activities</h2>
                        <ul>
                            <li onclick="load_a_html('postc', '_pages_container/invoice_view.jsp')">Invoices</li>
                            <li>Messages</li>
                            <li>Contact Admin</li>
                            <li>Notification</li>
                            <li>Email Settings</li>
                        </ul>
                        </li>
                    </ul>
                </div>
                <!-- end #sidebar -->
                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>
    </div>
    <!-- end #page -->
    <div id="footer">
    </div>
</div>
<style type="text/css">

    #wrapper{
        margin: 0;
        padding: 0;
        /*background: #2E550E url(images/main-wrapper.png) repeat;*/
        /*font-family: Arial, Helvetica, sans-serif;*/
        font-size: 14px;
        color: #000;
    }

    #wrapper strong {
        color: #60B61A;
    }

    #wrapper h1, #wrapper h2, #wrapper h3 {
        margin: 0;
        padding: 0;
        text-transform: uppercase;
        font-family: 'Abel', sans-serif;
        font-weight: normal;
        color: #2B2522;
    }

    #wrapper h1 {
        font-size: 2em;
    }

    #wrapper h2 {
        font-size: 2.8em;
    }

    #wrapper h3 {
        font-size: 1.6em;
    }

    #wrapper p,#wrapper  ul,#wrapper  ol {
        margin-top: 0;
        line-height: 180%;
    }

    #wrapper ul, #wrapper ol {
    }

    #wrapper a {
        text-decoration: underline;
        color: #60B61A;
    }

    #wrapper a:hover {
        text-decoration: none;
    }

    #wrapper {
        width: 800px;
        margin: 0 auto;
        padding: 0;
    }

    /* Header */

    #header-wrapper {
        height: 100px;
        margin-bottom: -20px;
    }

    #header {
        width: 800px;
        margin: 0 auto;
        padding: 0px 0px 0px 0px;
    }

    /* Logo */

    #logo {
        float: left;
        width: 550px;
        margin: 0;
        padding: 0;
        /*color: #FFFFFF;*/
        color: #000;
        /*border: 1px solid #777;*/
    }

    #logo h1, #logo p {
    }

    #logo h1 {
        margin-left: 30px;
        padding: 20px 0px 0px 0px;
        letter-spacing: -1px;
        text-transform: uppercase;
        font-family: 'Abel', sans-serif;
        font-size: 20px;
        font-weight: bold;
        /*color: #FFFFFF;*/
        color: #000;
    }

    #logo h1 a {
        /*color: #FFFFFF;*/
        color: #000;
    }

    #logo h1 span {
    }

    #logo p {
        margin: 0;
        padding: 0px 0 0 32px;
        /* font: normal 14px Georgia, "Times New Roman", Times, serif;*/
        font-style: italic;
        /*color: #FFFFFF;*/
        color: #000;
    } 

    #logo a {
        border: none;
        background: none;
        text-decoration: none;
        /*color: #FFFFFF;*/
        color: #000;
    }

    /* Search */

    #search {
        float: right;
        width: 180px;
        height: 180px;
        padding: 0px 0px 0px 0px;
    }

    #search img{
        margin-top:-8px;
        margin-left:-20px;


    }


    /* Menu */

    #menu {
        float: right;
        height: 70px;
        margin: 0 auto;
        padding: 0;
        /*border: 1px solid #777;*/
    }

    #menu ul {
        margin: 0;
        padding: 0px 0px 0px 0px;
        list-style: none;
        line-height: normal;
    }

    #menu li {
        float: left;
    }

    #menu a {
        display: block;
        height: 50px;
        padding: 10px 25px 0px 25px;
        text-decoration: none;
        text-align: center;
        text-transform: uppercase;
        font-family: 'Abel', sans-serif;
        font-size: 14px;
        font-weight: normal;
        /*color: #FFFFFF;*/
        color: #000;
        border: none;
    }

    #menu a:hover, #menu .current_page_item a {
        text-decoration: none;
    }

    #menu .current_page_item a {
    }

    /* Page */

    #page {
        width: 800px;
        margin: 0 auto;
        padding: 0 0 0 0;
        /* border:1px solid #777;*/

    }

    #page-bgtop {
        padding: 20px 0px;
    }
    /* Content */

    #content {
        float: right;
        width: 570px;
        padding: 0px 0px 0px 0px;
    }

    .post {
        margin-bottom: 30px;
        padding: 10px 20px 10px 20px;
        /*background: rgba(0,0,0,.3);*/
        outline: 1px dashed #CCC;
        outline-offset: -5px;
        min-height: 715px;
        color: #000;
    }

    .post .title {
        height: 31px;
        font-size: 12px;
        padding: 0px 0px 0px 0px;
        letter-spacing: -1px;
        font-family: 'Abel', sans-serif;
        color: #000;
    }

    .post .title a {
        text-decoration: none;
        /*color: #60B61A;*/
        color: #000;
        border: none;
        font-size: 20px;
    }

    .post .entry {
        padding: 20px 30px 20px 30px;
        padding-bottom: 20px;
        text-align: justify;

    }

    .post .byline {
        clear: both;
        overflow: hidden;
        padding-bottom: 5px;
    }

    .post .meta {
        float: left;
    }

    .post .links {
        float: right;
    }

    .links a {
    }

    /* Sidebar */

    #sidebar {
        float: left;
        width: 220px;
        margin: 0px;
        padding: 10px 0 0 0;
        /*border:1px solid #777;*/
    }

    #sidebar ul {
        margin: 0;
        padding: 0;
        list-style: none;
    }

    #sidebar li {
        margin: 0;
        padding: 0;
    }

    #sidebar li ul {
        margin: 0px 0px;
        padding-bottom: 5px;
    }

    #sidebar li li {
        line-height: 35px;
        border-bottom: 1px dashed #CCC;
        /*background: url(images/img01.jpg) no-repeat left 15px; */
        margin: 0px 20px 0px 20px;
        border-left: none;
        text-align: left;
        padding-left: 10px;
    }
    #sidebar li li:hover{
        cursor: pointer;
        background-color: #F0F0F0;
    }

    #sidebar li li span {
        display: block;
        margin-top: -20px;
        padding: 0;
        font-size: 11px;
        font-style: italic;
    }

    #sidebar li li a {
        padding: 0px 0px 0px 10px;
        text-decoration:none;
    }

    #sidebar h2 {
        height: 11px;
        margin: 0px 0px 20px 0px;
        padding: 5px 0px 0px 20px;
        background: url(images/img03.jpg) no-repeat left top;
        /*text-shadow: #203060 -1px 1px 2px;*/
        text-align: left;
        text-transform: uppercase;
        letter-spacing: -.5px;
        font-size: 16px;;
        /*color: #FFFFFF;*/
        color: #000;
    }

    #sidebar p {
        margin: 0 0px;
        padding: 0px 20px 10px 20px;
        text-align: justify;
        /*color: #FFFFFF;*/
        color:#000;
    }

    #sidebar a {
        border: none;
        /*color: #FFFFFF;*/
        color:#000;
    }

    #sidebar a:hover {
        text-decoration: underline;
        color: #7777;
    }

    /* Calendar */

    #calendar {
    }

    #calendar_wrap {
        padding: 20px;
    }

    #calendar table {
        width: 100%;
    }

    #calendar tbody td {
        text-align: center;
    }

    #calendar #next {
        text-align: right;
    }

    /* Footer */

    #footer {
        width: 880px;
        height: 50px;
        margin: 0 auto;
        padding: 0px 0 15px 0;
        font-family: Arial, Helvetica, sans-serif;
    }

    #footer p {
        margin: 0;
        line-height: normal;
        font-size: 12px;
        text-transform: uppercase;
        text-align: center;
        color: #A8FF5C;
    }

    #footer a {
        color: #A8FF5C;
    }


</style>
<!-- end #footer -->

<script type="text/javascript">
    var xmlhttpreq;
    function getxmlhttpxx() {
        if (window.XMLHttpRequest) {
            xmlhttpreq = new XMLHttpRequest();
            //alert("XMLHTTP");
        } else {
            xmlhttpreq = new ActiveXObject("Microsoft.XMLHTTP");
            //alert("ActiveX");
        }
    }


    function load_a_html(req_container, html_location) {
        getxmlhttpxx();
        //document.getElementById("page-sub-container").innerHTML='<object data="_admin_pages/_products_management/product_details.jsp" class="subcontent"> </object>';
        var con = document.getElementById(req_container);
        //alert(con);
        xmlhttpreq.onreadystatechange = function (e) {
            if (xmlhttpreq.readyState === 4 && xmlhttpreq.status === 200) {
                // alert("innn");
                con.innerHTML = xmlhttpreq.responseText;

            }
        };
        xmlhttpreq.open("POST", html_location, true);
        xmlhttpreq.setRequestHeader('Content-type', 'text/html');
        xmlhttpreq.send();
    }

    function updateuserdata(formname, outmsg) {
        // alert('oky');
        var form = document.forms.namedItem(formname);
        var outarea = document.getElementById(outmsg);
        var odata = new FormData(form);
        form.addEventListener('button', function (ev) {
            xmlhttpreq.onreadystatechange = function () {
                if (xmlhttpreq.readyState === 4 && xmlhttpreq.status === 200) {
                    outarea.innerHTML = xmlhttpreq.responseText;
                }

            };

            xmlhttpreq.open("GET", "update_user_data", true);
            xmlhttpreq.send(odata);
            ev.preventDefault();
        }, false);
    }


    function chagpasw() {
        alert('workd');
        try {
            getxmlhttpxx();
            var crr_pass = document.getElementById("crr_pass").value;
            var nw_pass = document.getElementById("nw_pass").value;
            var cfm_pass = document.getElementById("cfm_pass").value;
            var flag_update = true;
            var urlpatn = "";
            if (crr_pass === "") {
                flag_update = false;
                alert("Enter Current Password");
            } else {
                urlpatn = "&crr_pass=" + crr_pass;
            }

            if (nw_pass === "") {
                flag_update = false;
                alert("Enter New Password");
            } else {
                urlpatn = "&nw_pass=" + nw_pass;
            }

            if (cfm_pass === "") {
                flag_update = false;
                alert("Enter Confirm Password ");
            } else {
                urlpatn = "&cfm_pass=" + cfm_pass;
            }

            if (flag_update) {

                xmlhttpreq.onreadystatechange = function () {
                    if (xmlhttpreq.readyState === 4 && xmlhttpreq.status === 200) {
                        var resultarr = xmlhttpreq.responseText.split("_");

                        if (resultarr[0] === "1") {
                            crr_pass.value = "";
                            nw_pass.value = "";
                            cfm_pass.value = "";

                            alert(resultarr[1]);

                        } else {
                            alert(resultarr[1]);
                        }
                    }

                };

                xmlhttpreq.open("POST", "chng_psw?valx=3345" + urlpatn, true);
                xmlhttpreq.send();
            }


        } catch (error) {
            alert(error);
        }
    }
    
    function  lol(){
        alert("lol");
    }

</script>