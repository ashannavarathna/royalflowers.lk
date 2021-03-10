
<%@page import="java.text.DecimalFormat"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<div class="m_container">
    <div class="content_row">
        <div class="col">
            <div style="background-color: #333;color: #FFF;padding: 3px;font-weight: bold;">Advertising Categories</div>
            <form class="sv_form" >
                <label>Add Category</label>
                <input type="text" name="add_cat" id="addver_Cat">
                <input type="button" value="add" onclick="save_advertise_category('addver_Cat', 'sv_form_msg')">
            </form>
            <div id="sv_form_msg"></div>
            <table>
                <thead>
                    <tr>
                    <td style="background-color: #777;color: #FFF;width: 20%;display: inline-block;">ID</td>
                    <td style="background-color: #777;color: #FFF;width: 76.4%;display: inline-block;">Category</td>                   
                    </tr>

                </thead>
                <tbody>
                    <% /*comment */

                        Session ses = conn.connector.getSessionFactory().openSession();
                        DecimalFormat df = new DecimalFormat("0.00");
                        Criteria cry = ses.createCriteria(pojo.AdvertisingCategory.class);
                        pojo.AdvertisingStatus adstate = (pojo.AdvertisingStatus) ses.load(pojo.AdvertisingStatus.class, 1); // get the active state
                        cry.add(Restrictions.eq("advertisingStatus", adstate));
                        List<pojo.AdvertisingCategory> adclist = cry.list();
                        for (pojo.AdvertisingCategory adx : adclist) {

                    %>
                    <tr>
                    <td class="tbd_cl1"><%=adx.getIdadvertisingCategory()%></td>
                    <td class="tbd_cl2"><%=adx.getCategory()%><span onclick="remove_ad_category('<%=adx.getIdadvertisingCategory()%>', 'sv_form_msg')">remove</span></td>                   
                    </tr>
                    <%}

                    %>



                </tbody>
            </table>
        </div>
        <div class="col">
            <div style="background-color: #333;color: #FFF;padding: 3px;font-weight: bold;">Update advertising location details </div>
            <label>Select Location <span style="font-size: 11px;">(image size per define. )</span></label>
            <select style="width: 300px;display: inline-block;" name="ad_loc_cmb" id="ad_loc_cmb_admin" onchange="load_ad_loc_details()">
                <option value="0">select location</option>
                <%/*loading ad location*/
                    Criteria cryadloc = ses.createCriteria(pojo.AdvertisingLocation.class);
                    List<pojo.AdvertisingLocation> adloclist = cryadloc.list();
                    String fstvalimgsize = ""; // getting the img size of first vale in db
                    for (pojo.AdvertisingLocation adloc : adloclist) {
                        if (fstvalimgsize == "") {
                            fstvalimgsize = adloc.getImgSize();
                        }
                        out.write("<option value='" + adloc.getIdadvertisingLocation() + "'>" + adloc.getLocation() + "</option>");
                    }
                %>
            </select><label style="display: inline-block;border: 1px dotted #CCC;width: 120px;padding: 6px;margin-left: 10px;background-color: #F0F0F0;margin-top: 0;text-align: center;"id="adloc_imgsize_admin" >width x height (px)</label>
            <label>Location Cost <span style="font-size: 11px;">(LKR)</span></label>
            <input type="text" name="ad_loc_price" id="ad_loc_price_admin" onkeypress='return (event.charCode >= 48 && event.charCode <= 57) || event.charCode === 0 || event.charCode === 46' style="display: inline-block;width: 100px;text-align: right;padding: 5px;border: 1px solid #CCC;" placeholder="0.00">
            <label>Discount <span style="font-size: 11px;">(LKR)</span></label>
            <input type="text" name="ad_loc_dscnt" id="ad_loc_dscnt_admin" onkeypress='return (event.charCode >= 48 && event.charCode <= 57) || event.charCode === 0 || event.charCode === 46' style="display: inline-block;width: 100px;text-align: right;padding: 5px;border: 1px solid #CCC;" placeholder="0.00">
            <br/><br/> <input type="button" value="update" style="padding: 3px; width: 115px;" onclick="update_ad_loc_data()">
            <div id="adloc_msg_admin" style="font-size: 11px;padding: 5px;"></div>
        </div>

    </div>
    <div class="content_row" style="min-height: 350px;">
        <div class="col" style="border:none;width: 350px;">
            <div style="background-color: #333;color: #FFF;padding: 3px;font-weight: bold;">Update advertising date plans </div>
            <label>Package Name <span style="font-size: 11px;">(to update type pkg name and press enter)</span></label>
            <input type="text"  name="ad_pkg_name" id="ad_pkg_name_admin" style="display: inline-block;width: 300px;text-align: left;padding: 5px;border: 1px solid #CCC;">
            <label>Date Count <span style="font-size: 11px;">(ad display date range)</span></label>
            <input type="text" name="ad_pkg_dcount" id="ad_pkg_dcount_admin" onkeypress='return (event.charCode >= 48 && event.charCode <= 57) || event.charCode === 0' style="display: inline-block;width: 100px;text-align: right;padding: 5px;border: 1px solid #CCC;" placeholder="0">
            <label>Package Cost <span style="font-size: 11px;">(LKR)</span></label>
            <input type="text" name="ad_pkg_price" id="ad_pkg_price_admin" onkeypress='return (event.charCode >= 48 && event.charCode <= 57) || event.charCode === 0 || event.charCode === 46' style="display: inline-block;width: 100px;text-align: right;padding: 5px;border: 1px solid #CCC;" placeholder="0.00">
            <label>Discount<span style="font-size: 11px;">(LKR)</span></label>
            <input type="text" name="ad_pkg_dscount" id="ad_pkg_dscount_admin" onkeypress='return (event.charCode >= 48 && event.charCode <= 57) || event.charCode === 0 || event.charCode === 46' style="display: inline-block;width: 100px;text-align: right;padding: 5px;border: 1px solid #CCC;" placeholder="0.00">
            <label><span style="font-size: 11px;">your prices will update</span></label>
            <input type="button" value="save & update" style="padding: 3px; width: 120px;" onclick="save_and_update_date_palans()">
        </div>


        <div class="col" style="width: 570px;padding-top:0;border:none;">
            <div id="sv_form_msg"></div>
            <table style="height:320px;margin-top: 0;border: none;">
                <thead>
                    <tr>
                    <td style="background-color: #777;color: #FFF;width: 50px;display: inline-block;">ID</td>
                    <td style="background-color: #777;color: #FFF;width: 220px;display: inline-block;">Package Name</td>
                    <td style="background-color: #777;color: #FFF;width: 55px;display: inline-block;">D-Cnt</td>
                    <td style="background-color: #777;color: #FFF;width: 90px;display: inline-block;">Price</td>
                    <td style="background-color: #777;color: #FFF;width: 90px;display: inline-block;">Dscnt</td>
                    </tr>

                </thead>
                <tbody style="height: 300px;">
                    <% /*comment */

                        Criteria cryadplan = ses.createCriteria(pojo.AdvertisingDatePlans.class);

                        cryadplan.add(Restrictions.eq("advertisingStatus", adstate));
                        List<pojo.AdvertisingDatePlans> adplanlist = cryadplan.list();
                        for (pojo.AdvertisingDatePlans addplan : adplanlist) {
                    %>
                    <tr>
                    <td class="tbd_cl1" style="width: 50px;"><%=addplan.getIdadvertisingDatePlans()%></td>
                    <td class="tbd_cl1" style="width: 220px;"><%=addplan.getPakage()%><span onclick="remove_ad_pkgplan('<%=addplan.getIdadvertisingDatePlans()%>')">remove</span></td>                   
                    <td class="tbd_cl1" style="width: 55px;text-align: right;"><%=addplan.getDateCount()%></td>
                    <td class="tbd_cl1" style="width: 85px;text-align: right;"><%=df.format(addplan.getPrice())%></td>
                    <td class="tbd_cl1" style="width: 80px;text-align: right;"><%=df.format(addplan.getDiscount())%></td>
                    </tr>
                    <%}
                        ses.close();
                    %>



                </tbody>
            </table>
        </div>

    </div>
