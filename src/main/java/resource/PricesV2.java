package resource;

import com.google.gson.Gson;
import entity.Material;
import entity.Price;
import persistence.GenericDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource for <code>Price</code> classes, providing <code>GET</code> method handling for the return of individual results via the <code>Response</code>
 * object.
 *
 * @author tlmirkes
 * @version 1.0
 */
@Path("/pricesV2")
public class PricesV2 {
    private GenericDao<Price> comPoster = new GenericDao(Price.class);
    private Gson gson = new Gson();

    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     * 
     * @param id record ID
     * @return formatted Price result data
     */
    @GET
    @Path("/{id: [0-9]*}/plain_text")
    @Produces({MediaType.TEXT_PLAIN})
    public Response getRequestPlainText(@PathParam("id") int id) {
        String priceData = comPoster.getById(id).toString();
        return Response.status(200).entity(priceData).build();
    }
    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Price result data
     */
    @GET
    @Path("/{id: [0-9]*}/html")
    @Produces({MediaType.TEXT_HTML})
    public Response getRequestHtml(@PathParam("id") int id) {
        Price priceData = comPoster.getById(id);
        String returnHtml = "<h3>Price:</h3><br><p>" + priceData.getPerUnit() + "</p><p>" + priceData.getUnitType() + "</p>";
        return Response.status(200).entity(returnHtml).build();
    }
    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Price result data
     */
    @GET
    @Path("/{id: [0-9]*}/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRequestJson(@PathParam("id") int id) {
        Price priceData = comPoster.getById(id);
        String formattedData = this.gson.toJson(priceData);
        return Response.status(200).entity(formattedData).build();
    }
    /**
     * Accepts <code>PUT</code> requests, using user-provided data to update an existing <code>Price</code> record.
     *
     * @param id existing id
     * @param perUnit new name
     * @param unit new comments
     * @return <code>Response</code> containing result message
     */
    @PUT
    @Path("/alter/{id: [0-9]*}/{perUnit}/{unit}")
    public Response putRequest(@PathParam("id") int id, @PathParam("perUnit") Double perUnit, @PathParam("unit") String unit) {
        Price priceToEdit = comPoster.getById(id);
        priceToEdit.setPerUnit(perUnit);
        priceToEdit.setUnitType(unit);
        comPoster.editEntity(priceToEdit);
        if (comPoster.getById(id) != null) {
            return Response.status(200).entity("Record " + id + " edited:  " + priceToEdit).build();
        } else {
            return Response.status(404).entity("No such record found. Please check the ID and try again.").build();
        }
    }
    /**
     * Accepts <code>DELETE</code> requests, using user-provided data to delete an existing <code>Price</code> record.
     *
     * @param id existing id
     * @return <code>Response</code> containing result message
     */
    @DELETE
    @Path("/drop/{id: [0-9]*}")
    public Response deleteRequest(@PathParam("id") int id) {
        Price priceToDelete = comPoster.getById(id);
        comPoster.deleteEntity(priceToDelete);
        if (comPoster.getById(id) == null) {
            return Response.status(200).entity("Record " + id + " deleted.").build();
        } else {
            return Response.status(404).entity("No such record found. Please check the ID and try again.").build();
        }
    }
}
