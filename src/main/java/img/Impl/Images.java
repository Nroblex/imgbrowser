package img.Impl;

import img.ResponseMessage;

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
