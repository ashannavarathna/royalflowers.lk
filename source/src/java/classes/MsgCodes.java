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
public class MsgCodes {

    private static int _404 = 404; // page not found
    private static int _500 = 500; // sever internal error
    private static int _503 = 503;
    private static int _200101 = 200101; // save success msg 

    public static void _404() {

    }

    /* @form validation 
     errorx 100101 to 100... for form submititng
    
     errorx_100101 - input filed empty
    
     errox value binds 100 101 1 040 - last three index reprset the lenth of text
    //
    100101 - null values
    1001010 - charater limit
    1001015 - duplicate
    200101 - success
    200202 - no errors
    100100 - if error occured
     */
    public static String fromValidation(String codex) {
        String msg = "";
        int code = 100100;

        if (codex.length() == 6) {
            //get the msg type
            code = Integer.valueOf(code);
        } else if (codex.length() > 6) {
            //get the msg value type
            code = Integer.valueOf(codex.substring(0, 7));
        } else {
            //get the msg value
        }
        switch (code) {
            case 100101:
                msg = "input field can not be empty";
                break;
            case 1001011:
                //validation the length of a text
                String lg = codex.substring(7);
                msg = "your text must be less than " + lg;
                break;
            case 200101:
                msg = "save success ";
                break;
            case 100104:
                msg = "save failed";
                break;
            default:
                msg = "undefine exception in formvalidation";
                break;

        }
        return msg;
    }

    public static void main(String[] args) {
        //System.out.println(fromValidation("1001011040"));
    }
}
