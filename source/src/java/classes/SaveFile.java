/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveFile {

    public static void saveObj() {
        ArrayList<String> auth = new ArrayList();
        auth.add(0, "");
        String path = new File("").getAbsolutePath() + File.separator + "build\\web\\config";
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream(new File(path + "\\mail.dll")));
            out.writeObject(auth);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        saveObj();
    }

}
