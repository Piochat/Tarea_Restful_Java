/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Autor;

/**
 *
 * @author georg
 */
public class ConsultasDibujante {
    
    private final String DB = "comicsdb";
    private final String USER = "piocha";
    private final String PWD = "kok";
    private final String TB = "Dibujantes";

    public String insertarDibujante(Autor e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "INSERT INTO " + TB + "(nombre_dibujante, appellido_dibujante) values('"
                + e.getNombre() + "', '" + e.getApellido() + "')";
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Insert Exitoso";
        } else {
            return "Fallo al insertar";
        }
    }
    
    public String updateDibujante(Autor e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "UPDATE " + TB + " SET `nombre_dibujante`='" + e.getNombre() +
                "',`appellido_dibujante`='" + e.getApellido() +"' WHERE `id_dibujante`=" + e.getId();
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Update Exitoso";
        } else {
            return "Falló el update";
        }
    }
    
    public String deleteDibujante(Autor e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "DELETE FROM `" + TB + "` WHERE `id_dibujante`=" + e.getId();
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Delete Exitoso";
        } else {
            return "Falló el Delete";
        }
    }
    
    public ArrayList<Autor> selecDibujante(String condicion) {
        if (condicion.equals("")) {
            condicion = "1=1";
        }

        String query = "SELECT * FROM `"+ TB +"` WHERE " + condicion;
        ArrayList<Autor> listado = new ArrayList<>();
        Autor autor = new Autor();
        Conexion con = new Conexion(DB, USER, PWD);
        ResultSet rs = con.select(query);

        try {
            while (rs.next()) {
                autor.setId(rs.getInt("id_dibujante"));
                autor.setNombre(rs.getString("nombre_dibujante"));
                autor.setApellido(rs.getString("appellido_dibujante"));
                listado.add(autor);
                autor = new Autor();
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDibujante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listado;
    }
}
