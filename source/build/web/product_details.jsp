<%-- 
    Document   : index
    Created on : Sep 13, 2015, 10:31:27 AM
    Author     : Ashna Nawarathna
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products | Green Wood Furniture</title>
        <link href="_css/_custome_002.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="_script/_js/_custome_01.js"></script>
        <script type = "text/javascript" src = "_script/jquery-1.7.2.min.js" charset = "utf-8" ></script>
        <script type="text/javascript" src="_script/jquery.easing.min.js"></script>
        <script type="text/javascript" src="_script/jquery.easy-ticker.js"></script>
        <script type="text/javascript">
            function photoChanger(img_id) {
                var main_img = document.getElementById("main_img");
                var sub_img = document.getElementById(img_id);
                //alert(main_img.src);
                main_img.src = sub_img.src;

            }

            /*add slidering*/
            $(document).ready(function () {
                var dd = $('.sun_ad_slider').easyTicker({
                    direction: 'up',
                    //easing: 'easeInOutBack',
                    speed: 'slow',
                    interval: 5000,
                    height: '465',
                    visible: 1,
                    mousePause: 0,
                }).data('easyTicker');

            });
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


            function put_likes(status, pid, user_id) {
                try {
                    getxmlhttp();
                    var save_enable = true;
                    if (user_id === "0") {
                        save_enable = false;
                    }
                    if (save_enable) {
                        var url_pattern = "?likestatusid=" + status + "&pid=" + pid + "&usr_id=" + user_id;
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                                if (xmlhttp.responseText.split("_")[0] === "1") {
                                    document.getElementById("likecdis").innerHTML = xmlhttp.responseText.split("_")[1].split(",")[0];
                                    document.getElementById("unlikecdis").innerHTML = xmlhttp.responseText.split("_")[1].split(",")[1];
                                } else {
                                    alert(xmlhttp.responseText.split("_")[1]);
                                }
                            }
                        };
                        xmlhttp.open("POST", "put_like" + url_pattern, true);
                        xmlhttp.send();
                    } else {
                        alert("To rate this product you must login");
                    }
                } catch (error) {
                    alert(error);
                }
            }


        </script>
        <style type="text/css">
            .sun_ad_slider ul{
                padding: 0;
            }
            #vlikebtn{
                cursor: pointer;
                display: inline-block;
                background-color: #4cae4c;
                color: #FFF;
                padding: 1px 5px;
                border-radius: 2px;
            }
            #vunlikebtn{
                cursor: pointer;
                display: inline-block;
                background-color: #dd3d08;
                color: #FFF;
                padding: 1px 5px;
                border-radius: 2px;
            }
            .votecounter{
                padding: 0 5px;
                border: 1px dotted #CCC;
                margin-left: 5px;
                color: #777;
                border-radius: 2px;
            }
        </style>
    </head>
    <body>
        <%@include file="_pages_container/top_header.jsp" %>
        <%@include file="_pages_container/_noscript.jsp"%>
        <div class="main-wrapper">
            <%@include file="_pages_container/navbar_top.jsp" %>
            <%                //varibales
                DecimalFormat df = new DecimalFormat("0.00");
                int pid = 0;
                int qty = 0;
                double price = 0;
                double discount = 0;
                double weihgt = 0;

                String pcode = "";
                String brand = "";
                String desc = "";
                String pcolor = "";
                String name = "";
                String img_1 = "";
                String img_2 = "";
                String img_3 = "";
                String img_main_url = "";

                int brandidprolaod = 0;

                //check if product availbe
                if (request.getParameter("pcode") == null || request.getParameter("pcode").length() == 0) {
                    //no product code has passed
                    response.sendRedirect("index.jsp");
                } else {
                    Session sespro = conn.connector.getSessionFactory().openSession();

                    Criteria pcr = sespro.createCriteria(pojo.Product.class);
                    pcr.add(Restrictions.eq("productCode", request.getParameter("pcode")));

                    pojo.Product product = (pojo.Product) pcr.uniqueResult();
                    brandidprolaod = product.getBrand().getIdbrand();

                    if (product == null) {
                        // no prodcut avlible for the code
                        response.sendRedirect("index.jsp");
                    } else {
                        // product is availbe
                        pid = product.getIdproduct();
                        name = product.getName();
                        qty = product.getQty();
                        price = product.getPrice();
                        discount = product.getDiscount();
                        pcode = product.getProductCode();
                        pcolor = product.getProductColor().getColor();
                        weihgt = product.getWeight();
                        desc = product.getDescription();
                        brand = product.getBrand().getBrandName();
                        //img ulrs seeting up
                        if (product.getImageUrl1() != null) {
                            img_1 = "_images/product/category/products/" + product.getImageUrl1();
                        } else {
                            img_1 = "_images/_site/null_img.png";
                        }
                        if (product.getImageUrl2() != null) {
                            img_2 = "_images/product/category/products/" + product.getImageUrl2();
                        } else {
                            img_2 = "_images/_site/null_img.png";
                        }
                        if (product.getImageUrl3() != null) {
                            img_3 = "_images/product/category/products/" + product.getImageUrl3();
                        } else {
                            img_3 = "_images/_site/null_img.png";
                        }

                        img_main_url = img_1;
                    }
                    sespro.close();
                }

            %>




            <!--div class="center_title_wrapper">
                <div class="center_title">
                    All Products
                </div>
            </div-->
            <div class="product_detail_wrapper">
                <div class="product_detail_container">
                    <div class="product_detail_img">
                        <div class="pro_big_img">
                            <img src="<%=img_main_url%>" id="main_img"/>


                        </div>
                        <div class="pro_mini_img">
                            <img src="<%=img_1%>" onclick="photoChanger('sub_img_1')" id="sub_img_1"/>
                            <img src="<%=img_2%>" onclick="photoChanger('sub_img_2')"  id="sub_img_2"/>
                            <img src="<%=img_3%>"  onclick="photoChanger('sub_img_3')" id="sub_img_3"/>
                        </div>

                    </div>
                    <div class="prodcut_detail_center">
                        <div class="pro-details-title"><%=name%></div>
                        <!--div class="pro-details-review">Reviews : 45</div-->
                        <div class="pro-details-status">Availability :
                            <%
                                if (qty > 0) {

                            %>
                            <span class="stock-status-msg-t">In Stock</span>
                            <%                            } else {
                            %>
                            <span class="stock-status-msg-f">Out Of Stock</span>
                            <%
                                }
                            %>

                        </div>
                        <form action="addtocart" method="post">
                            <input type="hidden" name="pid" value="<%=pid%>">
                            <input type="hidden" name="pcode" id="pcode" value="<%=pcode%>"/>
                            <input type="hidden" name="pqty" id="pqty" value="<%=qty%>"/>
                            <div class="pro-details-price-box">
                                <div class="pro-d-price">
                                    <input type="hidden" value="<%=df.format(price)%>" id="pprice" />
                                    <input type="hidden" value="<%=df.format(discount)%>" id="pdiscount" />
                                    Price :
                                    <%

                                        if (discount > 0) {
                                    %>
                                    <span class="pro-p-old" >Rs <%=df.format(price)%></span>
                                    <span class="pro-p-new" >Rs <%=df.format(price - discount)%></span>
                                    <%
                                    } else {

                                    %>
                                    <span class="pro-p-new" >Rs <%=df.format(price)%></span>
                                    <%                                        }

                                    %>

                                </div>

                                <div class="pro-qty">Quantity : <span class="pro-qty-dis"><input type="text" value="1"  onkeypress='return (event.charCode >= 48 && event.charCode <= 57) || event.charCode === 0' value="0"name="uqty" onkeyup="setQty()" id="uqty"></span> <!--span class="pro-qty-up"><img src="_images/_site/_arrows/arr_up.png"></span><span class="pro-qty-down"><img src="_images/_site/_arrows/arr_down.png"></span--></div>
                                <div id="qty_msg" style="color: red;font-size: 11px;padding: 0;margin-top: -10px;height: 10px; margin-bottom: 5px;"></div>
                                <div class="pro-amt-dis">
                                    <div class="pro-tot-amount" id="tot-amount">Total Amount : Rs <%=df.format(price - discount * 1)%> </div>
                                    <div class="pro-tot-saving" id="tot-saving">Total Saving : Rs  <%=df.format(discount * 1)%> </div>  
                                </div>
                                <!-- pass the submit type here-->
                                <div class="pro-chkout" id="btn-add-cart"><input type="submit" value="Add to Cart"><!--input type="submit" value="Buy Now"--></div>
                            </div>
                        </form>
                        <%
                            Session sesadrate = conn.connector.getSessionFactory().openSession();
                            pojo.Product product = (pojo.Product) sesadrate.load(pojo.Product.class, pid);

                            int usrid = 0;
                            pojo.User usrx = null;
                            if (request.getSession().getAttribute("user-id") != null) {
                                usrid = (Integer) request.getSession().getAttribute("user-id");
                                usrx = (pojo.User) sesadrate.load(pojo.User.class, usrid);
                            }

                            //getting buyied user count
                            Criteria buyercr = sesadrate.createCriteria(pojo.ProductRating.class);
                            buyercr.add(Restrictions.eq("product", product));

                            int buyercount = 0;
                            int purchasecount = 0;
                            List<pojo.ProductRating> prlist = buyercr.list();
                            for (pojo.ProductRating pr : prlist) {
                                if (pr.getBoughtCount() != null && pr.getBoughtCount() > 0) {
                                    purchasecount += pr.getBoughtCount();
                                    buyercount++;
                                }
                            }

                            //getting all purcase count
                            //create likes
                            pojo.PVotes votelike = (pojo.PVotes) sesadrate.load(pojo.PVotes.class, 1);
                            pojo.PVotes voteunlike = (pojo.PVotes) sesadrate.load(pojo.PVotes.class, 2);

                            //get like count
                            Criteria likescr = sesadrate.createCriteria(pojo.ProductRating.class);
                            likescr.add(Restrictions.eq("PVotes", votelike));
                            likescr.add(Restrictions.eq("product", product));
                            int likecount = likescr.list().size();
                            //get unlike count

                            Criteria unlikescr = sesadrate.createCriteria(pojo.ProductRating.class);
                            unlikescr.add(Restrictions.eq("PVotes", voteunlike));
                            unlikescr.add(Restrictions.eq("product", product));
                            int unlikecount = unlikescr.list().size();
                        %>
                        <div class="p_ratings" style="border: 1px solid #CCC; padding: 5px;">
                            <div style="font-size: 13px;border-bottom: 1px solid #CCC;width: 200px;margin-bottom: 5px;">This product Rating Level</div>
                            <div style="font-size: 12px;"><span style="width: 140px;display: inline-block;">buyers count</span><span style="width: 100px;display: inline-block;text-align: center;">0<%=buyercount%></span> </div>
                            <div style="font-size: 12px;"><span style="width: 140px;display: inline-block;">purchase count (qty)</span><span style="width: 100px;display: inline-block;text-align: center;">0<%=purchasecount%></span> </div>
                            <div style="font-size: 12px;margin-top: 5px;margin-bottom: 3px;"><span>voting </span></div>
                            <div style="font-size: 12px;"><span onclick="put_likes('1', '<%=pid%>', '<%=usrid%>')" id="vlikebtn" > like </span><span id="likecdis" class="votecounter"><%=likecount%></span> <span onclick="put_likes('2', '<%=pid%>', '<%=usrid%>')" id="vunlikebtn"> unlike</span> <span id="unlikecdis" class="votecounter"><%=unlikecount%></span></div>
                        </div>
                        <%sesadrate.close();%>
                        <div class="pro-details-sub-header">QUICK OVERVIEW</div>
                        <div class="pro-details-desc">
                            <%=desc%><br/><br/>
                            Weight : <%=weihgt + "g"%><br/>
                            Color  : <%=pcolor%> <br/>
                            Brand  : <%=brand%>
                        </div>

                    </div>
                    <div class="prodcut_detail_right">
                        <div class="crt_add_lnk">Advertising <a href="add_create.jsp">Create Ad</a></div>
                        <div class="sun_ad_slider">
                            <ul>
                                <%/*ad loading */

                                    Session sesadds = conn.connector.getSessionFactory().openSession();
                                    pojo.AdvertisingStatus adstatus = (pojo.AdvertisingStatus) sesadds.load(pojo.AdvertisingStatus.class, 1);
                                    pojo.AdvertisingLocation adloc = (pojo.AdvertisingLocation) sesadds.load(pojo.AdvertisingLocation.class, 2);
                                    Criteria crads = sesadds.createCriteria(pojo.Advertising.class);
                                    crads.add(Restrictions.eq("advertisingStatus", adstatus));
                                    crads.add(Restrictions.eq("advertisingLocation", adloc));

                                    List<pojo.Advertising> adlist = crads.list();
                                    if (adlist.size() == 0) {
                                %> 
                                <li>
                                    <div class="prd_adds">

                                        <img src="_images/_add/_sub_page/ad_default_sub.jpg" >
                                        <div class="prd_adds_title">Advertising plannig</div>
                                        <div class="prd_adds_lnk"><a href="#">www.royalfolwers.com</a></div>
                                        <div class="prd_adds_descc">reach out more customer with us</div> 
                                    </div>
                                </li>
                                <li>
                                    <div class="prd_adds">

                                        <img src="_images/_add/_sub_page/ad_default2_sub.jpg" >
                                        <div class="prd_adds_title">Adverting plannig</div>
                                        <div class="prd_adds_lnk"><a href="#">www.royalfolwers.com</a></div>
                                        <div class="prd_adds_descc">make your business wider </div> 
                                    </div>
                                </li>
                                <%
                                } else if (adlist.size() == 1) {
                                    pojo.Advertising ad = adlist.get(0);
                                %>
                                <li>
                                    <div class="prd_adds">

                                        <img src="_images/_add/_sub_page/<%=ad.getImgUrl()%>" >
                                        <div class="prd_adds_title"><%=ad.getAddTitle()%> </div>
                                        <div class="prd_adds_lnk"><a href="<%=ad.getWebsiteUrl()%>"><%=ad.getWebsiteUrl()%></a></div>
                                        <div class="prd_adds_descc"><%=ad.getDescription()%></div> 
                                    </div>
                                </li>
                                <li>
                                    <div class="prd_adds">

                                        <img src="_images/_add/_sub_page/ad_default_sub.jpg" >
                                        <div class="prd_adds_title">Adverting plannig</div>
                                        <div class="prd_adds_lnk"><a href="#">www.royalfolwers.com</a></div>
                                        <div class="prd_adds_descc">make your business wider</div> 
                                    </div>
                                </li>
                                <%
                                } else {

                                    for (pojo.Advertising ad : adlist) {
                                %>
                                <li>
                                    <div class="prd_adds">

                                        <img src="_images/_add/_sub_page/<%=ad.getImgUrl()%>" >
                                        <div class="prd_adds_title"><%=ad.getAddTitle()%> </div>
                                        <div class="prd_adds_lnk"><a href="<%=ad.getWebsiteUrl()%>"><%=ad.getWebsiteUrl()%></a></div>
                                        <div class="prd_adds_descc"><%=ad.getDescription()%></div> 
                                    </div>
                                </li>
                                <%
                                        }
                                    }
                                    sesadds.close();

                                %>
                            </ul>

                        </div>
                    </div>


                    <%                        if (request.getParameter("err") != null) {
                    %>
                    <div class="prodcut_detail_footer">
                        <div id="pdata-msg" style="color: red; font-size: 11px;padding: 5px;">
                            <%
                                String errcode = request.getParameter("err");
                                if (errcode.equals("2201")) {
                                    out.write("Entered invalid quantity re enter the quantity");
                                } else if (errcode.equals("2202")) {
                                    out.write("The request product is not available right now try other one <br/> <a href='index.jsp'>click here</a>");
                                } else if (errcode.equals("2203")) {
                                    out.write("Minimum quantuty must be 1 ");
                                } else if (errcode.equals("2204")) {
                                    out.write("The request quantity is not available <br/>");
                                    out.write("Available quantity is : " + qty);
                                }
                            %>

                        </div>
                    </div>

                    <%
                        }//30a7e14945b32d758a4d71593b6d34c4.jpg
