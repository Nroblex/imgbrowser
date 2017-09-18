package img;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/images")
@Produces(MediaType.APPLICATION_JSON)
public interface ImgService {


    @GET
    @Path("/ping")
    public PingResponse ping();

    @GET
    @Path("/ping2")
    public Response ping2();


    @GET
    @Path("/configuration")
    public ResponseMessage viewConfiguration();

}
