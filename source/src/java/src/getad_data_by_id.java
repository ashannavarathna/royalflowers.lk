/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Advertising;

/**
 *
 * @author Ashan Nawarathna
 */
public class getad_data_by_id extends HttpServlet {

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
            int adid = Integer.parseInt(request.getParameter("adid"));
            String result = "";
            Session ses = conn.connector.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(pojo.Advertising.class);
            cr.add(Restrictions.eq("idadvertising", adid));
            pojo.Advertising ad = (pojo.Advertising) cr.uniqueResult();
            if (ad != null) {
                
                int id = ad.getIdadvertising();
                String title = ad.getAddTitle();
                String weburl = ad.getWebsiteUrl();
                String imgurl = ad.getImgUrl();
                String descr = ad.getDescription();
                int statusid = ad.getAdvertisingStatus().getIdadvertisingStatus();
                String imgwh = ad.getAdvertisingLocation().getImgSize();
                Date exfdate = null;
                if (statusid == 1 || statusid == 4) {
                    Date ondate = ad.getOnDate();
                    Calendar clndr = Calendar.getInstance();
                    clndr.setTime(ondate);
                    clndr.add(Calendar.DATE, ad.getAdvertisingDatePlans().getDateCount());
                    clndr.getTime();
                    exfdate = clndr.getTime();
                    
                }
                
                if (result.equals("")) {
                    result = id + "," + title + "," + weburl + "," + imgurl + "," + imgwh + "," + descr + "," + statusid + "," + exfdate;
                } else {
                    result += "," + id + "," + title + "," + weburl + "," + imgurl + "," + imgwh + "," + descr + "," + statusid + "," + exfdate;;
                }

                out.write("1|-" + result);
            } else {
                out.write("0|-no ad found");
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
