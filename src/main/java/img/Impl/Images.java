package img.Impl;

import img.Impl.response.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Images {

    private String imagePath = "";
    private Pattern JPG_ENTRY_PATTERN = Pattern.compile("^.*logic.(\\w+)\\.jpg$");
    public String getImagePath()  {

        // Get the base naming context
        Context env = null;
        try {
            env = (Context)new InitialContext().lookup("java:comp/env");
            imagePath = (String)env.lookup("imagepath");
            return imagePath;
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return imagePath;

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

        File f = new File("C:\\Users\\SEAS19062\\Pictures\\Clown.jpg");
        try {

            return Files.readAllBytes(f.toPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public byte[] getRandomImageData(){

        String initDir = getImagePath();

        File initDirectory = new File(initDir);

        List<File> imageFiles = new ArrayList<>();

        File[] files = initDirectory.listFiles();
        for (File f : files){
            if (f.isFile()){
                imageFiles.add(f);
            }
        }

        Random rnd = new Random();

        if (imageFiles.size()> 0){
            File pickedFile = imageFiles.get(rnd.nextInt(imageFiles.size()));

            try {
                return Files.readAllBytes(pickedFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    public FolderResponseMessage getFolderInformation() {

        FolderInfo info = new FolderInfo();
        info.setFolderCount(10);
        info.setImageCount(1029);
        info.setRootDirectory(getImagePath());

        return new FolderResponse(ResponseType.RESPONSE_SUCCESS, info);


    }


}
