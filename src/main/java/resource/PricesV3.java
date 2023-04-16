package resource;

import com.google.gson.Gson;
import entity.Price;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Root resource for <code>Price</code> classes, providing <code>POST</code> method handling for creation of new records.
 *
 * @author tlmirkes
 * @version 1.0
 */
@Path("/pricesV3")
public class PricesV3 {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Price> comPoster = new GenericDao(Price.class);
    private Gson gson = new Gson();

    /**
     * Accepts <code>POST</code> requests, passing parameters to the DAO class to create a new resource record.  The
     * <code>Response</code> object contains an appropriate HTTP status code and the data inserted.
     * 
     * @param price Price cost
     * @param unit Price unit of measure
     * @return ID of the new Price record
     */
    @POST
    @Path("/{price}/{unit}")
    @Consumes("application/x-www-form-urlencoded")
    public Response postRequest(@PathParam("price") Double price, @PathParam("unit") String unit) {
        int newId = comPoster.addEntity(new Price(price, unit));
        Price insertedPrice = comPoster.getById(newId);
        return Response.status(201).entity("New Price added!  -->  " + insertedPrice.toString()).build();
    }
}
