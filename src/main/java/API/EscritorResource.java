/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Autor;
import negocio.EscritorJson;

/**
 * REST Web Service
 *
 * @author georg
 */
@Path("escritor")
public class EscritorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EscritorResource
     */
    public EscritorResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(Autor cardamomo) {
        EscritorJson escritor = new EscritorJson();

        try {
            escritor.addEscritor(cardamomo);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return cardamomo.getNombre();
    }

    /**
     * Retrieves representation of an instance of API.EscritorResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        EscritorJson escritor = new EscritorJson();
        return escritor.datosEscritor();
    }

    /**
     * Retrieves representation of an instance of API.EditorialResource
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonById(@PathParam("id") String id) {
        //TODO return proper representation object
        EscritorJson escritor = new EscritorJson();
        return escritor.escritorById(id);
    }

    /**
     * PUT method for updating or creating an instance of EscritorResource
     *
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(Autor content) {
        EscritorJson escritor = new EscritorJson();
        try {
            escritor.modEscritor(content);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return content.getNombre();
    }
    
    /**
     * DELETE method for delete an instance of EditorialResource
     * @param content representation for the resource
     * @return 
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteJson(Autor content) {
        EscritorJson escritor = new EscritorJson();
        String str = "";
        
        try {
            escritor.delEscritor(content);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
  
        return str;
    }
}
