/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// varibel and method to get xmlhttp
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

/* function for save category*/

function save_category() {
    getxmlhttp();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            document.getElementById("save_msg").innerHTML = "<p>" + xmlhttp.responseText + "</p>";

        }
    };

    var name = document.getElementById("c_name").value;
    xmlhttp.open("POST", "save_categroy_1?c_name=" + name, true);
    xmlhttp.send();
}
/* end of category save funtion*/


/* cutomizing top naivagtion*/
function pageNavigator(pagenumber) {
    var pages = ['index-pg', 'product-pg', 'cart-pg', 'delivery-pg', 'contact-pg'];
    var listnum = ['ls1', 'ls2', 'ls3', 'ls5', 'ls6'];
    document.getElementById(pages[pagenumber]).className = "_active ";
    document.getElementById(listnum[pagenumber]).className = "_active ";
    for (var i = 0; i < pages.length; i++) {
        if (i !== pagenumber) {
            document.getElementById(pages[i]).className = "_inacitve";
            document.getElementById(listnum[i]).className = "_inactive ";
        }
    }

}

function checkNameValidation(name) {
    var value_match = false;
    var uname = name;
    var spchar = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', "-", '=', '+', ';', ':', '"', "'", '?', '/', '|', "\\", '{', '}', '[', ']', ',', '.', '<', '>', '`', '~'];
    for (var i = 0; i < spchar.length; i++) {
        for (var j = 0; j < uname.length; j++) {
            if (spchar[i] === uname[j] | uname.length < 2 | uname.length > 35) {
                value_match = true;
                return true;
            } else {
                value_match = false;
            }
        }
    }
    return false;
}



function signup_validation() {
    //use to verify that all varible are ok
    var flag_form_validator = false, flag_nullcheck = false, flag_fname = false, flag_lname = false, flag_email = false, flag_passn = false, flag_passc = false, flag_country = false;
    //geting data from field
    var fname = document.getElementById("signup_fname").value;
    var lname = document.getElementById("signup_lname").value;
    var email = document.getElementById("signup_email").value;
    var pswn = document.getElementById("signup_nwpsw").value;
    var pswc = document.getElementById("signup_cnfrmpsw").value;
    var country = document.getElementById("signup_country");
    var cntry = country.options[country.selectedIndex].value;

    //genarating loops for valid all passing fileds 
    var datalist = [fname, lname, email, pswn, pswc, cntry];
    //checing if nay field is empty
    for (var i = 0; i < datalist.length; i++) {
        if (datalist[i] !== "") {
            applyErrFormFieldBorder(i, false);
            setErrMsgVisibel(false, i, null);
            flag_nullcheck = true;
        } else {
            applyErrFormFieldBorder(i, true);
            setErrMsgVisibel(true, i, "This field is required");
            flag_nullcheck = false;
        }
    }

    //validation user name and email
    if (fname === "") {
        setErrContainerVisible(true, 0);
        flag_fname = false;

    } else {
        if (checkNameValidation(fname)) {
            flag_fname = false;
            applyErrFormFieldBorder(0, true);
            setErrMsgVisibel(true, 0, "This name is not valid");
        } else {
            flag_fname = true;
            applyErrFormFieldBorder(0, false);
            setErrMsgVisibel(false, 0, null);
        }
    }

    if (lname === "") {
        setErrContainerVisible(true, 0);
        flag_lname = false;
    } else {
        if (checkNameValidation(lname)) {
            flag_lname = true;
            applyErrFormFieldBorder(1, true);
            setErrMsgVisibel(true, 1, "This name is not valid");
        } else {
            flag_lname = false;
            applyErrFormFieldBorder(1, false);
            setErrMsgVisibel(false, 1, null);
        }
    }
    if (fname !== "" && lname !== "") {
        setErrContainerVisible(false, 0);
        flag_fname = true;
        flag_lname = true;
        if (checkNameValidation(fname) || checkNameValidation(lname)) {
            setErrContainerVisible(true, 0);
        }
    }



    //validation email
    if (email === "") {
        setErrContainerVisible(true, 1);
        flag_email = false;
    } else {
        setErrContainerVisible(false, 1);
        flag_email = true;
        //var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;     
        //var filter = /^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i;
        if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/).test(email)) {
            setErrContainerVisible(true, 1);
            setErrMsgVisibel(true, 2, "invalid email address");
            applyErrFormFieldBorder(2, true);
            flag_email = false;

        } else {
            setErrContainerVisible(false, 1);
            setErrMsgVisibel(false, 2, null);
            applyErrFormFieldBorder(2, false);
            flag_email = true;
        }
    }
    //validation password new password
    if (pswn === "") {
        setErrContainerVisible(true, 2);
        flag_passn = false;
    } else {
        setErrContainerVisible(false, 2);
        flag_passc = true;
        //checking for if password lenght ok
        if (pswn.length < 6) {
            setErrContainerVisible(true, 2);
            setErrMsgVisibel(true, 3, "minmun 6 caharate");
            applyErrFormFieldBorder(3, true);
            flag_passn = false;
        } else {
            setErrContainerVisible(false, 2);
            setErrMsgVisibel(false, 3, null);
            applyErrFormFieldBorder(3, false);
            flag_passn = true;
        }
    }

//validation password confirm password
    if (pswc === "") {
        setErrContainerVisible(true, 3);
        flag_passc = false;
    } else {
        setErrContainerVisible(false, 3);
        flag_passc = true;
        //check for password matching
        if (pswn === pswc) {
            setErrContainerVisible(false, 3);
            setErrMsgVisibel(false, 4, null);
            applyErrFormFieldBorder(4, false);
            flag_passc = true;
        } else {
            setErrContainerVisible(true, 3);
            setErrMsgVisibel(true, 4, "password not match");
            applyErrFormFieldBorder(4, true);
            flag_passc = false;
        }
    }
    //checing for if countoty isseleted
    if (cntry === "") {
        setErrContainerVisible(true, 4);
        setErrMsgVisibel(true, 5, "select your country");
        applyErrFormFieldBorder(5, true);
        flag_country = false;
    } else {
        setErrContainerVisible(false, 4);
        setErrMsgVisibel(false, 5, null);
        applyErrFormFieldBorder(5, false);
        flag_country = true;
    }

    if (flag_nullcheck && flag_fname && flag_lname && flag_email && flag_passn && flag_passc && flag_country) {
        flag_form_validator = true;
        return  true;
    } else {
        flag_form_validator = false;
        return false;
    }
}
function  setErrContainerVisible(booleanVal, indexNum) {
    //seting up class invalidation or validation filed container
    var errTextidlist = ["err_input_cont_name", "err_input_cont_email", "err_input_cont_npass", "err_input_cont_cpass", "err_input_cont_contry"];
    if (booleanVal) {
        document.getElementById(errTextidlist[indexNum]).removeAttribute("class");
        document.getElementById(errTextidlist[indexNum]).setAttribute("class", "err-text err_visible");
    } else {
        document.getElementById(errTextidlist[indexNum]).removeAttribute("class");
        document.getElementById(errTextidlist[indexNum]).setAttribute("class", "err-text err_hidden");
    }
}
function setErrMsgVisibel(booleanVal, indexNum, errMsg) {
    //seting up class invalidation or validation filed and the msg
    var errtextfiledid = ["err_fname", "err_lname", "err_email", "err_nwpass", "err_crnpass", "err_contry"];
    if (booleanVal) {
        document.getElementById(errtextfiledid[indexNum]).removeAttribute("class");
        document.getElementById(errtextfiledid[indexNum]).setAttribute("class", "invalid_input err_visible");
        document.getElementById(errtextfiledid[indexNum]).innerHTML = errMsg;
    } else {
        document.getElementById(errtextfiledid[indexNum]).removeAttribute("class");
        document.getElementById(errtextfiledid[indexNum]).setAttribute("class", "invalid_input err_hidden");
    }
}

function applyErrFormFieldBorder(indexNum, booleanval) {
    //chaign the border if input field is invalid
    var formfieldids = ["signup_fname", "signup_lname", "signup_email", "signup_nwpsw", "signup_cnfrmpsw", "signup_country"];
    if (booleanval) {
        document.getElementById(formfieldids[indexNum]).style.border = "1px dotted red";
    } else {
        document.getElementById(formfieldids[indexNum]).style.border = "1px solid #CCC";
    }
}


function saveNewUser_Buyer() {
    getxmlhttp();
    if (signup_validation()) {
        //getvalues
        var fname = document.getElementById("signup_fname").value;
        var lname = document.getElementById("signup_lname").value;
        var email = document.getElementById("signup_email").value;
        var pswn = document.getElementById("signup_nwpsw").value;
        var pswc = document.getElementById("signup_cnfrmpsw").value;
        var country = document.getElementById("signup_country");
        var cntry = country.options[country.selectedIndex].value;
        document.getElementById('signup_msg_dis').innerHTML = "please wait... ";
        document.getElementById('signup_msg_dis').style.color = "black";
        document.getElementById("sun_saveu").style.pointerEvents = "none";
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                var msgObject = document.getElementById('signup_msg_dis');
                document.getElementById("sun_saveu").style.pointerEvents = "auto";
                var serverMSG = xmlhttp.responseText.split("_");
                //alert(xmlhttp.responseText);
                if (serverMSG[0] === '1') {
                    msgObject.style.color = "green";
                    msgObject.innerHTML = "server repiled : save success <br/> <span style='color=#333;font-size:12px;'> please login to your acount";
                } else {
                    msgObject.style.color = "red";
                    msgObject.innerHTML = "server replied : " + serverMSG[1];


                }
                msgObject.style.visibility = "visible";


            }
        };
        xmlhttp.open("POST", "user_registration?pptap_isrex_=ixtrr345vc&f_name=" + fname + "&l_name=" + lname + "&e_mail=" + email + "&n_pass=" + pswn + "&c_pass=" + pswc + "&country=" + cntry, true);
        xmlhttp.send();
    } else {
        document.getElementById('signup_msg_dis').style.visibility = 'hidden';
    }
}

/* updating deliveries */

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

/*        end          */


