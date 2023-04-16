package resource;

import com.google.gson.Gson;
import entity.Period;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Root resource for <code>Period</code> classes, providing <code>POST</code> method handling for creation of new records.
 *
 * @author tlmirkes
 * @version 1.0
 */
@Path("/periodsV3")
public class PeriodsV3 {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Period> comPoster = new GenericDao(Period.class);
    private Gson gson = new Gson();

    /**
     * Accepts <code>POST</code> requests, passing parameters to the DAO class to create a new resource record.  The
     * <code>Response</code> object contains an appropriate HTTP status code and the data inserted.
     *
     * @param frequency Period frequency
     * @param timeUnit Period unit of time
     * @return ID of the new Period record
     */
    @POST
    @Path("/{frequency}/{timeUnit}")
    @Consumes("application/x-www-form-urlencoded")
    public Response postRequest(@PathParam("frequency") int frequency, @PathParam("timeUnit") String timeUnit) {
        int newId = comPoster.addEntity(new Period(frequency, timeUnit));
        Period insertedPeriod = comPoster.getById(newId);
        return Response.status(201).entity("New Period added!  -->  " + insertedPeriod.toString()).build();
    }
}
