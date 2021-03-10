/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ashan Nawarathna
 */
public class load_ads_prices_usr extends HttpServlet {

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
            DecimalFormat df = new DecimalFormat("0.00");
            //load data from ad location info
            if (request.getParameter("ad_l") != null && !request.getParameter("ad_l").isEmpty()) {
                pojo.AdvertisingLocation adloc = (pojo.AdvertisingLocation) ses.load(pojo.AdvertisingLocation.class, Integer.valueOf(request.getParameter("ad_l")));
                double price = adloc.getPrice();
                double dscnt = adloc.getDiscount();
                String imgsize = adloc.getImgSize();

                String nprice = df.format(price - dscnt);

                out.write("ad-l_" + nprice + "_" + imgsize);
            }

            //load adata form ad plan info
            if (request.getParameter("ad_p") != null && !request.getParameter("ad_p").isEmpty()) {
                pojo.AdvertisingDatePlans adpkg = (pojo.AdvertisingDatePlans) ses.load(pojo.AdvertisingDatePlans.class, Integer.valueOf(request.getParameter("ad_p")));
                double price = adpkg.getPrice();
                double dscnt = adpkg.getDiscount();

                String nprice = df.format(price - dscnt);

                out.write("ad-p_" + nprice + "_no-img");

            }
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
