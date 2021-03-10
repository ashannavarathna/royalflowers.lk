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

/**
 *
 * @author Ashan Nawarathna
 */
public class getDeliveryPerkmCosting extends HttpServlet {

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
            if (request.getParameter("dplnid") == null || request.getParameter("dplnid").isEmpty()) {
                out.write("select a delivery plan");
            } else {
                int dplanid = Integer.parseInt(request.getParameter("dplnid"));
                double distance = Double.parseDouble(request.getParameter("dsnt"));
                
                Session ses = conn.connector.getSessionFactory().openSession();
                pojo.DeliveryPlan dplan = (pojo.DeliveryPlan) ses.load(pojo.DeliveryPlan.class, dplanid);
                DecimalFormat df = new DecimalFormat();
                if (distance < 10) {
                    out.write(df.format(dplan.getK10()) + "");
                } else if (distance < 50) {
                    out.write(df.format(dplan.getK50()) + "");
                    
                } else if (distance < 100) {
                    out.write(df.format(dplan.getK100()) + "");
                    
                } else if (distance > 100) {
                    out.write(df.format(dplan.getK100up()) + "");
                    
                } else {
                    // invalid distance
                }
                
                ses.close();
                
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
