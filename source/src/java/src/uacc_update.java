/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.UserType;

/**
 *
 * @author Ashan Nawarathna
 */
public class uacc_update extends HttpServlet {

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
            Session ses = conn.connector.getSessionFactory().openSession();

            String email = "";
            if (request.getParameter("upemail") != null) {
                email = request.getParameter("upemail");
                int typeid = Integer.parseInt(request.getParameter("tid"));
                Criteria cr_user = ses.createCriteria(pojo.User.class);
                cr_user.add(Restrictions.eq("email", email));

                pojo.User user = (pojo.User) cr_user.uniqueResult();

                if (user != null) {
                    //checking the type of user account
                    int u_id = user.getUserType().getIduserType();
                    if (u_id == 3) {
                        //user user accout updating
                        Criteria cryx = ses.createCriteria(pojo.User.class);
                        pojo.UserType utypx = (pojo.UserType) ses.load(pojo.UserType.class, 3);
                        pojo.UserState ustatex = (pojo.UserState) ses.load(pojo.UserState.class, 1);
                        cryx.add(Restrictions.eq("userType", utypx));
                        cryx.add(Restrictions.eq("userState", ustatex));

                        List ulistx = cryx.list();
                        boolean _save_bx = true;
                        if (ulistx.size() > 0) {
                            if (ulistx.size() == 1) {
                                // if only one active super admin exixts
                                if (request.getParameter("save_type").equals("ustate")) {
                                    //if try to update sataus
                                    if (typeid != 1) {
                                        _save_bx = false;
                                    }
                                }
                                if (request.getParameter("save_type").equals("utype")) {
                                    //if try to update state
                                    if (typeid != 3) {
                                        _save_bx = false;
                                    }
                                }

                            }
                            if (_save_bx) {
                                //save can be done...  if satement in the below will excute
                                Transaction trx = ses.beginTransaction();
                                if (request.getParameter("save_type").equals("ustate")) {
                                    //if try to update sataus
                                    pojo.UserState us = (pojo.UserState) ses.load(pojo.UserState.class, typeid);
                                    user.setUserState(us);
                                }
                                if (request.getParameter("save_type").equals("utype")) {
                                    //if try to update state
                                    pojo.UserType utype = (pojo.UserType) ses.load(pojo.UserType.class, typeid);
                                    user.setUserType(utype);
                                }
                                ses.save(user);
                                trx.commit();
                                trx = null;

                                out.write("update success... relaod the page");
                            } else {
                                out.write("To do this update, Need atleast one active super addmin account");

                            }
                        } else {
                            out.write("Need atleas one active super user accoutn");
                        }

                    } else {
                        // normal user accout updating
                        Transaction trx = ses.beginTransaction();
                        if (request.getParameter("save_type").equals("ustate")) {
                            //if try to update sataus
                            pojo.UserState us = (pojo.UserState) ses.load(pojo.UserState.class, typeid);
                            user.setUserState(us);
                        }
                        if (request.getParameter("save_type").equals("utype")) {
                            //if try to update state
                            pojo.UserType utype = (pojo.UserType) ses.load(pojo.UserType.class, typeid);
                            user.setUserType(utype);
                        }
                        ses.save(user);
                        trx.commit();
                        trx = null;

                        out.write("update success... relaod the page");
                    }

                } else {
                    out.write("invalid email");
                    ses.close();
                }

                if (ses.isOpen()) {
                    ses.close();
                }

            } else {
                out.write("enter email address");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
