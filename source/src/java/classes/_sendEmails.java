/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.GoogleMail;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author x
 */
public class _sendEmails {

    public static void sendHTMLMail(String recpt, String title, String msg){
        String pscode = "flower1001";
        try {
            GoogleMail.Send("flowerwhilte", pscode, recpt, title, msg);
        } catch (MessagingException ex) {
            Logger.getLogger(_sendEmails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
