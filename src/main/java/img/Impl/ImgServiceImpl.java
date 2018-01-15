package img.Impl;

import img.ImgService;
import img.PingResponse;
import img.ResponseMessage;

import javax.ws.rs.core.Response;


public class ImgServiceImpl implements ImgService {

    @Override
    public PingResponse ping() {
        return new PingResponse("This is a successmessage, ping was success!!");
    }

    @Override
    public Response ping2() {

        return Response.status(200).entity(new PingResponse("OK!")).build();

    }
}
