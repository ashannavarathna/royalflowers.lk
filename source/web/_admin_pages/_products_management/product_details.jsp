<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%
    Session ses = conn.connector.getSessionFactory().openSession();
    Criteria cr = null;
%>
<div class="save-product-content">


    <form  method="POST" enctype="multipart/form-data" name="psave" id="pr_save_form" ">
        <!-- class="table-container-product-save" -->
        <table >
            <tr valign="top">
            <td>
                <table width="470" >
                    <!-- sub talbe mini 1-->
                    <tr>
                    <td>Product Name</td>
                    <td><input type="text" name="pname"/></td>
                    </tr>
                    <tr>
                    <tr>
                    <td>Product Code</td>
                    <td><input type="text" name="pcode"/></td>
                    </tr>
                    <tr>
                        <%
                            cr = ses.createCriteria(pojo.Catagory.class);
                            List<pojo.Catagory> catlist = cr.list();
                        %>
                    <tr>
                    <td>Product Category</td>
                    <td>
                        <select id="pcatid" name="mcatid" class="savepro-select" onchange="loadSubCategory('pcatid', 'pscatid')">
                            <%
                                for (pojo.Catagory clist : catlist) {
                            %>
                            <option value="<%=clist.getIdcatagory()%>"><%=clist.getCatagory()%></option>
                            <%
                                }
                                cr = null;
                                catlist = null;
                            %>
                        </select>
                    </td>
                    </tr>

                    <tr>
                    <td>Product Sub Category</td>
                    <td>
                        <select id="pscatid" name="subcatid" class="savepro-select">

                        </select>
                    </td>
                    </tr>
                    <tr>
                    <td>Product Brand</td>
                    <td>
                        <% cr = ses.createCriteria(pojo.Brand.class);
                            List<pojo.Brand> blist = cr.list();
                        %>
                        <select id="pbrandid" name="brandid" class="savepro-select">
                            <%
                                for (pojo.Brand brand : blist) {
                            %>
                            <option value="<%=brand.getIdbrand()%>"><%=brand.getBrandName()%></option>
                            <%
                                }
                                cr = null;
                                blist = null;

                            %>
                        </select>
                    </td>
                    </tr>
                    <tr>
                    <td>Product Color</td>
                    <td>
                        <%                            cr = ses.createCriteria(pojo.ProductColor.class);
                            List<pojo.ProductColor> pclist = cr.list();
                        %>
                        <select id="pcolorid" name="colorid" class="savepro-select">
                            <%
                                for (pojo.ProductColor pcolor : pclist) {
                            %>
                            <option value="<%=pcolor.getIdcolor()%>"><%=pcolor.getColor()%></option>
                            <%
                                }
                                cr = null;
                                blist = null;

                            %>
                        </select>
                    </td>
                    </tr>
                    <tr>
                    <td>Product Weight</td>
                    <td class="input_num_val">
                    <input  type="text"  placeholder="0" name="pweight" style="width: 100px;"/><span style="display: inline-block;padding: 3px 5px;border: 1px solid #CCC;margin-left: 10px;color: #666;">In Grams</span>
            </td>
            </tr>
            <tr>
            <td>Quantity</td>
            <td class="input_num_val"><input placeholder="0" type="text" name="pqty"><span style="display: inline-block;padding: 3px 5px;border: 1px solid #CCC;margin-left: 10px;color: #666;">(LKR)</span></td>
            </tr>
            <tr>
            <td>Re-oder Level </td>
            <td class="input_num_val"><input placeholder="0" type="text" name="prodrlv"><span style="display: inline-block;padding: 3px 5px;border: 1px solid #CCC;margin-left: 10px;color: #666;">(LKR)</span></td>
            </tr>
            <tr>
            <td>Price</td>
            <td class="input_num_val"><input placeholder="0.00" type="text" name="pprice"><span style="display: inline-block;padding: 3px 5px;border: 1px solid #CCC;margin-left: 10px;color: #666;">(LKR)</span></td>
            </tr>
            <tr>
            <td>Discount</td>
            <td class="input_num_val"><input placeholder="0.00" type="text" name="pdscnt"><span style="display: inline-block;padding: 3px 5px;border: 1px solid #CCC;margin-left: 10px;color: #666;">(LKR)</span></td>
            </tr>

            <!--tr style="display: none;">
            <td>Registry Date</td>
            <td colspan="3"><input type="text" name="prgstrydate" disabled></td>
            </tr-->
        </table>

        </td>
        <td>
            <table > 

                <tr>
                <td>
                    <table width="480">
                        <tr><td>Choose Images</td></tr>
                        <tr>
                        <td height="20" align="center" style="border: 1px dotted #CCC;background-color: #F7F7F7;">
                            <div><input type="file" name="img_1" id="fk1" style="float: right;margin-bottom: 3px;width: 470px;" ></div>
                        </td>

                        </tr>
                        <tr style="height:3px;"></tr>
                        <tr>
                        <td height="20" align="center" style="border: 1px dotted #CCC;background-color: #F7F7F7;">
                            <div><input type="file" name="img_2" style="float: right;margin-bottom: 3px;width: 470px;" ></div>
                        </td>
                        </tr>
                        <tr style="height:3px;"></tr>
                        <tr>
                        <td height="20" align="center" style="border: 1px dotted #CCC;background-color: #F7F7F7;">
                            <div><input type="file" name="img_3"  style="float: right;margin-bottom: 3px;width: 470px;" ></div>
                        </td>
                        </tr>
                    </table>
                </td>
                </tr>
                <tr>
                <td>
                    <table width="480">
                        <tr><td>
                            <div style="margin-bottom: 10px;">
                                <p>Description</p>
                                <textarea name="desc" style="width: 475px; height: 120px;border: 1px solid #CCC;"></textarea>
                            </div>
                            <div>
                                <input type="submit" value="save product" onclick="saveproduct()">
                            </div>
                        </td></tr>
                        <tr>
                        <td><div id="msgerr_d"></div></td>
                        </tr>
                    </table>
                </td>
                </tr>
            </table>
        </td>
        </tr>

        </table>
    </form>

</div>
