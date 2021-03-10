<%@page import="java.text.DecimalFormat"%>
<%@page import="groovy.mock.interceptor.Demand"%>
<%@page import="org.hibernate.criterion.MatchMode"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%Session sesloadtypeadmin = conn.connector.getSessionFactory().openSession();%>
<div style="width:980px;">
    <div class="c_col">
        update Stock
        <div class="b_field">
            <label>Product Code</label>
            <input type="text" name="pcode" id="pcode">
        </div>
        <div class="b_field">
            <label>Price</label>
            <input type="text" name="price" id="price">
        </div>
        <div class="b_field">
            <label>Discount</label>
            <input type="text" name="dsnt" id="dsnt">
        </div>
        <div class="b_field">
            <label>Quantity</label>
            <input type="text" name="qty" id="qty">
        </div>
        <input type="submit" value="Update" id="b_field_submit_upstate"  onclick="update_stock_vls()">
        <input type="submit" value="Remove" id="b_field_submit_upstate" onclick="delete_product()">
        <div id="up_msg" class="r_msg"></div>
        <!--
        update product details
        <div class="b_field">
            <label>Product Code</label>
            <input type="email" name="upemail" id="upusemail">
        </div>
        <div class="b_field">
            <label>Product Code</label>
            <input type="email" name="upemail" id="upusemail">
        </div>

        <input type="submit" value="update" id="b_field_submit_upstate" >
        <div id="msg_state" class="r_msg"></div>
        -->
    </div>

    <div class="admin_sub_content">
        Search for products
        <div class="a_field">
            <label>Product Name</label>
            <input type="text" name="vl1" id="vl1">
            <input type="submit" value="search" id="a_field_submit" onclick="document.getElementById('st_view').click();">
        </div>

        <div class="b_col">
            <table>
                <tr>
                <th>P Name</th>
                <th>P code</th>
                <th>Price</th>
                <th>Discount</th>
                <th>Quantity</th>
                <!--th>#</th-->
                </tr>

                <%  //comment              
                    Criteria cruserlist = sesloadtypeadmin.createCriteria(pojo.Product.class);
                    if (request.getParameter("vl1") != null && !request.getParameter("vl1").isEmpty()) {
                        cruserlist.add(Restrictions.like("name", request.getParameter("vl1"), MatchMode.ANYWHERE));
                    }
                    DecimalFormat df = new DecimalFormat("0.00");
                    List<pojo.Product> prolist = cruserlist.list();

                    for (pojo.Product prodcut : prolist) {
                        pojo.PStatus pstate = prodcut.getPStatus();
                        if (pstate.getIdpStatus() == 1) {
                            out.write("<tr>");
                            out.write("<td>" + prodcut.getName() + "</td>");
                            out.write("<td>" + prodcut.getProductCode() + "</td>");
                            out.write("<td style='text-align:right;'>" + df.format(prodcut.getPrice()) + "</td>");
                            out.write("<td style='text-align:right;'>" + df.format(prodcut.getDiscount()) + "</td>");
                            out.write("<td style='text-align:center;'>" + prodcut.getQty() + "</td>");
                            out.write("</tr>");
                        }
                    }

                    sesloadtypeadmin.close();
                %>
            </table>


        </div>



    </div>

    <style>
        .admin_sub_content{
            width: 550px;
            min-height: 300px;
            padding: 10px;
            border: 1px dotted #CCC;

        }
        .a_field{
            width: 530px;
            padding: 5px;
        }
        .a_field label{
            display: inline-block;
            width: 120px;
            //border: 1px solid #CCC;
            padding: 3px 5px;
        }
        .a_field input[type=text],.a_field input[type=email]{
            display: inline-block;
            width: 260px;
            padding: 5px 5px;
            border: 1px solid #CCC;
        }
        .a_field select{
            width: 150px;
            padding: 2px;
            border: 1px solid #CCC;
        }
        .a_field select option{
            width: 140px;
            padding: 3px;
        }

        #a_field_submit{
            padding: 3px 5px;
            width: 107px;
        }
        .b_col{
            padding: 10px;
            width: 540px;
            /*border: 1px solid #CCC;*/
            height: 270px;
            overflow: auto;
        }
        .b_col table{
            width: 540px;
            //border: 1px solid #CCC;
        }

        .b_col table th{
            text-align: left;
            border: 1px solid #777;
            padding-left: 3px;
        }
        .b_col table td{

            padding-left: 3px;
        }
        .c_col{
            min-height: 200px;
            width: 380px;
            min-width: 200px;
            border: 1px dotted #CCC;
            float: right;
            padding: 10px;
        }
        .b_field{
            width: 330px;
            padding: 5px;
        }
        .b_field label{
            display: block;
            width: 120px;
            //border: 1px solid #CCC;
            padding: 3px 5px;
        }
        .b_field input[type=text],.b_field input[type=email]{
            display: inline-block;
            width: 260px;
            padding: 5px 5px;
            border: 1px solid #CCC;
        }
        .b_field select{
            width: 200px;
            padding: 2px;
            border: 1px solid #CCC;
        }
        .b_field select option{
            width: 180px;
            padding: 3px;
        }
        #b_field_submit_uptype, #b_field_submit_upstate{
            padding: 3px 5px;
            width: 107px;
            margin-left: 5px;
        }

        .r_msg{
            color: #985f0d;
            font-size: 11px;
            margin-left: 10px;
        }


    </style>
</div>