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
public class Update_delivery extends HttpServlet {

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
            if (request.getParameter("dcode") != null && !request.getParameter("dcode").isEmpty()) {
                String dcode = request.getParameter("dcode");
                Session sex = conn.connector.getSessionFactory().openSession();
                Criteria cryinvo = sex.createCriteria(pojo.Invoice.class);
                cryinvo.add(Restrictions.eq("invoiceNum", dcode));

                pojo.Invoice invo = (pojo.Invoice) cryinvo.uniqueResult();

                if (invo != null) {
                    Transaction trnas = sex.beginTransaction();
                    Criteria cry = sex.createCriteria(pojo.Delivery.class);
                    cry.add(Restrictions.eq("invoice", invo));

                    pojo.Delivery dlv = (pojo.Delivery) cry.uniqueResult();
                    dlv.setState("deliverd");
                    sex.save(dlv);
                    trnas.commit();
                    trnas = null;
                    out.write("Update Success");

                } else {
                    out.write("no develivery fount for this number");
                }
                sex.close();

            } else {
                out.write("Enter invoice number");
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
