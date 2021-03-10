<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<div class="container_pro_vend">
    <%Session sesvendotmngt = conn.connector.getSessionFactory().openSession();%>
    <div class="rows">
        <div class="col" style="width: 63%">
            <div class='header-col'>List - Vendors notifications settings</div>
            <div>Sort by Status : 
                <select onchange="load_phasvenlist(this.value, 'phvlisttbody')" >
                    <option value="0">-select-</option>
                    <%
                        Criteria proreqstatecry = sesvendotmngt.createCriteria(pojo.ProductRequestStatus.class);
                        List<pojo.ProductRequestStatus> proreqstatelist = proreqstatecry.list();
                        for (pojo.ProductRequestStatus prores : proreqstatelist) {
                            out.write("<option value='" + prores.getIdproductRequestStatus() + "'>" + prores.getStatus() + "</option>");
                        }
                    %>
                </select>
            </div>
            <table class="p_ven_list">
                <thead>
                    <tr>
                    <td style="width: 80px">Product</td>
                    <td style="width: 90px;">PCode</td>
                    <td style="width: 150px">Vendor</td>
                    <td style="width: 60px">Req. Qty</td>
                    <td style="width: 60px">Avl. Qty</td>
                    <td style="width: 75px">Req. Status</td>
                    </tr>
                </thead>
                <tbody style="width: 620px;" id="phvlisttbody">
                    <%                        Criteria prohasvencry = sesvendotmngt.createCriteria(pojo.ProductHasVendors.class);

                        //filtering search by status
                        if (request.getParameter("vl_phvid") != null && !request.getParameter("vl_phvid").isEmpty()) {
                            int phvid = Integer.parseInt(request.getParameter("vl_phvid"));
                            pojo.ProductRequestStatus prstate = (pojo.ProductRequestStatus) sesvendotmngt.load(pojo.ProductRequestStatus.class, phvid);
                            prohasvencry.add(Restrictions.eq("productRequestStatus", prstate));
                        }

                        List<pojo.ProductHasVendors> prohasvenlist = prohasvencry.list();
                        if (prohasvenlist.size() == 0) {
                            out.write("<tr ><td style='width:585px;'>No result found</td></tr>");
                        }
                        int x = 1;
                        for (pojo.ProductHasVendors phv : prohasvenlist) {

                            String name = phv.getProduct().getName();
                            String pcode = phv.getProduct().getProductCode();
                            String vendor = phv.getVendors().getName();
                            String reqty = phv.getRequestQuantity();
                            int avqty = phv.getProduct().getQty();
                            String status = phv.getProductRequestStatus().getStatus();
                            String oe = "";
                            if (x % 2 == 0) {
                                oe = "even";
                            } else {
                                oe = "odd";
                            }
                            x++;
                            out.write("<tr class='" + oe + "'>"
                                    + " <td style='width: 80px'>" + name + "</td>"
                                    + "<td style='width: 90px;'>" + pcode + "</td>"
                                    + "<td style='width: 150px'>" + vendor + "</td>"
                                    + "<td style='width: 60px'>" + reqty + "</td>"
                                    + "<td style='width: 60px'>" + avqty + "</td>"
                                    + "<td style='width: 75px'>" + status + "</td>"
                                    + "</tr>");
                        }


                    %>
                </tbody>
            </table>
        </div>
        <div class="col" style="width: 25%">
            <div class='header-col'>Update Details</div>
            <div>
                <lable>Product Code</lable>
                <input type="text" id="pcode">
                <lable>Vendor</lable>
                <select id="vendorid">
                    <option value="0">-select-</option>

                    <%                        Criteria vendorscry = sesvendotmngt.createCriteria(pojo.Vendors.class);
                        List<pojo.Vendors> venlist1 = vendorscry.list();
                        for (pojo.Vendors ven : venlist1) {
                            out.write("<option value='" + ven.getIdcompanies() + "'>" + ven.getName() + "</option>");
                        }
                    %>
                </select>
                <lable>Request Quantity</lable>
                <input type="text" id="reqqty">
                <lable>Request Status</lable>
                <select id="preqstate">
                    <option value="0">-select-</option>
                    <%                        for (pojo.ProductRequestStatus prores : proreqstatelist) {
                            out.write("<option value='" + prores.getIdproductRequestStatus() + "'>" + prores.getStatus() + "</option>");
                        }
                    %>
                </select>
                <input type="button" value="Updates" onclick="update_phv_details()">
            </div>
            <div id="msgbox_phv" class="msgbox"></div>
        </div>
    </div>
    <div class="rows">
        <div class="col" style="width: 63%">
            <div class='header-col'>List - Vendors</div>
            <table class="ven_list">
                <thead>
                    <tr>
                    <td style="width: 95px">Name</td>
                    <td style="width: 150px">Email</td>
                    <td style="width: 200px">Address</td>
                    <td style="width: 100px">Contact</td>
                    </tr>
                </thead>
                <tbody style="width: 620px;">
                    <%                        Criteria vencry = sesvendotmngt.createCriteria(pojo.Vendors.class);
                        List<pojo.Vendors> venlist = vencry.list();
                        if (venlist.size() == 0) {
                            out.write("<tr ><td style='width:587px;'>No result found</td></tr>");
                        }
                        int xx = 1;
                        for (pojo.Vendors vens : venlist) {
                            String oe = "";
                            if (xx % 2 == 0) {
                                oe = "even";
                            } else {
                                oe = "odd";
                            }
                            xx++;

                            out.write("<tr class='" + oe + "'>"
                                    + "<td style='width: 95px'>" + vens.getName() + "</td>"
                                    + "<td style='width: 150px'>" + vens.getEmail() + "</td>"
                                    + "<td style='width: 200px'>" + vens.getAddress() + "</td>"
                                    + "<td style='width: 100px'>" + vens.getCnt1() + "</td>"
                                    + "</tr>");
                        }

                    %>
                </tbody>
            </table>
        </div>
        <div class="col" style="width: 25%">
            <div class='header-col'>Update Details</div>
            <div>
                <lable>Vendor Email</lable>
                <input type="text" id="venemail">
                <lable>Name</lable>
                <input type="text" id="venname">
                <lable>Address</lable>
                <input type="text" id="venaddr">
                <lable>Contact</lable>
                <input type="text" id="vencnt1">
                <input type="button" value="Updates" onclick="update_vendor_details()">
            </div>
            <div id="msgbox_ven" class="msgbox"></div>
        </div>
    </div>
