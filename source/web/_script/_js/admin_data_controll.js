
var xmlhttp;
function getxmlhttp() {
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
        //alert("XMLHTTP");
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        //alert("ActiveX");
    }
}

function formValidationsavecategory(formx) {
    var form = document.getElementById(formx);
    var inputf = null;
    var msg = null;
    var flag_msg_err = true;
    var flag_submit = false;
    for (var j = 0; j < form.length; j++) {
// alert(form.elements[j].type);
        if (form.elements[j].type === 'text') {
            inputf = form.elements[j];
            if (inputf.value.length === 0) {
                msg = 'name can not be empty';
                flag_msg_err = true;
                flag_submit = false;
            } else if (inputf.value.length > 45) {
                msg = 'name must less than 40 characters';
            } else {
                flag_msg_err = false;
                flag_submit = true;
                saveProductCat(form['spc_name'].value, form['savec_type'].value, form);
            }


            if (flag_msg_err) {
                document.getElementById(form['hxf'].value).style = 'color:red';
            } else {
                document.getElementById(form['hxf'].value).innerHTML = "";
            }

            document.getElementById(form['hxf'].value).innerHTML = msg;
        }

    }
    return  flag_submit;
}


function saveProductCat(cat_name, cat_type, form) {
//saving product categories to given name
    getxmlhttp();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            //alert(xmlhttp.responseText);
            if (xmlhttp.responseText[0] === '0') {
                // alert('in error');
                document.getElementById(form['hxf'].value).style = 'color:red';
                if (xmlhttp.responseText.substring(2, xmlhttp.responseText.length) === '100101') {
                    document.getElementById(form['hxf'].value).innerHTML = "name can not be empty";
                } else if (xmlhttp.responseText.substring(2, xmlhttp.responseText.length) === '1001010') {
                    document.getElementById(form['hxf'].value).innerHTML = "name must be less than 40 charaters";
                } else if (xmlhttp.responseText.substring(2, xmlhttp.responseText.length) === '1001015') {
                    document.getElementById(form['hxf'].value).innerHTML = "name already registerd";
                }
            } else {
                //alert('in succes');
                document.getElementById(form['hxf'].value).style = 'color:green';
                if (xmlhttp.responseText.substring(2, xmlhttp.responseText.length) === '200101') {

                    document.getElementById(form['hxf'].value).innerHTML = "save success";
                    form['spc_name'].value = "";
                }

            }


        }
    };
    xmlhttp.open("POST", "save_product_category?pgx_vld=xmsv_pd3i&spc_name=" + cat_name + "&savec_type=" + cat_type, true);
    xmlhttp.send();
}

function loadCategories(cat_type, select_ele) {
    getxmlhttp();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            document.getElementById(select_ele).innerHTML = "";
            var arr = xmlhttp.responseText.split(',');
            for (var j = 0; j < arr.length; j++) {
                document.getElementById(select_ele).innerHTML += "<option value=" + arr[j].split(":")[1] + ">" + arr[j].split(":")[0] + "</option>";
            }
        }
    };
    xmlhttp.open("POST", "Category_Loader?pgx_vld=xmsv_pd3i&cat_type=" + cat_type, true);
    xmlhttp.send();
}

function onloadCategoryLoader() {
//  loadCategories("mcat", "pcatid");
//  loadCategories("pbrand", "pbrandid");
//  loadCategories("ptype", "ptypeid");
//  loadCategories("pcolor", "pcolorid");

}

function saveSubCat(form, select_el) {
    getxmlhttp();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            var results = xmlhttp.responseText.split("_");
            if (results[0] === "0") {
                document.getElementById("msg-disx-savesubcatfrom").style = "color:red;";
            } else {
                document.getElementById("msg-disx-savesubcatfrom").style = "color:green;";
            }
            document.getElementById("msg-disx-savesubcatfrom").innerHTML = results[1];
        }
    };
    var id = document.getElementById(select_el).value;
    var formx = document.getElementById(form);
    var name = formx['spc_name'].value;
    xmlhttp.open("POST", "save_sub_cat?pgx_vld=svgcat_subpgx&id_cat=" + id + "&scat_name=" + name + "", true);
    xmlhttp.send();
}


