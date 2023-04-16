package resource;

import com.google.gson.Gson;
import entity.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Root resource for <code>Material</code> classes, providing <code>POST</code> method handling for creation of new records.
 *
 * @author tlmirkes
 * @version 1.0
 */
@Path("/materialsV3")
public class MaterialsV3 {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Material> comPoster = new GenericDao(Material.class);
    private Gson gson = new Gson();

    /**
     * Accepts <code>POST</code> requests, passing parameters to the DAO class to create a new resource record.  The
     * <code>Response</code> object contains an appropriate HTTP status code and the data inserted.
     *
     * @param name Material name
     * @param comm Material comments
     * @return ID of the new Material record
     */
    @POST
    @Path("/{name}/{comments}")
    @Consumes("application/x-www-form-urlencoded")
    public Response postRequest(@PathParam("name") String name, @PathParam("comments") String comm) {
        int newId = comPoster.addEntity(new Material(name, comm));
        Material insertedMaterial = comPoster.getById(newId);
        return Response.status(201).entity("New Material added!  -->  " + insertedMaterial.toString()).build();
    }
}
