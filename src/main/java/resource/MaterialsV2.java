package resource;

import com.google.gson.Gson;
import entity.Material;
import persistence.GenericDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource for <code>Material</code> classes, providing <code>GET</code> method handling for the return of individual results via the <code>Response</code>
 * object.
 *
 * @author tlmirkes
 * @version 1.0
 */
@Path("/materialsV2")
public class MaterialsV2 {
    private GenericDao<Material> comPoster = new GenericDao(Material.class);
    private Gson gson = new Gson();

    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Material result data
     */
    @GET
    @Path("/{id: [0-9]*}/plain_text")
    @Produces({MediaType.TEXT_PLAIN})
    public Response getRequestPlainText(@PathParam("id") int id) {
        String materialData = comPoster.getById(id).toString();
        return Response.status(200).entity(materialData).build();
    }
    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Material result data
     */
    @GET
    @Path("/{id: [0-9]*}/html")
    @Produces({MediaType.TEXT_HTML})
    public Response getRequestHtml(@PathParam("id") int id) {
        Material materialData = comPoster.getById(id);
        String returnHtml = "<h3>Material:</h3><br><p>" + materialData.getName() + "</p><p>" + materialData.getComments() + "</p>";
        return Response.status(200).entity(returnHtml).build();
    }
    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Material result data
     */
    @GET
    @Path("/{id: [0-9]*}/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRequestJson(@PathParam("id") int id) {
        Material materialData = comPoster.getById(id);
        String formattedData = this.gson.toJson(materialData);
        return Response.status(200).entity(formattedData).build();
    }
    /**
     * Accepts <code>PUT</code> requests, using user-provided data to update an existing <code>Material</code> record.
     *
     * @param id existing id
     * @param name new name
     * @param comments new comments
     * @return <code>Response</code> containing result message
     */
    @PUT
    @Path("/alter/{id: [0-9]*}/{name}/{comments}")
    public Response putRequest(@PathParam("id") int id, @PathParam("name") String name, @PathParam("comments") String comments) {
        Material materialToEdit = comPoster.getById(id);
        materialToEdit.setName(name);
        materialToEdit.setComments(comments);
        comPoster.editEntity(materialToEdit);
        if (comPoster.getById(id) != null) {
            return Response.status(200).entity("Record " + id + " edited:  " + materialToEdit).build();
        } else {
            return Response.status(404).entity("No such record found. Please check the ID and try again.").build();
        }
    }
    /**
     * Accepts <code>DELETE</code> requests, using user-provided data to delete an existing <code>Material</code> record.
     *
     * @param id existing id
     * @return <code>Response</code> containing result message
     */
    @DELETE
    @Path("/drop/{id: [0-9]*}")
    public Response deleteRequest(@PathParam("id") int id) {
        Material materialToDelete = comPoster.getById(id);
        comPoster.deleteEntity(materialToDelete);
        if (comPoster.getById(id) == null) {
            return Response.status(200).entity("Record " + id + " deleted.").build();
        } else {
            return Response.status(404).entity("No such record found. Please check the ID and try again.").build();
        }
    }
}
