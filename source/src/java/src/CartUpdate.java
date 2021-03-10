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
import org.hibernate.Session;

/**
 *
 * @author Ashan Nawarathna
 */
public class CartUpdate extends HttpServlet {

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
            if (request.getParameter("pid") == null) {
                response.sendRedirect("cart.jsp");
            }
            //System.out.println("ook");
            int pid = Integer.parseInt(request.getParameter("pid"));
            int userqty = 0;
            Session sescart = conn.connector.getSessionFactory().openSession();
            pojo.Product prodcut = (pojo.Product) sescart.load(pojo.Product.class, pid);

            //check prodcut availability
            if (prodcut.getPStatus().getIdpStatus() == 2) {
                /// prodcut not avalible
                String pcd = prodcut.getProductCode();
                sescart.close();
                response.sendRedirect("cart.jsp?err=2202&pcode=" + pcd);
            }

            //checking quantity validation
            String qty = request.getParameter("uqty");
            boolean qty_valid = true;
            for (int i = 0; i < qty.length(); i++) {
                if (!Character.isDigit(qty.charAt(i))) {
                    // not a posivte number
                    qty_valid = false;
                }
            }
            if (!classes.numFormater.isPositveNum(request.getParameter("uqty"))) {
                // not a posivte number
                qty_valid = false;
            }

            boolean flag_cart_update = false;

            if (qty_valid) {
                userqty = Integer.parseInt(request.getParameter("uqty"));

                //checking quantity
                if (userqty <= 0) {
                    qty_valid = false;
                    String pcd = prodcut.getProductCode();
                    sescart.close();
                    response.sendRedirect("cart.jsp?err=2203&pcode=" + pcd);
                } else {
                    if (prodcut.getQty() < userqty) {
                        String pcd = prodcut.getProductCode();
                        sescart.close();
                        response.sendRedirect("cart.jsp?err=2204&pcode=" + pcd);
                    } else {
                        //input validation success
                        flag_cart_update = true;
                    }
                }
            } else {
                String pcd = prodcut.getProductCode();
                sescart.close();
                response.sendRedirect("cart.jsp?err=2201&pcode=" + pcd);
            }

            boolean succes_cart = true;
            if (flag_cart_update) {
                List<int[]> cart = (ArrayList) request.getSession().getAttribute("s_cart");
                for (int x = 0; x < cart.size(); x++) {
                    int[] item = cart.get(x);
                    if (prodcut.getIdproduct() == item[0]) {
                        //quantity minimize
                        int totalqty = userqty;
                        if (totalqty > 0) {
                            item[1] = totalqty;
                            cart.set(x, item);
                        } else if (totalqty <= classes.CurrentQuantity.getCurrentQty(request.getParameter("pcode"))) {
                            item[1] = totalqty;
                            cart.set(x, item);
                        } else {
                            //can not update
                        }

                        break;
                    }
                }
                request.getSession().setAttribute("s_cart", cart);

                sescart.close();
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
