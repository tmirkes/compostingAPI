package resource;

import com.google.gson.Gson;
import entity.Material;
import entity.Period;
import persistence.GenericDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource for <code>Period</code> classes, providing <code>GET</code> method handling for the return of individual results via the <code>Response</code>
 * object.
 *
 * @author tlmirkes
 * @version 1.0
 */
@Path("/periodsV2")
public class PeriodsV2 {
    private GenericDao<Period> comPoster = new GenericDao(Period.class);
    private Gson gson = new Gson();

    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Period result data
     */
    @GET
    @Path("/{id: [0-9]*}/plain_text")
    @Produces({MediaType.TEXT_PLAIN})
    public Response getRequestPlainText(@PathParam("id") int id) {
        String periodData = comPoster.getById(id).toString();
        return Response.status(200).entity(periodData).build();
    }
    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Period result data
     */
    @GET
    @Path("/{id: [0-9]*}/html")
    @Produces({MediaType.TEXT_HTML})
    public Response getRequestHtml(@PathParam("id") int id) {
        Period periodData = comPoster.getById(id);
        String returnHtml = "<h3>Period:</h3><br><p>" + periodData.getFrequency() + "</p><p>" + periodData.getTimeUnit() + "</p>";
        return Response.status(200).entity(returnHtml).build();
    }
    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @param id record ID
     * @return formatted Period result data
     */
    @GET
    @Path("/{id: [0-9]*}/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRequestJson(@PathParam("id") int id) {
        Period periodData = comPoster.getById(id);
        String formattedData = this.gson.toJson(periodData);
        return Response.status(200).entity(formattedData).build();
    }
    /**
     * Accepts <code>PUT</code> requests, using user-provided data to update an existing <code>Period</code> record.
     *
     * @param id existing id
     * @param frequency new name
     * @param timeUnit new comments
     * @return <code>Response</code> containing result message
     */
    @PUT
    @Path("/alter/{id: [0-9]*}/{frequency}/{timeUnit}")
    public Response putRequest(@PathParam("id") int id, @PathParam("frequency") int frequency, @PathParam("timeUnit") String timeUnit) {
        Period periodToEdit = comPoster.getById(id);
        periodToEdit.setFrequency(frequency);
        periodToEdit.setTimeUnit(timeUnit);
        comPoster.editEntity(periodToEdit);
        if (comPoster.getById(id) != null) {
            return Response.status(200).entity("Record " + id + " edited:  " + periodToEdit).build();
        } else {
            return Response.status(404).entity("No such record found. Please check the ID and try again.").build();
        }
    }
    /**
     * Accepts <code>DELETE</code> requests, using user-provided data to delete an existing <code>Period</code> record.
     *
     * @param id existing id
     * @return <code>Response</code> containing result message
     */
    @DELETE
    @Path("/drop/{id: [0-9]*}")
    public Response deleteRequest(@PathParam("id") int id) {
        Period periodToDelete = comPoster.getById(id);
        comPoster.deleteEntity(periodToDelete);
        if (comPoster.getById(id) == null) {
            return Response.status(200).entity("Record " + id + " deleted.").build();
        } else {
            return Response.status(404).entity("No such record found. Please check the ID and try again.").build();
        }
    }
}
