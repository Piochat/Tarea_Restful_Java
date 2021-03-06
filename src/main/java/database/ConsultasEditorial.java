/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Editorial;

/**
 *
 * @author georg
 */
public class ConsultasEditorial {

    private final String DB = "comicsdb";
    private final String USER = "piocha";
    private final String PWD = "koke";
    private final String TB = "Editoriales";

    public String insertarEditorial(Editorial e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "INSERT INTO " + TB + "(nombre_editorial) values('" + e.getNombre() + "')";
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Insert Exitoso";
        } else {
            return "Fallo al insertar";
        }
    }

    public String updateEditorial(Editorial e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "UPDATE " + TB + " SET `nombre_editorial`='"+ e.getNombre() +"' WHERE `id_editorial`=" + e.getId();
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Update Exitoso";
        } else {
            return "Falló el update";
        }
    }

    public String deleteEditorial(Editorial e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "DELETE FROM `" + TB + "` WHERE `id_editorial`=" + e.getId();
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Delete Exitoso";
        } else {
            return "Falló el Delete";
        }
    }

    public ArrayList<Editorial> selecEditorial(String condicion) {
        if (condicion.equals("")) {
            condicion = "1=1";
        }

        String query = "SELECT * FROM `"+TB+"` WHERE " + condicion;
        ArrayList<Editorial> listado = new ArrayList<>();
        Editorial editorial = new Editorial();
        Conexion con = new Conexion(DB, USER, PWD);
        ResultSet rs = con.select(query);

        try {
            while (rs.next()) {
                editorial.setId(rs.getInt("id_editorial"));
                editorial.setNombre(rs.getString("nombre_editorial"));
                listado.add(editorial);
                editorial = new Editorial();
            }
            rs.close();
        } catch (NullPointerException | SQLException ex) {
            System.err.println("Trono en la parte del select " + ex.getMessage());
            Logger.getLogger(ConsultasEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listado;
    }
}
