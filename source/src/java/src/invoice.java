/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import classes.createRecipt;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Invoice;

/**
 *
 * @author Ashna Nawarathna
 */
public class invoice extends HttpServlet {

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
            Session sesproducts = conn.connector.getSessionFactory().openSession();
            //get form jsp delivery details
            String time = System.currentTimeMillis() + "";

            String accnum = "4526BOC8415KG";
            int dpack_id = 0;
            double distance = 0;

            //product details
            int itemcount = 0;
            double dp_cost = 0;

            //total prices
            double billtotal = 0;
            double discounttotal = 0;
            double totalnetamount = 0;
            double totalweight = 0;
            double deliverycosttotal = 0;

            double fullamount = 0;
            List tabledata = new ArrayList();
            Integer userid = (Integer) request.getSession().getAttribute("user-id");
            Criteria crr = sesproducts.createCriteria(pojo.User.class);
            crr.add(Restrictions.eq("iduser", userid));
            pojo.User user = (pojo.User) crr.uniqueResult();
            if (user.getUserState().getIduserState() == 1) {

                if (request.getParameter("pgx_sumid") == null || !request.getParameter("pgx_sumid").equals("vld1265dix")) {
                    response.sendRedirect("error_404.jsp");
                } else {
                    if (request.getParameter("dlpack_code") == null || request.getParameter("dlpack_code").isEmpty()) {
                        //error delivery packgae not seleted
                        response.sendRedirect("product_summery.jsp?eco=ibm_7788_28k&lng=EN-SI");

                    } else {
                        if (request.getParameter("dldsnt_ln") == null || request.getParameter("dldsnt_ln").isEmpty()) {
                            //error distance not supply
                            response.sendRedirect("product_summery.jsp?eco=p_7789_455F&lng=EN-IN");
                        } else {
                            // start transaction
                            //out.write("Begin transaction... <br/>");
                            dpack_id = Integer.parseInt(request.getParameter("dlpack_code"));
                            distance = Double.parseDouble(request.getParameter("dldsnt_ln"));
                            boolean flag_data_ok = true;
                            int errcode = 100000;
                            List<int[]> cart = (ArrayList) request.getSession().getAttribute("s_cart");
                            itemcount = cart.size();

                            for (int[] item : cart) {
                                int id = item[0];
                                int qty = item[1];
                                pojo.Product p = (pojo.Product) sesproducts.load(pojo.Product.class, id);

                                if (qty <= p.getQty()) {
                                    HashMap<String, Object> hm = new HashMap();
                                    hm.put("pname", p.getName());
                                    hm.put("pcode", p.getProductCode());
                                    hm.put("pqty", qty);
                                    hm.put("pnetamount", (p.getPrice() - p.getDiscount()) * qty);
                                    tabledata.add(hm);

                                    //getting total for seletec items
                                    billtotal += p.getPrice() * item[1];
                                    discounttotal += p.getDiscount() * item[1];
                                    totalweight += p.getWeight() * item[1];

                                    //out.write("can issue <br/>");
                                } else {
                                    //can not issue quantity
                                    flag_data_ok = false;
                                    errcode = 0;
                                    // out.write("can not iuuse <br/>");
                                    break;
                                }

                            }

                            //total net amoutn
                            totalnetamount = billtotal - discounttotal;

                            //getting delivery pack chargers
                            pojo.DeliveryPlan dplan = (pojo.DeliveryPlan) sesproducts.load(pojo.DeliveryPlan.class, dpack_id);
                            if (dplan != null) {
                                if (distance < 10) {
                                    dp_cost = dplan.getK10();
                                } else if (distance < 50) {
                                    dp_cost = dplan.getK50();

                                } else if (distance < 100) {
                                    dp_cost = dplan.getK100();

                                } else if (distance > 100) {
                                    dp_cost = dplan.getK100up();

                                } else {
                                    // invalid distance
                                    flag_data_ok = false;
                                }

                            } else {
                                // no such d-plan found
                                flag_data_ok = false;
                                errcode = 1;

                            }
                            //getting amoutn after adding delivery costs

                            if (flag_data_ok) {
                                deliverycosttotal = (((dp_cost / 1000) * totalweight) * distance);
                                fullamount = totalnetamount + deliverycosttotal;
                                //out.write("process success");
                                String cname = user.getFname() + " " + user.getLname();
                                String caddres = user.getAddress1() + "," + user.getAddress2() + "," + user.getCity() + "," + user.getCountry();
                                String daddres = request.getParameter("add1") + "," + request.getParameter("add2") + "," + request.getParameter("a_city") + ",SriLanka";
                                String fname = request.getParameter("fname");
                                String lname = request.getParameter("lname");
                                String add1 = request.getParameter("add1");
                                String add2 = request.getParameter("add2");
                                String a_city = request.getParameter("a_city");
                                String ps_code = request.getParameter("ps_code");
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                                Date date_today = new Date();
                                Calendar c = Calendar.getInstance();
                                c.setTime(date_today);
                                pojo.DeliveryPlan pdn = new pojo.DeliveryPlan();
                                dplan.setIddeliveryPlan(dpack_id);
                                c.add(Calendar.DATE, dplan.getDeliveryPeriod());
                                Date newDate = c.getTime();

                                String today = sdf.format(date_today);
                                String d_date = sdf.format(newDate);

                                Transaction tr = sesproducts.beginTransaction();

                                pojo.Cart cartx = new pojo.Cart();
                                cartx.setProductCount(itemcount);
                                cartx.setTotalAmount(totalnetamount);
                                //cartx.setDateTime(date_today);
                                cartx.setUser(user);

                                sesproducts.save(cartx);

                                pojo.Invoice invoice = new pojo.Invoice();

                                //get and set max invoice number then the invoice numbr to avoid invoice um dupllication
                                Criteria cr1 = sesproducts.createCriteria(Invoice.class);
                                // cr1.setProjection(Projections.max(""));

                                int maxid = cr1.list().size();

                                String trnascode = "TRNS" + time.substring(7, 11) + "LKR" + (maxid + 1);
                                String invoicenum = "INO" + time.substring(0, 4) + "ED " + time.substring(7, 11) + (maxid + 1);
                                invoice.setInvoiceNum(invoicenum);
                                invoice.setCart(cartx);
                                invoice.setUser(user);

                                //  invoice.setQty(itemcount);
                                //  invoice.setTotal(totalnetamount);
                                invoice.setTimeDate(date_today);
                                //  invoice.setUser(user);

                                sesproducts.save(invoice);

                                pojo.Delivery delivery = new pojo.Delivery();
                                delivery.setName(fname + " " + lname);
                                delivery.setAddress1(add1);
                                delivery.setAddress2(add2);
                                delivery.setCity(a_city);
                                delivery.setPostalCode(ps_code);
                                delivery.setCost(deliverycosttotal);
                                delivery.setState("pending");
                                delivery.setShippingDate(newDate);
                                delivery.setInvoice(invoice);
                                delivery.setDeliveryPlan(dplan);
                                delivery.setUser(user);

                                sesproducts.save(delivery);

                                for (int[] cart1 : cart) {
                                    pojo.CartHasProducts chp = new pojo.CartHasProducts();
                                    pojo.Product prd = (pojo.Product) sesproducts.load(pojo.Product.class, cart1[0]);
                                    chp.setCart(cartx);
                                    chp.setProduct(prd);
                                    chp.setQty(cart1[1]);
                                    chp.setAmount((prd.getPrice() - prd.getDiscount()) * cart1[1]);
                                    prd.setQty(prd.getQty() - cart1[1]);

                                    sesproducts.save(chp);
                                    sesproducts.save(prd);

                                    //if quatity low.. notifi vendors
                                    if (prd.getQty() <= prd.getReoderLevel()) {
                                        //send mail to vendor (notify quantity)
                                        Criteria cr_phv = sesproducts.createCriteria(pojo.ProductHasVendors.class);
                                        cr_phv.add(Restrictions.eq("product", prd));
                                        pojo.ProductHasVendors phv = (pojo.ProductHasVendors) cr_phv.uniqueResult();
                                        if (phv.getProductRequestStatus().getIdproductRequestStatus() == 1) {
                                            String reqqtyreceipt = classes.QtyReqMailGen.getReceipt(phv.getVendors().getName(), phv.getVendors().getEmail(), prd.getName(), prd.getProductCode(), phv.getRequestQuantity(), phv);
                                            classes._sendEmails.sendHTMLMail(phv.getVendors().getEmail(), "Quantity Requestitng", reqqtyreceipt);
                                        }
                                    }

                                }

                                // pojo.TransactionDetails trans = new pojo.TransactionDetails();
                                // trans.setInvoice(invoice);
                                // trans.setAccountNumber(accnum);
                                //  trans.setTransactionCode(trnascode);
                                //  sesproducts.save(trans);
                                tr.commit();
                                request.getSession().removeAttribute("s_cart");

                                //jsper reporrts
                                //params
                                HashMap<String, String> hmprams = new HashMap();
                                hmprams.put("invoicenum", invoicenum);
                                hmprams.put("b_date", today.split(" ")[0]);
                                hmprams.put("b_time", today.split(" ")[1]);
                                hmprams.put("c_name", cname);
                                hmprams.put("c_add", caddres);
                                hmprams.put("d_add", daddres);
                                //bill amounts
                                HashMap<String, Double> hmamount = new HashMap();
                                hmamount.put("bill_netamount", totalnetamount);
                                hmamount.put("delivery_cost", deliverycosttotal);
                                hmamount.put("bill_total", fullamount);
                                Object[] jsreportdatasources = new Object[3];
                                jsreportdatasources[0] = tabledata;
                                jsreportdatasources[1] = hmprams;
                                jsreportdatasources[2] = hmamount;
                                request.getSession().setAttribute("jsreportdata", jsreportdatasources);

                                //recipts transaction
                                classes.createRecipt crcpt = new createRecipt(trnascode, accnum, cname, caddres, itemcount, billtotal, discounttotal, totalnetamount, deliverycosttotal, fullamount, fname, lname, add1, add2, a_city, ps_code);
                                String recipt = crcpt.getRecipt();

                                classes._sendEmails.sendHTMLMail(user.getEmail(), "Payment Recipt", recipt);
                                out.write(recipt);

                                if (sesproducts.isOpen()) {
                                    sesproducts.close();
                                }
                            } else {
                                if (sesproducts.isOpen()) {
                                    sesproducts.close();
                                }
                                // out.write("not Success");
                                switch (errcode) {

                                    case 0:
                                        response.sendRedirect("product_summery.jsp?eco=total_7791_2545k&lng=EN_El");
                                        break;
                                    case 1:
                                        response.sendRedirect("product_summery.jsp?eco=eidbm_7790_25FG&lng=EN-");
                                        break;
                                    default:
                                        //default case
                                        break;
                                }

                            }
                        }
                    }

                }
            } else {
                if (sesproducts.isOpen()) {
                    sesproducts.close();
                }
                response.sendRedirect("user_login?usrxttp=100255_105");
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
