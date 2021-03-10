/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;

/**
 *
 * @author Ashan Nawarathna
 */
public class report_gen extends HttpServlet {

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

        PrintWriter out = response.getWriter();

        JTable jTable1 = new JTable();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Item Description", "Serial Number", "Qty", "Net Price"
                }) {
                    Class[] types = new Class[]{
                        java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
                    };
                    boolean[] canEdit = new boolean[]{
                        false, false, false, false
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
        try {
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();

            for (int i = 0; i < 5; i++) {
                Vector v = new Vector();
                v.add("test1");
                v.add("test2");
                v.add(Integer.valueOf("0"));
                v.add(Double.valueOf("0"));
                dt.addRow(v);

            }

            JRTableModelDataSource datasource = new JRTableModelDataSource(jTable1.getModel());
            String reportSource = "G:\\rpt-x\\invoice.jrxml";

            Map<String, Object> params = new HashMap<String, Object>();

            params.put("invoice", null);
            params.put("date", "Bill Date :");
            params.put("time", "Bill Time : ");

            String custName = "Name :";

            String custAdd = "Customer : ";
            String d_add = "Delivery : ";

            params.put("cust_name", custName);

            params.put("cust_add", custAdd);
            params.put("d_add", d_add);

            double total = Double.parseDouble("0");
            double d_amount = Double.parseDouble("0");
            Double b_total = Double.valueOf("0");

            params.put("total", total);
            params.put("d_charge", d_amount);
            params.put("total_amount", b_total);

            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            //JasperViewer.viewReport(jasperPrint, false);

           // out.write("success");
            // JasperPrintManager.printReport(jasperPrint, true);
            JRHtmlExporter expoter = new JRHtmlExporter();
            expoter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            expoter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
            //Map imagesMap = new HashMap();
            //request.getSession().setAttribute("IMAGES_MAP", imagesMap);
            //request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
            //expoter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);

            expoter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");

            // expoter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?rnd=" + Math.random() + "&image=");
            out.write("<div style='background-color:#000;width:600px;height:500px;border:1px solid #777;margin-left:50px;'>");
            expoter.exportReport();
            out.write("</div>");

            //JasperExportManager.exportReportToPdfFile(jasperPrint, "E:/Jasper-Day 1/abcd.pdf");
            //JasperExportManager.exportReportToHtmlFile(jasperPrint, "E:/Jasper-Day 1/abcd.html");
        } catch (JRException ex) {
            out.write(ex + "");
            Logger.getLogger(report_gen.class.getName()).log(Level.SEVERE, null, ex);

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
