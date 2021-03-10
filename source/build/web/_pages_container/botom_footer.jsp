<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<div class="footer_wrapper">
    <div class="footer_container">
        <ul>
            <%
                Session sesfoot = conn.connector.getSessionFactory().openSession();
                Criteria ccrfoot = sesfoot.createCriteria(pojo.Catagory.class);

                List<pojo.Catagory> lstxxx = ccrfoot.list();

                for (pojo.Catagory cat : lstxxx) {
            %>
            <li><a href="#"><%=cat.getCatagory()%></a>
                <ul>
                    <%
                        pojo.Catagory mcatx = (pojo.Catagory) sesfoot.load(pojo.Catagory.class, cat.getIdcatagory());
                        Criteria csub = sesfoot.createCriteria(pojo.SubCategory.class);
                        csub.add(Restrictions.eq("catagory", mcatx));

                        List< pojo.SubCategory> subcat = csub.list();
                        if (subcat.size() > 0) {
                            for (pojo.SubCategory sb : subcat) {
                    %>
                    <li><a href="products.jsp?vl6=<%=sb.getIdsubCategory()%>"><%=sb.getSubCategory()%></a></li>
                        <%
                                }
                            }
                        %>
                </ul>
            </li>
            <%
                }
                sesfoot.close();
            %>
        </ul>
        <div class="newslttr">
            <!--input type="email" name="newsmail" placeholder="example@host.com"-->
            <!--input type="submit" value="subcribe"-->
        </div>
        <div class="foot-navg">
            <div id="right-ex">Alright reserved @ <a href="index.jsp">royal flowers</a> | developed & design @ CARTS.solutions </div>
            <div id="ex-nav">
                <ul >
                    <li><a href="index.jsp">home</a></li>
                    <li><a href="#">about</a></li>
                    <li><a href="#">contact</a></li>
                </ul>
            </div>
        </div>

    </div>

    <style type="text/css">
        .footer_container{
            padding-top: 30px;
        }
        .footer_container ul li a{
            color: #CCC;
        }
        .footer_container ul{
            padding: 0;
            /*margin-top: 200px;*/
            font-size: 13px;
            margin-left: 200px;
            text-align: justify;
            font-weight: bolder;
        }
        .footer_container ul li{
            display: inline-block;
            margin-left: 10px;
            /*border: 1px solid #777;*/
            width: 170px;
            
        }
        .footer_container ul li ul{
            margin-top: 0;
            position: absolute;
            margin-left: 0;
        }
        .footer_container ul li ul li{
            display: block;
            margin-left: 0;
            
        }
        .footer_container ul li ul li a:hover{
            color: #FFF;
            
        }
        .footer_container ul li ul li a{
            text-decoration: none;
        }
        .newslttr{
            /*border: 1px solid #777;*/
            position: relative;
            margin-top: 100px;
            width: 400px;
            margin-left: 210px;
        }
        .newslttr input[type=email]{
            width: 300px;
            padding: 5px 3px;
        }
        .newslttr input[type=submit]{
           
            padding: 3px 3px;
        }
        #ex-nav{
            float: right;
            margin-top: 20px;
        }
        #ex-nav ul li{
            margin-left: -130px;
        }
        #ex-nav ul li a{
            text-decoration: none;
        }
        #right-ex{
            float: left;
            margin-left: 210px;
            margin-top: 35px;
            font-size: 13px;
            color: #FFF;
        }
        #right-ex a{
            color: #FFF;
        }

    </style>
</div>
