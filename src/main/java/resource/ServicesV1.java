package resource;

import com.google.gson.Gson;
import entity.Service;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Root resource for <code>Service</code> classes, providing <code>GET</code> method handling for the return of result lists via the <code>Response</code>
 * object.
 *
 * @author tlmirkes
 * @version 1.0
 */
@Path("/servicesV1/")
public class ServicesV1 {
    private GenericDao<Service> comPoster = new GenericDao(Service.class);
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
        List<Service> allServices = new ArrayList(comPoster.getAll());
        while (counter < allServices.size()) {
            listToString(allServices.get(counter));
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
        List<Service> allServices = new ArrayList(comPoster.getAll());
        while (counter < allServices.size()) {
            listToHtml(allServices.get(counter));
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
        List<Service> allServices = new ArrayList(comPoster.getAll());
        while (counter < allServices.size()) {
            listToString(allServices.get(counter));
            counter++;
        }
        String formattedData = this.gson.toJson(returnData);
        return Response.status(200).entity(formattedData).build();
    }

    /**
     * Aggregates <code>String</code> output from the passed <code>Service</code> object for use in constructing the
     * <code>Response</code> object attributes.
     *
     * @param thisService Service object in <code>ResultSet</code> data
     */
    public void listToString(Service thisService) {
        returnData += thisService.toString() + "\n";
    }

    /**
     * Aggregates <code>String</code> output to construct <code>HTML</code> from the passed <code>Service</code> object for use
     * in constructing the <code>Response</code> object attributes.
     *
     * @param thisService Service object in <code>ResultSet</code> data
     */
    public void listToHtml(Service thisService) {
        returnData += "<p>" + thisService.toString() + "</p>";
    }
}
