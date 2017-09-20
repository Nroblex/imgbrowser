package img.Impl.response;

import org.codehaus.enunciate.json.JsonRootType;

@JsonRootType
public class ImageResponse extends ImageResponseMessage {

    public ImageResponse(ResponseType responseType, byte[] imgArray) {
        super(responseType, imgArray);
    }
}
