

<%@page import="org.hibernate.Session"%>
<div class="page_top_content">
    <div class="top_content_wapper">
        <div class="top_brand">

        </div>
        <div class="top_right_nav">
            <ul>

                <li><a href="index.jsp"><span id="top_nav_link">home</span></a></li>
                <li>|</li>
                <li><a href="#"><span id="top_nav_link">Contact</span></a></li>
                <li>|</li>
                    <%
                        if (request.getSession().getAttribute("user-id") != null) {
                            Session sesulog = conn.connector.getSessionFactory().openSession();

                            Integer userid = (Integer) request.getSession().getAttribute("user-id");
                            pojo.User user = (pojo.User) sesulog.load(pojo.User.class, userid);
                    %>
                <li><a href="user_profile.jsp">Hello <span id="top_log_user"><%=user.getEmail()%></span></a></li>    
                        <%
                            sesulog.close();
                        } else {
                        %>
                <li><a href="signin.jsp"><span id="top_log_user">Log in</span></a></li>
                    <%
                        }

                    %>

            </ul>
        </div>
    </div>
</div>
