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

/**
 *
 * @author Ashan Nawarathna
 */
public class Stockupdate extends HttpServlet {

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

            String pcode = "";
            if (request.getParameter("pcode") != null) {
                pcode = request.getParameter("pcode");
                boolean validnum = true;
                Criteria cr_prodcut = ses.createCriteria(pojo.Product.class);
                cr_prodcut.add(Restrictions.eq("productCode", pcode));

                pojo.Product productx = (pojo.Product) cr_prodcut.uniqueResult();

                if (productx != null) {

                    Transaction trx = ses.beginTransaction();
                    //out.write("tans");
                    if (request.getParameter("price") != null && !request.getParameter("price").isEmpty()) {
                        if (classes.numFormater.isPositveNum(request.getParameter("price"))) {
                            double price = Double.parseDouble(request.getParameter("price"));
                            productx.setPrice(price);
                        } else {
                            validnum = false;
                        }
                    }
                    if (request.getParameter("dsnt") != null && !request.getParameter("dsnt").isEmpty()) {
                        if (classes.numFormater.isPositveNum(request.getParameter("dsnt"))) {
                            double discount = Double.parseDouble(request.getParameter("dsnt"));
                            productx.setDiscount(discount);
                        } else {
                            validnum = false;
                        }

                    }
                    if (request.getParameter("qty") != null && !request.getParameter("qty").isEmpty()) {
                        if (!classes.numFormater.isAPositiveDecimal(request.getParameter("qty"))) {
                            int qty = Integer.parseInt(request.getParameter("qty"));
                            productx.setQty(qty);
                        } else {
                            validnum = false;
                        }

                    }

                    if (validnum) {
                        //out.write("vlaid");

                        ses.save(productx);
                        trx.commit();
                        trx = null;

                        out.write("update success... relaod the page");

                    } else {
                        out.write("invalid number format");
                    }

                } else {
                    out.write("no prodcut found for this code");
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
