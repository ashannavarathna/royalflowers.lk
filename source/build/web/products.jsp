<%@page import="java.text.DecimalFormat"%>
<%@page import="org.hibernate.criterion.MatchMode"%>
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
    <body onload="loadSubCategory('pcatid', 'pscatid')">
        <%@include file="_pages_container/top_header.jsp" %>
        <%@include file="_pages_container/_noscript.jsp"%>
        <div class="main-wrapper">
            <%@include file="_pages_container/navbar_top.jsp" %>

            <div class="center_title_wrapper">
                <div class="center_title">
                    Search Products
                </div>

            </div>
            <div class="products_wrapper">
                <div class="products_left_nav">
                    <div id="p_n_head"> Custom Search</div>
                    <form action="products.jsp" method="POST">
                        <%                           
                        DecimalFormat df = new DecimalFormat("0.00");
                        Session sesxrtp = conn.connector.getSessionFactory().openSession();
                            Criteria crxxtp = null;
                            crxxtp = sesxrtp.createCriteria(pojo.Catagory.class);
                            List<pojo.Catagory> catlist = crxxtp.list();
                        %>
                        <label>Select Main Category</label>
                        <select id="pcatid" name="vl7" class="savepro-select" onchange="loadSubCategory('pcatid', 'pscatid')">
                            <option value="">--select--</option>
                            <%
                                for (pojo.Catagory clist : catlist) {
                            %>
                            <option value="<%=clist.getIdcatagory()%>"><%=clist.getCatagory()%></option>
                            <%
                                }
                                crxxtp = null;
                                catlist = null;
                            %>
                        </select><br/>
                        <label>Select Sub Category</label>
                        <select id="pscatid" name="vl6" class="savepro-select">

                        </select><br/>
                        <% crxxtp = sesxrtp.createCriteria(pojo.Brand.class);
                            List<pojo.Brand> blist = crxxtp.list();
                        %>

                        <label>Select Brands</label>
                        <select id="pbrandid" name="vl5" class="savepro-select">
                            <option value="">--select--</option>
                            <%
                                for (pojo.Brand brand : blist) {
                            %>
                            <option value="<%=brand.getIdbrand()%>"><%=brand.getBrandName()%></option>
                            <%
                                }
                                crxxtp = null;
                                blist = null;

                            %>
                            <%                            crxxtp = sesxrtp.createCriteria(pojo.ProductColor.class);
                                List<pojo.ProductColor> pclist = crxxtp.list();
                            %>
                        </select><br/>
                        <label>Select Colors</label>
                        <select id="pcolorid" name="vl4" class="savepro-select">
                            <option value="">--select--</option>
                            <%
                                for (pojo.ProductColor pcolor : pclist) {
                            %>
                            <option value="<%=pcolor.getIdcolor()%>"><%=pcolor.getColor()%></option>
                            <%

                                }

                                crxxtp = null;
                                blist = null;

                            %>
                        </select><br/>
                        <label>Select Price Range</label>
                        <select name="vl3">
                            <option value="">--select--</option>
                            <option value="0_1000">0-1000 (LKR)</option>
                            <option value="1000_1850">1000-1850(LKR)</option>
                            <option value="1850_2600">1850-2600(LKR)</option>
                            <option value="2600_5000">2600-5000(LKR)</option>
                            <option value="5000_15000">5000-UP (LKR)</option>
                        </select><br/>

                        <input type="submit" value="search">
                    </form>


                </div>
                <div class="products_center_container">


                    <div class="center_prodbox_wrapper" style="width: 600px;">
                        <!-- loooooooooooo ding profutsa-->

                        <%//load products to index from db
                                /* 8parameterss
                             * by id
                             * by name
                             * by price
                             * by color
                             * by brand
                             * by sub cat
                             * by main cat
                             */
                            boolean bid = false;
                            boolean bname = false;
                            boolean bprice = false;
                            boolean bcolor = false;
                            boolean bbrand = false;
                            boolean bscat = false;
                            boolean bmcat = false;

                            String vl1 = "";
                            String vl2 = "";
                            String vl3 = "";
                            String vl4 = "";
                            String vl5 = "";
                            String vl6 = "";
                            String vl7 = "";

                            String uripattern = "";

                            Session sesx200 = conn.connector.getSessionFactory().openSession();
                            Criteria crrx11 = sesx200.createCriteria(pojo.Product.class);

                            //loading types
                            boolean loadtype[] = new boolean[]{bid, bname, bprice, bcolor, bbrand, bscat, bmcat};

                            if (request.getParameter("vl1") == null || request.getParameter("vl1").isEmpty()) {
                                bid = false;
                            } else {
                                bid = true;
                                crrx11.add(Restrictions.eq("idproduct", Integer.parseInt(request.getParameter("vl1"))));
                                vl1 = request.getParameter("vl1");

                            }

                            if (request.getParameter("vl2") == null || request.getParameter("vl2").isEmpty()) {
                                bname = false;
                            } else {
                                bname = true;
                                crrx11.add(Restrictions.like("name", request.getParameter("vl2"), MatchMode.ANYWHERE));
                                vl2 = request.getParameter("vl2");
                            }

                            if (request.getParameter("vl3") == null || request.getParameter("vl3").isEmpty()) {
                                bprice = false;
                            } else {
                                bprice = true;
                                String pcode = request.getParameter("vl3");
                                crrx11.add(Restrictions.between("price", Double.parseDouble(pcode.split("_")[0]), Double.parseDouble(pcode.split("_")[1])));
                                vl3 = request.getParameter("vl3");

                            }

                            if (request.getParameter("vl4") == null || request.getParameter("vl4").isEmpty()) {
                                bcolor = false;
                            } else {
                                bcolor = true;
                                int colorid = Integer.parseInt(request.getParameter("vl4"));
                                pojo.ProductColor pcolor = (pojo.ProductColor) sesx200.load(pojo.ProductColor.class, colorid);
                                crrx11.add(Restrictions.eq("productColor", pcolor));
                                vl4 = request.getParameter("vl4");
                            }

                            if (request.getParameter("vl5") == null || request.getParameter("vl5").isEmpty()) {
                                bbrand = false;
                            } else {
                                bbrand = true;
                                int brandid = Integer.parseInt(request.getParameter("vl5"));
                                pojo.Brand pbrand = (pojo.Brand) sesx200.load(pojo.Brand.class, brandid);
                                crrx11.add(Restrictions.eq("brand", pbrand));
                                vl5 = request.getParameter("vl5");
                            }
                            if (request.getParameter("vl6") == null || request.getParameter("vl6").isEmpty()) {
                                bscat = false;
                            } else {
                                bscat = true;
                                int subtcatid = Integer.parseInt(request.getParameter("vl6"));
                                pojo.SubCategory subcat = (pojo.SubCategory) sesx200.load(pojo.SubCategory.class, subtcatid);
                                crrx11.add(Restrictions.eq("subCategory", subcat));
                                vl6 = request.getParameter("vl6");

                            }
