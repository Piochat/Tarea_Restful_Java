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
import modelo.Comic;

/**
 *
 * @author georg
 */
public class ConsultasComic {
    
    private final String DB = "comicsdb";
    private final String USER = "piocha";
    private final String PWD = "kok";
    private final String TB = "Comics";
    
    public String insertarComic(Comic e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "INSERT INTO " + TB + "(nombre_comic, ruta_comic, img_comic, editoria_id, escritor_id, dibujante_id) "
                + "values('"+ e.getNombre() + "', '" + e.getRuta()+ "', '" + e.getImgn() + "', " 
                + e.getEditorial() + ", " + e.getEscritor() + ", " + e.getDibujante() + ")";
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Insert Exitoso";
        } else {
            return "Fallo al insertar";
        }
    }
    
    public String updateComic(Comic e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "UPDATE " + TB + " SET `nombre_comic`='" + e.getNombre() +
                "',`ruta_comic`='" + e.getRuta()+"', `img_comic`='" + e.getImgn() + 
                "',`editoria_id`=" + e.getEditorial() + ", `escritor_id`=" + e.getEscritor() + 
                ",`dibujante_id`=" + e.getDibujante() + " WHERE `id_comic`=" + e.getId();
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Update Exitoso";
        } else {
            return "Falló el update";
        }
    }
    
    public String deleteComic(Comic e) {
        Conexion con = new Conexion(DB, USER, PWD);
        String query = "DELETE FROM `" + TB + "` WHERE `id_comic`=" + e.getId();
        String result = con.insertUpdatDel(query);

        if ("Ok".equals(result)) {
            return "Delete Exitoso";
        } else {
            return "Falló el Delete";
        }
    }
    
        public ArrayList<Comic> selecComic(String condicion) {
        if (condicion.equals("")) {
            condicion = "1=1";
        }

        String query = "SELECT * FROM `"+ TB +"` WHERE " + condicion;
        ArrayList<Comic> listado = new ArrayList<>();
        Comic comic = new Comic();
        Conexion con = new Conexion(DB, USER, PWD);
        ResultSet rs = con.select(query);

        try {
            while (rs.next()) {
                comic.setId(rs.getInt("id_comic"));
                comic.setNombre(rs.getString("nombre_comic"));
                comic.setRuta(rs.getString("ruta_comic"));
                comic.setImgn(rs.getString("img_comic"));
                comic.setEditorial(rs.getInt("editoria_id"));
                comic.setEscritor(rs.getInt("escritor_id"));
                comic.setDibujante(rs.getInt("dibujante_id"));
                listado.add(comic);
                comic = new Comic();
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasComic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listado;
    }
}