</div>
<style type="text/css">
    .m_container{
        width: 970px;
        /*border: 1px solid #CCC;*/
        min-height: 500px;
        padding: 5px;
    }
    .content_row{
        padding: 5px;
        border: 1px dotted #CCC;
        min-height: 300px;
        margin-bottom: 5px;
    }
    .col{   
        padding: 5px;
        width: 48%;
        margin-left: 5px;
        min-height: 280px;
        border: 1px solid #CCC;
        float: left;
        position: relative;

    }
    .col .sv_form label{
        display: inline-block;
        padding: 5px;
        width: 100px;
    }
    .col .sv_form input[type=text]{
        display: inline-block;
        padding: 5px;
        width: 229px;
        border: 1px solid #CCC;
    }
    .col .sv_form input[type=button]{
        padding: 3px;
        width: 100px;
    }
    .col table{
        width: 100%;
        border: 1px solid #CCC;
        padding: 3px;
        margin-top: 10px;
    }
    .col table td{
        padding: 3px;
    }
    .col table td span{
        display: block;
        font-size: 11px;
        color: #333;
        text-decoration: underline;
        cursor: pointer;
    }
    .col table thead{
        display: block;
        width: 100%;
    }
    .col table thead tr{
        width: 100%;
        /*background: #005580;*/
        display: inline-block;
    }
    .col table tbody{
        width: 100%;
        height: 170px;
        display: block;
        overflow-y: auto;


    }
    .col table tbody tr{
        display:block;
        /*background-color: #0088CC;*/
    }
    .col table tbody td{
        /*background: #006600;*/
    }
    .col table tbody tr .tbd_cl1{
        width: 21%;
        display: inline-block;
        height: 30px;
    }
    .col table tbody .tbd_cl2{
        width: 75%;
        display: inline-block;
        height: 30px;
    }
    .col label{
        display: block;
        margin-top: 10px;
        margin-bottom: 5px;
        font-size: 13px;
        font-weight: bold;
        color: #504b4b;
        padding-left: 1px;
    }
    .col select{
        width: 350px;
        border: 1px solid #CCC;
    }
    .col select option {
        padding: 5px;
    }

</style>