//                            if (request.getParameter("vl7") == null || request.getParameter("vl7").isEmpty()) {
//                                bmcat = false;
//                            } else {
//                                bmcat = true;
//                                 int mcatid = Integer.parseInt(request.getParameter("vl7"));
//                                pojo.Catagory mcat = (pojo.Catagory) sesx.load(pojo.Catagory.class, mcatid);
//                                //crr.add(Restrictions.eq("subCategory", subcat));
//                                vl7 = request.getParameter("vl7");
//                            }

                            pojo.PStatus pstate = (pojo.PStatus) sesx200.load(pojo.PStatus.class, 1);
                            crrx11.add(Restrictions.eq("PStatus", pstate));

                            uripattern = "&vl1=" + vl1 + "&vl2=" + vl2 + "&vl3=" + vl3 + "&vl4=" + vl4 + "&vl5=" + vl5 + "&vl6=" + vl6 + "&vl7=" + vl7;

                            List<pojo.Product> plist = crrx11.list();

                            if (plist.size() == 0) {
                        %>
                        <div style="margin-left:10px;padding: 10px;font-size: 14px; ">
                            No match result found. Change your pattern and try again
                        </div>

                        <%
                        } else {

                            int listsize = plist.size();
                            int offsetcounter = 0;// the begin index for load

                            //pagination
                            int item_per_page = 3;
                            int fst_rslt = 0;
                            int pgxid = 0;
                            if (request.getParameter("pgxid") != null && !request.getParameter("pgxid").isEmpty()) {
                                pgxid = Integer.parseInt(request.getParameter("pgxid"));
                                fst_rslt = pgxid * item_per_page;
                            } else {
                                fst_rslt = 0;
                            }

                            int count = listsize / item_per_page;
                            if (listsize % item_per_page == 0) {
                                count = count - 1;
                            }

                            crrx11.setFirstResult(fst_rslt);
                            crrx11.setMaxResults(item_per_page);

                            List<pojo.Product> plxlist = crrx11.list();
                            String img_url = "";
                            for (pojo.Product product : plxlist) {
                                if (product.getImageUrl1() != null) {
                                    img_url = "_images/product/category/products/" + product.getImageUrl1();
                                } else {
                                    img_url = "_images/_site/null_img.png";
                                }

                        %>
                        <div class="center_prod_box_container">
                            <div class="prod_imgs">
                                <img src="<%=img_url%>" />
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

                            }

                            sesx200.close();

                        %>



                    </div>
                    <div style="clear: both;padding: 10px;">

                        <%  /*setting up pagination*/
                                if (pgxid > 0) {
                                    out.write("<a href='products.jsp?pgxid=" + (pgxid - 1) + "&" + uripattern + "' class='pg-btx' style='text-decoration:none;color:#777;font-size:16px;display:inline-block;padding:5px;border:1px solid #CCC;width:60px;text-align:center;margin-left:2px;'> Back </a>");
                                }
                                for (int px = 0; px <= count; px++) {
                                    if (px == pgxid) {
                                        //highlihgt current page
                                        out.write("<a href='products.jsp?pgxid=" + px + "&" + uripattern + "' class='pg-btx current' style='text-decoration:none;color:#777;font-size:16px;display:inline-block;padding:5px;border:1px solid #CCC;width:25px;text-align:center;margin-left:2px;'> " + (px + 1) + " </a>");
                                    } else {
                                        out.write("<a href='products.jsp?pgxid=" + px + "&" + uripattern + "' class='pg-btx ' style='text-decoration:none;color:#777;font-size:16px;display:inline-block;padding:5px;border:1px solid #CCC;width:25px;text-align:center;margin-left:2px;'> " + (px + 1) + " </a>");
                                    }
                                }
                                if (pgxid < count) {
                                    out.write("<a href='products.jsp?pgxid=" + (pgxid + 1) + "&" + uripattern + "' class='pg-btx' style='text-decoration:none;color:#777;font-size:16px;display:inline-block;padding:5px;border:1px solid #CCC;width:60px;text-align:center;margin-left:2px;'> Next </a>");
                                }

                            }


                        %>
                        <style>
                            .pg-btx:hover{
                                background-color: #CCC;
                                cursor: pointer;

                            }
                            .current{
                                background-color: #CCC;
                                
                            }
                        </style>
                    </div>

                </div>
            </div>


        </div>
        <%@include file="_pages_container/botom_footer.jsp" %>


    </body>

    <script type="text/javascript">
        function loadSubCategory(slmc, slsc) {
            var maincat_id = document.getElementById(slmc).value;
            getxmlhttp();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    // alert(xmlhttp.responseText);
                    document.getElementById(slsc).innerHTML = "";
                    var subcats = xmlhttp.responseText.split(",");
                    document.getElementById(slsc).innerHTML = "<option value=''> --select--</option>";
                    for (var j = 0; j < subcats.length; j++) {
                        document.getElementById(slsc).innerHTML += "<option value=" + subcats[j].split(":")[0] + ">" + subcats[j].split(":")[1] + "</option>";
                    }
                }
            };
            var catval = document.getElementById(slmc).value;
            if (Number(catval) === Number(0)) {
                document.getElementById(slsc).innerHTML = "<option value=''> --select--</option>";
            } else {
                // alert(maincat_id);
                xmlhttp.open("POST", "Load_sub_category?pgx_vld=ldcat14525subpgx&mcat_id=" + maincat_id, true);
                xmlhttp.send();

            }


        }
    </script>
</html>
