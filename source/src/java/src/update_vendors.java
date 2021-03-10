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
public class update_vendors extends HttpServlet {

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

            if (request.getParameter("email") != null && !request.getParameter("email").isEmpty()) {

                Criteria vendorcry = ses.createCriteria(pojo.Vendors.class);
                vendorcry.add(Restrictions.eq("email", request.getParameter("email")));
                pojo.Vendors vendor = (pojo.Vendors) vendorcry.uniqueResult();

                //geting other varibales
                String name = "";
                String addr = "";
                String cnt1 = "";

                //validating 3 parameters
                if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
                    name = request.getParameter("name");
                }
                if (request.getParameter("addr") != null && !request.getParameter("addr").isEmpty()) {
                    addr = request.getParameter("addr");
                }

                if (request.getParameter("cnt1") != null && !request.getParameter("cnt1").isEmpty()) {
                    cnt1 = request.getParameter("cnt1");
                }

                if (vendor == null) {
                    // adding a new vendor

                    //validation befor add data
                    if (!name.equals("")) {
                        if (!addr.equals("")) {
                            if (!cnt1.equals("")) {
                                Transaction trans = ses.beginTransaction();
                                vendor = new pojo.Vendors();

                                vendor.setEmail(request.getParameter("email"));
                                vendor.setName(name);
                                vendor.setCnt1(cnt1);
                                vendor.setAddress(addr);

                                ses.save(vendor);
                                trans.commit();
                                ses.flush();
                                out.write("1_update success");
                            } else {
                                out.write("0_Enter Vendor's contact");
                            }
                        } else {
                            out.write("0_Enter Vendor's address");
                        }
                    } else {
                        out.write("0_Enter vendor's name");
                    }

                } else {
                    //do update for existing vendor
                    Transaction trans = ses.beginTransaction();
                    //updating as passed values
                    if (!name.equals("")) {
                        vendor.setName(name);
                    }

                    if (!addr.equals("")) {
                        vendor.setAddress(addr);
                    }
                    if (!cnt1.equals("")) {
                        vendor.setCnt1(cnt1);
                    }

                    ses.save(vendor);
                    trans.commit();
                    ses.flush();

                    out.write("1_update success");

                }

            } else {
                //if pcode is emtpy
                out.write("0_Enter Email address");
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
