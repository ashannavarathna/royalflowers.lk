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
public class save_product_category extends HttpServlet {

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

            //checcked for input value is empty
            if (request.getParameter("spc_name") == null || request.getParameter("spc_name").length() == 0) {
                out.write("0_100101");
            } else if (request.getParameter("spc_name").length() > 40) {
                //if the name is too long
                out.write("0_1001010");
            } else {
                String svg_msg = saveCategories(request.getParameter("savec_type"), request.getParameter("spc_name"));

                if (svg_msg.equals("1001015")) {
                    //cat already registered   
                    out.write("0_1001015");
                } else if (svg_msg.equals("200101")) {
                    //if save success
                    out.write("1_200101");
                }

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
        if (request.getParameter("pgx_vld") == null) {
            response.sendRedirect("_pages_container/_error_404.jsp");

        } else {
            processRequest(request, response);
        }

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
        if (request.getParameter("pgx_vld") == null) {
            response.sendRedirect("_pages_container/_error_404.jsp");

        } else {
            processRequest(request, response);
        }
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

    private String saveCategories(String cat_type, String cat_name) {
        Session ses = conn.connector.getSessionFactory().openSession();
        Transaction trans = null;
        try {
            Criteria cr = null;
            if (cat_type.equals("maincat")) {
                cr = ses.createCriteria(pojo.Catagory.class);
                cr.add(Restrictions.eq("catagory", cat_name));
                pojo.Catagory mcat = (pojo.Catagory) cr.uniqueResult();
                if (mcat != null) {
                    return "1001015";
                } else {
                    trans = ses.beginTransaction();
                    mcat = new pojo.Catagory();
                    mcat.setCatagory(cat_name);

                    ses.save(mcat);
                    trans.commit();
                }

            } else if (cat_type.equals("catpbrand")) {
                cr = ses.createCriteria(pojo.Brand.class);
                cr.add(Restrictions.eq("brandName", cat_name));
                pojo.Brand brand = (pojo.Brand) cr.uniqueResult();

                if (brand != null) {
                    return "1001015";
                } else {
                    trans = ses.beginTransaction();
                    brand = new pojo.Brand();
                    brand.setBrandName(cat_name);

                    ses.save(brand);
                    trans.commit();
                }

            } else if (cat_type.equals("catpcolor")) {
                cr = ses.createCriteria(pojo.ProductColor.class);
                cr.add(Restrictions.eq("color", cat_name));
                pojo.ProductColor pcolor = (pojo.ProductColor) cr.uniqueResult();

                if (pcolor != null) {
                    return "1001015";
                } else {
                    trans = ses.beginTransaction();
                    pcolor = new pojo.ProductColor();
                    pcolor.setColor(cat_name);

                    ses.save(pcolor);
                    trans.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "100100";
        }

        trans = null;
        ses.close();

        return "200101";
    }

}
