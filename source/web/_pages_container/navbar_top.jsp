<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<div class="top_navbar_wrapper">

    <style >
        .main-logo{
            /*border: 1px solid #999;*/
            width: 250px;
            height: 130px;
            float: left;
            padding: 5px;
        }
        .main-cnt-dis{
            /*border: 1px solid #999;*/
            width: 200px;
            height: 130px;
            float: left;
            padding: 5px;
            text-align: center;
        }
        #main-cnt-num , #main-cnt-desc{
            display: block;
            color: #555;
        }
        #main-cnt-num{
            margin-top: 50px;
            font-size: 20px;
            font-weight: bolder;
        }
        #main-cnt-desc{
            font-size: 12px;
        }

        .main-search{
            /*border: 1px solid #999;*/
            width: 300px;
            height: 130px;
            float: left;
            padding: 5px;

        }
        .main-search input[type=text]{
            margin-top: 50px;
            width: 200px;
            padding: 5px;
            border: 1px solid #CCC;
        }
        .main-search input[type=text]:focus{
            border: 1px solid #CCC;
        }
        .main-search input[type=submit]{            
            width: 83px;
            padding: 3px 5px;
            background-color: #777;
            color: #FFF;
            border: 1px solid #222;
            font-weight: bold;
        }
        .main-search input[type=submit]:hover {
            border: 1px solid #777;
        }
        .main-search a{
            font-size: 12px;
            color: #777;
            margin-left: 3px;
        }
        /*cart style */
        .main-cart-dis{
            /*border: 1px solid #999;*/
            width: 200px;
            height: 130px;
            float: left;
            padding: 5px;

        }
        #cart-img {
            float: left;
            margin-right: 5px;
            height: 60px;
            width: 50px;
            margin-left: 15px;
            margin-top: 8px;

        }
        #cart-img img{
            margin-top: 10px;
            width: 50px;
            height: 50px;
        }
        #cart-cont{
            color: #777;
            margin-top: 10px;
            float: left;
            width: 115px;
            font-size: 12px;
            margin-bottom: 10px;
        }
        #cart-name{
            padding: 2px 3px;
            font-weight: bold;
        }
        #cnm {
            display: inline-block;            
        }
        #cnimg{
            display: inline-block;
            margin-left: 5px;
        }
        #cnimg img{
            width: 15px;
            height: 15px;
        }

        #cart-item{

            padding: 2px 3px;
            font-size: 13px;
        }
        #cart-total{

            padding: 2px 3px;
            font-size: 13px;
        }
        #view-cart a{
            display: block;
            border: 1px solid #222;
            clear: both;
            padding: 3px;
            text-align: center;
            background-color: #777;
            width: 110px;
            margin-left: 50px;


        }
        #view-cart a{
            text-decoration: none;
            color: #FFF;
            font-weight: bolder;
            font-size: 13px;

        }

        /*end cart style*/
        .main_navigation{
            clear: both;
        }
        .main_navigation ul{
            padding: 0;
            margin-left: 10px;
            border-bottom: 1px solid #ccc;
        }
        .main_navigation ul li{
            display: inline-block;
            list-style: none;
            margin-left: 35px;
            width: 100px;
            //border: 1px solid #222;
            text-align: center;
            padding: 10px 10px;
            position: relative;
            -webkit-transition: all 0.2s;
            -moz-transition: all 0.2s;
            -ms-transition: all 0.2s;
            -o-transition: all 0.2s;
            transition: all 0.2s;

        }

        .main_navigation ul li a{
            text-decoration: none;
            text-align: center;
            color: #333;
            font-weight: bold;
            font-size: 16px;
        }
        .main_navigation ul li a:hover{
            color: #999;
        }
        /*sub naivagion (drowdown)*/
        .main_navigation ul li ul{
            padding: 5px;
            position: absolute;
            border-bottom: none;
            top: 39px;
            left: 0;
            width: 180px;

            display: none;
            opacity: 0;
            visibility: hidden;
            -webkit-transiton: opacity 0.2s;
            -moz-transition: opacity 0.2s;
            -ms-transition: opacity 0.2s;
            -o-transition: opacity 0.2s;
            -transition: opacity 0.2s;
            font-size: 13px;
        }

        .main_navigation ul li ul li{
            padding: 10px;
            margin-left: 0;
            text-align: justify;
            display: block;           
            width: 160px;
            border-bottom: 1px solid #CCC;
        }
        .main_navigation ul li ul li a{
            font-size: 12px;
            font-weight: normal;
        }
        .main_navigation ul li ul li a:hover{
            color: #0e90d2;
        }
        .main_navigation ul li:hover ul{
            display: block;
            opacity: 1;
            visibility: visible;
            z-index: 1000;
            background-color: #F3F3EE;
            border: 1px solid #CCC;
            //border-top: none;
        } 
        .main_navigation ul li ul li:hover{

        }


        /* crumb navigation */

        .crumb-nav ul{
            padding: 0;
            margin-left: 30px;
            margin-top: -10px;
        }
        .crumb-nav ul li{
            display: inline-block;
            list-style: none;
        }
        .crumb-nav ul li a{
            text-decoration: none;
            text-align: center;
            color: #999;
            font-size: 13px;
        }

    </style>
    <div class="main-logo">
        <a href="index.jsp">
            <img src="_images/logos/logo.png">
        </a>
    </div>
    <div class="main-cnt-dis">
        <div>
            <span id="main-cnt-num">094 71 753 336 8</span><span id="main-cnt-desc">24 hours per day 7 day per week</span>

        </div>
    </div>
    <div class="main-search">
        <form action="products.jsp" method="POST"  onsubmit="return searchnameFieldValidation()">
            <input type="text" id="pname" name="vl2" />
            <input type="submit" value="search" />
            <a href="products.jsp?vl2=search" >filter search</a>
            <br/>
        </form>
        
        
    </div>
    <script type="text/javascript">
        function searchnameFieldValidation() {
            var inputf = document.getElementById("pname").value;
            if (inputf.length <= Number(0)) {
                alert("Enter name for search");
                return false;
            } else {
                return true;
            }
        }
    </script>
    <div class="main-cart-dis">
        <div id="cart-img">
            <img src="_images/_site/Basket.png">
        </div>
        <div id="cart-cont">
            <div id="cart-name">
                <span id="cnm">your basket</span><span id="cnimg"><img src="_images/_site/arrow.png"></span>
            </div>
            <%
                int itemcountmincart = 0;
                int totalmincart = 0;
                if (request.getSession().getAttribute("s_cart") != null) {
                    Session sesp = conn.connector.getSessionFactory().openSession();

                    List<int[]> cart = (ArrayList) request.getSession().getAttribute("s_cart");
                    itemcountmincart = cart.size();
                    pojo.Product product = null;
                    for (int x = 0; x < cart.size(); x++) {
                        int item[] = cart.get(x);
                        product = (pojo.Product) sesp.load(pojo.Product.class, item[0]);
                        totalmincart += (product.getPrice() - product.getDiscount()) * item[1];
                    }

                }
            %>

            <div id="cart-item">Items : <%=itemcountmincart%></div>
            <div id="cart-total">Total : <%=totalmincart%> (LKR) </div>
        </div>
        <div id="view-cart">
            <a href="cart.jsp">View Basket</a>
        </div>
    </div>
    <div class="main_navigation">
        <ul>
            <%
                Session ses = conn.connector.getSessionFactory().openSession();
                Criteria ccrxtt = ses.createCriteria(pojo.Catagory.class);

                List<pojo.Catagory> lst = ccrxtt.list();

                for (pojo.Catagory cat : lst) {
            %>
            <li><a href="#"><%=cat.getCatagory()%></a>
                <ul>
                    <%
                        pojo.Catagory mcat = (pojo.Catagory) ses.load(pojo.Catagory.class, cat.getIdcatagory());
                        Criteria csub = ses.createCriteria(pojo.SubCategory.class);
                        csub.add(Restrictions.eq("catagory", mcat));

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
                ses.close();
            %>
        </ul>
    </div>


</div>
