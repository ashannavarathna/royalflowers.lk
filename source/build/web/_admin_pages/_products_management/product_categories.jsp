<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%
    Session ses = conn.connector.getSessionFactory().openSession();
    Criteria cr = null;
%>
<div class="save-product-category-content"  >
    <div style="padding: 10px 0 5px 0; border-bottom: 1px solid #777; width: 180px;margin: 0 0 10px 10px;">Products Categories & Brands</div>
    <div class="sp_category sub_container_sp_mini" style="display: none;">
        <div class="sub_cont_header">
            Registration Main Categories
        </div>
        <div class="sub_cont_body" >
            <form id="savemcatform" >
                <input type="hidden" value="nb_vtx-cr455fg" name="pgx_vld">
                <input type="hidden" value="maincat" name="savec_type">
                <label>Name</label>
                <input type="text" name="spc_name">
                <input type="button" value="save" class="default-button" onclick=" formValidationsavecategory('savemcatform')">
                <a href="#">view list</a>
                <input type="hidden" name="hxf" value="msg-disx-savemcatform">
            </form>
            <div id="msg-disx-savemcatform" class="error_msg"></div>

        </div>
    </div>
    <div class="sp_category sub_container_sp_mini" style="height: 200px;" >
        <div class="sub_cont_header">
            Registration Sub Categories
        </div>
        <div class="sub_cont_body">
            <label>Select main category</label>
            <%
                cr = ses.createCriteria(pojo.Catagory.class);
                List<pojo.Catagory> list = cr.list();
            %>
            <select name="sp_sub_to_main_cat" id="main_cat_subcatpage" >
                <%
                    for (pojo.Catagory clist : list) {
                %>
                <option value="<%=clist.getIdcatagory()%>"><%=clist.getCatagory()%></option>
                <%
                    }
                %>
            </select>
            <form id="savesubcatfrom">
                <label>Name</label><input type="text" name="spc_name">
                <input type="button" value="save" class="default-button" onclick=" saveSubCat('savesubcatfrom','main_cat_subcatpage')">
                <a href="#">view list</a>
                <input type="hidden" name="hxf" value="msg-disx-savesubcatfrom">
            </form>
            <div id="msg-disx-savesubcatfrom" class="error_msg"></div>
        </div>
    </div>
    <div style="clear: both; padding: 10px 0 5px 0; border-bottom: 1px solid #777; width: 95px;margin: 0 0 10px 10px;"> Product Options</div>
    <div class="sp_category sub_container_sp_mini">
        <div class="sub_cont_header">
            Registration Product Brands
        </div>
        <div class="sub_cont_body">
            <form id="savebrand">
                <label>Name</label><input type="text" name="spc_name">
                <input type="hidden" value="catpbrand" name="savec_type">
                <input type="button" value="save" class="default-button" onclick=" formValidationsavecategory('savebrand')">
                <a href="#">view list</a>
                <input type="hidden" name="hxf" value="msg-disx-savebrand">
            </form>
            <div id="msg-disx-savebrand" class="error_msg"></div>
        </div>
    </div>

    <!--div class="sp_category sub_container_sp_mini" >
        <div class="sub_cont_header">
            Registration Product Types
        </div>
        <div class="sub_cont_body">
            <form id="savetype">
                <label>Name</label><input type="text" name="spc_name">
                <input type="hidden" value="catptype" name="savec_type">
                <input type="button" value="save" class="default-button" onclick=" formValidationsavecategory('savetype')">
                <a href="#">view list</a>
                <input type="hidden" name="hxf" value="msg-disx-savetype">
            </form>
            <div id="msg-disx-savetype" class="error_msg"></div>
        </div>
    </div-->
    <div class="sp_category sub_container_sp_mini" >
        <div class="sub_cont_header">
            Registration Product Colors
        </div>
        <div class="sub_cont_body">
            <form id="savecolor">
                <label>Name</label><input type="text" name="spc_name">
                <input type="hidden" value="catpcolor" name="savec_type">
                <input type="button" value="save" class="default-button" onclick=" formValidationsavecategory('savecolor')">
                <a href="#">view list</a>
                <input type="hidden" name="hxf" value="msg-disx-savecolor">
            </form>
            <div id="msg-disx-savecolor" class="error_msg"></div>
        </div>
    </div>
    <div style="width: 560px;overflow-x: auto; max-height: 200px;overflow-y: auto;"></div>


</div>