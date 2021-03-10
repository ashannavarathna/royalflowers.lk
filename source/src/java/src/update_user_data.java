/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ashan Nawarathna
 */
public class update_user_data extends HttpServlet {

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
            if (request.getSession().getAttribute("user-id") != null) {
                Integer uid = (Integer) request.getSession().getAttribute("user-id");

                Session sess = conn.connector.getSessionFactory().openSession();
                pojo.User user = (pojo.User) sess.load(pojo.User.class, uid);
                Transaction trns = sess.beginTransaction();
                if (request.getParameter("fanme") != null) {
                    user.setFname(request.getParameter("fname"));
                    System.out.println("hiii");
                }
                if (request.getParameter("lname") != null) {
                    user.setLname(request.getParameter("lname"));
                }
                if (request.getParameter("lan_cnt") != null) {
                    user.setTelephone(request.getParameter("lan_cnt"));
                }
                if (request.getParameter("m_cnt") != null) {
                    user.setMobile(request.getParameter("m_cnt"));
                }
                if (request.getParameter("add1") != null) {
                    user.setAddress1(request.getParameter("add1"));
                }
                if (request.getParameter("add2") != null) {
                    user.setAddress2(request.getParameter("add2"));
                }
                if (request.getParameter("add3") != null) {
                    user.setAddress3(request.getParameter("add3"));
                }
                if (request.getParameter("ucity") != null) {
                    user.setCity(request.getParameter("ucity"));
                }
                if (request.getParameter("dstrct") != null) {
                    user.setDistrict(request.getParameter("dstrct"));
                }

                sess.save(user);
                trns.commit();;
                sess.close();
                trns = null;

                response.sendRedirect("user_profile.jsp?msg=successfully updated user data");

            } else {
                response.sendRedirect("signin.jsp");
            }

        } catch (Exception e) {
            throw new ServerException("Err.. " + e);
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
