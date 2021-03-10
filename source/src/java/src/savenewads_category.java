/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import com.sun.xml.xsom.impl.RestrictionSimpleTypeImpl;
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

/**
 *
 * @author Ashan Nawarathna
 */
public class savenewads_category extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                String name = request.getParameter("name");
                Session ses = conn.connector.getSessionFactory().openSession();
                Criteria cry = ses.createCriteria(pojo.AdvertisingCategory.class);
                cry.add(Restrictions.eq("category", name));

                pojo.AdvertisingCategory adcat = (pojo.AdvertisingCategory) cry.uniqueResult();
                pojo.AdvertisingStatus adstate = (pojo.AdvertisingStatus) ses.load(pojo.AdvertisingStatus.class, 1);
                if (adcat == null) { 
                    //System.out.println("here");
                    Transaction trns = ses.beginTransaction();
                    adcat = new pojo.AdvertisingCategory();
                    adcat.setCategory(name);
                    adcat.setAdvertisingStatus(adstate);
                    ses.save(adcat);
                    trns.commit();
                    ses.close();
                    out.write("1_save success");

                } else {
                    Transaction trns = ses.beginTransaction();
                    adcat.setAdvertisingStatus(adstate);
                    ses.save(adcat);
                    trns.commit();
                    ses.close();
                    out.write("1_Category updated");
                }

            } else {
                out.write("0_Enter category to save");
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
