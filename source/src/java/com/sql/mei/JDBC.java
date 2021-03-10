/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sql.mei;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashna Nawarathna
 */
public class JDBC {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/inventory";
    private String password = "Allibaba@mysQl5";
    private Connection con;
    public static JDBC DB = new JDBC();

    private JDBC() {
    }

    Connection createConnection() throws Exception {
        if (con == null) {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", password);
        }
        return con;
    }

    public void setQuery(String query) {
        // use this method to search update and delete sql

        try {
            Statement state = createConnection().createStatement();
            state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet getQuery(String query) {
        ResultSet result = null;
        try {
            Statement state = createConnection().createStatement();
            result = state.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
