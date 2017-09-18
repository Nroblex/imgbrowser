package img.Impl;

import img.ImgService;
import img.PingResponse;
import img.ResponseMessage;

import javax.ws.rs.core.Response;


public class ImgServiceImpl extends Images implements ImgService {

    @Override
    public PingResponse ping() {
        return new PingResponse("This is a successmessage!");
    }

    @Override
    public Response ping2() {

        return Response.status(200).entity(new PingResponse("OK!")).build();

    }

    @Override
    public ResponseMessage viewConfiguration(){

        return new PingResponse(getImagePath());

    }

}
