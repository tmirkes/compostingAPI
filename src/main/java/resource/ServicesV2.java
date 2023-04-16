package resource;

import com.google.gson.Gson;
import entity.Material;
import entity.Service;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import persistence.*;

/**
 * Root resource for <code>Service</code> classes, providing <code>GET</code> method handling for the return of individual results via the <code>Response</code>
 * object.
 *
 * @author tlmirkes
 * @version 1.0
 */
@Path("/servicesV2")
public class ServicesV2 {
    private GenericDao<Service> comPoster = new GenericDao(Service.class);
    private Gson gson = new Gson();

    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Service result data
     */
    @GET
    @Path("/{id: [0-9]*}/plain_text")
    @Produces({MediaType.TEXT_PLAIN})
    public Response getRequestPlainText(@PathParam("id") int id) {
        String serviceData = comPoster.getById(id).toString();
        return Response.status(200).entity(serviceData).build();
    }
    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Service result data
     */
    @GET
    @Path("/{id: [0-9]*}/html")
    @Produces({MediaType.TEXT_HTML})
    public Response getRequestHtml(@PathParam("id") int id) {
        Service serviceData = comPoster.getById(id);
        String returnHtml = "<h3>Service:</h3><br><p>" + serviceData.getName() + "</p><p>" + serviceData.getDescription() + "</p>";
        return Response.status(200).entity(returnHtml).build();
    }
    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Service result data
     */
    @GET
    @Path("/{id: [0-9]*}/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRequestJson(@PathParam("id") int id) {
        Service serviceData = comPoster.getById(id);
        String formattedData = this.gson.toJson(serviceData);
        return Response.status(200).entity(formattedData).build();
    }
    /**
     * Accepts <code>PUT</code> requests, using user-provided data to update an existing <code>Service</code> record.
     *
     * @param id existing id
     * @param name new name
     * @param description new description
     * @return <code>Response</code> containing result message
     */
    @PUT
    @Path("/alter/{id: [0-9]*}/{name}/{description}")
    public Response putRequest(@PathParam("id") int id, @PathParam("name") String name, @PathParam("description") String description) {
        Service serviceToEdit = comPoster.getById(id);
        serviceToEdit.setName(name);
        serviceToEdit.setDescription(description);
        comPoster.editEntity(serviceToEdit);
        if (comPoster.getById(id) != null) {
            return Response.status(200).entity("Record " + id + " edited:  " + serviceToEdit).build();
        } else {
            return Response.status(404).entity("No such record found. Please check the ID and try again.").build();
        }
    }
    /**
     * Accepts <code>DELETE</code> requests, using user-provided data to delete an existing <code>Service</code> record.
     *
     * @param id existing id
     * @return <code>Response</code> containing result message
     */
    @DELETE
    @Path("/drop/{id: [0-9]*}")
    public Response deleteRequest(@PathParam("id") int id) {
        Service serviceToDelete = comPoster.getById(id);
        comPoster.deleteEntity(serviceToDelete);
        if (comPoster.getById(id) == null) {
            return Response.status(200).entity("Record " + id + " deleted.").build();
        } else {
            return Response.status(404).entity("No such record found. Please check the ID and try again.").build();
        }
    }
}