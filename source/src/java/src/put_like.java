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
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ashan Nawarathna
 */
public class put_like extends HttpServlet {

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
            if (request.getParameter("likestatusid") != null && request.getParameter("pid") != null && request.getParameter("usr_id") != null) {
                int statusid = Integer.parseInt(request.getParameter("likestatusid"));
                int pid = Integer.parseInt(request.getParameter("pid"));
                int usr_id = Integer.parseInt(request.getParameter("usr_id"));
                Criteria cry = ses.createCriteria(pojo.ProductRating.class);
                pojo.User user = (pojo.User) ses.load(pojo.User.class, usr_id);
                pojo.Product product = (pojo.Product) ses.load(pojo.Product.class, pid);
                pojo.PVotes pvote = (pojo.PVotes) ses.load(pojo.PVotes.class, statusid);
                cry.add(Restrictions.eq("product", product));
                cry.add(Restrictions.eq("user", user));

                Transaction tr = ses.beginTransaction();
                pojo.ProductRating prating = (pojo.ProductRating) cry.uniqueResult();
                if (prating == null) {
                    prating = new pojo.ProductRating();
                    prating.setProduct(product);
                    prating.setUser(user);
                    prating.setPVotes(pvote);

                    ses.save(prating);
                    tr.commit();
                    tr = null;

                } else {
                    prating.setPVotes(pvote);
                    ses.save(prating);
                    tr.commit();
                    tr = null;
                }

                Criteria likecry = ses.createCriteria(pojo.ProductRating.class);
                pojo.PVotes likevote = (pojo.PVotes) ses.load(pojo.PVotes.class, 1);

                likecry.add(Restrictions.eq("product", product));
                likecry.add(Restrictions.eq("PVotes", likevote));

                int likecount = likecry.list().size();

                Criteria unlikecry = ses.createCriteria(pojo.ProductRating.class);
                pojo.PVotes unlikevote = (pojo.PVotes) ses.load(pojo.PVotes.class, 2);

                unlikecry.add(Restrictions.eq("product", product));
                unlikecry.add(Restrictions.eq("PVotes", unlikevote));

                int unlikecount = unlikecry.list().size();

                out.write("1_" + likecount + "," + unlikecount);

                ses.close();
            } else {
                out.write("0_empty param list");
            }
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
