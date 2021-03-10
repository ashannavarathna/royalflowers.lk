/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author x
 */
public class user_login extends HttpServlet {

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
           // System.out.println(request.getRequestURI());
            //System.out.println(request.getRequestURL());
            RequestDispatcher rd = request.getRequestDispatcher("signup.sjp");

            if (request.getParameter("usrxttp") == null) {
                response.sendRedirect("_pages_container/_error_404.jsp");
            } else {
                Session ses = conn.connector.getSessionFactory().openSession();
                if (request.getSession().getAttribute("user-id") == null) {
                    if (request.getParameter("usr_email") != null && request.getParameter("usr_psw") != null) {
                        String u_mail = request.getParameter("usr_email");
                        String u_psw = request.getParameter("usr_psw");
                        String encpsw_new = classes._32CodeGen.codeGenarator(u_psw);
                        Criteria c = ses.createCriteria(pojo.User.class);

                        c.add(Restrictions.eq("email", u_mail));
                        c.add(Restrictions.eq("PCode", encpsw_new));

                        pojo.User user = (pojo.User) c.uniqueResult();

                        if (user != null) {
                            pojo.UserState us = (pojo.UserState) ses.load(pojo.UserState.class, user.getUserState().getIduserState());
                            if (us.getIduserState() == 1) {
                                HttpSession hs = request.getSession();
                                hs.setAttribute("user-id", user.getIduser());
                                ses.close();
                                response.sendRedirect("index.jsp");
                                //login success

                            } else if (us.getIduserState() == 2) {
                                String hashcode = classes._32CodeGen.codeGenarator(System.currentTimeMillis() + "" + user.getFname());
                                classes._sendEmails.sendHTMLMail(user.getEmail(), "Verification Code", hashcode);
                                request.getSession().setAttribute("account-activate-info", hashcode);
                                HttpSession hs = request.getSession();
                                hs.setAttribute("user-id", user.getIduser());
                                ses.close();

                                response.sendRedirect("email_verification.jsp");
                                //account activation

                            } else if (us.getIduserState() == 3) {
                                ses.close();
                                out.write("your accoutn has been suspended plz contant system admintrator"
                                        + ""
                                        + "<b2>Please Contact +94 717533368</b2>"
                                        + "<h5>Customer Care</h5>"
                                        + "<a href='index.jsp'></a>");
                            }

                        } else {
                            ses.close();
                            response.sendRedirect("signin.jsp?msg=user name or password invalid");
                        }
                    } else {

                        response.sendRedirect("signin.jsp?msg=Enter email address");
                    }

                } else {
                    //aleadry logged
                    Integer userid = (Integer) request.getSession().getAttribute("user-id");
                    pojo.User user = (pojo.User) ses.load(pojo.User.class, userid);

                    pojo.UserState us = (pojo.UserState) ses.load(pojo.UserState.class, user.getUserState().getIduserState());
                    if (us.getIduserState() == 1) {
                        ses.close();
                       // System.out.println(request.getRequestURI());
                        response.sendRedirect("index.jsp");
                        //already logged

                    } else if (us.getIduserState() == 2) {
                        if (request.getSession().getAttribute("account-activate-info") == null) {
                            String hashcode = classes._32CodeGen.codeGenarator(System.currentTimeMillis() + "" + user.getFname());
                            classes._sendEmails.sendHTMLMail(user.getEmail(), "Verification Code", hashcode);
                            request.getSession().setAttribute("account-activate-info", hashcode);
                        }
                        ses.close();
                        response.sendRedirect("email_verification.jsp");
                        //account activation

                    } else if (us.getIduserState() == 3) {
                        ses.close();
                        out.write("your accoutn has been suspended plz contant system admintrator"
                                + ""
                                + "<b2>Please Contact +94 717533368</b2>"
                                + "<h5>Customer Care</h5>"
                                + "<a href='index.jsp'></a>");

                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
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
