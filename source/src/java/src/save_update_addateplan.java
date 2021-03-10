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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.AdvertisingStatus;

/**
 *
 * @author Ashan Nawarathna
 */
public class save_update_addateplan extends HttpServlet {

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
            if (request.getParameter("pkgname") != null && !request.getParameter("pkgname").isEmpty()) {
                String pkg_name = request.getParameter("pkgname");

                Criteria crx = ses.createCriteria(pojo.AdvertisingDatePlans.class);
                crx.add(Restrictions.eq("pakage", pkg_name));
                pojo.AdvertisingDatePlans addateplan = (pojo.AdvertisingDatePlans) crx.uniqueResult();

                int datecount = 0;
                double price = 0;
                double dscnt = 0;

                if (request.getParameter("datecnt") != null && !request.getParameter("datecnt").isEmpty()) {
                    datecount = Integer.valueOf(request.getParameter("datecnt"));
                }

                if (request.getParameter("price") != null && !request.getParameter("price").isEmpty()) {
                    price = Double.valueOf(request.getParameter("price"));
                }

                if (request.getParameter("dscnt") != null && !request.getParameter("dscnt").isEmpty()) {
                    dscnt = Double.valueOf(request.getParameter("dscnt"));
                }

                if (addateplan == null) {
                    //new packge
                    Transaction tras = ses.beginTransaction();
                    addateplan = new pojo.AdvertisingDatePlans();
                    addateplan.setPakage(pkg_name);
                    addateplan.setDateCount(datecount);
                    addateplan.setPrice(price);
                    addateplan.setDiscount(dscnt);
                    addateplan.setAdvertisingStatus((AdvertisingStatus) ses.load(pojo.AdvertisingStatus.class, 1));

                    ses.save(addateplan);
                    tras.commit();
                    out.write("1_save success");

                } else {
                    //update a packge
                    if (request.getParameter("datecnt") == null || request.getParameter("datecnt").isEmpty()) {
                        datecount = addateplan.getDateCount();
                    } else {
                        datecount = Integer.valueOf(request.getParameter("datecnt"));
                    }

                    if (request.getParameter("price") == null || request.getParameter("price").isEmpty()) {
                        price = addateplan.getPrice();
                    } else {
                        price = Double.valueOf(request.getParameter("price"));
                    }

                    if (request.getParameter("dscnt") == null || request.getParameter("dscnt").isEmpty()) {
                        dscnt = addateplan.getDiscount();
                    } else {
                        dscnt = Double.valueOf(request.getParameter("dscnt"));
                    }

                    Transaction tras = ses.beginTransaction();
                    addateplan.setDateCount(datecount);
                    addateplan.setPrice(price);
                    addateplan.setDiscount(dscnt);
                    addateplan.setAdvertisingStatus((AdvertisingStatus) ses.load(pojo.AdvertisingStatus.class, 1));

                    ses.save(addateplan);
                    tras.commit();
                    out.write("1_package updated");

                }

            } else {
                out.write("0_name can not be empty");
            }

            ses.close();
        } catch (Exception e) {
            throw new ServletException("Err.." + e);
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
