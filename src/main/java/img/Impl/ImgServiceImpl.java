package img.Impl;

import img.ImgService;
import img.Impl.response.*;

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

    @Override
    public ImageResponseMessage getAnImage() {

        return getImageResponseMessage();

    }

    @Override
    public byte[] getImageData() {
        return new byte[0];
    }

    @Override
    public FolderResponseMessage getFolders() {

        return getFolderInformation();
    }



}
