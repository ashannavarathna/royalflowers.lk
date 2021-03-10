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
        <title>Advertisement | Royal Flowers</title>
        <link href="_css/_custome_002.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="_script/_js/_custome_01.js"></script>
        <script type="text/javascript">
            var xmlhttp;
            function getxmlhttp() {
                if (window.XMLHttpRequest) {
                    xmlhttp = new XMLHttpRequest();

                } else {
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

                }
            }
            function load_and_set_prices(search_type) {
                try {
                    getxmlhttp();

                    var enable_setprice = true;
                    var adl_price_in_table = document.getElementById("adlp_in_tbl");
                    var adp_price_in_table = document.getElementById("adpp_in_tbl");
                    var ad_total = document.getElementById("ad_total");

                    var adl_price = document.getElementById("adl_price_usr");
                    var adp_price = document.getElementById("adp_price_usr");
                    var imgsize = document.getElementById("ad_imgsize_usr");
                    var adimg = document.getElementById("ad_img_usr");
                    var url_pattern = "";

                    if (search_type === "ad_l") {
                        url_pattern = "?ad_l=" + document.getElementById("ad_loc_cmb_usr").value;

                        if (document.getElementById("ad_loc_cmb_usr").value === "0") {
                            enable_setprice = false;
                            adl_price.innerHTML = "0.00";
                            adl_price_in_table.innerHTML = "0.00";
                            ad_total.innerHTML = parseFloat(Number(adl_price_in_table.innerHTML) + Number(adp_price_in_table.innerHTML)).toFixed(2);
                        }

                    }

                    if (search_type === "ad_p") {
                        url_pattern = "?ad_p=" + document.getElementById("ad_pkg_cmb_usr").value;

                        if (document.getElementById("ad_pkg_cmb_usr").value === "0") {
                            enable_setprice = false;
                            adp_price.innerHTML = "0.00";
                            adp_price_in_table.innerHTML = "0.00";
                            ad_total.innerHTML = parseFloat(Number(adl_price_in_table.innerHTML) + Number(adp_price_in_table.innerHTML)).toFixed(2);
                        }

                    }


                    //setting up data



                    if (enable_setprice) {
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status) {
                                var result = xmlhttp.responseText.split("_");
                                if (result[0] === "ad-l") {
                                    //setting things for add location
                                    adl_price.innerHTML = result[1] + " (LKR)";
                                    adl_price_in_table.innerHTML = result[1];
                                    imgsize.value = result[2];
                                    document.getElementById("img_size_dis").innerHTML = "imge size must be " + result[2] + " for this ad";

                                } else if (result[0] === "ad-p") {
                                    adp_price.innerHTML = result[1] + " (LKR)";
                                    adp_price_in_table.innerHTML = result[1];
                                }
                                ad_total.innerHTML = parseFloat(Number(adl_price_in_table.innerHTML) + Number(adp_price_in_table.innerHTML)).toFixed(2);
                            }
                        };

                        // alert(url_pattern);
                        xmlhttp.open("POST", "load_ads_prices_usr" + url_pattern, true);
                        xmlhttp.send();
                    }



                } catch (error) {
                    alert(error);
                }
            }

            function saveandsubmit() {
                try {
                    var save_enable = true;
                    // getting valuess from filed
                    var category = document.getElementById('adcr_adc_usr');
                    var title = document.getElementById('ad_title_usr');
                    var web_url = document.getElementById('ad_web_url_usr');
                    var ad_location = document.getElementById('ad_loc_cmb_usr');
                    var ad_img = document.getElementById('ad_img_usr');
                    var imgsize_hidden = document.getElementById('ad_imgsize_usr');
                    var ad_d_plan = document.getElementById('ad_pkg_cmb_usr');
                    var ad_description = document.getElementById('ad_descr_usr');
                    // var ad_total;

                    var password = document.getElementById('usr_psw_admin');
                    var card_number = document.getElementById('ad_card_num_usr');
                    var exf_date = document.getElementById('ad_card_exf_date_usr');
                    var exf_month = document.getElementById('ad_card_exf_month_usr');
                    var card_svs = document.getElementById('ad_card_cvc_usr');

                    var msgbox = document.getElementById('ad_msg_box_usr');
                    //chekc name

                    if (category.value === '0') {
                        save_enable = false;
                        //msgbox.innerHTML = 'Select a ad category';
                        category.style.border = '1px dotted red';
                    } else {
                        category.style.border = '1px solid #CCC';
                    }

                    //chekc title
                    if (title.value === "") {
                        save_enable = false;
                        //msgbox.innerHTML = 'Enter title for the ad ';
                        title.style.border = '1px dotted red';
                    } else {
                        title.style.border = '1px solid #CCC';
                    }

                    //chekc web url
                    if (web_url.value === "") {
                        save_enable = false;
                        //msgbox.innerHTML = 'Enter web site url for the ad';
                        web_url.style.border = '1px dotted red';
                    } else {
                        web_url.style.border = '1px solid #CCC';
                    }

                    //chec location
                    if (ad_location.value === "0") {
                        save_enable = false;
                        // msgbox.innerHTML = 'Select a advetisement location';
                        ad_location.style.border = '1px dotted red';
                    } else {
                        ad_location.style.border = '1px solid #CCC';
                    }

                    //chekc img 
                    if (ad_img.value === "") {
                        save_enable = false;
                        //msgbox.innerHTML = 'upload ad image';
                        ad_img.style.border = '1px dotted red';
                    } else {
                        ad_img.style.border = '1px solid #CCC';
                    }


                    //chekc ad plan
                    if (ad_d_plan.value === "0") {
                        save_enable = false;
                        //msgbox.innerHTML = 'Select a advetisement date plan';
                        ad_d_plan.style.border = '1px dotted red';
                    } else {
                        ad_d_plan.style.border = '1px solid #CCC';
                    }


                    //chekc descption
                    if (ad_description.value === "") {
                        save_enable = false;
                        //msgbox.innerHTML = 'Enter short decription for the advertisement';
                        ad_description.style.border = '1px dotted red';
                    } else {
                        ad_description.style.border = '1px solid #CCC';
                    }
                    //password valiation
                    if (password.value === "") {
                        save_enable = false;
                        // msgbox.innerHTML = 'Enter your password';
                        password.style.border = '1px dotted red';
                    } else {
                        password.style.border = '1px solid #CCC';
                    }

                    //check card num
                    if (card_number.value === "") {
                        save_enable = false;
                        // msgbox.innerHTML = 'Enter card number';
                        card_number.style.border = '1px dotted red';
                    } else {
                        card_number.style.border = '1px solid #CCC';
                    }

                    //chekc card validaton
                    if (exf_date.value === "") {
                        save_enable = false;
                        //msgbox.innerHTML = 'Enter card expire date';
                        exf_date.style.border = '1px dotted red';
                    } else {
                        exf_date.style.border = '1px solid #CCC';
                    }
                    if (exf_month.value === "") {
                        save_enable = false;
                        // msgbox.innerHTML = 'Enter card expire month';
                        exf_month.style.border = '1px dotted red';
                    } else {
                        exf_month.style.border = '1px solid #CCC';
                    }
                    if (card_svs.value === "") {
                        save_enable = false;
                        //msgbox.innerHTML = 'Enter card expire cvc';
                        card_svs.style.border = '1px dotted red';
                    } else {
                        card_svs.style.border = '1px solid #CCC';
                    }


                    //save and submit

                    if (save_enable) {
                        msgbox.innerHTML = "please wait... your ad is processing";
                        msgbox.style.color = "#777";
                        document.getElementById("ad_submit_btn").disabled = true;
                        var form = document.forms.namedItem("save_ad");
                        var oData = new FormData(form);

                        form.addEventListener('submit', function (ev) {
                            xmlhttp.onreadystatechange = function () {
                                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

                                    if (xmlhttp.responseText.split("_")[0] == "1") {
                                        msgbox.style.color = "green"
                                        msgbox.innerHTML = xmlhttp.responseText.split("_")[1] + "please vist admanger or reload page";
                                    } else {
                                        msgbox.style.color = "red";
                                        msgbox.innerHTML = xmlhttp.responseText.split("_")[1];
                                        document.getElementById("ad_submit_btn").disabled = false;
                                    }

                                }
                            };
                            xmlhttp.open("POST", "save_n_submit_ad", true);
                            xmlhttp.send(oData);
                            ev.preventDefault();
                        }, false);



                    } else {
                        msgbox.innerHTML = "input filed error";
                        msgbox.style.color = "red";
                        return false;// return false then submit will stop
                    }

                } catch (error) {
                    alert(error);
                }
            }
            function password_validation() {

            }


            function check_imgsize() {
                var upimg = document.getElementById('ad_img_usr').value;
                // alert(upimg.offsetHeight);

                var imgsize_hidden = document.getElementById('ad_imgsize_usr');
                // alert(imgsize_hidden.value);
            }
        </script>
        <style>
            .add_c_form{
                width: 950px;
                padding: 5px;
                margin: 0 auto;
                clear:both;
                min-height: 500px;
            }
            .add_c_form_cnt{
                position: relative;
                float: left;
                margin-left: 10px;
                min-height: 480px;
                width: 440px;
                padding: 10px;
                border: 1px dotted #CCC;
            }
            .add_c_form label{
                display: block;
                margin-top: 10px;
                margin-bottom: 5px;
                font-size: 13px;
                font-weight: bold;
                color: #504b4b;
                padding-left: 1px;
            }
            .add_c_form input[type=text]{
                display: block;
                padding: 5px;
                width: 400px;
                border: 1px solid #CCC;
            }
            .add_c_form input[type=file]{
                display: block;
                padding: 5px;
                width: 400px;
                border: 1px dotted #CCC;

            }
            .add_c_form input[type=password]{
                display: block;
                padding: 5px;
                width: 400px;
                border: 1px solid #CCC;
            }
            .add_c_form select{
                display: block;
                padding: 0px 5px;
                width: 412px;
                border: 1px solid #CCC;

            }
            .add_c_form select option{
                padding: 5px 5px;
            }
            .add_c_form .ad_paycard input{
                display: inline-block;
                width: 250px;
                text-align: center;
            }
            .add_c_form form input[type=submit]{
                width: 195px;
                padding: 5px;
                margin-top: 14px;
                border: 1px solid #999;
                background-color: #CCC;
                border-radius: 2px;
                box-shadow: 0 0 7px -5px #777;
                font-weight: bolder;
                /*text-transform: uppercase;*/
                color: #333;
            }
            .add_c_form form input[type=submit]:hover{
                background-color: #C1C1C1;
                border: 1px solid #999;
                cursor: pointer;
                box-shadow: 0 0 7px -5px #777;
            }
            .add_c_form .add_c_msg{
                padding: 5px;
                font-size: 11px;
                border: 1px dotted #CCC;
                color: #777;
            }

        </style>
    </head>
    <body>

        <%@include file="_pages_container/top_header.jsp" %>
        <%@include file="_pages_container/_noscript.jsp"%>
        <div class="main-wrapper">
            <%@include file="_pages_container/navbar_top.jsp" %>

            <% /*check logged user*/
                if (request.getSession().getAttribute("user-id") == null) {
                    out.write("<div style='min-height:100px;margin:0 auto;width:600px;padding:20px;border:1px dotted #CCC;font-size:13px;'>before you create a advertisement please login <a href='signin.jsp'>click here</a> </div> ");
                } else {
            %>
            <div class="add_c_form">
                <form  method="post" enctype="multipart/form-data" name="save_ad" >
                    <div class="add_c_form_cnt">
                        <!--basic advertsiemt info-->
                        <label>Select Category</label>
                        <select name="adcr_adc" id="adcr_adc_usr">
                            <option value="0">select the advertising category</option>
                            <% /*comment */

                                Session sescr_ad = conn.connector.getSessionFactory().openSession();
                                Criteria cry = sescr_ad.createCriteria(pojo.AdvertisingCategory.class);
                                pojo.AdvertisingStatus adstate = (pojo.AdvertisingStatus) sescr_ad.load(pojo.AdvertisingStatus.class, 1);
                                cry.add(Restrictions.eq("advertisingStatus", adstate));
                                List<pojo.AdvertisingCategory> adclist = cry.list();
                                for (pojo.AdvertisingCategory adx : adclist) {
                                    out.write("<option value='" + adx.getIdadvertisingCategory() + "'>" + adx.getCategory() + "</option>");
                                }
                            %>

                        </select>
                        <label>Title <span style="font-size: 11px;">(title of your ad)</span></label>
                        <input type="text" name="ad_title" id="ad_title_usr" />

                        <label>Web-Site URL <span style="font-size: 11px;">(your site or company)</span></label>
                        <input type="text" name="ad_web_url" id="ad_web_url_usr"/>

                        <label>Select Location <span style="font-size: 11px;">(this will change your cost of advertising)</span></label>
                        <select style="width: 250px;display: inline-block;" name="ad_loc_cmb" id="ad_loc_cmb_usr" onchange="load_and_set_prices('ad_l')">
                            <option value="0">select location</option>
                            <%/*loading ad location*/
                                Criteria cryadloc = sescr_ad.createCriteria(pojo.AdvertisingLocation.class);
                                List<pojo.AdvertisingLocation> adloclist = cryadloc.list();
                                String fstvalimgsize = ""; // getting the img size of first vale in db
                                for (pojo.AdvertisingLocation adloc : adloclist) {
                                    if (fstvalimgsize == "") {
                                        fstvalimgsize = adloc.getImgSize();
                                    }
                                    out.write("<option value='" + adloc.getIdadvertisingLocation() + "'>" + adloc.getLocation() + "</option>");
                                }
                            %>
                        </select>
                        <label style="display: inline-block;margin-left: 5px; border: 1px dotted #CCC;padding: 5px;width: 140px;text-align: right;" id="adl_price_usr">0.00 (LKR)</label>
                        <label>Image <span style="font-size: 11px;" id="img_size_dis">(image sizes are different from selected location)</span></label>
                        <input type="file" name="ad_img" id="ad_img_usr" onchange="check_imgsize()" />
                        <input type="hidden" name="imgszize" id="ad_imgsize_usr">
                        <label>Plan your ad dates <span style="font-size: 11px;">(select a data plan suit your budget)</span></label>
                        <select style="width: 250px;display: inline-block;" name="ad_pkg_cmb" id="ad_pkg_cmb_usr" onchange="load_and_set_prices('ad_p')">
                            <option value="0">select location</option>
                            <%/*loading ad location*/
                                Criteria cryadpkg = sescr_ad.createCriteria(pojo.AdvertisingDatePlans.class);
                                List<pojo.AdvertisingDatePlans> adpkglist = cryadpkg.list();

                                for (pojo.AdvertisingDatePlans adpkg : adpkglist) {

                                    out.write("<option value='" + adpkg.getIdadvertisingDatePlans() + "'>" + adpkg.getPakage() + "</option>");
                                }
                            %>
                        </select>
                        <label style="display: inline-block;margin-left: 5px; border: 1px dotted #CCC;padding: 5px;width: 140px;text-align: right;" id="adp_price_usr">0.00 (LKR)</label>
                        <label>Short Description <span style="font-size: 11px;">(simple note for the target customers)</span></label>
                        <input type="text" name="add_descr" id="ad_descr_usr"/>
                    </div>
                    <div class="add_c_form_cnt">

                        <label>Ad Costing</label>
                        <table width="410" style="border: 1px dotted #CCC;padding: 2px 1px;font-size: 12px;">
                            <tr style="background-color: #504b4b; color: #FFF;font-size: 13px; font-weight: bold;">
                                <td width="250" style="padding: 3px;">Detail</td>
                                <td style="padding: 3px;text-align: right;">Cost (LKR)</td>
                            </tr>
                            <tr>
                                <td width="250" style="padding: 3px;">Location Costing</td>
                                <td style="padding: 3px;text-align: right;" id="adlp_in_tbl">0.00</td>
                            </tr>
                            <tr>
                                <td width="250" style="padding: 3px;">Date Plan Costing</td>
                                <td style="padding: 3px;text-align: right;" id="adpp_in_tbl">0.00</td>
                            </tr>
                            <tr>
                                <td width="250" style="padding: 3px;font-weight: bold;">Total Ad Cost</td>
                                <td style="padding: 3px;text-align: right;font-weight: bold;" id="ad_total">0.00</td>
                            </tr>
                        </table>
                        <div style="margin-top: 10px;border-bottom: 1px solid #CCC;"></div>
                        <label>Payments</label>
                        <label>Re-Enter password</label>
                        <input type="password" style="width:250px;" name="usr_psw" id="usr_psw_admin">
                        <label>Card Number</label>
                        <div class="ad_paycard">
                            <input type="text" placeholder="" name="ad_card_num" id="ad_card_num_usr" onkeypress="return ((document.getElementById('ad_card_num_usr').value.length <= 15) && (event.charCode >= 48 && event.charCode <= 57)) || (event.charCode === 0)"> 
                            <!-- - <input type="text" placeholder=""> - <input type="text" placeholder=""> - <input type="text" placeholder=""> -->
                        </div>
                        <label>Card Details <span style="font-size: 11px;">(card expire date, card verification code)</span></label>
                        <div class="ad_paycard_detaisl">
                            <input type="text" style="display: inline-block;width: 40px;text-align: center;" placeholder="MM" name="ad_card_exf_month" id="ad_card_exf_month_usr" onkeyup="keyup_value_vlidation('ad_card_exf_month_usr', '12')" onkeypress="return ((document.getElementById('ad_card_exf_month_usr').value.length <= 1) && (event.charCode >= 48 && event.charCode <= 57)) || (event.charCode === 0)" /><input type="text" style="display: inline-block;width: 40px;margin-left: 5px;text-align: center;" placeholder="DD" name="ad_card_exf_date" id="ad_card_exf_date_usr" onkeypress="return ((document.getElementById('ad_card_exf_date_usr').value.length <= 1) && (event.charCode >= 48 && event.charCode <= 57)) || (event.charCode === 0)" onkeyup="keyup_value_vlidation('ad_card_exf_date_usr', '31')" /><input type="text" name="ad_card_cvc" id="ad_card_cvc_usr" style="display: inline-block;width: 60px;margin-left: 15px;text-align: center;" placeholder="CVC" onkeypress="return ((document.getElementById('ad_card_cvc_usr').value.length <= 3) && (event.charCode >= 48 && event.charCode <= 57)) || (event.charCode === 0)" />
                        </div>
                        <input type="submit" value="pay & submit" onclick="return saveandsubmit()" id="ad_submit_btn">
                        <label><span style="font-size: 11px;">(after submit, your payment will accept and the ad will send to administrator approval, you can manage your ad's easily through <a href="#"> ad_manager </a>)</span></label>
                        <div class="add_c_msg" id="ad_msg_box_usr"></div>

                    </div>
                </form>
                <script>
                    function keyup_value_vlidation(id, maxval) {
                        try {
                            var element = document.getElementById(id);

                            if (element.value > Number(maxval)) {
                                element.value = "";
                            }
                        } catch (error) {
                            alert(error);
                        }
                    }
                </script>
            </div>
            <div style="margin-bottom: 20px;"></div>


            <%                }

            %>


        </div>
        <%@include file="_pages_container/botom_footer.jsp" %>


    </body>
</html>


