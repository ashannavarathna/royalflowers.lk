/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author x
 */
public class _fileReader {

    private static String psss = null;

    public static String readFile() {
        try {
            String path = new File("").getAbsolutePath() + File.separator + "build\\web\\config";
            ObjectInputStream obin = new ObjectInputStream(new FileInputStream(new File(path + "\\mail.dll")));
            ArrayList<String> auth = (ArrayList) obin.readObject();
            psss = auth.get(0).toString();
            System.out.println("+++++++++++++="+psss);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return psss;
    }
}
