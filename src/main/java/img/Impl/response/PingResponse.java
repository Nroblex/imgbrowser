package img.Impl.response;

import org.codehaus.enunciate.json.JsonRootType;

@JsonRootType
public class PingResponse extends ResponseMessage {
    public PingResponse(final String answer) {
        super(ResponseType.RESPONSE_PING, answer);
    }
}
