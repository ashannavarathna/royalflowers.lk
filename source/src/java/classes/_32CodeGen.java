/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author x
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;

public class _32CodeGen {

    public static String codeGenarator(String input) throws NoSuchAlgorithmException {
        //getting hash code value from input and system time
        int mailHash = input.hashCode();
        int timeHash = String.valueOf(System.currentTimeMillis()).hashCode();

        //genarate a hashcode form two values
        int hashCode = mailHash + timeHash;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(String.valueOf(mailHash).getBytes());
        byte[] byteCode = md.digest();

        StringBuffer hexBufferString = new StringBuffer();
        //genaratehash format in hex
        for (byte binx : byteCode) {
            hexBufferString.append(Integer.toString((binx & 0xff) + 0x100, 16).substring(1));
        }
        return hexBufferString.toString();
    }

   public static String simple_code() {
        String longx = String.valueOf(System.currentTimeMillis());
        String codeb = "";
        String[] indexs = new String[longx.length()];
        String bycode = "";
        for (int i = 1; i < longx.length(); i++) {
            if (codeb.equals("")) {
                codeb += longx.charAt(i);
            } else {
                codeb += "_" + longx.charAt(i);
            }

        }
        indexs = codeb.split("_");

        bycode += indexs[indexs.length - 6] + indexs[indexs.length - 2];
        bycode += indexs[indexs.length - 1] + indexs[indexs.length - 8];
        bycode += indexs[2] + indexs[8];
        bycode += indexs[indexs.length - 3] + indexs[indexs.length - 1];
        bycode += indexs[0] + indexs[4];
        bycode += indexs[indexs.length - 1] + indexs[indexs.length - 2];
        bycode += indexs[indexs.length - 1] + indexs[indexs.length - 1];
        bycode += indexs[9] + indexs[11];
        bycode += indexs[3] + indexs[5];
        bycode += indexs[0] + indexs[4];
        bycode += indexs[indexs.length - 1] + indexs[indexs.length - 4];

        String code = "";
        for (int i = 0; i < bycode.length(); i++) {
            int x = (int) bycode.charAt(i) + 50;
            code += (char) x;
        }
        return code;

    }

}
