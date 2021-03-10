/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

/**
 *
 * @author Ashan Nawarathna
 */
public class JsReportFile {

    public static Object[] createReport(ArrayList<HashMap> tabledata, HashMap<String, String> nameprams, HashMap<String, Double> amounts) {

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

        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();

        for (HashMap<String, Object> value : tabledata) {
            Vector v = new Vector();
            v.add(value.get("pname").toString());
            v.add(value.get("pcode").toString());
            v.add(Integer.valueOf(value.get("pqty").toString()));
            v.add(Double.valueOf(value.get("pnetamount").toString()));
            dt.addRow(v);

        }

        JRTableModelDataSource datasource = new JRTableModelDataSource(jTable1.getModel());
        String reportSource = "G:\\rpt-x\\invoice.jrxml";

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("invoice", nameprams.get("invoicenum"));
        params.put("date", "Bill Date : "+nameprams.get("b_date"));
        params.put("time", "Bill Time : "+nameprams.get("b_time"));

        String custName = "Name : "+nameprams.get("c_name");

        String custAdd = "Customer : "+nameprams.get("c_add");
        String d_add = "Delivery : "+nameprams.get("d_add");

        params.put("cust_name", custName);

        params.put("cust_add", custAdd);
        params.put("d_add", d_add);

        double total = amounts.get("bill_netamount");
        double d_amount = amounts.get("delivery_cost");
        double b_total = amounts.get("bill_total");

        params.put("total", total);
        params.put("d_charge", d_amount);
        params.put("total_amount", b_total);

        Object[] data_type = new Object[]{reportSource, params, datasource};
        return data_type;
    }
}
