/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class load_prohasvendors extends HttpServlet {

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
            Criteria cr = ses.createCriteria(pojo.ProductHasVendors.class);
            if (request.getParameter("prqid") != null && !request.getParameter("prqid").isEmpty()) {
                int id = Integer.parseInt(request.getParameter("prqid"));
                pojo.ProductRequestStatus prstate = (pojo.ProductRequestStatus) ses.load(pojo.ProductRequestStatus.class, id);
                cr.add(Restrictions.eq("productRequestStatus", prstate));
            }

            List<pojo.ProductHasVendors> list = cr.list();
            if (list.size() == 0) {
                out.write("0||No result found");
            } else {
                StringBuffer sbf = new StringBuffer();
                for (pojo.ProductHasVendors phv : list) {
                    String name = phv.getProduct().getName();
                    String pcode = phv.getProduct().getProductCode();
                    String vendor = phv.getVendors().getName();
                    String reqty = phv.getRequestQuantity();
                    int avqty = phv.getProduct().getQty();
                    String status = phv.getProductRequestStatus().getStatus();

                    String params = name + "," + pcode + "," + vendor + "," + reqty + "," + avqty + "," + status;
                    if (sbf.length() == 0) {
                        sbf.append(params);
                    } else {
                        sbf.append(";");
                        sbf.append(params);

                    }
                }
                out.write("1||" + sbf.toString());
            }

            ses.close();
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
