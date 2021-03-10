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
import org.hibernate.Session;

/**
 *
 * @author Ashan Nawarathna
 */
public class admin_login extends HttpServlet {

    private static String sadminunme = "dev_admin";
    private static String sadminupass = "bb1";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(final HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("ixadminreq") == null) {
                //if request come direclty to the servlet
                response.sendRedirect("_pages_container/_error_404.jsp");
            } else {
                boolean flagAdmin = false;
                boolean flagSuperadmin = false;
                String username = "";
                String psw = "";

                Integer uid = (Integer) request.getSession().getAttribute("user-id");
                Session sesulogcpl = conn.connector.getSessionFactory().openSession();

                pojo.User user = (pojo.User) sesulogcpl.load(pojo.User.class, uid);

                if (user.getUserType().getIduserType() == 1) {
                    //admin
                    flagAdmin = true;
                    flagSuperadmin = false;

                } else if (user.getUserType().getIduserType() == 3) {
                    //super admin
                    flagAdmin = true;
                    flagSuperadmin = true;

                } else {
                    //normal user
                    flagAdmin = false;
                    flagSuperadmin = false;

                }

                sesulogcpl.close();

                if (flagAdmin) {
                    if ((request.getParameter("unadmin") != null && request.getParameter("upswadmin") != null) && (!request.getParameter("unadmin").isEmpty() && !request.getParameter("upswadmin").isEmpty())) {
                        username = request.getParameter("unadmin");
                        psw = request.getParameter("upswadmin");
                        String encpsw_new = classes._32CodeGen.codeGenarator(psw);
                        //static user login
                        if (username.equals(user.getEmail())) {
                            if (encpsw_new.equals(user.getPCode())) {
                                response.sendRedirect("dashboard.jsp");
                                request.getSession().setMaxInactiveInterval(60 * 5);
                            } else {
                                response.sendRedirect("cpanel.jsp?serverMsg=0_1542");
                            }
                        } else if (false) {

                        } else {
                            response.sendRedirect("cpanel.jsp?serverMsg=0_1542");
                        }
                    } else {
                        response.sendRedirect("cpanel.jsp?serverMsg=0_1544");
                    }
                } else {
                    response.sendRedirect("cpanel.jsp?serverMsg=0_1550");
                }

            }

        } catch (Exception e) {
            System.out.println(e);
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
