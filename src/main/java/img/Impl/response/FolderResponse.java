package img.Impl.response;

import org.codehaus.enunciate.json.JsonRootType;

@JsonRootType
public class FolderResponse extends FolderResponseMessage {
    public FolderResponse(ResponseType responseType, FolderInfo folderInfo){
        super(responseType, folderInfo );
    }

}