function loadSubCategory(slmc, slsc) {

    var maincat_id = document.getElementById(slmc).value;
    getxmlhttp();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

            document.getElementById(slsc).innerHTML = "";
            var subcats = xmlhttp.responseText.split(",");
            for (var j = 0; j < subcats.length; j++) {
                document.getElementById(slsc).innerHTML += "<option value=" + subcats[j].split(":")[0] + ">" + subcats[j].split(":")[1] + "</option>";
            }
        }
    };
    xmlhttp.open("POST", "Load_sub_category?pgx_vld=ldcat14525subpgx&mcat_id=" + maincat_id, true);
    xmlhttp.send();
}

function saveproduct() {
    getxmlhttp();

    var form = document.forms.namedItem("psave");
    var oData = new FormData(form);

    form.addEventListener('submit', function (ev) {
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                var result = xmlhttp.responseText.split("_");
                if (result[0] === "1") {
                    // set success msg
                    for (var f = 0; f < form.length; f++) {
                        form[f].style.border = "1px solid #CCC";
                    }

                    if (result[1] === "dup") {
                        document.getElementById('msgerr_d').innerHTML = "This product code alredy registred";
                        document.getElementById('msgerr_d').style.fontsize = "12px";
                        document.getElementById('msgerr_d').style.color = "red";
                        form[1].style.border = "1px dotted red";
                    } else if (result[1] === "nfin") {
                        var efiled = result[2].split(",");
                        for (var x = 0; x < efiled.length; x++) {
                            form[efiled[x]].style.border = "1px dotted red";
                        }
                        document.getElementById('msgerr_d').innerHTML = "Invalid number format";
                        document.getElementById('msgerr_d').style.fontsize = "12px";
                        document.getElementById('msgerr_d').style.color = "red";

                    } else {
                        document.getElementById('msgerr_d').innerHTML = result[1];
                        document.getElementById('msgerr_d').style.fontsize = "12px";
                        document.getElementById('msgerr_d').style.color = "green";
                    }


                } else {
                    // setting up boder for errors
                    var errofileds = result[1].split(",");
                    var errcount = 0;
                    for (var el = 0; el < form.length; el++) {
                        if (errofileds[el] === 'false') {
                            form[el].style.border = "1px dotted red";
                            errcount++;
                        } else {
                            form[el].style.border = "1px solid #CCC";
                        }
                    }
                    // set error msg

                    document.getElementById('msgerr_d').innerHTML = errcount + " fields are empty or invalid";
                    document.getElementById('msgerr_d').style.fontsize = "12px";
                    document.getElementById('msgerr_d').style.color = "red";
                }

            }
        };
        xmlhttp.open("POST", "save_products", true);
        xmlhttp.send(oData);
        ev.preventDefault();
    }, false);
}

function load_phasvenlist(id, locid) {
    try {
        getxmlhttp();
        var container = document.getElementById(locid);
        container.innerHTML = "";
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                var res = xmlhttp.responseText.split("||");
                var rowsarr = res[1].split(";");
                if (res[0] === '1') {
                    var x = 1;
                    for (var j = 0; j < rowsarr.length; j++) {
                        var oe = "";
                        if (x % 2 === 0) {
                            oe = "even";
                        } else {
                            oe = "odd";
                        }

                        container.innerHTML += "<tr class='" + oe + "'> \n\
                                    <td style='width: 80px'> " + rowsarr[j].split(",")[0] + "</td>\n\
                                    <td style='width: 90px;'>" + rowsarr[j].split(",")[1] + "</td>\n\
                                    <td style='width: 150px'>" + rowsarr[j].split(",")[2] + "</td>\n\
                                    <td style='width: 60px'>" + rowsarr[j].split(",")[3] + "</td>\n\
                                    <td style='width: 60px'>" + rowsarr[j].split(",")[4] + "</td>\n\
                                    <td style='width: 75px'> " + rowsarr[j].split(",")[5] + "</td>\n\
                                    </tr>";
                    }
                } else {
                    container.innerHTML = "<tr><td style='width:585px;'>" + res[1] + "</td></tr>";
                }
            }
        };

        xmlhttp.open("POST", "load_prohasvendors?prqid=" + id, true);
        xmlhttp.send();
    } catch (error) {
        alert(error);
    }

}


