package img.Impl;

import img.Impl.response.FolderInfo;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Folders {

    private final String startPath;
    private FolderInfo folderInfo = new FolderInfo();

    private int dirCount = 0;
    private int fileCount = 0;

    public Folders(String startPath){
        this.startPath = startPath;
    }

    public FolderInfo getFolderInformation(){


        Path myStartPath = Paths.get(startPath);
        try {
            Files.walkFileTree(myStartPath, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toFile().isDirectory()){
                        dirCount++;
                    }
                    if (file.toFile().isFile()){
                        fileCount++;
                        if (fileCount > 10000)
                            return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


        folderInfo.setFolderCount(dirCount);
        folderInfo.setImageCount(fileCount);
        folderInfo.setRootDirectory(startPath);

        return folderInfo;

    }

}
