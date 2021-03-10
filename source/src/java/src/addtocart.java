/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author Ashan Nawarathna
 */
public class addtocart extends HttpServlet {

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
                response.sendRedirect("index.jsp");
            }

            int pid = Integer.parseInt(request.getParameter("pid"));
            int userqty = 0;
            Session sescart = conn.connector.getSessionFactory().openSession();
            pojo.Product prodcut = (pojo.Product) sescart.load(pojo.Product.class, pid);

            //check prodcut availability
            if (prodcut.getPStatus().getIdpStatus() == 2) {
                /// prodcut not avalible
                sescart.close();
                response.sendRedirect("product_details.jsp?err=2202&pcode=" + prodcut.getProductCode());
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
                    String pcd =  prodcut.getProductCode();
                    sescart.close();
                    response.sendRedirect("product_details.jsp?err=2203&pcode=" +pcd);
                } else {
                    if (prodcut.getQty() < userqty) {
                        String pcd =  prodcut.getProductCode();
                        sescart.close();
                        response.sendRedirect("product_details.jsp?err=2204&pcode=" + pcd);
                    } else {
                        //input validation success
                        flag_cart_update = true;
                    }
                }
            } else {
                String pcd =  prodcut.getProductCode();
                sescart.close();
                response.sendRedirect("product_details.jsp?err=2201&pcode=" + pcd);
            }

            boolean succes_cart = true;
            if (flag_cart_update) {
                if (request.getSession().getAttribute("s_cart") == null) {
                    // if cart no cart presnt
                    int[] cartdata = new int[2];
                    cartdata[0] = pid;
                    cartdata[1] = userqty;

                    List<int[]> cart = new ArrayList();

                    cart.add(cartdata);

                    request.getSession().setAttribute("s_cart", cart);
                } else {
                    // if has a cart... so updating cart

                    List<int[]> cart = (ArrayList) request.getSession().getAttribute("s_cart");
                    boolean duplicated = false;
                    int dupindex = 0;
                    for (int i = 0; i < cart.size(); i++) {
                        int[] oldi = cart.get(i);
                        if (oldi[0] == pid) {
                            // already exsits
                            duplicated = true;
                            dupindex = i;
                            break;
                        }
                    }

                    if (!duplicated) {
                        int[] cartdata = new int[2];
                        cartdata[0] = pid;
                        cartdata[1] = userqty;

                        cart.add(cartdata);
                    } else {
                        //if duplicated item found
                        int[] olist = cart.get(dupindex);

                        int totalquantity = userqty + olist[1];
                        if (totalquantity > classes.CurrentQuantity.getCurrentQty(prodcut.getProductCode())) {
                            //can not issue quantity
                            String pcd =  prodcut.getProductCode();
                            sescart.close();
                            response.sendRedirect("product_details.jsp?err=2204&pcode=" + pcd);
                            return;
                        } else {
                            olist[1] = totalquantity;
                            cart.set(dupindex, olist);
                        }

                    }
                    request.getSession().setAttribute("s_cart", cart);
                }
                sescart.close();
                response.sendRedirect("cart.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }finally{
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
