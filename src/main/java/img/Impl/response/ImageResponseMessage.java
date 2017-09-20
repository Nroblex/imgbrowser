package img.Impl.response;

public abstract class ImageResponseMessage {
    private  byte[] imgArray;

    public ImageResponseMessage(ResponseType responseType, byte[] imgArray){
        this.imgArray = imgArray;
    }

    public byte[] getImgArray() {
        return imgArray;
    }

    public void setImgArray(byte[] imgArray) {
        this.imgArray = imgArray;
    }
}
