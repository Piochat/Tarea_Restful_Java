/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
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
     * PUT method for updating or creating an instance of EditorialResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
