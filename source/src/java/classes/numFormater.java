/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Ashan Nawarathna
 */
public class numFormater {

    public static boolean isNumber(String s) {
        final int len = s.length();
        if (len == 0) {
            return false;
        }
        int dotCount = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {

                if (i == len - 1) {//last character must be digit

                    return false;
                } else if (c == '.') {
                    if (++dotCount > 1) {
                        return false;
                    }
                } else if (i != 0 || c != '+' && c != '-') {//+ or - allowed at start

                    return false;
                }

            }
        }
        return true;

    }

    public static boolean isPositveNum(String txt) {
        if (isNumber(txt)) {
            if (Double.valueOf(txt) >= 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isAPositiveDecimal(String txt) {
        if (isPositveNum(txt)) {
            for (int i = 0; i < txt.length(); i++) {
                if (txt.charAt(i) == '.') {
                    return true;
                }
            }
        }
        return false;

    }

}
