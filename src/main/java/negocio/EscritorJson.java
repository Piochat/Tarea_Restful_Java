/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.ConsultasEscritor;
import java.util.List;
import modelo.Autor;

/**
 *
 * @author georg
 */
public class EscritorJson {
    
    public String datosEscritor() {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasEscritor consulta = new ConsultasEscritor();
        List<Autor> dibujantes = consulta.selecEscritor("");
        
        try {
            retorno = mapper.writeValueAsString(dibujantes);
        } catch (JsonProcessingException e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
        }
        
        return retorno;
    }
    
    public String addEscritor(Autor ed) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasEscritor consulta = new ConsultasEscritor();
        
         try {
            if (consulta.insertarEscritor(ed).equals("Insert Exitoso")) {
                retorno = "Isnertado";
            }
        } catch (Exception e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
            retorno = "Error";
        }
        
        return retorno;
    }
    
    public String escritorById(String id) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasEscritor consulta = new ConsultasEscritor();
        List<Autor> dibujantes = consulta.selecEscritor("id_escritor=" + id);
        
        try {
            retorno = mapper.writeValueAsString(dibujantes);
        } catch (JsonProcessingException e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
        }
        
        return retorno;
    }
    
    public String modEscritor(Autor ed) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasEscritor consulta = new ConsultasEscritor();
        
         try {
            if (consulta.updateEscritor(ed).equals("Update Exitoso")) {
                retorno = "Actualizado";
            }
        } catch (Exception e) {
            System.err.println("Ediotrial Json " + e.getMessage());
            System.err.println(e.toString());
            retorno = "Error";
        }
        
        return retorno;
    }
    
    public String delEscritor(Autor ed) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasEscritor consulta = new ConsultasEscritor();
        
         try {
            if (consulta.deleteEscritor(ed).equals("Update Exitoso")) {
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
