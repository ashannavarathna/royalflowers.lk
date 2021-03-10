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
public class ps_changer extends HttpServlet {

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
            Session upuserses = conn.connector.getSessionFactory().openSession();
            boolean save_valid = false;
            String encpsw_crm = "";
            String encpsw_new = "";
            Integer uid = 0;
            int save_type = 0; // 0  for fb and 1 for cg
            // out.write("up");

            if (request.getParameter("fg") != null && request.getParameter("fg").equals("fgi_1289")) {
               // out.write("in fifi");

                //password forgot
                uid = (Integer) request.getSession().getAttribute("req_uid");
                // out.write("1");
                String sesioncode = (String) request.getSession().getAttribute("req_codex");
                // out.write("2");
                String uinputcode = request.getParameter("req_code");
                // out.write("3");
                encpsw_new = classes._32CodeGen.codeGenarator(request.getParameter("ps1"));
                // out.write("4");
                encpsw_crm = classes._32CodeGen.codeGenarator(request.getParameter("ps2"));
               // out.write("5");

                //check mailcode
                if (sesioncode.equals(uinputcode)) {
                    if (encpsw_crm.equals(encpsw_new)) {
                        // System.out.println("heree");
                        request.getSession().removeAttribute("req_uid");
                        //System.out.println("heer3");
                        request.getSession().removeAttribute("req_codex");
                        // System.out.println("heree4");
                        save_valid = true;
                        save_type = 0;
                    } else {
                        response.sendRedirect("fg_ps_changer.jsp?msg=4002&el=err");
                    }

                } else {
                    response.sendRedirect("fg_ps_changer.jsp?msg=4005&el=err");
                }

            }

            if (request.getParameter("cg") != null && request.getParameter("cg").equals("cgl_4578")) {
                //password change
                // out.write("cg here");

            }
            if (save_valid) {
                Transaction tr = upuserses.beginTransaction();
                pojo.User userobject = (pojo.User) upuserses.load(pojo.User.class, uid);
                userobject.setPCode(encpsw_new);
                upuserses.save(userobject);
                tr.commit();
                tr = null;

                if (save_type == 0) {
                    response.sendRedirect("signin.jsp?msg=chage password success");
                } else if (save_type == 1) {
                    //  out.write("save type 1");

                }

            }
            // out.write("ses codleo");
            upuserses.close();

        } catch (Exception e) {
            e.printStackTrace();
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
