/* load # content to dispaly*/
function load_hash_content() {
    document.getElementById("top-title-subpages").innerHTML = "# Content";
    document.getElementById("center_content_con").innerHTML = "<div class='dashbord_welcome' style='padding:250px 400px;text-alling:center;font-size:18px;'> welcome to dashborad </div>";
}

/* end of # */

/*load product registration*/
function load_product_registration() {
    document.getElementById("top-title-subpages").innerHTML = "PRODUCT REGISTRATION";
    document.getElementById("center_content_con").innerHTML = "<div class='page_menu'>" +
            "<ul>" +
            "<li onclick='load_save_products_details()'>Add Products</li>" +
            "<li onclick=' load_save_products_sub_category()'>Add Categories </li>" +
            "<li onclick=" + '"' + "" + "load_a_html('page-sub-container','_admin_pages/_products_management/vendors_proreq.jsp')" + '"' + " id='pvenmngt'>Vendors Mngt</li>" +
            " </ul>" +
            "</div>" +
            " <div class='page-display' id='page-sub-container'>" +
            "</div>";
    load_save_products_details();
}
/* end load product registration*/

/*load user Managment*/
function load_user_managment() {
    document.getElementById("top-title-subpages").innerHTML = "USER MANAGMENT";
    document.getElementById("center_content_con").innerHTML = "<div class='page_menu'>" +
            "<ul>" +
            "<li onclick='load_view_user()' id='u_view'>View & Update Users </li>" +
            " </ul>" +
            "</div>" +
            " <div class='page-display' id='page-sub-container'>" +
            "</div>";
    load_view_user();
}
/* end load user Managment*/
/*load stock Managment*/
function load_stock_managment() {
    document.getElementById("top-title-subpages").innerHTML = "STOCK MANAGMENT";
    document.getElementById("center_content_con").innerHTML = "<div class='page_menu'>" +
            "<ul>" +
            "<li onclick='load_pro_list()' id='st_view'>Prodcuts List </li>" +
            " </ul>" +
            "</div>" +
            " <div class='page-display' id='page-sub-container'>" +
            "</div>";
    load_pro_list();
}
/* end load stock Managment*/

/*load delivery Managment*/
function load_delivery_managment() {
    document.getElementById("top-title-subpages").innerHTML = "DELIVERY MANAGMENT";
    document.getElementById("center_content_con").innerHTML = "<div class='page_menu'>" +
            "<ul>" +
            "<li onclick='load_Delivery()' id='dlv_view'>Jobs </li>" +
            " </ul>" +
            "</div>" +
            " <div class='page-display' id='page-sub-container'>" +
            "</div>";
    load_Delivery();
}
/* end load deliver Managment*/

function load_salses() {
    document.getElementById("top-title-subpages").innerHTML = "Sales Reports";
    document.getElementById("center_content_con").innerHTML = "<div class='page_menu'>" +
            "<ul>" +
            "<li onclick='load_invoice()' id='v_invo'>Sales </li>" +
            " </ul>" +
            "</div>" +
            " <div class='page-display' id='page-sub-container'>" +
            "</div>";
    load_invoice();
}
function load_advertisemetn_panel() {
    document.getElementById("top-title-subpages").innerHTML = "Ad Manager";
    document.getElementById("center_content_con").innerHTML = "<div class='page_menu'>" +
            "<ul>" +
            "<li  onclick=" + '"' + "" + "load_a_html('page-sub-container','_admin_pages/advertisement/manage_add.jsp')" + '"' + " id='v_admng_setting'>Ads Manager</li>" +
            "<li onclick=" + '"' + "" + "load_a_html('page-sub-container','_admin_pages/advertisement/ad_controll.jsp')" + '"' + " id='v_ad_setting'>Ads Settings</li>" +
            " </ul>" +
            "</div>" +
            " <div class='page-display' id='page-sub-container'>" +
            "</div>";
    load_a_html('page-sub-container', '_admin_pages/advertisement/manage_add.jsp');

}
//end

function click_a_tab(id) {
    document.getElementById(id).click();
}



