<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<div class="ad_container">
    <div class="col" style="float: right; ">

        <div style="background-color: #333;color: #FFF;padding: 3px;font-weight: bold;">Mange adds here</div>
        <label>Ad Title <span style="font-size: 11px;">(ad title)</span></label>
        <input type="hidden" name="adid" id="ad_id">
        <input type="text"  name="adtitle" id="adtitle" >
        <label>Web Url<span style="font-size: 11px;"> (ad display date range)</span></label>
        <input type="text" name="adurl" id="adwurl" >
        <label>Image<span style="font-size: 11px;"> (ad image)</span></label>
        <img src="#" width="300px" height="150px;" id="adimg">
        <label>Description<span style="font-size: 11px;"> (about ad)</span></label>
        <input type="text" name="adscr" id="adscr">
        <label>Ad Status<span style="font-size: 11px;"> (current status of the ad)</span></label>
        <input type="text" name="adstate" id="adstate" disabled >
        <label>Exf Date<span style="font-size: 11px;"> (the date of the add expire)</span></label>
        <input type="text" name="adexfd" id="adexfd" disabled >
        <label><span style="font-size: 11px;"></span></label>
        <div id="adctrlbtn">
            <input type="button" value="Controll" style="padding: 3px; width: 120px;">
        </div>
    </div>
    <div class="ad_table" >
        <div>
            <form >
                <label style="display: inline-block;padding: 5px;">Advertising status <span style="font-size: 11px;"></span></label>
                <select style="width: 300px;display: inline-block;padding: 5px;" name="adstaus_cmb" id="adstaus_cmb_admin">
                    <option value="0">select Status</option>
                    <%/*loading ad location*/

                        Session ses = conn.connector.getSessionFactory().openSession();
                        Criteria cryadloc = ses.createCriteria(pojo.AdvertisingStatus.class);
                        List<pojo.AdvertisingStatus> adloclist = cryadloc.list();
                        for (pojo.AdvertisingStatus adloc : adloclist) {

                            out.write("<option value='" + adloc.getIdadvertisingStatus() + "'>" + adloc.getStatus() + "</option>");
                        }
                    %>
                </select>
                <input type="button" value="search" onclick="load_ad_list('adstaus_cmb_admin')" style="padding:3px;width:100px;">
            </form>
        </div>
        <div style="width:650px;">

            <table style="height:320px;margin-top: 0;border: none;">
                <thead style="border: 1px solid #CCC;">
                    <tr>
                    <td style="background-color: #777;color: #FFF;width: 50px;display: inline-block;">ID</td>
                    <td style="background-color: #777;color: #FFF;width: 220px;display: inline-block;">Ad Title</td>
                    <td style="background-color: #777;color: #FFF;width: 55px;display: inline-block;">On Date</td>
                    <td style="background-color: #777;color: #FFF;width: 90px;display: inline-block;">Price</td>
                    <td style="background-color: #777;color: #FFF;width: 179px;display: inline-block;">User</td>
                    </tr>

                </thead>
                <tbody style="height: 350px;border: 1px solid #CCC;" id="ad_details_on_adview">

                </tbody>
            </table>
        </div>
    </div>

    <%        ses.close();
    %>
</div>

<style type="text/css">
    .ad_container{
        width: 970px;
        /*border: 1px solid #CCC;*/
        min-height: 700px;
        padding: 5px;
    }
    .ad_container div{

    }


    table{
        width: 100%;
        border: 1px solid #CCC;
        padding: 3px;
        margin-top: 10px;
    }
    table td{
        padding: 3px;
    }
    table td span{
        display: block;
        font-size: 11px;
        color: #333;
        text-decoration: underline;
        cursor: pointer;
    }
    table thead{
        display: block;
        width: 100%;
    }
    table thead tr{
        width: 100%;
        /*background: #005580;*/
        display: inline-block;
    }
    table tbody{
        width: 100%;
        height: 170px;
        display: block;
        overflow-y: auto;


    }
    table tbody tr{
        display:block;
        /*background-color: #0088CC;*/
    }
    table tbody td{
        /*background: #006600;*/
    }
    table tbody tr .tbd_cl1{
        width: 21%;
        display: inline-block;
        height: 30px;
    }
    table tbody .tbd_cl2{
        width: 75%;
        display: inline-block;
        height: 30px;
    }
    .col{
        margin-top: 30px;
        padding: 5px;
        width: 300px;;
        margin-left: 5px;
        min-height: 280px;
        border: 1px solid #CCC;
        float: left;
        position: relative;

    }
    .col  label{
        display: block;
        padding: 5px;
        width: 300px;
    }
    .col input[type=text]{
        display: block;
        padding: 5px;
        width: 280px;
        border: 1px solid #CCC;
    }
    .col  input[type=button]{
        padding: 3px;
        width: 100px;
    }
</style>