<%@page import="org.hibernate.criterion.MatchMode"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%Session sesloadtypeadmin = conn.connector.getSessionFactory().openSession();%>
<div style="width:980px;">
    <div class="c_col">
        update user state and type
        <div class="b_field">
            <label>Email</label>
            <input type="email" name="upemail" id="upusemail">
        </div>

        <div class="b_field">
            <label>Set User Type</label>
            <select name="uputype" id="upustype"  >
                <%
                    Criteria updatecrtypelsit = sesloadtypeadmin.createCriteria(pojo.UserType.class);
                    List<pojo.UserType> updatetypelist = updatecrtypelsit.list();
                    for (pojo.UserType utype : updatetypelist) {
                        out.write("<option value=" + utype.getIduserType() + ">" + utype.getTypeName() + "</option>");
                    }

                %>
            </select>
        </div>

        <input type="submit" value="update" id="b_field_submit_uptype" onclick="update_user_types('utype')">
        <div id="msg_type" class="r_msg"></div>

        <div class="b_field" >
            <label>Set User State</label>
            <select name="upustate" id="upusstate" >
                <% //coment
                    Criteria updatecrsatelist = sesloadtypeadmin.createCriteria(pojo.UserState.class);
                    List<pojo.UserState> updatesttelist = updatecrsatelist.list();
                    for (pojo.UserState ustate : updatesttelist) {
                        out.write("<option value=" + ustate.getIduserState() + ">" + ustate.getState() + "</option>");
                    }

                %>
            </select>

        </div>
        <input type="submit" value="update" id="b_field_submit_upstate"  onclick="update_user_types('ustate')">
        <div id="msg_state" class="r_msg"></div>
    </div>










    <div class="admin_sub_content">
        Search for users
        <div class="a_field">
            <label>First Name</label>
            <input type="text" name="fname" id="usfname">
        </div>
        <div class="a_field">
            <label>Last Name</label>
            <input type="text" name="lname" id="uslname">
        </div>
        <div class="a_field">
            <label>Email</label>
            <input type="email" name="email" id="usemail">
        </div>
        <div class="a_field">
            <label>User Type</label>
            <select name="utype" id="ustype">
                <option value="">select</option>
                <%                    Criteria crtypelsit = sesloadtypeadmin.createCriteria(pojo.UserType.class);
                    List<pojo.UserType> typelist = crtypelsit.list();
                    for (pojo.UserType utype : typelist) {
                        out.write("<option value=" + utype.getIduserType() + ">" + utype.getTypeName() + "</option>");
                    }

                %>
            </select>
        </div>
        <div class="a_field">
            <label>User Status</label>
            <select name="ustate" id="usstate">
                <option value="">select</option>
                <% //coment
                    Criteria crsatelist = sesloadtypeadmin.createCriteria(pojo.UserState.class);
                    List<pojo.UserState> sttelist = crsatelist.list();
                    for (pojo.UserState ustate : sttelist) {
                        out.write("<option value=" + ustate.getIduserState() + ">" + ustate.getState() + "</option>");
                    }

                %>
            </select>
            <input type="submit" value="search" id="a_field_submit" onclick="document.getElementById('u_view').click();">
        </div>

        <div class="b_col">
            <table>
                <tr>
                <th>Fname</th>
                <th>Lname</th>
                <th>Email</th>
                <th>Status</th>
                <th>Type</th>
                <!--th>#</th-->
                </tr>
    
                <%  //comment              
                    Criteria cruserlist = sesloadtypeadmin.createCriteria(pojo.User.class);
                    if (request.getParameter("fname") != null && !request.getParameter("fname").isEmpty()) {
                        cruserlist.add(Restrictions.like("fname", request.getParameter("fname"), MatchMode.ANYWHERE));
                    }

                    if (request.getParameter("lname") != null && !request.getParameter("lname").isEmpty()) {
                        cruserlist.add(Restrictions.like("lname", request.getParameter("lname"), MatchMode.ANYWHERE));
                    }

                    if (request.getParameter("email") != null && !request.getParameter("email").isEmpty()) {
                        cruserlist.add(Restrictions.like("email", request.getParameter("email"), MatchMode.ANYWHERE));
                    }
                    if (request.getParameter("ustate") != null && !request.getParameter("ustate").isEmpty()) {

                        Integer x = Integer.parseInt(request.getParameter("ustate"));
                        pojo.UserState usstate = (pojo.UserState) sesloadtypeadmin.load(pojo.UserState.class, x);
                        cruserlist.add(Restrictions.eq("userState", usstate));
                    }
                    if (request.getParameter("utype") != null && !request.getParameter("utype").isEmpty()) {
                        Integer x = Integer.parseInt(request.getParameter("utype"));
                        pojo.UserType ustype = (pojo.UserType) sesloadtypeadmin.load(pojo.UserType.class, x);
                        cruserlist.add(Restrictions.eq("userType", ustype));
                    }

                    List<pojo.User> userslist = cruserlist.list();

                    for (pojo.User user : userslist) {
                        out.write("<tr>");
                        out.write("<td>" + user.getFname() + "</td>");
                        out.write("<td>" + user.getLname() + "</td>");
                        out.write("<td>" + user.getEmail() + "</td>");
                        out.write("<td>" + user.getUserState().getState() + "</td>");
                        out.write("<td>" + user.getUserType().getTypeName() + "</td>");
                        out.write("</tr>");
                    }

                    sesloadtypeadmin.close();
                %>
            </table>


        </div>



    </div>

    <style>
        .admin_sub_content{
            width: 550px;
            min-height: 300px;
            padding: 10px;
            border: 1px dotted #CCC;

        }
        .a_field{
            width: 430px;
            padding: 5px;
        }
        .a_field label{
            display: inline-block;
            width: 120px;
            //border: 1px solid #CCC;
            padding: 3px 5px;
        }
        .a_field input[type=text],.a_field input[type=email]{
            display: inline-block;
            width: 260px;
            padding: 5px 5px;
            border: 1px solid #CCC;
        }
        .a_field select{
            width: 150px;
            padding: 2px;
            border: 1px solid #CCC;
        }
        .a_field select option{
            width: 140px;
            padding: 3px;
        }

        #a_field_submit{
            padding: 3px 5px;
            width: 107px;
        }
        .b_col{
            padding: 10px;
            width: 540px;
            /*border: 1px solid #CCC;*/
            height: 270px;
            overflow: auto;
        }
        .b_col table{
            width: 540px;
            //border: 1px solid #CCC;
        }

        .b_col table th{
            text-align: left;
            border: 1px solid #777;
            padding-left: 3px;
        }
        .b_col table td{

            padding-left: 3px;
        }
        .c_col{
            min-height: 200px;
            width: 380px;
            min-width: 200px;
            height: 318px;
            border: 1px dotted #CCC;
            float: right;
            padding: 10px;
        }
        .b_field{
            width: 330px;
            padding: 5px;
        }
        .b_field label{
            display: block;
            width: 120px;
            //border: 1px solid #CCC;
            padding: 3px 5px;
        }
        .b_field input[type=text],.b_field input[type=email]{
            display: inline-block;
            width: 260px;
            padding: 5px 5px;
            border: 1px solid #CCC;
        }
        .b_field select{
            width: 200px;
            padding: 2px;
            border: 1px solid #CCC;
        }
        .b_field select option{
            width: 180px;
            padding: 3px;
        }
        #b_field_submit_uptype, #b_field_submit_upstate{
            padding: 3px 5px;
            width: 107px;
            margin-left: 5px;
        }

        .r_msg{
            color: #985f0d;
            font-size: 11px;
            margin-left: 10px;
        }


    </style>
</div>