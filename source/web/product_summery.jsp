<%-- 
    Document   : index
    Created on : Sep 13, 2015, 10:31:27 AM
    Author     : Ashna Nawarathna
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product_Summary | Royal Flowers</title>
        <link href="_css/_custome_002.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="_script/_js/_custome_01.js"></script>
        <script src="http://maps.google.com/maps?file=api&v=2&key=ABQIAAAA7j_Q-rshuWkc8HyFI4V2HxQYPm-xtd00hTQOC0OXpAMO40FHAxT29dNBGfxqMPq5zwdeiDSHEPL89A" type="text/javascript"></script>
    </head>
    <body>
        <%@include file="_pages_container/top_header.jsp" %>
        <%@include file="_pages_container/_noscript.jsp"%>
        <div class="main-wrapper">
            <%@include file="_pages_container/navbar_top.jsp" %>

            <div class="center_title_wrapper">
                <div class="center_title">
                    Review Summary
                </div>

                <div class="summary_p_display">
                    <div class="pdcontent" style="height: 40px;">

                        <div class="pdcntd">
                            <ul>
                                <li class="pdimgdh">#</li>
                                <li class="pdnameh">Product Name</li>
                                <li class="pdcodeh">Product Code</li>
                                <li class="pdcnth">Qty</li>
                                <li class="pdtoth">Total Amount (LKR)</li>
                                <li class="pdwgth">Total Weight (g)</li>
                            </ul>
                        </div>
                    </div>
                    <%                    try {
                            DecimalFormat df = new DecimalFormat("0.00");

                            if (request.getSession().getAttribute("user-id") == null) {
                                out.write("<div style='height:200px;padding:10px;'>");
                                out.write("Your need to log to procede check out <a href='signin.jsp'>log here</a>");
                                out.write("</div>");
                            } else {
                                Integer userid = (Integer) request.getSession().getAttribute("user-id");
                                Session sespd = conn.connector.getSessionFactory().openSession();
                                pojo.User user = (pojo.User) sespd.load(pojo.User.class, userid);
                                if (user.getUserState().getIduserState() == 1) {
                                    //active user
                                    if (request.getSession().getAttribute("s_cart") == null || ((ArrayList) request.getSession().getAttribute("s_cart")).isEmpty()) {
                                        //your cart is empty
                                        out.write("<div style='height:200px;padding:10px;'>");
                                        out.write("Cart is Empty... please add prodcut <a href='products.jsp'>click to buy</a>");
                                        out.write("</div>");
                                    } else {
                                        //your have products
                                        List<int[]> cart = (ArrayList) request.getSession().getAttribute("s_cart");

                                        Criteria crr = sespd.createCriteria(pojo.Product.class);
                                        List<pojo.Product> plist = crr.list();
                                        pojo.Product product = null;
                                        // int readindex = 0;
                                        String murl = "";
                                        int itemcount = cart.size();
                                        double total = 0;
                                        double totaldisocunt = 0;
                                        double totalweight = 0;

                                        for (int rx = 0; rx < cart.size(); rx++) {
                                            int[] sprdt = cart.get(rx);
                                            for (pojo.Product p : plist) {

                                                if (p.getIdproduct() == sprdt[0]) {
                                                    //
                                                    product = p;
                                                    total += p.getPrice() * sprdt[1];
                                                    totaldisocunt += p.getDiscount() * sprdt[1];
                                                    totalweight += p.getWeight() * sprdt[1];
                                                    if (product.getImageUrl1() != null) {
                                                        murl = "_images/product/category/products/" + product.getImageUrl1();
                                                    } else {
                                                        murl = "_images/_site/null_img.png";
                                                    }

                    %>
                    <div class="pdcontent">
                        <div class="pdimgd">
                            <img src="<%=murl%>" width="40" height="40">
                        </div>
                        <div class="pdcntd">
                            <ul>
                                <li class="pdname"><%=p.getName()%></li>
                                <li class="pdcode"><%=p.getProductCode()%></li>
                                <li class="pdcnt"><%=sprdt[1]%></li>
                                <li class="pdtot"><%=df.format(sprdt[1] * (p.getPrice() - p.getDiscount()))%></li>
                                <li class="pdwgt"><%=df.format(sprdt[1] * p.getWeight())%></li>
                            </ul>
                        </div>
                    </div>


                    <%                                                }
                            }

                        }
                    %>


                    <%
                        String errMSG = "";
                        String style = "display:none";
                        int ecode = 0;
                        if (request.getParameter("eco") != null && !request.getParameter("eco").isEmpty()) {
                            style = "border:1px dotted red;pdding:10px;maring-bottom:-40px;font-size:12px;";
                            ecode = Integer.valueOf(request.getParameter("eco").split("_")[1]);
                            if (ecode == 7788) {
                                errMSG = "select a delivery plan";
                            } else if (ecode == 7789) {
                                errMSG = "Enter your delivary address";
                            } else if (ecode == 7790) {
                                errMSG = "no such delivery plan found";
                            } else if (ecode == 7791) {
                                errMSG = "sorry the request product not available";
                            }

                        } else {

                        }

                    %>

                    <div id="psum_msg" style="<%=style%>"><%=errMSG%></div>
                    <div class="shipping_controll">

                        <div class="summary_payments">
                            <form method="POST" action="invoice">
                                <input type="hidden" value="p300_postal" name="gcode"/>
                                <input type="hidden" value="vld1265dix" name="pgx_sumid"/>
                                <div id="sp_head">Payment Details <span style="font-size: 11px;color: #333;font-weight: bold;">(prices in (LKR))</span> </div>
                                <div class="sp_it"><span class="sp_it_nm">Item Count</span>:<span class="sp_id_dt"><%=itemcount%></span> </div>
                                <div class="sp_it"><span class="sp_it_nm">Amount</span>:<span class="sp_id_dt"><%=df.format(total)%> </span></div>
                                <div class="sp_it"><span class="sp_it_nm">Total Discount</span>:<span class="sp_id_dt"><%=df.format(totaldisocunt)%>   </span></div>
                                <div class="sp_it"><span class="sp_it_nm">Net Amount</span>:<span class="sp_id_dt"><%=df.format(total - totaldisocunt)%> </span></div>
                                <input type="hidden" value="<%=df.format(total - totaldisocunt)%>" name="in_tamount" id="in_tamount">
                                <div id="sp_divd"></div>
                                <div class="sp_it"><span class="sp_it_nm">Total Weight (g) </span>:<span class="sp_id_dt"><%=df.format(totalweight)%> </span></div>
                                <input type="hidden" value="<%=df.format(totalweight)%>" id="in_tdsnt" name="in_tdsnt" >
                                <div class="sp_it"><span class="sp_it_nm">Distance (KM) </span>:<span class="sp_id_dt" id="t-dsnt"></span></div>
                                <div class="sp_it"><span class="sp_it_nm">per kilometer</span>:<span class="sp_id_dt" id="dpl-cost"></span></div>
                                <div class="sp_it"><span class="sp_it_nm">Delivery Cost</span>:<span class="sp_id_dt" id="dt-cost"></span></div>
                                <div id="sp_divd"></div>
                                <div class="sp_it" style="border: 1px solid #777;font-size: 13px;background-color: darkkhaki;color: #FFF;" ><span class="sp_it_nm">Total Amount</span>:<span class="sp_id_dt" id="tt-cost" style="font-weight: bolder;font-size: 15px;"></span></div>
                                <input type="hidden" name="dlpack_code" value="" id="pck_code">
                                <input type="hidden" name="dldsnt_ln" value="" id="pcdsnt">
                                <input type="hidden" name="fname" value="" id="fname"/>
                                <input type="hidden" name="lname" value="" id="lname">
                                <input type="hidden" name="add1" value="" id="add1">
                                <input type="hidden" name="add2" value="" id="add2">
                                <input type="hidden" name="a_city" value="" id="a_city">
                                <input type="hidden" name="ps_code" value="" id="ps_code">
                                <input type="submit" value="Check out" id="chkout" disabled />
                            </form>
                            <div style="font-size: 11px; color: #0088cc;margin-bottom: 10px;">click check out to buy your product and transaction will be made. <br/>
                                you will be agree to our terms and condition.<br/><a href="#">terms & condition</a></div>
                            <img src="_images/_site/paypal-icon_png.jpeg" width="270" height="50">
                        </div>
                        Delivery Details
                        <form name="del_data" id="del_data">
                            <label>First Name</label>
                            <input type="text" name="s_fname" id="s_fname" onkeyup="document.getElementById('fname').value = document.getElementById('s_fname').value"/>
                            <label>Last Name</label>
                            <input type="text" name="s_lname" id="s_lname" onkeyup="document.getElementById('lname').value = document.getElementById('s_lname').value"/>
                            <label>Address Line 1</label>
                            <input type="text" name="s_addl_1" id="s_add1" onkeyup="document.getElementById('add1').value = document.getElementById('s_add1').value"/>
                            <label>Address Line 2</label>
                            <input type="text" name="s_addl_2" id="s_add2" onkeyup="document.getElementById('add2').value = document.getElementById('s_add2').value"/>
                            <label>City - (delivery on this )</label>
                            <input type="text" name="s_city" id="s_city" onkeyup="document.getElementById('a_city').value = document.getElementById('s_city').value" />
                            <label id="s_err_msg"></label>
                            <label>Postal Code</label>
                            <input type="text" name="s_distric" id="s_pscode" onkeyup="document.getElementById('ps_code').value = document.getElementById('s_pscode').value"/>
                            <label>Country</label>
                            <input type="text" name="s_country" value="Sri Lanka" disabled>
                            <input type="hidden" name="s_cntry" value="LK"/>
                            <label>Select a delivery method</label>
                            <select id="dplans" name="dplans">
                                <%
                                    Session sesdplan = conn.connector.getSessionFactory().openSession();

                                    Criteria c = sesdplan.createCriteria(pojo.DeliveryPlan.class);
                                    List<pojo.DeliveryPlan> dlist = c.list();
                                    for (pojo.DeliveryPlan dplan : dlist) {
                                %>
                                <option name value="<%=dplan.getIddeliveryPlan()%>"> <%=dplan.getName()%></option>
                                <%
                                    }
                                    sesdplan.close();
                                %>
                            </select>

                            <input type="button" value="Calculate" onclick="validateDeliveryForm()">
                        </form>
                        <div id="sd_form_msg"></div>
                        <div style="background-color: #0088cc;color: #FFF;padding: 5px;font-size: 12px;font-weight: bolder; ">We are delivery only inside Sri Lanka. Do not enter any foreign Cities </div>
                    </div>
                    <%
                                    }
                                } else {
                                    response.sendRedirect("user_login?usrxttp=522_1254");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    %>
                </div>

            </div>

        </div>
        <%@include file="_pages_container/botom_footer.jsp" %>


    </body>
    <style type="text/css">
        .summary_p_display{
            font-size: 12px;
            width: 950px;
            /*height: 200px;*/
            /*border: 1px solid #777;*/
            padding: 5px;
            margin-left: 20px;
            margin-top: 10px;
            float: left;
        }
        .summary_p_display ul{
            padding: 0;
        }
        .summary_p_display .pdimgd{
            clear: left;
            float: left;

        }
        .summary_p_display ul li{
            display: inline-block;
            list-style: none;
        }
        .pdname, .pdcnt, .pdtot , .pdwgt ,.pdcode{
            /*border: 1px solid #777;*/
            padding: 10px 3px;
            margin-left: 19px;
            margin-top: 1px;
            text-align: center;
        }
        .pdcode{
            width: 150px;
        }
        .pdname {
            width: 350px;
        }
        .pdcnt{
            width: 20px;
        }
        .pdtot{
            width: 100px;
        }
        .pdwgt{
            width: 100px;
        }

        .pdcontent{
            border-bottom: 1px dotted #CCC;
        }
        .pdnameh, .pdcnth, .pdtoth , .pdwgth, .pdimgdh, .pdcodeh{
            /*border: 1px solid #777;*/
            padding: 10px 3px;
            margin-left: 20px;
            margin-top: 1px;
            text-align: center;
            font-weight: bolder;
        }
        .pdimgdh{
            width: 20px;
            margin-left: 10px;
        }
        .pdcodeh{
            width: 150px;
        }
        .pdnameh {
            width: 350px;
        }
        .pdcnth{
            width: 20px;
        }
        .pdtoth{
            width: 100px;
        }
        .pdwgth{
            width: 100px;
        }

        .shipping_controll{
            margin-top: 50px;
        }
        .shipping_controll{
            width: 650px;
            padding: 10px;
            border: 1px solid #CCC;
        }
        .shipping_controll form label{
            display: block;
        }
        .shipping_controll form{
            padding: 5px;
        }
        .shipping_controll form input[type=text]{
            display: block;
            width: 250px;
            padding: 3px;
            margin-top: 5px;
            margin-bottom: 5px;
            border: 1px solid #CCC;
        }
        .shipping_controll form input[type=button]{
            display: block;
            width: 100px;
            padding: 2px;
            margin-top: 5px;
        }
        .shipping_controll form select{
            display: block;
            width: 150px;
            padding: 3px;
            margin-top: 5px;
        }
        .summary_payments{
            font-size: 12px;
            width: 270px;
            height: 200px;
            /*border: 1px solid #777;*/
            padding: 5px;
            float: right;
            margin-top: -5px;
        }
        .summary_payments #sp_head{
            font-size: 14px;
        }
        .summary_payments #sp_divd{
            padding: 2px 3px;

        }
        .summary_payments .sp_it{
            font-size: 13px;
            padding: 1px 3px;
            font-family: consolas;
            text-align: right;
        }
        .summary_payments .sp_it .sp_it_nm{
            width: 110px;
            display: inline-block;
        }
        .summary_payments .sp_it .sp_id_dt{
            padding: 0 3px;
            display: inline-block;

            /*border: 1px solid #777;*/
            width: 80px;
        }
        .summary_payments form input[type='submit']{
            margin-top: 10px;
            //background-color: #777;
            //border: 1px solid #666;
            width: 250px;
            padding: 3px;
            margin-left: 5px;
            //box-shadow: 0px 0px 10px -3px;
        }
    </style>
    <script type="text/javascript">
        //global verialbels
        var perkilometeramount = 0;
        var totaldistance = 0;
        var deliveryt_cost = 0;
        var netamount = 0;
        var totalcost = 0;

        var totalweight = 0;

        var checkout = false;
        enable_checkout();
        function enable_checkout() {
            if (checkout) {
                document.getElementById("chkout").disabled = false;
            } else {
                document.getElementById("chkout").disabled = true;
            }
        }

        function validateDeliveryForm() {
            var form = document.getElementById("del_data");
            var validated = true;
            for (var i = 0; i < form.length; i++) {
                if (form[i].type !== 'button') {
                    if (form[i].value === "") {
                        form[i].style = "border:1px dotted red;";
                        validated = false;

                        if (form[4].value === "") {
                            document.getElementById("s_err_msg").innerHTML = "Enter your city";
                            document.getElementById("s_err_msg").style = "color:red;font-size:11px;";

                        }
                    } else {
                        form[i].style = "border:1px solid #CCC;";

                    }
                }
            }


            if (validated) {
                showLocation();
                document.getElementById("psum_msg").innerHTML = "";
                document.getElementById("psum_msg").style = "display:none;";

            } else {
                document.getElementById("psum_msg").innerHTML = "error... delivery address invalid";
                document.getElementById("psum_msg").style = "color:red;border:1px dotted red;font-size: 12px; padding: 10px 5px; margin: 10px 0 -45px 0;";
                document.getElementById('dpl-cost').innerHTML = "invalid";
                document.getElementById('dt-cost').innerHTML = "invalid";
                document.getElementById('tt-cost').innerHTML = "invalid";
            }

        }

        function showLocation() {
            try {
                // alert('initializing...');
                geocoder = new GClientGeocoder();
                //  alert("initialized...");
                geocoder.getLocations('Kurunegala', function (response) {
                    //alert('2');
                    if (!response || response.Status.code !== 200) {
                        alert("Sorry, we were unable to geocode the first address");
                    } else {
                        // alert('3');
                        location1 = {lat: response.Placemark[0].Point.coordinates[1], lon: response.Placemark[0].Point.coordinates[0], address: response.Placemark[0].address};
                        geocoder.getLocations(document.getElementById('s_city').value, function (response) {
                            //alert('getting location 2..');
                            if (!response || response.Status.code !== 200) {
                                alert("Sorry, we were unable to geocode the second address");
                            } else {
                                location2 = {lat: response.Placemark[0].Point.coordinates[1], lon: response.Placemark[0].Point.coordinates[0], address: response.Placemark[0].address};
                                calculateDistance();
                                // alert('getting location finished');
                            }
                        });
                    }
                });
            } catch (error) {
                alert(error);
            }
        }

        // getperkilometer amount


        function calculateDistance() {
            try {
                var glatlng1 = new GLatLng(location1.lat, location1.lon);
                var glatlng2 = new GLatLng(location2.lat, location2.lon);
                var miledistance = glatlng1.distanceFrom(glatlng2, 3959).toFixed(1);
                var kmdistance = (miledistance * 1.609344).toFixed(1);
                //alert(kmdistance);

                if (Number(kmdistance) > 250) {
                    document.getElementById('s_err_msg').innerHTML = "Out of srilanka... please select a city in srilanka";
                    document.getElementById('s_err_msg').style = "color:red;font-size:11px;";
                    document.getElementById('t-dsnt').innerHTML = "Out Of Range";
                    document.getElementById('t-dsnt').style = "color:red;";
                    document.getElementById('dpl-cost').innerHTML = "invalid";
                    document.getElementById('dt-cost').innerHTML = "invalid";
                    document.getElementById('tt-cost').innerHTML = "invalid";
                    checkout = false;
                    enable_checkout();

                } else {
                    document.getElementById('s_err_msg').innerHTML = "We will delivery to this location";
                    document.getElementById('s_err_msg').style = "color:green;font-size:11px;";
                    document.getElementById('t-dsnt').innerHTML = kmdistance;
                    document.getElementById('pcdsnt').value = kmdistance;
                    document.getElementById('pck_code').value = document.getElementById('dplans').value;
                    totaldistance = kmdistance;
                    document.getElementById('t-dsnt').style = "color:green;";
                    getCostPerKm();
                }
            } catch (error) {
                alert(error);
            }

        }

        function getCostPerKm() {
            getxmlhttp();
            var deliver_planid = document.getElementById('dplans').value;
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    perkilometeramount = xmlhttp.responseText;
                    document.getElementById('dpl-cost').innerHTML = perkilometeramount;

                    totalweight = document.getElementById('in_tdsnt').value;
                    netamount = document.getElementById("in_tamount").value;

                    deliveryt_cost = ((Number(perkilometeramount) / Number(1000)) * Number(totalweight) * Number(totaldistance)).toFixed(2);
                    totalcost = Number(netamount) + Number(deliveryt_cost);
                    document.getElementById('dt-cost').innerHTML = Number(deliveryt_cost);
                    document.getElementById('tt-cost').innerHTML = Number(totalcost);
                    checkout = true;
                    enable_checkout();
                }
            };
            xmlhttp.open("POST", "getDeliveryPerkmCosting?dplnid=" + deliver_planid + "&dsnt=" + totaldistance, true);
            xmlhttp.send();


        }

    </script>
</html>
