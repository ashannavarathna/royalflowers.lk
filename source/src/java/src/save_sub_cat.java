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
public class save_sub_cat extends HttpServlet {

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
            int catID = 0;
            String subcatname = "";
            String errcode = "";
            boolean flag_id_ok = false, flag_name_ok = false;
            if (request.getParameter("id_cat") == null) {
                flag_id_ok = false;
                out.write("0_select a any category");
            } else {
                catID = Integer.parseInt(request.getParameter("id_cat"));
                flag_id_ok = true;
            }

            if (request.getParameter("scat_name") == null) {
                flag_name_ok = false;
                out.write("0_name can not be empty");
            } else {
                if (request.getParameter("scat_name").length() > 1) {
                    subcatname = request.getParameter("scat_name");
                    flag_name_ok = true;
                } else {
                    flag_name_ok = false;
                    out.write("0_name empty or invalid");
                }
            }
            if (flag_id_ok && flag_name_ok) {
                Criteria cr = ses.createCriteria(pojo.SubCategory.class);
                pojo.Catagory mcategory = (pojo.Catagory) ses.load(pojo.Catagory.class, catID);

                cr.add(Restrictions.eq("subCategory", subcatname));
                cr.add(Restrictions.eq("catagory", mcategory));

                pojo.SubCategory subcat = (pojo.SubCategory) cr.uniqueResult();

                if (subcat != null) {
                    out.write("0_name already registered in this category");
                } else {
                    Transaction tr = ses.beginTransaction();
                    pojo.SubCategory sscat = new pojo.SubCategory();
                    sscat.setCatagory(mcategory);
                    sscat.setSubCategory(subcatname);

                    ses.save(sscat);
                    tr.commit();
                    ses.close();

                    out.write("1_save success");
                }

            } else {
                ses.close();

            }

        } catch (Exception e) {

            throw new ServletException("Exception : " + e);
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
        if (request.getParameter("pgx_vld") != null) {
            if (request.getParameter("pgx_vld").equals("svgcat_subpgx")) {
                processRequest(request, response);
            } else {
                response.sendRedirect("_error_404.jsp");
            }

        } else {
            response.sendRedirect("_error_404.jsp");
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
        if (request.getParameter("pgx_vld") != null) {
            if (request.getParameter("pgx_vld").equals("svgcat_subpgx")) {
                processRequest(request, response);
            } else {
                response.sendRedirect("_error_404.jsp");
            }

        } else {
            response.sendRedirect("_error_404.jsp");
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

}