function update_phv_details() {
    try {
        getxmlhttp();

        var pcode = document.getElementById('pcode');
        var vendorid = document.getElementById('vendorid');
        var reqqty = document.getElementById('reqqty');
        var preqstate = document.getElementById('preqstate');

        var url_pattern = "";
        if (pcode.value !== "") {
            url_pattern = "?pcode=" + pcode.value;
            if (vendorid.value !== "") {
                url_pattern += "&vid=" + vendorid.value;
            }
            if (reqqty.value !== "") {
                url_pattern += "&reqqty=" + reqqty.value;
            }
            if (preqstate.value !== "") {
                url_pattern += "&reqsid=" + preqstate.value;
            }


        } else {
            alert("enter product code");
        }

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.status === 200 & xmlhttp.readyState === 4) {
                // alert(xmlhttp.responseText);
                var msgbox = document.getElementById('msgbox_phv');
                var res = xmlhttp.responseText.split("_");
                if (res[0] === "1") {
                    msgbox.style.color = "green";
                } else {
                    msgbox.style.color = "red";
                }
                msgbox.innerHTML = res[1];
            }
        };
        xmlhttp.open("POST", "update_product_reqest" + url_pattern, true);
        xmlhttp.send();

    } catch (error) {
        alert(error);
    }

}

function update_vendor_details() {
    try {
        getxmlhttp();
        var msgbox = document.getElementById('msgbox_ven');
        var venname = document.getElementById('venname');
        var venemail = document.getElementById('venemail');
        var venaddr = document.getElementById('venaddr');
        var vencnt1 = document.getElementById('vencnt1');


        var url_pattern = "";
        if (venemail.value !== "") {
            url_pattern = "?email=" + venemail.value;
            if (venname.value !== "") {
                url_pattern += "&name=" + venname.value;
            }
            if (venaddr.value !== "") {
                url_pattern += "&addr=" + venaddr.value;
            }
            if (vencnt1.value !== "") {
                url_pattern += "&cnt1=" + vencnt1.value;
            }
        } else {
            alert("enter vendor email");
        }

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.status === 200 & xmlhttp.readyState === 4) {
                //alert(xmlhttp.responseText);
                var res = xmlhttp.responseText.split("_");
                if (res[0] === "1") {
                    msgbox.style.color = "green";
                } else {
                    msgbox.style.color = "red";
                }
                msgbox.innerHTML = res[1];
            }
        };
        xmlhttp.open("POST", "update_vendors" + url_pattern, true);
        xmlhttp.send();
    } catch (error) {
        alert(error);
    }


}

// advetisng manager data controllers
function save_advertise_category(value_div, msg_div) {
    // saving new category for advetesemetn
    getxmlhttp();
    try {
        var value = document.getElementById(value_div).value;
        var msgbox = document.getElementById(msg_div);
        msgbox.style = "font-size:11px;";
        if (value === null || value === "") {
            alert("Category can not be empty");
        } else {
            //alert("here");
            xmlhttp.onreadystatechange = function () {
                //alert(xmlhttp.readyState +" : "+ xmlhttp.status);
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    //alert(xmlhttp.responseText);
                    var resulttype = xmlhttp.responseText.split("_")[0];
                    var resultmsg = xmlhttp.responseText.split("_")[1];
                    if (resulttype === '1') {
                        msgbox.style.color = "green";
                        msgbox.innerHTML = resultmsg;
                        //load_a_html('page-sub-container', '_admin_pages/advertisement/ad_controll.jsp');
                    } else {
                        msgbox.style.color = "red";
                        msgbox.innerHTML = resultmsg;
                    }
                }
            };
            //alert("ohh");
            xmlhttp.open("POST", "savenewads_category?name=" + value, true);
            xmlhttp.send();
        }
    } catch (error) {
        alert(error);
    }
}

