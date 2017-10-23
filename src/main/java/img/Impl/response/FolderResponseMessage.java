package img.Impl.response;

public abstract class FolderResponseMessage {

    private FolderInfo folderInfo;

    public FolderResponseMessage(ResponseType responseType, FolderInfo folderInfo){
        this.folderInfo=folderInfo;
    }
    public FolderInfo getFolderInfo() {
        return folderInfo;
    }

    public void setFolderInfo(FolderInfo folderInfo) {
        this.folderInfo = folderInfo;
    }
}
