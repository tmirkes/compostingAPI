package resource;

import com.google.gson.Gson;
import entity.Service;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

/**
 * Root resource for <code>Service</code> classes, providing <code>POST</code> method handling for creation of new records.
 *
 * @author tlmirkes
 * @version 1.0
 */
@Path("/servicesV3")
public class ServicesV3 {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Service> comPoster = new GenericDao(Service.class);
    private Gson gson = new Gson();

    /**
     * Accepts <code>POST</code> requests, passing parameters to the DAO class to create a new resource record.  The
     * <code>Response</code> object contains an appropriate HTTP status code and the data inserted.
     *
     * @param name Service name
     * @param desc Service description
     * @return ID of the new Service record
     */
    @POST
    @Path("/{name}/{description}")
    @Consumes("application/x-www-form-urlencoded")
    public Response postRequest(@PathParam("name") String name, @PathParam("description") String desc) {
        int newId = comPoster.addEntity(new Service(name, desc));
        Service insertedService = comPoster.getById(newId);
        return Response.status(201).entity("New Service added!  -->  " + insertedService.toString()).build();
    }
}
