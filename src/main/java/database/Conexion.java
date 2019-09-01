/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author georg
 */
public class Conexion {

    private String dbName;
    private String user;
    private String pwd;
    private Connection conn;

    public Conexion(String dbName, String user, String pwd) {
        this.dbName = dbName;
        this.user = user;
        this.pwd = pwd;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error Conexion: " + e.getMessage() + " " + e.toString());
            System.exit(-1);
        }
    }

    private void abrirConxion() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + dbName, user, pwd);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    private void cerrarConexion() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public String insertUpdatDel(String query) {
        abrirConxion();
        try {
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(query);
            String msg = "";
            
            if (result > 0) {
                cerrarConexion();
                msg = "Ok";
            }
            return msg;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return "Error";
        }
    }
    
    public ResultSet select(String query) {
        abrirConxion();
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        
       return rs;
    }
}
