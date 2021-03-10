/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.DecimalFormat;

/**
 *
 * @author Ashan Nawarathna
 */
public class randomChar {

    public static char randomChar() {
        DecimalFormat df = new DecimalFormat("0.00");
        String random = "";
        String number = "";
        int randomint = 0;
        char c = 0;
        boolean checking = true;
        while (checking) {
            random = df.format(Math.random());
            number = random.substring(2, random.length());
            randomint = Integer.parseInt(number);
            if (randomint > 64 && randomint < 90) {
                c = (char) randomint;
                checking = false;
            }
        }
        return c;
    }

}
