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
import pojo.SubCategory;

/**
 *
 * @author Ashan Nawarathna
 */
public class Load_sub_category extends HttpServlet {

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
            int cat_id = Integer.parseInt(request.getParameter("mcat_id"));
            String resultarr = "";
            pojo.Catagory mcat = (pojo.Catagory) ses.load(pojo.Catagory.class, cat_id);
            Criteria cc = ses.createCriteria(pojo.SubCategory.class);
            cc.add(Restrictions.eq("catagory", mcat));
            List<pojo.SubCategory> list = cc.list();
            for (SubCategory list1 : list) {
                if (resultarr.equals("")) {
                    resultarr += list1.getIdsubCategory() + ":" + list1.getSubCategory();
                } else {
                    resultarr += "," + list1.getIdsubCategory() + ":" + list1.getSubCategory();
                }
            }
            ses.close();
            out.write(resultarr);
        } catch (Exception e) {
            throw new ServletException("Err.. : " + e);
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
            if (request.getParameter("pgx_vld").equals("ldcat14525subpgx")) {
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
            if (request.getParameter("pgx_vld").equals("ldcat14525subpgx")) {
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
