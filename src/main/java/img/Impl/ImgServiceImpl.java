package img.Impl;

import img.ImgService;
import img.PingResponse;

public class ImgServiceImpl implements ImgService {

    public PingResponse ping() {
        return new PingResponse("This is a successmessage!");
    }
}
