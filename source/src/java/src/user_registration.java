/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import classes._check_email_exists;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author x
 */
public class user_registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("pptap_isrex_") == null) {
                response.sendRedirect("_pages_container/_error_404.jsp");

            } else {
                String outmsg = "";
                Session ses = conn.connector.getSessionFactory().openSession();

                boolean filed_filed = false;
                String fname = "", lname = "", email = "", nwpass = "", cnfrmpass = "", contry = "";

                if (request.getParameter("f_name") != null) {
                    fname = request.getParameter("f_name");

                } else {

                }

                if (request.getParameter("l_name") != null) {
                    lname = request.getParameter("l_name");

                } else {

                }

                if (request.getParameter("e_mail") != null) {
                    email = request.getParameter("e_mail");

                    Criteria cxd = ses.createCriteria(pojo.User.class);
                    cxd.add(Restrictions.eq("email", email));
                    pojo.User uss = (pojo.User) cxd.uniqueResult();
                    if (uss == null) {
                        // no user exist
                        filed_filed = true;
                    } else {
                        // user exits
                        filed_filed = false;
                        outmsg = "Email alreday registered";
                    }

                } else {

                }

                if (request.getParameter("n_pass") != null) {
                    nwpass = request.getParameter("n_pass");

                } else {

                }

                if (request.getParameter("c_pass") != null) {
                    cnfrmpass = request.getParameter("c_pass");

                } else {

                }

                if (request.getParameter("country") != null) {
                    contry = request.getParameter("country");

                } else {

                }

                String[] dataFields = {fname, lname, email, nwpass, cnfrmpass, contry};
                for (int i = 0; i < dataFields.length; i++) {
                    if (!dataFields[i].equals("")) {
                        //valid
                    } else {
                        filed_filed = false;
                        outmsg = "invalid input";
                    }
                }

                if (filed_filed) {

                    String encpsw_new = classes._32CodeGen.codeGenarator(nwpass);
                    Transaction trans = ses.beginTransaction();
                    pojo.User user = new pojo.User();

                    user.setFname(fname);
                    user.setLname(lname);
                    user.setEmail(email);
                    user.setPCode(encpsw_new);
                    user.setCountry(contry);
                    pojo.UserType ut = (pojo.UserType) ses.load(pojo.UserType.class, 2);
                    pojo.UserState ustate = (pojo.UserState) ses.load(pojo.UserState.class, 2);
                    user.setUserType(ut);
                    user.setUserState(ustate);

                    ses.save(user);
                    trans.commit();
                    ses.close();
                    out.write("1_success");
                } else {
                    out.write("0_" + outmsg);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("_pages_container/_error_500.jsp?msg=" + e);
            throw new ServletException(e);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
