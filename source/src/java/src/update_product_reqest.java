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
import pojo.ProductHasVendors;
import pojo.ProductRequestStatus;
import pojo.Vendors;

/**
 *
 * @author Ashan Nawarathna
 */
public class update_product_reqest extends HttpServlet {

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

            if (request.getParameter("pcode") != null && !request.getParameter("pcode").isEmpty()) {

                Criteria productcry = ses.createCriteria(pojo.Product.class);
                productcry.add(Restrictions.eq("productCode", request.getParameter("pcode")));
                pojo.Product product = (pojo.Product) productcry.uniqueResult();

                Criteria phvcry = ses.createCriteria(pojo.ProductHasVendors.class);
                phvcry.add(Restrictions.eq("product", product));

                pojo.ProductHasVendors phv = (pojo.ProductHasVendors) phvcry.uniqueResult();

                //getting 3 objects
                pojo.Vendors vendor = null;
                pojo.ProductRequestStatus producrequeststatus = null;
                String reqestquantity = "";

                //validating 3 parameters
                if (request.getParameter("vid") != null && !request.getParameter("vid").equals("0")) {
                    int id = Integer.parseInt(request.getParameter("vid"));
                    vendor = (Vendors) ses.load(pojo.Vendors.class, id);
                }
                if (request.getParameter("reqsid") != null && !request.getParameter("reqsid").equals("0")) {
                    int id = Integer.parseInt(request.getParameter("reqsid"));
                    producrequeststatus = (ProductRequestStatus) ses.load(pojo.ProductRequestStatus.class, id);
                }

                if (request.getParameter("reqqty") != null && !request.getParameter("reqqty").equals("0")) {
                    reqestquantity = request.getParameter("reqqty");
                }

                if (phv == null) {
                    // adding a new prodcut to phv

                    //validation befor add data
                    if (vendor != null) {
                        if (producrequeststatus != null) {
                            Transaction trans = ses.beginTransaction();
                            phv = new ProductHasVendors();
                            phv.setProduct(product);
                            phv.setVendors(vendor);
                            phv.setProductRequestStatus(producrequeststatus);
                            phv.setRequestQuantity(reqestquantity);

                            ses.save(phv);
                            trans.commit();
                            ses.flush();
                            out.write("1_update success");

                        } else {
                            out.write("0_select a prodcut request status");
                        }
                    } else {
                        out.write("0_select a vendor");
                    }

                } else {
                    //do update for existing product
                    Transaction trans = ses.beginTransaction();
                    //updating as passed values
                    if (vendor != null) {
                        phv.setVendors(vendor);
                    }

                    if (producrequeststatus != null) {
                        phv.setProductRequestStatus(producrequeststatus);
                    }
                    if (!reqestquantity.equals("")) {
                        phv.setRequestQuantity(reqestquantity);
                    }

                    ses.update(phv);
                    trans.commit();
                    ses.flush();

                    out.write("1_update success");

                }

            } else {
                //if pcode is emtpy
                out.write("0_enter product code");
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
