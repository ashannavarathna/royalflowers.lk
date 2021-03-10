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

/**
 *
 * @author Ashna Nawarathna
 */
public class Category_Loader extends HttpServlet {

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
            try {
                Criteria cr = null;
                String dataarr = "";

                if (request.getParameter("cat_type").equals("mcat")) {
                    cr = ses.createCriteria(pojo.Catagory.class);
                    List<pojo.Catagory> list = cr.list();
                    for (pojo.Catagory list1 : list) {
                        if (dataarr.equals("")) {
                            dataarr += list1.getCatagory() + ":" + list1.getIdcatagory();
                        } else {
                            dataarr += "," + list1.getCatagory() + ":" + list1.getIdcatagory();
                        }
                    }

                } else if (request.getParameter("cat_type").equals("pbrande")) {
                    cr = ses.createCriteria(pojo.Brand.class);
                    List<pojo.Brand> list = cr.list();
                    for (pojo.Brand list1 : list) {
                        if (dataarr.equals("")) {
                            dataarr += list1.getBrandName() + ":" + list1.getIdbrand();
                        } else {
                            dataarr += "," + list1.getBrandName() + ":" + list1.getIdbrand();
                        }
                    }

                } else if (request.getParameter("cat_type").equals("pcolor")) {
                    cr = ses.createCriteria(pojo.ProductColor.class);
                    List<pojo.ProductColor> list = cr.list();
                    for (pojo.ProductColor list1 : list) {
                        if (dataarr.equals("")) {
                            dataarr += list1.getColor() + ":" + list1.getIdcolor();
                        } else {
                            dataarr += "," + list1.getColor() + ":" + list1.getIdcolor();
                        }
                    }

                }
                out.write(dataarr);
                cr = null;
                ses.close();

            } catch (Exception e) {
                response.sendRedirect("_error_500.jsp");
                throw new ServletException(e);
            }

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
            response.sendRedirect("_error_404.jsp");

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
            response.sendRedirect("_error_404.jsp");

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

}
