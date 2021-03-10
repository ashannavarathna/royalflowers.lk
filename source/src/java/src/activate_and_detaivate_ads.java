/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class activate_and_detaivate_ads extends HttpServlet {

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
            if (request.getParameter("adid") != null && request.getParameter("statusid") != null) {
                int adid = Integer.parseInt(request.getParameter("adid"));
                int statusid = Integer.parseInt(request.getParameter("statusid"));
                Session ses = conn.connector.getSessionFactory().openSession();

                Transaction trns = ses.beginTransaction();
                pojo.Advertising adobj = (pojo.Advertising) ses.load(pojo.Advertising.class, adid);
                pojo.AdvertisingStatus adsatusobj = (pojo.AdvertisingStatus) ses.load(pojo.AdvertisingStatus.class, statusid);
                Date today = new Date();
                if (statusid == 1) {
                    adobj.setOnDate(today);
                    adobj.setAdvertisingStatus(adsatusobj);
                    ses.save(adobj);
                    trns.commit();
                    ses.flush();
                    ses.close();
                    out.write("1_ad activated");
                } else if (statusid == 2) {
                    adobj.setAdvertisingStatus(adsatusobj);
                    ses.save(adobj);
                    trns.commit();
                    ses.flush();
                    ses.close();
                    out.write("1_ad removed");

                } else if (statusid == 4) {
                    adobj.setAdvertisingStatus(adsatusobj);
                    ses.save(adobj);
                    trns.commit();
                    ses.flush();
                    ses.close();
                    out.write("1_ad discard");

                }
            } else {
                out.write("0_empty para meters");
            }

        } catch (Exception e) {
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
