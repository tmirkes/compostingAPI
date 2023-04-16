package resource;

import com.google.gson.Gson;
import entity.Period;
import persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
}
