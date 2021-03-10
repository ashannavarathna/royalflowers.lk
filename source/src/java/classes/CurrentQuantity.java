/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ashan Nawarathna
 */
public class CurrentQuantity {

    public static int getCurrentQty(String pcode) {

        Session seslp = conn.connector.getSessionFactory().openSession();

        Criteria crr = seslp.createCriteria(pojo.Product.class);
        crr.add(Restrictions.eq("productCode", pcode));

        pojo.Product product = (pojo.Product) crr.uniqueResult();

        if (product != null) {
            // if product exsists
            int qty = product.getQty();
            seslp.close();
            return qty;
        } else {
            seslp.close();
            return 0;
        }

    }

}
