/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import classes._32CodeGen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ashan Nawarathna
 */
public class save_n_submit_ad extends HttpServlet {

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
            //System.out.println("request come");
            Session ses = conn.connector.getSessionFactory().openSession();
            boolean ismultipart = ServletFileUpload.isMultipartContent(request);
            // System.out.println("check for mulitpart");
            Integer catid = 0, loc_id = 0, pkg_id = 0;
            String title = "", web_url = "", descr = "", psw = "", card_num = "", date = "", month = "", cvc = "";

            String resultmsg = "";
            System.out.println("here...1");
            if (ismultipart) {
                // System.out.println("it is multipart");
                FileItemFactory fif = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fif);

                List<FileItem> file_list = upload.parseRequest(request);

                //get values from request
                catid = Integer.parseInt(file_list.get(0).getString());
                System.out.println("hi..1");
                title = file_list.get(1).getString();
                System.out.println("hi..2");
                web_url = file_list.get(2).getString();
                System.out.println("hi..3");
                loc_id = Integer.parseInt(file_list.get(3).getString());
                System.out.println("hi..4");
                BufferedImage bfimg = ImageIO.read(file_list.get(4).getInputStream());
                System.out.println("hi..5");
                pkg_id = Integer.parseInt(file_list.get(6).getString());
                System.out.println("hi..6");
                descr = file_list.get(7).getString();
                System.out.println("hi..7");
                psw = file_list.get(8).getString();
                System.out.println("hi..8");
                card_num = file_list.get(9).getString();
                System.out.println("hi..9");
                month = file_list.get(10).getString();
                System.out.println("hi..10");
                date = file_list.get(11).getString();
                System.out.println("hi..11");
                cvc = file_list.get(12).getString();
                System.out.println("hi..12");

                //datavalidation
                boolean save_enable = true;
                //load objects from db
                pojo.AdvertisingCategory ad_cat = (pojo.AdvertisingCategory) ses.load(pojo.AdvertisingCategory.class, catid);
                pojo.AdvertisingLocation ad_loc = (pojo.AdvertisingLocation) ses.load(pojo.AdvertisingLocation.class, loc_id);
                pojo.AdvertisingDatePlans ad_pkg = (pojo.AdvertisingDatePlans) ses.load(pojo.AdvertisingDatePlans.class, pkg_id);
                pojo.AdvertisingStatus adStaus = (pojo.AdvertisingStatus) ses.load(pojo.AdvertisingStatus.class, 3);

                //password validation
                // pojo.User user = (pojo.User) ses.load(pojo.User.class, Integer.parseInt((String) request.getSession().getAttribute("user-id")));
                Criteria cr_user = ses.createCriteria(pojo.User.class);
                String encpsw = classes._32CodeGen.codeGenarator(psw);
                int userid = (int) request.getSession().getAttribute("user-id");
                cr_user.add(Restrictions.eq("PCode", encpsw));
                cr_user.add(Restrictions.eq("iduser", userid));
                pojo.User user = (pojo.User) cr_user.uniqueResult();
                System.out.println("after getting dara from db");
                if (user == null) {
                    save_enable = false;
                    out.write("0_password is incorrect");
                    System.out.println("user not null");
                }

                //image size validation
                int adimg_width = Integer.parseInt(ad_loc.getImgSize().split("x")[0]);
                int adimg_height = Integer.parseInt(ad_loc.getImgSize().split("x")[1]);
                if (bfimg.getWidth() != adimg_width || bfimg.getHeight() != adimg_height) {
                    save_enable = false;
                    out.write("0_your image is not match for the preferred width and height");
                }
                System.out.println("image is validation");

                if (card_num.length() < 16) {
                    save_enable = false;
                    out.write("0_card number is invalid");
                }

                if (cvc.length() < 4) {
                    save_enable = false;
                    out.write("0_cvc  is invalid");
                }
                
                System.out.println(" going to save");
                if (save_enable) {
                    Transaction trns = ses.beginTransaction();
                    pojo.Advertising ad = new pojo.Advertising();

                    ad.setAdvertisingCategory(ad_cat);
                    ad.setAddTitle(title);
                    ad.setWebsiteUrl(web_url);
                    String name = file_list.get(4).getName();
                    String imgextention[] = name.split("\\.");

                    String img_name = _32CodeGen.codeGenarator(System.currentTimeMillis() + "IMG_01") + "." + imgextention[imgextention.length - 1];
                    ad.setImgUrl(img_name);
                    ad.setUser(user);
                    ad.setDescription(descr);
                    ad.setAdvertisingDatePlans(ad_pkg);
                    ad.setAdvertisingLocation(ad_loc);
                    ad.setAdvertisingStatus(adStaus);

                    java.util.Date today = new Date();
                    ad.setOnDate(today);

                    //save imge to disk
                    ses.save(ad);
                    trns.commit();
                    ses.flush();
                    trns = null;
                    file_list.get(4).write(new File(request.getServletContext().getRealPath("") + "/" + "_images/_add/_sub_page/" + img_name));
                    out.write("1_ad sumit success... wating for admin aproval");
                } else {
                    //out.write("0_error occured... can not submit this ad");
                }
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
