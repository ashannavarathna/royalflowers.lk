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
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ashan Nawarathna
 */
public class adloc_mng_admin extends HttpServlet {

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
            if (request.getParameter("dtd_load") != null && !request.getParameter("dtd_load").isEmpty()) {
                //retrving data from db
                Integer locid = Integer.valueOf(request.getParameter("loc_id"));
                pojo.AdvertisingLocation adloc = (pojo.AdvertisingLocation) ses.load(pojo.AdvertisingLocation.class, locid);

                out.write(adloc.getImgSize() + "_" + df.format(adloc.getPrice()) + "_" + df.format(adloc.getDiscount()));
            }

            if (request.getParameter("dtd_update") != null && !request.getParameter("dtd_update").isEmpty()) {
                //updating db
                Integer locid = Integer.valueOf(request.getParameter("loc_id"));
                double price = Double.valueOf(request.getParameter("price"));
                double dscnt = Double.valueOf(request.getParameter("dscnt"));

                Transaction trans = ses.beginTransaction();
                pojo.AdvertisingLocation adloc = (pojo.AdvertisingLocation) ses.load(pojo.AdvertisingLocation.class, locid);
                
                adloc.setPrice(price);
                adloc.setDiscount(dscnt);

                ses.save(adloc);
                trans.commit();
                out.write("1_update success");

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
