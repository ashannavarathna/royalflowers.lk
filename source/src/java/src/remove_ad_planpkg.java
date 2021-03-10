/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ashan Nawarathna
 */
public class remove_ad_planpkg extends HttpServlet {

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
            if (request.getParameter("planid") != null && !request.getParameter("planid").isEmpty()) {
                String planid = request.getParameter("planid");
                Session ses = conn.connector.getSessionFactory().openSession();
                pojo.AdvertisingDatePlans adplan = (pojo.AdvertisingDatePlans) ses.load(pojo.AdvertisingDatePlans.class, Integer.valueOf(planid));
                pojo.AdvertisingStatus adstate = (pojo.AdvertisingStatus) ses.load(pojo.AdvertisingStatus.class, 2);
                if (adplan != null) {
                    Transaction trns = ses.beginTransaction();
                    adplan.setAdvertisingStatus(adstate);
                    ses.save(adplan);
                    trns.commit();
                    ses.close();
                    out.write("1_Package removed");

                } else {
                    out.write("0_un registerd packge");
                }
            } else {
                out.write("0_packge not fount found");
            }

        } catch (Exception e) {
            throw new ServletException("Err.. " + e);
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
