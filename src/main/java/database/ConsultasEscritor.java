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
public class ConsultasEscritor {

    private final String DB = "comicsdb";
    private final String USER = "piocha";
    private final String PWD = "kok";
    private final String TB = "Escritores";

    public String insertarEscritor(Autor e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "INSERT INTO " + TB + "(nombre_escritor, appellido_escritor) values('"
                + e.getNombre() + "', '" + e.getApellido() + "')";
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Insert Exitoso";
        } else {
            return "Fallo al insertar";
        }
    }
    
    public String updateEscritor(Autor e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "UPDATE " + TB + " SET `nombre_escritor`='" + e.getNombre() +
                "',`appellido_escritor`='" + e.getApellido() +"' WHERE `id_escritor`=" + e.getId();
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Update Exitoso";
        } else {
            return "Falló el update";
        }
    }
    
    public String deleteEscritor(Autor e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "DELETE FROM `" + TB + "` WHERE `id_escritor`=" + e.getId();
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Delete Exitoso";
        } else {
            return "Falló el Delete";
        }
    }
    
    public ArrayList<Autor> selecEscritor(String condicion) {
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
                autor.setId(rs.getInt("id_escritor"));
                autor.setNombre(rs.getString("nombre_escritor"));
                autor.setApellido(rs.getString("appellido_escritor"));
                listado.add(autor);
                autor = new Autor();
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasEscritor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listado;
    }
}
