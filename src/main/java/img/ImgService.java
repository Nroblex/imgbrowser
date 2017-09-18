package img;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/images")
public interface ImgService {


    @GET
    @Path("/ping")
    public PingResponse ping();

}
