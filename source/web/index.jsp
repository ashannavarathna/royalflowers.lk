<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home | Royal Flowers </title>
        <link href="_css/_custome_002.css" type="text/css" rel="stylesheet">
        <link href="_css/lightslider.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" href="_css/bjqs.css">
        <link rel="stylesheet" href="_css/demo.css">

        <script type="text/javascript" src="_script/_js/_custome_01.js"></script>
        <script type = "text/javascript" src = "_script/jquery-1.7.2.min.js" charset = "utf-8" ></script>
        <script type="text/javascript" src="_script/jquery.cycle.all.js"></script>
        <script type="text/javascript" src="_script/lightslider.js"></script>
        <script src="_script/bjqs-1.3.min.js"></script>
        <script>
            /* use for main silder img cycle*/
            $(document).ready(function () {
                $("#right_silder").cycle({
                });
            });
            /*using for silde the contetn slider */
            $(document).ready(function () {
                $("#content-slider").lightSlider({
                    loop: true,
                    keyPress: true,
                    auto: true,
                    speed: 1000,
                });
            });
        </script>
        <script class="secret-source">
            jQuery(document).ready(function ($) {

                $('#banner-slide').bjqs({
                    animtype: 'slide',
                    animspeed: 4500,
                    animduration: 1500,
                    height: 360,
                    width: 740,
                    resposive: true,
                    randomstart: true

                });

            });
        </script>
        <style type="text/css">
            .sponsers{
                height: 130px;
                width: 1060px;
                /*border-top: 1px solid #777;*/
                /*border-bottom: 1px solid #777;*/
                padding: 10px;
                clear: left;
                margin: 0 auto;
                margin-bottom: 10px;
            }
            .content-slider ul{
                list-style: none outside none;
                padding-left: 0;
                margin: 0;
            }
            .demo .item{
                margin-bottom: 60px;
            }
            .content-slider li{
                /*background-color: #ed3020;*/
                text-align: center;
                color: #FFF;
                height: 320px;
                width: 700px;
            }
            .content-slider h3 {
                margin: 0;
                padding: 50px 0;
            }
            .demo{
                width: 1000px;
            }
        </style>
    </head>

    <body>

        <%@include file="_pages_container/top_header.jsp" %>
        <%@include file="_pages_container/_noscript.jsp"%>
        <div class="main-wrapper">
            <%@include file="_pages_container/navbar_top.jsp" %>
            <%@include file="_pages_container/main_slider.jsp" %>
            <!--div class="center_title_wrapper">
                <div class="center_title">
                    Best Products
                </div>
            </div-->
            <div class="center_prodbox_wrapper">
                <%                    //load products to index from db
                    //new classes.ad_exp();

                    DecimalFormat df = new DecimalFormat("0.00");
                    Session sesx = conn.connector.getSessionFactory().openSession();
                    Criteria crr = sesx.createCriteria(pojo.Product.class);
                    List<pojo.Product> plist = crr.list();

                    if (plist.size() == 0) {
                %>
                no products available

                <%
                    }
                    int listsize = plist.size();
                    int offsetcounter = 0;// the begin index for load product
                    if (listsize > 10) {
                        offsetcounter = listsize - 10;
                    }
                    String img_url = "";

                    pojo.Product product = null;
                    for (int i = offsetcounter; i < listsize; i++) {
                        product = plist.get(i);

                        pojo.PStatus pstate = product.getPStatus();
                        if (pstate.getIdpStatus() == 1) {
                            if (product.getImageUrl1() != null) {
                                img_url = "_images/product/category/products/" + product.getImageUrl1();
                            } else {
                                img_url = "_images/_site/null_img.png";
                            }

                %>
                <div class="center_prod_box_container">
                    <div class="prod_imgs">
                        <img src="<%=img_url%>"/>
                    </div>
                    <div class="prodbox-price-box">
                        <div class="prodbox-title"><%=product.getName()%></div>
                        <div class="prodbox-price"><label class="prodbox-price-tag"><span style="text-decoration-line: line-through;margin-left: 5px;color: #333; ">Rs <%=df.format(product.getPrice())%> </span> <span style="float: right">Rs <%=df.format(product.getPrice() - product.getDiscount())%></span> </label></div>
                    </div>
                    <div class="prodbox-info">
                        <a href="product_details.jsp?pcode=<%=product.getProductCode()%>" class="btn-buy">Details</a>
                        <span class="prodbox-details"><%=product.getBrand().getBrandName()%></span>

                    </div>
                </div> 

                <%

                        } else {
                            // if not availbe the product
                        }
                    }

                    sesx.close();

                %>


            </div>

        </div>

        <!--div class="sponsers">
            <div>
                <div class="item">
                    <ul id="content-slider" class="content-slider">
                        <li>
                            <h3>1</h3>
                        </li>
                        <li>
                            <h3>2</h3>
                        </li>
                        <li>
                            <h3>3</h3>
                        </li>
                        <li>
                            <h3>4</h3>
                        </li>
                        <li>
                            <h3>5</h3>
                        </li>
                        <li>
                            <h3>6</h3>
                        </li>
                    </ul>
                </div>
            </div>
        </div-->
        <%@include file="_pages_container/botom_footer.jsp" %>

    </body>

</html>