/* load subpage contents */
/*load product details*/
function load_save_products_details() {
    //document.getElementById("page-sub-container").innerHTML='<object data="_admin_pages/_products_management/product_details.jsp" class="subcontent"> </object>';
    var con = document.getElementById('page-sub-container');
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function (e) {
        if (xhr.readyState === 4 && xhr.status === 200) {
            con.innerHTML = xhr.responseText;
            loadSubCategory("pcatid", "pscatid");
        }
    };

    xhr.open("POST", "_admin_pages/_products_management/product_details.jsp", true);
    xhr.setRequestHeader('Content-type', 'text/html');
    xhr.send();
}
function load_view_user() {
    try {
        var fname = "";
        var lname = "";
        var mail = "";
        var type = "";
        var state = "";

        if (document.getElementById('usfname') !== null) {
            fname = document.getElementById('usfname').value;
        }
        if (document.getElementById('uslname') !== null) {
            lname = document.getElementById('uslname').value;
        }
        if (document.getElementById('usemail') !== null) {
            mail = document.getElementById('usemail').value;
        }
        if (document.getElementById('ustype') !== null) {
            type = document.getElementById('ustype').value;
        }
        if (document.getElementById('usstate') !== null) {
            state = document.getElementById('usstate').value;
        }
        //alert("hi hi");
        //document.getElementById("page-sub-container").innerHTML='<object data="_admin_pages/_products_management/product_details.jsp" class="subcontent"> </object>';
        var con = document.getElementById('page-sub-container');
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function (e) {
            if (xhr.readyState === 4 && xhr.status === 200) {
                con.innerHTML = xhr.responseText;
            }
        };

        xhr.open("POST", "_admin_pages/user_search.jsp?fname=" + fname + "&lname=" + lname + "&email=" + mail + "&ustate=" + state + "&utype=" + type, true);
        xhr.setRequestHeader('Content-type', 'text/html');
        xhr.send();

    } catch (error) {
        alert(error);
    }
}


/* load save  product categories*/
function load_save_products_sub_category() {
    var con = document.getElementById('page-sub-container');
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function (e) {
        if (xhr.readyState === 4 && xhr.status === 200) {
            con.innerHTML = xhr.responseText;

        }
    };

    xhr.open("POST", "_admin_pages/_products_management/product_categories.jsp", true);
    xhr.setRequestHeader('Content-type', 'text/html');
    xhr.send();
}

/* load  manage product*/
function load_manage_products() {
    //document.getElementById("page-sub-container").innerHTML='<object data="_admin_pages/_products_management/product_details.jsp" class="subcontent"> </object>';
    var con = document.getElementById('page-sub-container');
    var xhr = new XMLHttpRequest();


    xhr.onreadystatechange = function (e) {
        if (xhr.readyState === 4 && xhr.status === 200) {
            con.innerHTML = xhr.responseText;
        }
    };

    xhr.open("POST", "_admin_pages/_products_management/Manage_product.jsp", true);
    xhr.setRequestHeader('Content-type', 'text/html');
    xhr.send();
}
function load_a_html(req_container, html_location) {
    var xhr = new XMLHttpRequest();
    //document.getElementById("page-sub-container").innerHTML='<object data="_admin_pages/_products_management/product_details.jsp" class="subcontent"> </object>';
    var con = document.getElementById(req_container);
    //alert(con);
    xhr.onreadystatechange = function (e) {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // alert("innn");
            con.innerHTML = xhr.responseText;

        }
    };
    xhr.open("POST", html_location, true);
    xhr.setRequestHeader('Content-type', 'text/html');
    xhr.send();
}

function update_user_types(save_type) {
    //alert("click");
    try {
        var xhr = new XMLHttpRequest();
        var email = document.getElementById("upusemail").value;
        var ustate = document.getElementById("upusstate").value;
        var utype = document.getElementById("upustype").value;
        var url_patten = "?upemail=" + email;
        var msgdiv = "";
        if (email === "") {
            alert("Enter email address");
        }
        if (save_type === "ustate") {
            url_patten += "&tid=" + ustate;
            msgdiv = document.getElementById("msg_state");
        } else if (save_type === "utype") {
            url_patten += "&tid=" + utype;
            msgdiv = document.getElementById("msg_type");
        }
        url_patten += "&save_type=" + save_type;
        //alert(url_patten);

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                msgdiv.innerHTML = xhr.responseText;
            }
        };
        xhr.open("POST", "uacc_update" + url_patten, true);
        xhr.send();
    } catch (error) {
        alert(error);
    }

}



