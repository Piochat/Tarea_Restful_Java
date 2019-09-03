/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.ConsultasComic;
import java.util.List;
import modelo.Comic;

/**
 *
 * @author georg
 */
public class ComicJson {

    public String datosComic() {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasComic consulta = new ConsultasComic();
        List<Comic> comics = consulta.selecComic("");

        try {
            retorno = mapper.writeValueAsString(comics);
        } catch (JsonProcessingException e) {
            System.err.println("Comic Json " + e.getMessage());
            System.err.println(e.toString());
        }

        return retorno;
    }

    public String addComic(Comic co) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasComic consulta = new ConsultasComic();

        try {
            if (consulta.insertarComic(co).equals("Insert Exitoso")) {
                retorno = "Isnertado";
            }
        } catch (Exception e) {
            System.err.println("Comic Json " + e.getMessage());
            System.err.println(e.toString());
            retorno = "Error";
        }

        return retorno;
    }
    
    public String comicById(String id) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasComic consulta = new ConsultasComic();
        List<Comic> comics = consulta.selecComic("`id_comic`=" + id);

        try {
            retorno = mapper.writeValueAsString(comics);
        } catch (JsonProcessingException e) {
            System.err.println("Comic Json " + e.getMessage());
            System.err.println(e.toString());
        }

        return retorno;
    }
    
    public String modComic(Comic co) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasComic consulta = new ConsultasComic();

        try {
            if (consulta.updateComic(co).equals("Update Exitoso")) {
                retorno = "Actualizado";
            }
        } catch (Exception e) {
            System.err.println("Comic Json " + e.getMessage());
            System.err.println(e.toString());
            retorno = "Error";
        }

        return retorno;
    }
    
    public String delComic(Comic co) {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "Error";
        ConsultasComic consulta = new ConsultasComic();

        try {
            if (consulta.deleteComic(co).equals("Delete Exitoso")) {
                retorno = "Borrado";
            }
        } catch (Exception e) {
            System.err.println("Comic Json " + e.getMessage());
            System.err.println(e.toString());
            retorno = "Error";
        }

        return retorno;
    }
}
