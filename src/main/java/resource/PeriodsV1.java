package resource;

import com.google.gson.Gson;
import entity.Period;
import persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Root resource for <code>Period</code> classes, providing <code>GET</code> method handling for the return of result lists via the <code>Response</code>
 * object.
 *
 * @author tlmirkes
 * @version 1.0
 */
@Path("/periodsV1/")
public class PeriodsV1 {
    private GenericDao<Period> comPoster = new GenericDao(Period.class);
    private Gson gson = new Gson();
    private String returnData = "";
    private int counter = 0;

    /**
     * Accepts <code>GET</code> requests, returning a <code>text/plain</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @return Response object
     */
    @GET
    @Path("/plain_text")
    @Produces({ MediaType.TEXT_PLAIN })
    public Response getRequestAllPlainText() {
        returnData = "";
        counter = 0;
        List<Period> allPeriods = new ArrayList(comPoster.getAll());
        while (counter < allPeriods.size()) {
            listToString(allPeriods.get(counter));
            counter++;
        }
        return Response.status(200).entity(returnData).build();
    }

    /**
     * Accepts <code>GET</code> requests, returning a <code>text/html</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @return Response object
     */
    @GET
    @Path("/html")
    @Produces({MediaType.TEXT_HTML})
    public Response getRequestAllHtml() {
        returnData = "<h1>Records found:</h1>";
        counter = 0;
        List<Period> allPeriods = new ArrayList(comPoster.getAll());
        while (counter < allPeriods.size()) {
            listToHtml(allPeriods.get(counter));
            counter++;
        }
        return Response.status(200).entity(returnData).build();
    }

    /**
     * Accepts <code>GET</code> requests, returning a <code>application/json</code> entity within a <code>Response</code> object
     * containing an appropriate response code.
     *
     * @return Response object
     */
    @GET
    @Path("/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRequestAllJson() {
        returnData = "";
        counter = 0;
        List<Period> allPeriods = new ArrayList(comPoster.getAll());
        while (counter < allPeriods.size()) {
            listToString(allPeriods.get(counter));
            counter++;
        }
        String formattedData = this.gson.toJson(returnData);
        return Response.status(200).entity(formattedData).build();
    }

    /**
     * Aggregates <code>String</code> output from the passed <code>Period</code> object for use in constructing the
     * <code>Response</code> object attributes.
     *
     * @param thisPeriod Period object in <code>ResultSet</code> data
     */
    public void listToString(Period thisPeriod) {
        returnData += thisPeriod.toString() + "\n";
    }

    /**
     * Aggregates <code>String</code> output to construct <code>HTML</code> from the passed <code>Period</code> object for use
     * in constructing the <code>Response</code> object attributes.
     *
     * @param thisPeriod Period object in <code>ResultSet</code> data
     */
    public void listToHtml(Period thisPeriod) {
        returnData += "<p>" + thisPeriod.toString() + "</p>";
    }
}