%>
                </div>
                <div></div>
            </div>

        </div>
        <%@include file="_pages_container/botom_footer.jsp" %>


    </body>

    <script type="text/javascript">
        var quatity = document.getElementById("pqty");
        getCurrentQuantityFromDb();
        function setQty() {
            var qtyval = document.getElementById('uqty').value;
            getCurrentQuantityFromDb();
            if (qtyval === "") {
                document.getElementById("qty_msg").innerHTML = "quantity can not be empty";
                //document.getElementById('uqty').value = 1;
                document.getElementById('btn-add-cart').style = "pointer-events:none";
                document.getElementById("tot-amount").innerHTML = "Total Amount : Rs 00.0";
                document.getElementById("tot-saving").innerHTML = "Total Saving : Rs 00.0";
            } else {
                if (isNaN(qtyval)) {
                    document.getElementById("qty_msg").innerHTML = "invaild number format";
                    // document.getElementById('uqty').value = "";
                    document.getElementById('btn-add-cart').style = "pointer-events:none";
                    document.getElementById("tot-amount").innerHTML = "Total Amount : Rs 00.0";
                    document.getElementById("tot-saving").innerHTML = "Total Saving : Rs 00.0";
                } else {
                    if (qtyval <= 0) {
                        document.getElementById("qty_msg").innerHTML = "minimum qty is : 1";
                        //document.getElementById('uqty').value = 1;
                        document.getElementById('btn-add-cart').style = "pointer-events:none";
                        document.getElementById("tot-amount").innerHTML = "Total Amount : Rs 00.0";
                        document.getElementById("tot-saving").innerHTML = "Total Saving : Rs 00.0";

                    } else if (Number(qtyval) > Number(this.quatity)) {

                        document.getElementById("qty_msg").innerHTML = "Request quantity not available. Currently Available : " + quatity;
                        document.getElementById('btn-add-cart').style = "pointer-events:none";
                        // document.getElementById('uqty').value = 15;
                        document.getElementById("tot-amount").innerHTML = "Total Amount : Rs 00.0";
                        document.getElementById("tot-saving").innerHTML = "Total Saving : Rs 00.0";

                    } else {
                        var price = document.getElementById("pprice").value;
                        var pdcnt = document.getElementById("pdiscount").value;

                        document.getElementById("tot-amount").innerHTML = "Total Amount : Rs " + (price - pdcnt) * qtyval;
                        document.getElementById("tot-saving").innerHTML = "Total Saving : Rs " + pdcnt * qtyval;
                        document.getElementById("qty_msg").innerHTML = "";
                        document.getElementById('btn-add-cart').style = "pointer-events:click";
                    }
                }
            }
        }

        function getCurrentQuantityFromDb() {
            getxmlhttp();
            var pcode = document.getElementById('pcode').value;
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    quatity = xmlhttp.responseText;
                }
            };
            xmlhttp.open("POST", "getCurrentQuantity?pcode=" + pcode, true);
            xmlhttp.send();


        }


    </script>
</html>
