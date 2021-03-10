<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<form  method="POST" action="update_user_data" class="uupform" name="user_up_form">

    <%
        Integer uprofid = 0;

        if (request.getSession().getAttribute("user-id") != null) {
            uprofid = (Integer) request.getSession().getAttribute("user-id");

        }
        Session userprofdata = conn.connector.getSessionFactory().openSession();
        pojo.User uprouser = (pojo.User) userprofdata.load(pojo.User.class, uprofid);


    %>
    <div style="background-color: #333;color: #FFF;padding: 5px;"><%=uprouser.getFname() + " " + uprouser.getLname() + "'s"%> Bio Data</div>
    <input type="hidden" name="uid" value="<%=uprofid%>">
    <label>First Name</label>
    <input type="text" name="fname" value="<%=uprouser.getFname()%>"/>
    <label>Last Name</label>
    <input type="text" name="lname" value="<%=uprouser.getLname()%>"/>
    <label>Email Address</label>
    <input type="text" name="email" value="<%=uprouser.getEmail()%>" disabled />
    <label>Office | Home Contact</label>
    <input type="text" name="lan_cnt" value="<%=uprouser.getTelephone()%> "/>
    <label>Mobile Contact</label>
    <input type="text" name="m_cnt" value="<%=uprouser.getMobile()%>"  />
    <label>Address Line 1</label>
    <input type="text" name="add1" value="<%=uprouser.getAddress1()%>" />
    <label>Address Line 2</label>
    <input type="text" name="add2" value="<%=uprouser.getAddress2()%>" />
    <label>Address Line 3</label>
    <input type="text" name="add3" value="<%=uprouser.getAddress3()%>" />
    <label>City</label>
    <input type="text" name="ucity" value="<%=uprouser.getCity()%>" />
    <label>District</label>
    <input type="text" name="dstrct" value="<%=uprouser.getDistrict()%>" />
    <label>Country</label>
    <input type="text" disabled  value="<%=uprouser.getCountry()%>" />
    <%        userprofdata.close();
    %>

    <input type="submit" value="update" />
</form>
<div class="outmsg" id="outmsg">

</div>
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