function load_pro_list() {
    try {
        var vl1 = "";
        if (document.getElementById('vl1') !== null) {
            vl1 = document.getElementById('vl1').value;
        }
        var con = document.getElementById('page-sub-container');
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function (e) {
            if (xhr.readyState === 4 && xhr.status === 200) {
                con.innerHTML = xhr.responseText;
            }
        };
        xhr.open("POST", "_admin_pages/product_update.jsp?vl1=" + vl1, true);
        xhr.setRequestHeader('Content-type', 'text/html');
        xhr.send();

    } catch (error) {
        alert(error);
    }
}

function load_Delivery() {
    try {
        var vl1 = "";
        if (document.getElementById('vl1') !== null) {
            vl1 = document.getElementById('vl1').value;
        }
        var con = document.getElementById('page-sub-container');
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function (e) {
            if (xhr.readyState === 4 && xhr.status === 200) {
                con.innerHTML = xhr.responseText;
            }
        };
        xhr.open("POST", "_admin_pages/delivery.jsp?vl1=" + vl1, true);
        xhr.setRequestHeader('Content-type', 'text/html');
        xhr.send();

    } catch (error) {
        alert(error);
    }
}

function load_invoice() {
    try {
        var vl1 = "";
        if (document.getElementById('vl1') !== null) {
            vl1 = document.getElementById('vl1').value;
        }
        var con = document.getElementById('page-sub-container');
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function (e) {
            if (xhr.readyState === 4 && xhr.status === 200) {
                con.innerHTML = xhr.responseText;
            }
        };
        xhr.open("POST", "_admin_pages/invoice_view.jsp?vl1=" + vl1, true);
        xhr.setRequestHeader('Content-type', 'text/html');
        xhr.send();

    } catch (error) {
        alert(error);
    }
}

function update_stock_vls() {
    try {
        var xhr = new XMLHttpRequest();
        var pcode = document.getElementById("pcode").value;
        var price = document.getElementById("price").value;
        var dsnt = document.getElementById("dsnt").value;
        var qty = document.getElementById("qty").value;
        var msgdiv = document.getElementById("up_msg");
        if (pcode === "") {
            alert("Enter product code");
        }
        var url_patten = "?pcode=" + pcode + "&price=" + price + "&dsnt=" + dsnt + "&qty=" + qty;
        xhr.onreadystatechange = function () {
            //alert(xhr.readyState +" : "+xhr.status );
            if (xhr.readyState === 4 && xhr.status === 200) {
                msgdiv.innerHTML = xhr.responseText;
            }
        };
        xhr.open("POST", "Stockupdate" + url_patten, true);
        xhr.send();
    } catch (error) {
        alert(error);
    }


}

function delete_product() {
    try {
        var xhr = new XMLHttpRequest();
        var pcode = document.getElementById("pcode").value;
        var msgdiv = document.getElementById("up_msg");
        if (pcode === "") {
            alert("Enter product code");
        }
        var url_patten = "?pcode=" + pcode;
        xhr.onreadystatechange = function () {
            //alert(xhr.readyState +" : "+xhr.status );
            if (xhr.readyState === 4 && xhr.status === 200) {
                msgdiv.innerHTML = xhr.responseText;
            }
        };
        xhr.open("POST", "delete_a_product" + url_patten, true);
        xhr.send();
    } catch (error) {
        alert(error);
    }

}

function update_Delivery() {
    try {
        var xhr = new XMLHttpRequest();
        var dcode = document.getElementById("dcode").value;
        var msgdiv = document.getElementById("up_msg");
        if (dcode === "") {
            alert("Enter invoice number");
        }
        var url_patten = "?dcode=" + dcode;
        xhr.onreadystatechange = function () {
            //alert(xhr.readyState +" : "+xhr.status );
            if (xhr.readyState === 4 && xhr.status === 200) {
                msgdiv.innerHTML = xhr.responseText;
            }
        };
        xhr.open("POST", "Update_delivery" + url_patten, true);
        xhr.send();
    } catch (error) {
        alert(error);
    }

}

/* end subcontent load */