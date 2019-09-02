/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.ConsultasEditorial;
import java.util.List;
import modelo.Editorial;

/**
 *
 * @author georg
 */
public class EditorialJson {
    
    public String datosEditorial() {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasEditorial consulta = new ConsultasEditorial();
        List<Editorial> editoriales = consulta.selecEditorial("");
        
        try {
            retorno = mapper.writeValueAsString(editoriales);
        } catch (JsonProcessingException e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
        }
        
        return retorno;
    }
    
    public String addEditorial(Editorial ed) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "";
        ConsultasEditorial consulta = new ConsultasEditorial();
        
        try {
            if (consulta.insertarEditorial(ed).equals("Insert Exitoso")) {
                retorno = "Isnertado";
            }
        } catch (Exception e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
            retorno = "Error";
        }
        
        return null;
    }
    
    public String editorialById(String id) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasEditorial consulta = new ConsultasEditorial();
        List<Editorial> editoriales = consulta.selecEditorial("id_editorial=" + id);
        
        try {
            retorno = mapper.writeValueAsString(editoriales);
        } catch (JsonProcessingException e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
        }
        
        return retorno;
    }
    
    public String updateEditorial(Editorial ed) {
        return null;
    }
}
