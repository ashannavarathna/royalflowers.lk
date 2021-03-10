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
        <link href="_css/_wishlist.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="_script/_js/_custome_01.js"></script>
        <script type = "text/javascript" src = "_script/jquery-1.7.2.min.js" charset = "utf-8" ></script>
        <script type="text/javascript" src="_script/jquery.cycle.all.js"></script>
    </head>
    <body>
        <%@include file="_pages_container/top_header.jsp" %>
        <%@include file="_pages_container/_noscript.jsp"%>
        <div class="main-wrapper">
            <%@include file="_pages_container/navbar_top.jsp" %>

            <div class="center_title_wrapper">
                <div class="center_title">
                    WishList | Save Your Products and Buy Tomorrow
                </div>
            </div>
            <div class="shopping_cart_wrapper">
                <div class="cart_table">
                    <div class="cart_table_head">
                        <table class="t-head">
                            <tr >
                                <td class="h-hash">#</td>
                                <td class="h-desc">Description</td>
                                <td class="h-prc">Price</td>
                                <td class="h-qty">Qty.</td>
                                <td class="h-tot">Total</td>
                                <td class="h-mng">Wishlist</td>
                            </tr>
                            <%

                                for (int i = 0; i < 3; i++) {

                                    if (i % 2 != 0) {


                            %>
                            <tr class="row-odd cont">
                                <td class="c-img "><img src="_images/produt/latest_products/_home_view/2.jpg" width="40" height="40"></td>
                                <td class="c-desc ">sofa rt5758895 x_sdjjd </td>
                                <td class="c-prc cnt">15000</td>
                                <td class="c-qty "><input type="text" width="15px" value="1" disabled></td>
                                <td class="c-tot cnt">15000</td>
                                <td class="c-mng "><span class="spn">add to cart</span></td>
                            </tr>
                            <%                                    } else {
                            %>
                            <tr class="row-even cont">
                                <td class="c-img "><img src="_images/produt/latest_products/_home_view/3.jpg" width="40" height="40"></td>
                                <td class="c-desc ">sofa rt5758895 x_sdjjd </td>
                                <td class="c-prc cnt">15000</td>
                                <td class="c-qty "><input type="text" width="20px" value="1" disabled></td>
                                <td class="c-tot cnt">15000</td>
                                <td class="c-mng "><span class="spn">add to cart</span></td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </table>
                    </div> 
                </div>
            </div>
        </div>
        <%@include file="_pages_container/botom_footer.jsp" %>


    </body>
</html>