</div>

<%sesvendotmngt.close();%>

<style type="text/css">
    .container_pro_vend{
        width: 1000px;

    }
    .rows{
        min-height: 300px;
        padding: 5px;
        /*border: 1px solid #CCC;*/
        margin-top: 5px;
    }
    .col{
        width: 44%;
        min-height: 300px;
        border: 1px solid silver;
        float: left;
        margin-left: 5px;
        padding: 5px;
    }
    .col lable{
        display: block;
        margin: 3px 0 3px 0;
    }
    .col input{
        display: block;
    }
    .col input[type='text']{
        width: 235px;
        padding: 5px;
        border: 1px solid #CCC;
    }
    .p_ven_list thead tr td{
        border:1px solid #CCC;
        padding: 0 5px;
    }

    .ven_list thead tr td{
        border:1px solid #CCC;
        padding: 0 5px;
    }
    .col input[type='button']{
        padding: 3px;
        margin-top: 5px;
        width: 100px;
    }
    .header-col{
        background-color: #444;
        color: #FFF;
        padding: 3px;
        font-weight: bold;
        margin-bottom: 4px;
    }
    .col select{
        min-width: 100px;
    }
    .col select option{
        padding: 3px;
    }
    .col tbody, .col thead{
        display: block;
    }
    .col tbody{
        height: 200px;
        overflow-y: auto;

    }
    .col tbody tr td{
        padding: 0 5px;
    }
    .col tbody tr{
        //display: block;
        width: 600px;
    }

    .col tbody .even{
        background-color: #EEE;
    }
    .col tbody .odd{
        background-color: #FFF;
    }
    .col tbody .even td{
        border: 1px solid #EEE;
    }
    .col tbody .odd td{
        border: 1px solid #FFF;
    }
    .msgbox{
        font-size: 13px;
        margin-top: 10px;
    }

</style>
