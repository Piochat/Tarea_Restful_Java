/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.ConsultasDibujante;
import java.util.List;
import modelo.Autor;

/**
 *
 * @author georg
 */
public class DibujanteJson {
    
    public String datosDibujantes() {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasDibujante consulta = new ConsultasDibujante();
        List<Autor> editoriales = consulta.selecDibujante("");
        
        try {
            retorno = mapper.writeValueAsString(editoriales);
        } catch (JsonProcessingException e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
        }
        
        return retorno;
    }
    
    public String addDibujante(Autor ed) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "";
        ConsultasDibujante consulta = new ConsultasDibujante();
        
        try {
            if (consulta.insertarDibujante(ed).equals("Insert Exitoso")) {
                retorno = "Isnertado";
            }
        } catch (Exception e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
            retorno = "Error";
        }
        
        return retorno;
    }
    
    public String dibujanteById(String id) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasDibujante consulta = new ConsultasDibujante();
        List<Autor> editoriales = consulta.selecDibujante("id_dibujante=" + id);
        
        try {
            retorno = mapper.writeValueAsString(editoriales);
        } catch (JsonProcessingException e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
        }
        
        return retorno;
    }
    
    public String modDibujante(Autor ed) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "";
        ConsultasDibujante consulta = new ConsultasDibujante();
        
        try {
            if (consulta.updateDibujante(ed).equals("Update Exitoso")) {
                retorno = "Actualizado";
            }
        } catch (Exception e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
            retorno = "Error";
        }
        
        return retorno;
    }
    
    public String delDibujante(Autor ed) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "";
        ConsultasDibujante consulta = new ConsultasDibujante();
        
        try {
            if (consulta.deleteDibujante(ed).equals("Delete Exitoso")) {
                retorno = "Borrado";
            }
        } catch (Exception e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
            retorno = "Error";
        }
        
        return retorno;
    }
}
