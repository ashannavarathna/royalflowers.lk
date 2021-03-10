<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<div style="width:675px;padding: 10px;">
    <div style="background-color: #333;color: #FFF;padding: 5px;">Advertising</div>
    <table style="height:320px;margin-top: 0;border: none;">
        <thead style="border: 1px solid #CCC;">
            <tr>
            <td style="background-color: #777;color: #FFF;width: 50px;display: inline-block;">ID</td>
            <td style="background-color: #777;color: #FFF;width: 219px;display: inline-block;">Ad Title</td>
            <td style="background-color: #777;color: #FFF;width: 55px;display: inline-block;">On Date</td>
            <td style="background-color: #777;color: #FFF;width: 90px;display: inline-block;">Price</td>
            <td style="background-color: #777;color: #FFF;width: 100px;display: inline-block;">Status</td>
            <td style="background-color: #777;color: #FFF;width: 85px;display: inline-block;">Ex Date</td>
            </tr>

        </thead>
        <tbody style="height: 350px;border: 1px solid #CCC;" id="ad_details_on_adview">
            <%/*loading add for user*/

                int user_id = (Integer) request.getSession().getAttribute("user-id");
                Session sesadds = conn.connector.getSessionFactory().openSession();
                pojo.User user = (pojo.User) sesadds.load(pojo.User.class, user_id);

                Criteria cry = sesadds.createCriteria(pojo.Advertising.class);
                cry.add(Restrictions.eq("user", user));

                List<pojo.Advertising> adlist = cry.list();
                for (pojo.Advertising ad : adlist) {
                    double price = (ad.getAdvertisingLocation().getPrice() - ad.getAdvertisingLocation().getDiscount()) + (ad.getAdvertisingDatePlans().getPrice() - ad.getAdvertisingDatePlans().getDiscount());
                    Date ondate = ad.getOnDate();
                    Calendar clndr = Calendar.getInstance();
                    clndr.setTime(ondate);
                    clndr.add(Calendar.DATE, ad.getAdvertisingDatePlans().getDateCount());
                    clndr.getTime();
                    Date exdate = clndr.getTime();
                    int stateid = ad.getAdvertisingStatus().getIdadvertisingStatus();
                    String colorcode = "";
                    if (stateid == 1) {
                        colorcode = "#00FF55";
                    } else if (stateid == 2) {
                        colorcode = "#FFD400";
                    } else if (stateid == 3) {
                        colorcode = "#2A7FFF";
                    } else if (stateid == 4) {
                        colorcode = "#FF552A";
                    }


            %>
            <tr>
            <td class='tbd_cl1' style='width: 50px;'><%=ad.getIdadvertising()%></td>
            <td class='tbd_cl1' style='width: 219px;'><%=ad.getAddTitle()%></td>
            <td class='tbd_cl1' style='width: 55px;text-align: right;font-size:11px;'><%=ad.getOnDate()%></td>
            <td class='tbd_cl1' style='width: 90px;text-align: right;'><%=price%></td>
            <td style="background-color: <%=colorcode%>;color: #333;font-weight: bold; width: 100px;display: inline-block;"><%=ad.getAdvertisingStatus().getStatus()%></td>
            <td style="color: #000;width: 85px;display: inline-block;font-size: 11px;"><%=exdate%></td>
            </tr>
            <%
                }
                sesadds.close();

            %>

        </tbody>
    </table>
</div>

<style>


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
</style>