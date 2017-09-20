package img.Impl;

import img.Impl.response.ImageResponse;
import img.Impl.response.ImageResponseMessage;
import img.Impl.response.ResponseType;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;


public class Images {

    private String imagePath = "";
    Properties properties = new Properties();

    InputStream inputStream = null;

    public String getImagePath()  {

        try {

            checkIfFileExists();

            inputStream= new FileInputStream("config.properties");
            properties.load(inputStream);

            imagePath = properties.getProperty("imagedirectory", "/repository/imgs");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return "ContextPath: " + imagePath;
    }

    public ImageResponseMessage getImageResponseMessage(){
        byte[] imgData = getImage();
        if (imgData != null){
            return new ImageResponse(ResponseType.RESPONSE_SUCCESS, imgData);
        } else {
            return new ImageResponse(ResponseType.RESPONSE_FAILURE, null);
        }
    }

    private byte[] getImage(){


        //File f = new File("/repository/imgs/svensk-sommar.jpg");
        File f = new File("C:\\Users\\SEAS19062\\Pictures\\Clown.jpg");
        try {

            return Files.readAllBytes(f.toPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    private void checkIfFileExists() {

        File f = new File("config.properties");
        if (!f.exists() ){
            try {
                OutputStream fs = new FileOutputStream("config.properties");
                properties.setProperty("imagedirectory", "/repository/imgs");
                properties.store(fs, null);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
