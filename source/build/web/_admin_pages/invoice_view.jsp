<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="org.hibernate.criterion.MatchMode"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%Session sesloadtypeadmin = conn.connector.getSessionFactory().openSession();%>

<div style="width:980px;">

    <div class="admin_sub_content">
        <div style="background-color: #333;color: #FFF;padding: 5px;"> Invoice </div>
        <div class="a_field">
            <label>Invoice Num</label>
            <input type="text" name="vl1" id="vl1">
        </div>
        <div style="font-size: 15px;padding-left: 10px;">Date Format <span style="font-size: 12px;display: inline-block;">(YYYY-MM-DD)</span></div>
        <div class="a_field">
            <label>Date To :</label>
            <input type="text" name="vl2" id="vl2" >
            <label>Date From :</label>
            <input type="text" name="vl3" id="vl3">
            <input type="submit" value="search" id="a_field_submit" onclick="load_invoice_with_params('page-sub-container', '_admin_pages/invoice_view.jsp')">
        </div>



        <div class="b_col">
            <table>
                <thead>
                    <tr>
                    <th style="width:140px;">Invoice Num</th>
                    <th style="width:130px;">Date</th>
                    <th style="width: 50px;text-align: center;">Items</th>
                    <!--th style="width:50px;text-align: center;">Qty.</th-->
                    <th style="width: 100px;text-align: right;">Amount</th>
                    <th style="width: 100px;text-align: right;">Dlv. Cost</th>
                    <th style="width: 100px;text-align: right;">Total</th>
                    <!--th>#</th-->
                    </tr>
                </thead>
                <tbody>
                    <%  //comment              
                        Criteria cruserlist = sesloadtypeadmin.createCriteria(pojo.Invoice.class);
                       // int x = (Integer) request.getSession().getAttribute("user-id");
                        // pojo.User userbbs = (pojo.User) sesloadtypeadmin.load(pojo.User.class, x);

                        // cruserlist.add(Restrictions.eq("user", userbbs));
                        if (request.getParameter("vl1") != null && !request.getParameter("vl1").isEmpty()) {
                            cruserlist.add(Restrictions.eq("invoiceNum", request.getParameter("vl1")));

                        }
                        if (request.getParameter("vl2") != null && !request.getParameter("vl2").isEmpty()) {
                            String valuee = request.getParameter("vl2");
                            //validate the date
                            boolean dateformat_valid = true; // check the format for the user passes
                            String ditems[] = valuee.split("-");

                            if (ditems.length == 3) {
                                if (ditems[0].length() != 4) {
                                    dateformat_valid = false;
                                }
                                if (ditems[1].length() < 1 || ditems[1].length() > 2) {
                                    dateformat_valid = false;
                                }
                                if (ditems[2].length() < 1 || ditems[2].length() > 2) {
                                    dateformat_valid = false;
                                }

                            } else {
                                dateformat_valid = false;
                            }

                            String dateoffset = valuee + " 00.00.00.000";
                            String dateoutset = valuee + " 23.59.00.000";

                            if (request.getParameter("vl3") != null && !request.getParameter("vl3").isEmpty()) {
                                String val2 = request.getParameter("vl3");

                                // validate date two
                                ditems = val2.split("-");

                                if (ditems.length == 3) {
                                    if (ditems[0].length() != 4) {
                                        dateformat_valid = false;
                                    }
                                    if (ditems[1].length() < 1 && ditems[1].length() > 2) {
                                        dateformat_valid = false;
                                    }
                                    if (ditems[2].length() < 1 && ditems[2].length() > 2) {
                                        dateformat_valid = false;
                                    }

                                } else {
                                    dateformat_valid = false;
                                }

                                dateoutset = val2 + " 23.59.00.000";
                            }

                            if (dateformat_valid) {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss.SSS");

                                java.util.Date date_begin = sdf.parse(dateoffset);
                                java.util.Date date_end = sdf.parse(dateoutset);
                                cruserlist.add(Restrictions.between("timeDate", date_begin, date_end));
                            }

                        }

                        List<pojo.Invoice> involist = cruserlist.list();
                        double totlaamount = 0;
                        double dlvcost = 0;
                        double total = 0;
                        int qtycount = 0;
                        DecimalFormat df = new DecimalFormat("0.00");
                        for (pojo.Invoice invo : involist) {
                            // Criteria cart = sesloadtypeadmin.createCriteria(pojo.Cart.class);
                            // cart.add(Restrictions.eq("invoice", invo));
                            //  pojo.TransactionDetails transd = (pojo.TransactionDetails) transdata.uniqueResult();
                            out.write("<tr>");
                            out.write("<td style='font-size:13px;width:140px;'>" + invo.getInvoiceNum() + "</td>");
                            out.write("<td style='font-size:12px;width:130px;'>" + invo.getTimeDate() + "</td>");
                            out.write("<td style='font-size:13px;text-align:center;width:50px;'>" + invo.getCart().getProductCount() + "</td>");

//                            Criteria crchp = sesloadtypeadmin.createCriteria(pojo.CartHasProducts.class);
//                            crchp.add(Restrictions.eq("cart", invo.getCart()));
//                            List<pojo.CartHasProducts> chplist = crchp.list();
//                            for (pojo.CartHasProducts chp : chplist) {
//                                qtycount += chp.getQty();
//                            }
                            Criteria crdlv = sesloadtypeadmin.createCriteria(pojo.Delivery.class);
                            crdlv.add(Restrictions.eq("invoice", invo));
                            pojo.Delivery dlv = (pojo.Delivery) crdlv.uniqueResult();

                            //out.write("<td style='font-size:13px;text-align:center;width:50px;'>" + qtycount + "</td>");
                            out.write("<td style='font-size:12px;text-align:right;width:100px;'>" + df.format(invo.getCart().getTotalAmount()) + "</td>");
                            totlaamount += invo.getCart().getTotalAmount();
                            out.write("<td style='font-size:13px;text-align:right;width:100px;'>" + df.format(dlv.getCost()) + "</td>");
                            dlvcost += dlv.getCost();
                            out.write("<td style='font-size:13px;text-align:right;width:100px;'>" + df.format(invo.getCart().getTotalAmount() + dlv.getCost()) + "</td>");
                            total += (invo.getCart().getTotalAmount() + dlv.getCost());

                            out.write("</tr>");
                        }

                        sesloadtypeadmin.close();
                    %>
                </tbody>
            </table>


        </div>
        <div style="font-family: consolas;">
            <div style="margin-left: 30px;font-size: 20px;margin-top: 5px;"><span style="display: inline-block;width: 250px;">Total Product Sales </span> : <span style="display: inline-block;width: 150px;text-align: right;padding-right: 3px;"> <%=df.format(totlaamount)%></span>  </div>
            <div style="margin-left: 30px;font-size: 20px;margin-top: 5px;"><span style="display: inline-block;width: 250px;">Total Delivery Cost </span> : <span style="display: inline-block;width: 150px;text-align: right;padding-right: 3px;"> <%=df.format(dlvcost)%></span>  </div>
            <div style="margin-left: 30px;font-size: 20px;margin-top: 5px;"><span style="display: inline-block;width: 250px;">Total Invoices Amount</span> : <span style="display: inline-block;width: 150px;text-align: right;padding-right: 3px;background-color: #333;color: #FFF;">  <%=df.format(total)%> </span> </div>
        </div>

    </div>

    <style>
        .admin_sub_content{
            width: 750px;
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
            width: 740px;
            /*border: 1px solid #CCC;*/
            height: 270px;
            overflow: auto;
        }
        .b_col table{
            width: 720px;
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
        table thead{
            display: block;
        }
        table tbody{
            display: block;
            overflow-y:  auto;
            height: 250px;
        }


    </style>
</div>
