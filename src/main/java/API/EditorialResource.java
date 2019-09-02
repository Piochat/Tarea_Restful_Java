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
import modelo.Editorial;
import negocio.EditorialJson;

/**
 * REST Web Service
 *
 * @author georg
 */
@Path("editorial")
public class EditorialResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EditorialResource
     */
    public EditorialResource() {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.APPLICATION_JSON) 
    public String postJson(Editorial cardamomo) {
        EditorialJson editorial = new EditorialJson();
        
        try {
            editorial.addEditorial(cardamomo);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
  
        return cardamomo.getNombre();
    }
    
    /**
     * Retrieves representation of an instance of API.EditorialResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        EditorialJson editorial = new EditorialJson();
        return editorial.datosEditorial();
    }
    
    /**
     * Retrieves representation of an instance of API.EditorialResource
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonById(@PathParam("id") String id) {
        //TODO return proper representation object
        EditorialJson editorial = new EditorialJson();
        return editorial.editorialById(id);
    }

    /**
     * PUT method for updating or creating an instance of EditorialResource
     * @param content representation for the resource
     * @return 
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(Editorial content) {
        EditorialJson editorial = new EditorialJson();
        
        try {
            editorial.modEditorial(content);
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
    public String deleteJson(Editorial content) {
        EditorialJson editorial = new EditorialJson();
        String str = "";
        
        try {
            editorial.delEditorial(content);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
  
        return str;
    }
}
