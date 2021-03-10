<%-- 
    Document   : index
    Created on : Sep 13, 2015, 10:31:27 AM
    Author     : Ashna Nawarathna
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products | Green Wood Furniture</title>
        <link href="_css/_custome_002.css" type="text/css" rel="stylesheet">
        <link href="_css/_products_001.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="_script/_js/_custome_01.js"></script>
    </head>
    <body>
        <%@include file="_pages_container/top_header.jsp" %>
        <%@include file="_pages_container/_noscript.jsp"%>
        <div class="main-wrapper">
            <%@include file="_pages_container/navbar_top.jsp" %>
            <%                DecimalFormat df = new DecimalFormat("0.00");
                double total = 0;
                int total_item_count = 0;
                int quantity = 0;


            %>
            <div class="center_title_wrapper">
                <div class="center_title">
                    Your Basket
                </div>
            </div>
            <div class="shopping_cart_wrapper">
                <div class="cart_table">

                    <table >
                        <tr id="crt-tbl-headrw" >
                            <td >#</td>
                            <td id="crt-item-name" ></td>
                            <td >Price</td>
                            <td >Qty.</td>
                            <td >Total</td>
                        </tr>


                        <%                            HttpSession htps = request.getSession();
                            if (htps.getAttribute("s_cart") == null) {
                        %>
                        <tr>
                            <td></td>
                            <td>Your cart is Empty</td>
                            <td></td>
                            <td></td>
                            <td></td>

                        </tr>
                        <%
                        } else {

                            Session sescart = conn.connector.getSessionFactory().openSession();
                            pojo.Product prodcut = null;
                            String img_main_url = "";
                            List cart = (ArrayList) htps.getAttribute("s_cart");

                            total_item_count = cart.size();
                            for (int x = 0; x < cart.size(); x++) {
                                int[] pitem = (int[]) cart.get(x);
                                prodcut = (pojo.Product) sescart.load(pojo.Product.class, pitem[0]);
                                total += (prodcut.getPrice() - prodcut.getDiscount()) * pitem[1];
                                if (prodcut.getImageUrl1() != null) {
                                    img_main_url = "_images/product/category/products/" + prodcut.getImageUrl1();
                                } else {
                                    img_main_url = "_images/_site/null_img.png";
                                }

                        %>
                        <tr class="row-odd cont">

                            <td ><img src="<%=img_main_url%>" width="40" height="40"></td>
                            <td id="cart-pro-name"><%=prodcut.getName()%> <div class="cart-remove-bt"><a href="removeFromCart?pcode=<%=prodcut.getProductCode()%>">remove</a></div> </td>
                            <td ><%=df.format(prodcut.getPrice() - prodcut.getDiscount())%></td>

                            <td >
                                <form action="CartUpdate" method="GET">
                                    <input type="text" width="15px" name="uqty" value="<%=pitem[1]%>" style="width: 20px;height: 10px;" />
                                    <input type="hidden" name="pcode" value="<%=prodcut.getProductCode()%>">
                                    <input type="hidden" name="pid" value="<%=prodcut.getIdproduct()%>">
                                    <input type="submit" value="update"
                                           style="
                                           display: inline;
                                           background-color: #FFF;
                                           border: none;
                                           text-decoration: underline;
                                           cursor: pointer;
                                           color: #777;
                                           font-size: 11px;

                                           ">
                                </form>
                            </td>

                            <td ><%=df.format((prodcut.getPrice() - prodcut.getDiscount()) * pitem[1])%></td>
                        </tr>
                        <tr ><td colspan="5" class="crt-item-divider"></td></tr>
                            <%                                }
                                    sescart.close();
                                }
                            %>
                    </table>

                </div>
                <div>
                    <div style="font-size: 11px;color: red;">
                        <%
                            if (request.getParameter("err") != null) {
                                String errcode = request.getParameter("err");
                                if (errcode.equals("2201")) {
                                    out.write("Entered invalid quantity re enter the quantity");
                                } else if (errcode.equals("2202")) {
                                    out.write("The request product is not available right now try other one <br/> <a href='index.jsp'>click here</a>");
                                } else if (errcode.equals("2203")) {
                                    out.write("Minimum quantuty must be 1 ");
                                } else if (errcode.equals("2204")) {
                                    out.write("The request quantity is not available <br/>");
                                }
                            }
                        %>
                    </div>
                </div>    

                <div class="cart_payment_content"> 
                    <div class="c_payment_title"><div class="t-text">SUMMARY</div>
                    </div>
                    <div class="c_payment">
                        <span class="p_tag">Total</span>
                        <span class="p_total"><%=df.format(total)%></span>
                    </div>
                    <div class="c_payment">
                        <span class="p_tag" style="font-size: 13px;">Item Count</span>
                        <span class="p_total" style="color: #006600; font-size: 13px;"><%=total_item_count%></span>
                    </div>
                    <div class="checkout-btn"><a href="product_summery.jsp">check out</a></div><div class="checkout-btn wish"><a href="products.jsp">Continue Shopping</a></div>
                    <div class="payment_msg">Buy your products here. This item will be cleared when you close the browser</div>
                </div>
            </div>
        </div>
        <%@include file="_pages_container/botom_footer.jsp" %>


    </body>
</html>