function  remove_ad_category(catid, msg_div) {
    getxmlhttp();
    try {
        var value = catid;
        var msgbox = document.getElementById(msg_div);
        msgbox.style = "font-size:11px;";
        xmlhttp.onreadystatechange = function () {
            // alert(xmlhttp.readyState +" : "+ xmlhttp.status);
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                //alert(xmlhttp.responseText);
                var resulttype = xmlhttp.responseText.split("_")[0];
                var resultmsg = xmlhttp.responseText.split("_")[1];
                if (resulttype === '1') {
                    //msgbox.style.color = "green";
                    //msgbox.innerHTML = resultmsg;
                    alert(resultmsg);
                    load_a_html('page-sub-container', '_admin_pages/advertisement/ad_controll.jsp');
                } else {
                    msgbox.style.color = "red";
                    msgbox.innerHTML = resultmsg;
                }
            }
        };

        xmlhttp.open("POST", "remove_ads_category?cid=" + value, true);
        xmlhttp.send();
    } catch (error) {
        alert(error);
    }
}

function load_ad_loc_details() {
    //getting data fields
    getxmlhttp();
    try {
        document.getElementById('adloc_msg_admin').innerHTML = "";
        var imgsizefield = document.getElementById("adloc_imgsize_admin");
        var pricefield = document.getElementById("ad_loc_price_admin");
        var dscntfield = document.getElementById("ad_loc_dscnt_admin");
        var adloc_id = document.getElementById("ad_loc_cmb_admin").value;

        //setting up data
        xmlhttp.onreadystatechange = function () {
            //alert(xmlhttp.readyState + ":" + xmlhttp.status);
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                var result = xmlhttp.responseText.split("_");
                imgsizefield.innerHTML = result[0] + " (px)";
                pricefield.value = result[1];
                dscntfield.value = result[2];

            }
        };


        //retrivng data for selected items
        if (adloc_id !== '0') {
            xmlhttp.open("POST", "adloc_mng_admin?dtd_load=101&loc_id=" + adloc_id, true);
            xmlhttp.send();
        } else {
            imgsizefield.innerHTML = "width x height (px)";
            pricefield.value = '0.00';
            dscntfield.value = '0.00';

        }


    } catch (error) {
        alert(error);
    }

}

function update_ad_loc_data() {
    try {
        getxmlhttp();
        var msgbox = document.getElementById('adloc_msg_admin');
        var pricefield = document.getElementById("ad_loc_price_admin");
        var dscntfield = document.getElementById("ad_loc_dscnt_admin");
        var adloc_id = document.getElementById("ad_loc_cmb_admin").value;

        var flagUpdate = true;
        if (adloc_id === "0") {
            flagUpdate = false;
        }


        if (flagUpdate) {
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    msgbox.innerHTML = xmlhttp.responseText.split('_')[1];
                    msgbox.style.color = "green";
                }
            };

            msgbox.innerHTML = "";
            xmlhttp.open("POST", "adloc_mng_admin?dtd_update=101&loc_id=" + adloc_id + "&price=" + pricefield.value + "&dscnt=" + dscntfield.value, true);
            xmlhttp.send();
        } else {
            msgbox.innerHTML = "select a ad location";
            msgbox.style.color = "red";
        }

    } catch (error) {
        alert(error);
    }
}

