<%@page import="org.hibernate.criterion.MatchMode"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%Session sesloadtypeadmin = conn.connector.getSessionFactory().openSession();%>
<div style="width:980px;">
    <!--div class="c_col">
        Update Delivery (invoice num)
        <div class="b_field">
            <label>Delivery CODE</label>
            <input type="text" name="dcode" id="dcode">
        </div>
        <input type="submit" value="Update" id="b_field_submit_upstate"  onclick="update_Delivery()">
        <div id="up_msg" class="r_msg"></div>
    </div-->

    <div class="admin_sub_content">
        Delivery Details
        <div class="a_field">
            <label>Note Status : </label>
            <select name="vl1" id="vl1">
                <option value="pending">PENDING</option>
                <option value="deliverd">DELIVERD</option>
            </select>
            <input type="submit" value="search" id="a_field_submit" onclick="document.getElementById('dlv_view').click();">
        </div>

        <div class="b_col">
            <table>
                <tr>
                <th>Number</th>
                <th>Name</th>
                <th>Status</th>
                <th>Postal Code</th>
                <th>Shipping date</th>
                <th>Invoice</th>
                </tr>

                <%  //comment              
                    Criteria cruserlist = sesloadtypeadmin.createCriteria(pojo.Delivery.class);
                    if (request.getParameter("vl1") != null && !request.getParameter("vl1").isEmpty()) {
                        cruserlist.add(Restrictions.like("state", request.getParameter("vl1"), MatchMode.ANYWHERE));
                    }

                    List<pojo.Delivery> dlist = cruserlist.list();

                    for (pojo.Delivery dlv : dlist) {
                        out.write("<tr>");
                        out.write("<td>" + dlv.getIddelivery() + "</td>");
                        out.write("<td>" + dlv.getName() + "</td>");
                        out.write("<td>" + dlv.getState() + "</td>");
                        out.write("<td>" + dlv.getPostalCode() + "</td>");
                        out.write("<td>" + dlv.getShippingDate() + "</td>");
                        // pojo.Invoice invo = (pojo.Invoice) sesloadtypeadmin.load(pojo.Invoice.class, dlv.getInvoice().getIdinvoice());
                        out.write("<td>" + dlv.getInvoice().getInvoiceNum() + "</td>");
                        out.write("</tr>");

                    }

                    sesloadtypeadmin.close();
                %>
            </table>


        </div>



    </div>

    <style>
        .admin_sub_content{
            width: 650px;
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
            width:600px;
            /*border: 1px solid #CCC;*/
            height: 270px;
            overflow: auto;
        }
        .b_col table{
            width: 600px;
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
            width: 280px;
            min-width: 200px;
            border: 1px dotted #CCC;
            float: right;
            padding: 10px;
        }
        .b_field{
            width: 250px;
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