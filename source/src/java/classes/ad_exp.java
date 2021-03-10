/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Advertising;

/**
 *
 * @author Ashan Nawarathna
 */
public class ad_exp {

    public ad_exp() {
        exp_ads();
    }

    public void exp_ads() {
        Session ses = conn.connector.getSessionFactory().openSession();
        Criteria cr_adlist = ses.createCriteria(pojo.Advertising.class);

        pojo.AdvertisingStatus ad_status = (pojo.AdvertisingStatus) ses.load(pojo.AdvertisingStatus.class, 1);
        pojo.AdvertisingStatus ad_status_exp = (pojo.AdvertisingStatus) ses.load(pojo.AdvertisingStatus.class, 4);

        cr_adlist.add(Restrictions.eq("advertisingStatus", ad_status));

        List<pojo.Advertising> adlist = cr_adlist.list();
        Transaction trans = ses.beginTransaction();
        for (Advertising adlist1 : adlist) {
            int date = adlist1.getAdvertisingDatePlans().getDateCount();
            GregorianCalendar g = new GregorianCalendar();
            g.setTime(adlist1.getOnDate());
            g.add(Calendar.DATE, date);

            if (adlist1.getOnDate().after(g.getTime())) {
                adlist1.setAdvertisingStatus(ad_status_exp);
                ses.update(adlist1);

            }

        }
        trans.commit();
        ses.flush();
        trans = null;

        ses.close();
    }

}