function save_and_update_date_palans() {
    try {
        getxmlhttp();
        var name = document.getElementById("ad_pkg_name_admin").value;
        var datecnt = document.getElementById("ad_pkg_dcount_admin").value;
        var price = document.getElementById("ad_pkg_price_admin").value;
        var dscnt = document.getElementById("ad_pkg_dscount_admin").value;
        // alert(name +":"+datecnt+":"+price+":"+dscnt);

        var url_pattern = "";
        if (name !== "") {
            url_pattern += "?pkgname=" + name;
            if (datecnt !== "" && !isNaN(datecnt)) {
                url_pattern += "&datecnt=" + datecnt;
            }

            if (price !== "") {
                url_pattern += "&price=" + price;
            }

            if (dscnt !== "") {
                url_pattern += "&dscnt=" + dscnt;
            }

            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    alert(xmlhttp.responseText.split("_")[1]);
                    if (xmlhttp.responseText.split("_")[0] === "1") {
                        load_a_html('page-sub-container', '_admin_pages/advertisement/ad_controll.jsp');
                    }
                }
            };
            //alert(url_pattern);
            xmlhttp.open("POST", "save_update_addateplan" + url_pattern, true);
            xmlhttp.send();

        } else {
            alert("Enter package name");
        }
    } catch (error) {
        alert(error);
    }
}

function  remove_ad_pkgplan(planid) {
    getxmlhttp();
    try {
        var value = planid;
        xmlhttp.onreadystatechange = function () {
            // alert(xmlhttp.readyState +" : "+ xmlhttp.status);
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                //alert(xmlhttp.responseText);
                var resulttype = xmlhttp.responseText.split("_")[0];
                var resultmsg = xmlhttp.responseText.split("_")[1];
                alert(resultmsg);
                if (resulttype === '1') {
                    load_a_html('page-sub-container', '_admin_pages/advertisement/ad_controll.jsp');
                } else {
                }
            }
        };

        xmlhttp.open("POST", "remove_ad_planpkg?planid=" + value, true);
        xmlhttp.send();
    } catch (error) {
        alert(error);
    }
}







function load_ad_list(status_id) {
    getxmlhttp();
    setfiled_empty();
    try {
        var status = document.getElementById(status_id);

        if (status.value !== '0') {
            var tbody = document.getElementById('ad_details_on_adview');
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    tbody.innerHTML = "";
                    if (xmlhttp.responseText.split("|")[0] === "1") {
                        var rows = xmlhttp.responseText.split("|")[1].split(";");
                        //alert(rows);
                        for (var j = 0; j < rows.length; j++) {
                            tbody.innerHTML += "<tr> \n\
                            <td class='tbd_cl1' style='width: 50px;'>" + rows[j].split(",")[0] + "</td>\n\
                            <td class='tbd_cl1' style='width: 220px;'>" + rows[j].split(",")[1] + " <span  onclick=" + '"' + "view_ad_data('" + rows[j].split(",")[0] + "')" + '"' + ">view</span></td> \n\
                            <td class='tbd_cl1' style='width: 55px;text-align: right;font-size:11px;'>" + rows[j].split(",")[2] + "</td> \n\
                            <td class='tbd_cl1' style='width: 90px;text-align: right;'>" + rows[j].split(",")[3] + "</td> \n\
                            <td class='tbd_cl1' style='width: 160px;text-align: left;'>" + rows[j].split(",")[4] + "</td>\n\
                            </tr>";
                        }
                    } else {
                        alert("no result found");
                    }
                }
            };
            xmlhttp.open("POST", "getAd_List?status_id=" + status.value, true);
            xmlhttp.send();

        } else {
            alert("select a status");
        }
    } catch (error) {
        alert(error);
    }
}

