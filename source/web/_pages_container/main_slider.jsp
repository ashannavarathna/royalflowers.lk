<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<div class="main_slider_wrapper">
    <div class="right_slider_container" >
        <a href="add_create.jsp" style="position: absolute;z-index: 5;background-color: #F6F8FB;color: #0088CC;font-size: 13px;font-weight:normal;padding: 1px 5px 2px 5px;margin:1px 1px 0 190px;opacity: 0.9;text-decoration: none;">create ad</a>
        <div id="right_silder" >
            <%/*ad loading */

                Session sesadds = conn.connector.getSessionFactory().openSession();
                pojo.AdvertisingStatus adstatus = (pojo.AdvertisingStatus) sesadds.load(pojo.AdvertisingStatus.class, 1);
                pojo.AdvertisingLocation adloc = (pojo.AdvertisingLocation) sesadds.load(pojo.AdvertisingLocation.class, 1);
                Criteria crads = sesadds.createCriteria(pojo.Advertising.class);
                crads.add(Restrictions.eq("advertisingStatus", adstatus));
                crads.add(Restrictions.eq("advertisingLocation", adloc));

                List<pojo.Advertising> adlist = crads.list();
                if (adlist.size() == 0) {
            %> 
            <img src="_images/_add/_sub_page/ad_default_home.jpg" style="z-index: 1"/>
            <%
            } else {
                for (pojo.Advertising ad : adlist) {
            %>
            <a href="<%=ad.getWebsiteUrl()%>"><img src="_images/_add/_sub_page/<%=ad.getImgUrl()%>" style="z-index: 1"/></a>
                <%}
                    }
                    sesadds.close();
                %>
        </div>

    </div>
    <div class="main_slide_container" >
        <div  id="banner-slide">
            <ul class="bjqs">
                <li ><img src="_images/_add/_main_banner/wed_cover_1.jpg" title="Best Flower Products"/></li>
                <li><img src="_images/_add/_main_banner/wed_cover_2.jpg" title="Best Customer Satisfaction"/></li>
                <li><img src="_images/_add/_main_banner/wed_cover_3.jpg" title="Sharing Your Love"/></li>
                <li><img src="_images/_add/_main_banner/wed_cover_4.jpg" title="Amazing Flowers "/></li>
                <li><img src="_images/_add/_main_banner/wed_cover_5.jpg" title="Enjoy Life With More Colours"/></li>

            </ul>

        </div>

    </div>

</div>