/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class removeFromCart extends HttpServlet {

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
            if (request.getParameter("pcode") == null || request.getParameter("pcode").isEmpty()) {
                response.sendRedirect("cart.jsp");
            } else {
                Session ses = conn.connector.getSessionFactory().openSession();
                Criteria crr = ses.createCriteria(pojo.Product.class);
                crr.add(Restrictions.eq("productCode", request.getParameter("pcode")));
                pojo.Product product = (pojo.Product) crr.uniqueResult();

                List<int[]> cart = (ArrayList) request.getSession().getAttribute("s_cart");
                int dupindex = 0;

                //read all cart data
                for (int i = 0; i < cart.size(); i++) {
                    int[] item = cart.get(i);

                    //get current product
                    if (product.getIdproduct() == item[0]) {
                        //remove product
                        cart.remove(i);
                        break;
                    }
                }
                if (cart.size() == 0) {
                    request.getSession().removeAttribute("s_cart");
                } else {
                    request.getSession().setAttribute("s_cart", cart);
                }
                ses.close();
                response.sendRedirect("cart.jsp");

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException();
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
