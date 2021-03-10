/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
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
 * @author Ashan Nawarathna
 */
public class user_activate extends HttpServlet {

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

            if (request.getParameter("mail_code") == null || request.getParameter("mail_code").isEmpty()) {
                //no code found
                out.write("200450");
            } else {
                String ac_code = "";
                String hs_code = "";
                if (request.getParameter("mail_code") != null) {
                    ac_code = request.getParameter("mail_code");
                    //System.out.println(ac_code);
                } else {
                    System.out.println("ac null");
                }
                if (request.getSession().getAttribute("account-activate-info") != null) {
                    hs_code = (String) request.getSession().getAttribute("account-activate-info");
                    //System.out.println(hs_code);
                } else {
                    System.out.println("hc null");
                }
                System.out.println(hs_code.equals("" + ac_code));
                boolean flagequal = hs_code.equals("" + ac_code);
                System.out.println(flagequal);
                if (flagequal) {
                    //code match
                    Session sesuac = conn.connector.getSessionFactory().openSession();
                    Criteria crrx = sesuac.createCriteria(pojo.User.class);
                    crrx.add(Restrictions.eq("email", request.getParameter("email")));
                    pojo.User user = (pojo.User) crrx.uniqueResult();
                    if (user.getUserState().getIduserState() == 2) {
                        Criteria x = sesuac.createCriteria(pojo.UserState.class);
                        x.add(Restrictions.eq("iduserState", 1));
                        pojo.UserState us = (pojo.UserState) x.uniqueResult();
                        Transaction tr = sesuac.beginTransaction();
                        user.setUserState(us);
                        sesuac.save(user);
                        tr.commit();
                        tr = null;
                        sesuac.close();
                        request.getSession().removeAttribute("account-activate-info");

                        out.write("200451");

                    } else {
                        //already activated
                        sesuac.close();
                        out.write("200453");
                    }

                } else {
                    //code not match
                    out.write("200452");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("Err.. " + e);
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
