/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.Conexion;
import modelo.Editorial;

/**
 *
 * @author georg
 */
public class ConsultasEditorial {

    private final String DB = "comicsdb";
    private final String USER = "root";
    private final String PWD = "";
    private final String TB = "Editoriales";

    public void insertarEditorial(Editorial e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "INSERT INTO " + TB + "(nombre_editorial) values('" + e.getNombre() + "')";
        String result = con.insertUpdatDel(query);
        
        if ("Ok".equals(result)) {
            System.err.println("Insert Exitoso");
        } else {
            System.err.println("Falló el insert");
        }
    }
    
    public void updateEditorial(Editorial e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "UPDATE " + TB + " SET `nombre_editorial`=[value-2] WHERE `id_editorial`=" + e.getId();
        String result = con.insertUpdatDel(query);
        
        if ("Ok".equals(result)) {
            System.err.println("Update Exitoso");
        } else {
            System.err.println("Falló el update");
        }
    }
    
    public void deleteEditorial(Editorial e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "DELETE FROM `" + TB +"` WHERE `id_editorial`=" + e.getId();
        String result = con.insertUpdatDel(query);
        
        if ("Ok".equals(result)) {
            System.err.println("Update Exitoso");
        } else {
            System.err.println("Falló el update");
        }
    }
}