function view_ad_data(id) {
    getxmlhttp();
    try {
        //get objects

        var ad_id = document.getElementById('ad_id');
        var adtitle = document.getElementById('adtitle');
        var adwurl = document.getElementById('adwurl');
        var adimg = document.getElementById('adimg');
        var addescr = document.getElementById('adscr');
        var adstatus = document.getElementById('adstate');
        var imglocation = "_images/_add/_sub_page/";
        var adexfdate = document.getElementById('adexfd');
        var controll_buttun_cont = document.getElementById('adctrlbtn');


        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                var outtype = xmlhttp.responseText.split("|-");
                if (outtype[0] === '1') {
                    var ad_elemtns = outtype[1].split(",");

                    var id = ad_elemtns[0];
                    var title = ad_elemtns[1];
                    var wurl = ad_elemtns[2];
                    var imgurl = ad_elemtns[3];
                    var imgwh = ad_elemtns[4];
                    var descr = ad_elemtns[5];
                    var status = ad_elemtns[6];
                    var exfdate = ad_elemtns[7];

                    ad_id.value = id;
                    adtitle.value = title;
                    adwurl.value = wurl;
                    adimg.width = imgwh.split("x")[0];
                    adimg.height = imgwh.split("x")[1];
                    adimg.src = imglocation + imgurl;
                    addescr.value = descr;
                    adexfdate.value = exfdate;

                    if (status === "3") {
                        adstatus.value = "Ad is pending";
                        controll_buttun_cont.innerHTML = "<input type='button' value='publish' style='padding: 3px; width: 120px;' onclick=" + "activate_and_detaivate_ads('" + id + "','1')" + "> <input type='button' value='discard' style='padding: 3px; width: 120px;' onclick=" + "activate_and_detaivate_ads('" + id + "','2')" + ">";
                    } else if (status === "2") {
                        adstatus.value = "This ad is not valid";
                        controll_buttun_cont.innerHTML = "";
                    } else if (status === "1") {
                        adstatus.value = "Ad is active";
                        controll_buttun_cont.innerHTML = "<input type='button' value='remove' style='padding: 3px; width: 120px;' onclick=" + "activate_and_detaivate_ads('" + id + "','4')" + "> ";
                    } else if (status === "4") {
                        adstatus.value = "Ad is expired";
                        controll_buttun_cont.innerHTML = "";
                    }
                } else {
                    alert("no result found");
                }
            }
        };
        xmlhttp.open("POST", "getad_data_by_id?adid=" + id, true);
        xmlhttp.send();
    } catch (error) {
        alert(error);
    }

}


function activate_and_detaivate_ads(id, status) {
    try {
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                //alert(xmlhttp.responseText);
                if (xmlhttp.responseText.split("_")[0] === "1") {
                    alert(xmlhttp.responseText.split("_")[1]);
                    view_ad_data(id);
                } else {
                    alert(xmlhttp.responseText.split("_")[1]);
                }
            }
        };

        xmlhttp.open("POST", "activate_and_detaivate_ads?adid=" + id + "&statusid=" + status, true);
        xmlhttp.send();

    } catch (error) {
        alert(error);
    }
}

function setfiled_empty() {

    document.getElementById('ad_id').value = "";
    document.getElementById('adtitle').value = "";
    document.getElementById('adwurl').value = "";
    var adimg = document.getElementById('adimg');
    adimg.width = "300";
    adimg.height = "150";
    adimg.src = "";
    document.getElementById('adscr').value = "";
    document.getElementById('adstate').value = "";
    document.getElementById('adexfd').value = "";
    document.getElementById('adctrlbtn').value = "";
}

// end of advertising manger data controlls

//load invoice by params
function load_invoice_with_params(req_container, html_location) {
    try {
        getxmlhttp();
        var val1 = document.getElementById("vl1").value;
        var val2 = document.getElementById("vl2").value;
        var val3 = document.getElementById("vl3").value;

        var con = document.getElementById(req_container);

        var urlpattern = "";

        if (val1 !== "") {
            urlpattern += "&vl1=" + val1;
        }
        if (val2 !== "") {
            urlpattern += "&vl2=" + val2;
        }
        if (val3 !== "") {
            urlpattern += "&vl3=" + val3;
        }


//alert(con);
        xmlhttp.onreadystatechange = function (e) {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                // alert("innn");
                con.innerHTML = xmlhttp.responseText;

            }
        };
        xmlhttp.open("POST", html_location + "?search=v2k2" + urlpattern, true);
        xmlhttp.setRequestHeader('Content-type', 'text/html');
        xmlhttp.send();
    } catch (error) {
        alert(error);
    }
}
 