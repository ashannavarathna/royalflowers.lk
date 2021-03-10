/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import classes._32CodeGen;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import pojo.PStatus;

/**
 *
 * @author Ashan Nawarathna
 */
public class save_products extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    boolean itemcheck[];

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //System.out.println("request come");
            Session ses = conn.connector.getSessionFactory().openSession();
            boolean ismultipart = ServletFileUpload.isMultipartContent(request);
            // System.out.println("check for mulitpart");

            String resultmsg = "";
            if (ismultipart) {
                // System.out.println("it is multipart");
                FileItemFactory fif = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fif);

                List<FileItem> file_list = upload.parseRequest(request);
                itemcheck = new boolean[file_list.size()];
                //System.out.println(itemcheck.length);
                String[] formfileds = new String[12];
                FileItem[] images = new FileItem[3];
                boolean flag_save = true;
                int i = 0; // get item count
                int ff = 0; // get fomr filed cout
                int fi = 0; // get file item cout
                //form validation
                try {
                    for (FileItem fileitem : file_list) {
                        if (i < 15) {
                            // System.out.println("vaildtion fields");
                            if (fileitem.isFormField()) {
                                // System.out.println(fileitem.getFieldName());
                                if (fileitem.getString().equals("")) {
                                    flag_save = false;
                                    itemcheck[i] = false;
                                } else {
                                    //out.write(fileitem.getString() + "<br/>");
                                    itemcheck[i] = true;
                                    formfileds[ff] = fileitem.getString();
                                    ff++;
                                }
                            } else {
                                // System.out.println(fileitem.getName());
                                if (fileitem.getName().equals("")) {
                                    flag_save = false;
                                    itemcheck[i] = false;
                                } else {
                                    // out.write(fileitem.getName() + "<br/>");
                                    itemcheck[i] = true;
                                    images[fi] = fileitem;
                                    fi++;
                                }
                            }
                        }
                        i++;
                    }
                } catch (Exception e) {
                    /// System.out.println(e);
                }
               // System.out.println("validation is over .........");

                //save the values
                // System.out.println("data not full");
                if (flag_save) {
                    //   System.out.println("data full");

                    //validation the numfer formts
                    double weight = 0;
                    int quantity = 0;
                    double price = 0;
                    double discount = 0;
                    int reoderlv = 0;
                    boolean numFiled = true;
                    String numberfieldcode = "";
                    for (int fnf = 6; fnf <= 10; fnf++) {
                        if (!classes.numFormater.isPositveNum(formfileds[fnf])) {
                            numFiled = false;
                            if (numberfieldcode.equals("")) {
                                numberfieldcode = fnf + "";
                            } else {
                                numberfieldcode += "," + fnf;
                            }
                        }
                    }

                    if (!numFiled) {
                        out.write("1_nfin_" + numberfieldcode);
                    } else {
                        Transaction tr = ses.beginTransaction();
                        pojo.Catagory category = (pojo.Catagory) ses.load(pojo.Catagory.class, Integer.valueOf(formfileds[2]));
                        pojo.SubCategory subcategory = (pojo.SubCategory) ses.load(pojo.SubCategory.class, Integer.valueOf(formfileds[3]));
                        pojo.Brand brand = (pojo.Brand) ses.load(pojo.Brand.class, Integer.valueOf(formfileds[4]));
                        pojo.ProductColor pcolor = (pojo.ProductColor) ses.load(pojo.ProductColor.class, Integer.valueOf(formfileds[5]));
                        String pname = formfileds[0];
                        String pcode = formfileds[1];
                        weight = Double.valueOf(formfileds[6]);
                        quantity = Integer.valueOf(formfileds[7]);
                        price = Double.valueOf(formfileds[8]);
                        discount = Double.valueOf(formfileds[9]);
                        reoderlv = Integer.valueOf(formfileds[10]);

                        String desc = formfileds[11];

                        String img_name_1;
                        String img_name_2;
                        String img_name_3;

                        Criteria cpdoceck = ses.createCriteria(pojo.Product.class);
                        cpdoceck.add(Restrictions.eq("productCode", pcode));

                        pojo.Product pctest = (pojo.Product) cpdoceck.uniqueResult();
                        //check of the prodcut code alrdy exit
                        if (pctest == null) {
                            Criteria cr_pro = ses.createCriteria(pojo.Product.class);
                            cr_pro.add(Restrictions.eq("brand", brand));
                            List<pojo.Product> plist = cr_pro.list();
                            if (plist.isEmpty()) {
                                pojo.Product prosx = new pojo.Product();
                                prosx.setBrand(brand);
                                prosx.setName(pname);
                                prosx.setProductCode(pcode);
                                prosx.setSubCategory(subcategory);
                                prosx.setBrand(brand);
                                prosx.setDiscount(discount);
                                prosx.setPrice(price);
                                prosx.setQty(quantity);
                                prosx.setReoderLevel(reoderlv);
                                prosx.setWeight(weight);
                                prosx.setDescription(desc);
                                pojo.PStatus pstate = (pojo.PStatus) ses.load(pojo.PStatus.class, 1);
                                prosx.setPStatus(pstate);
                                prosx.setProductColor(pcolor);

                                //creating extention for the files
                                String[] fileextention = new String[3];
                                int filecount = 0;
                                for (FileItem flix : images) {

                                    if (flix.getContentType().equals("image/jpeg")) {
                                        fileextention[filecount] = ".jpg";
                                    } else if (flix.getContentType().equals("image/png")) {
                                        fileextention[filecount] = ".png";
                                    }
                                    filecount++;
                                }

                                img_name_1 = _32CodeGen.codeGenarator(System.currentTimeMillis() + "IMG_01") + fileextention[0];
                                img_name_2 = _32CodeGen.codeGenarator(System.currentTimeMillis() + "IMG_02") + fileextention[1];
                                img_name_3 = _32CodeGen.codeGenarator(System.currentTimeMillis() + "IMG_03") + fileextention[2];

                                images[0].write(new File(request.getServletContext().getRealPath("") + "/" + "_images/product/category/products/" + img_name_1));
                                images[1].write(new File(request.getServletContext().getRealPath("") + "/" + "_images/product/category/products/" + img_name_2));
                                images[2].write(new File(request.getServletContext().getRealPath("") + "/" + "_images/product/category/products/" + img_name_3));

                                prosx.setImageUrl1(img_name_1);
                                prosx.setImageUrl2(img_name_2);
                                prosx.setImageUrl3(img_name_3);

                                ses.save(prosx);

                                resultmsg = "product save success";

                            } else {
                                // System.out.println("no same product for nad  and cat");
                                Criteria crp = ses.createCriteria(pojo.Product.class);
                                crp.add(Restrictions.eq("name", pname));
                                crp.add(Restrictions.eq("brand", brand));
                                pojo.Product prd = (pojo.Product) crp.uniqueResult();
                                if (prd == null) {
                                    //  System.out.println("hoooo n");
                                    pojo.Product prosx = new pojo.Product();
                                    prosx.setBrand(brand);
                                    prosx.setName(pname);
                                    prosx.setProductCode(pcode);
                                    prosx.setSubCategory(subcategory);
                                    prosx.setBrand(brand);
                                    prosx.setDiscount(discount);
                                    prosx.setPrice(price);
                                    prosx.setQty(quantity);
                                    prosx.setReoderLevel(reoderlv);
                                    prosx.setWeight(weight);
                                    prosx.setDescription(desc);
                                    pojo.PStatus pstate = (pojo.PStatus) ses.load(pojo.PStatus.class, 1);
                                    prosx.setPStatus(pstate);
                                    prosx.setProductColor(pcolor);

                                    //creating extention for the files
                                    String[] fileextention = new String[3];
                                    int filecount = 0;
                                    for (FileItem flix : images) {

                                        if (flix.getContentType().equals("image/jpeg")) {
                                            fileextention[filecount] = ".jpg";
                                        } else if (flix.getContentType().equals("image/png")) {
                                            fileextention[filecount] = ".png";
                                        }
                                        filecount++;
                                    }

                                    img_name_1 = _32CodeGen.codeGenarator(System.currentTimeMillis() + "IMG_01") + fileextention[0];
                                    img_name_2 = _32CodeGen.codeGenarator(System.currentTimeMillis() + "IMG_02") + fileextention[1];
                                    img_name_3 = _32CodeGen.codeGenarator(System.currentTimeMillis() + "IMG_03") + fileextention[2];

                                    images[0].write(new File(request.getServletContext().getRealPath("") + "/" + "_images/product/category/products/" + img_name_1));
                                    images[1].write(new File(request.getServletContext().getRealPath("") + "/" + "_images/product/category/products/" + img_name_2));
                                    images[2].write(new File(request.getServletContext().getRealPath("") + "/" + "_images/product/category/products/" + img_name_3));

                                    prosx.setImageUrl1(img_name_1);
                                    prosx.setImageUrl2(img_name_2);
                                    prosx.setImageUrl3(img_name_3);

                                    ses.save(prosx);

                                    resultmsg = "product save success";

                                } else {
                                    pojo.PStatus pstate = prd.getPStatus();
                                    if (pstate.getIdpStatus() == 1) {
                                        // dupicate entry
                                    } else {
                                        // deleted product re activated
                                        prd.setPStatus((PStatus) ses.load(pojo.PStatus.class, 2));

                                        //setup newly details of prodcut
                                        prd.setPrice(price);
                                        prd.setQty(quantity);
                                        prd.setDiscount(discount);
                                        prd.setReoderLevel(reoderlv);

                                        ses.save(prd);
                                        resultmsg = "2005";
                                        
                                        
                                    }

                                }

                            }
                            tr.commit();
                            ses.close();
                            // System.out.println("saved sucees");
                            out.write("1_" + resultmsg);
                        } else {
                            out.write("1_dup");
                        }
                    }

                } else {
                    // System.out.println("not saved");

                    for (int ix = 0; ix < itemcheck.length; ix++) {
                        if (resultmsg.equals("")) {
                            resultmsg = itemcheck[ix] + "";
                        } else {
                            resultmsg += "," + itemcheck[ix];
                        }
                    }
                    out.write("0_" + resultmsg);

                }
            } else {
                // System.out.println("not multpart");
            }
            if (ses.isOpen()) {
                ses.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            throw new ServletException();
        } finally {
            out.close();
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
        response.sendRedirect("_error_404.jsp");

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

/**
 * old file and fomr data wwithut mutipart
 */
