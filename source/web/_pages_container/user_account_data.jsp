<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<form  method="POST" class="uupform">

    <%
        Integer uprofid = 0;

        if (request.getSession().getAttribute("user-id") != null) {
            uprofid = (Integer) request.getSession().getAttribute("user-id");

        }
        Session userprofdata = conn.connector.getSessionFactory().openSession();
        pojo.User uprouser = (pojo.User) userprofdata.load(pojo.User.class, uprofid);


    %>
    <div style="background-color: #333;color: #FFF;padding: 5px;">Change Your Passwords</div>
    <input type="hidden" name="uid" value="<%=uprofid%>">
    <label>Email Address</label>
    <input type="text" name="email" value="<%=uprouser.getEmail()%>" disabled />
    <label>Current Password</label>
    <input type="password" name="crr_pass" id="crr_pass" value=""/>
    <label>New Password</label>
    <input type="password" name="nw_pass" value="" id="nw_pass" />
    <label>Confirm Password</label>
    <input type="password" name="cfm_pass" value="" id="cfm_pass" />
    <%        userprofdata.close();
    %>

    <input type="button" value="update" onclick="chagpasw()" />
</form>
<style type="text/css">
    .uupform label, .uupform input {
        display: block;
        padding: 5px 5px;
        margin-top: 2px;
        width: 300px;
        font-size: 12px;

    }
    .uupform input[type=submit]{
        width: 100px;
        margin-top: 10px;
        padding: 3px 5px;
    }
    .uupform input[type=text],.uupform input[type=email]{
        border: 1px solid #CCC;
        color: #666;
    } 
</style>