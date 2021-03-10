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
public class chng_psw extends HttpServlet {

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
            int uid = (int) request.getSession().getAttribute("user-id");

            String old_password = classes._32CodeGen.codeGenarator(request.getParameter("crr_pass"));
            String new_password = classes._32CodeGen.codeGenarator(request.getParameter("nw_pass"));
            String crf_password = classes._32CodeGen.codeGenarator(request.getParameter("cfm_pass"));

            //creating user object
            //pojo.User user = (pojo.User) ses.load(pojo.User.class, uid);
            Criteria cr = ses.createCriteria(pojo.User.class);
            cr.add(Restrictions.eq("iduser", uid));
            cr.add(Restrictions.eq("PCode", old_password));

            pojo.User user = (pojo.User) cr.uniqueResult();

            if (user != null) {
                if (new_password.equals(crf_password)) {
                    Transaction trans = ses.beginTransaction();
                    user.setPCode(new_password);
                    ses.save(user);
                    trans.commit();
                    trans = null;
                    
                    out.write("1_update success");

                } else {
                    out.write("0_Password not match");
                }

            } else {
                out.write("0_Old Password Error");
            }

            ses.close();

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
