package showDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

/**
 * describes fields and methods needed for getting 
 * parameters of files in default directory
 * @param name is name of file
 * @param type if type of file
 * @param size is size of file
 * @param directory is a default directory
 * @param listOfFiles is a list of files in directory
 * @param path is a path of file
 * @param stringDate is a date of file creation converted into String type
 * @param fileInfoList is a list of instances of FileInfo class, containing info
 *           about files
 * @param convertedDate is a String with date converted into
 *           format corresponding to requirements 
 */
public class FileInfoGetter {

    private String name = "";
    private String type = "";
    private double size = 0;
    private File directory = new File(".");
    private File[] listOfFiles = directory.listFiles();

    private Path path;
    private BasicFileAttributes attrs;
    private String stringDate = "";
    private ArrayList<FileInfo> fileInfoList = new ArrayList<FileInfo>();
    private String convertedDate = "";

    /**
     * gets information about files and makes list of instances with info
     * @param name is name of file
     * @param type if type of file
     * @param size is size of file
     * @param directory is a default directory
     * @param listOfFiles is a list of files in directory
     * @param path is a path of file
     * @param stringDate is a date of file creation converted into String type
     * @param fileInfoList is a list of instances of FileInfo class, containing info
     *           about files
     * @param convertedDate is a String with date converted into
     *           format corresponding requirements 
     * @return list of instances of FileInfo class, containing info
     *            about files
     */
    public ArrayList infoGetter() {
        for (File file : listOfFiles) {
            path = file.toPath();
            name = file.getName();
            type = getType(file);
            size = (getSize(file) / 1024);
            try {
                attrs = Files.readAttributes(path, BasicFileAttributes.class);
                FileTime date = attrs.creationTime();
                stringDate = date.toString();
                convertedDate = convertDate(stringDate);
            } catch (IOException e) {
                e.printStackTrace();
            }

            fileInfoList.add(new FileInfo(name, type, convertedDate, size));
        }
        return fileInfoList;
    }

    /**
     * checks if file is a directory or file
     * @param file is file from default directory
     * @return "DIR" if file is a directory, 
     *             "FILE" if file is a file
     */
    public String getType(File file) {
        if (file.isDirectory()) {
            return "DIR";
        } else {
            return "FILE";
        }
    }

    /**
     * counts size of file or directory
     * @param file is a file from default directory
     * @return size of file/directory
     */
    public double getSize(File file) {
        if (file.isFile()) {
            return file.length();
        }
        double size = 0;
        if (file.isDirectory()) {
            for (File fileInside : file.listFiles()) {
                if (fileInside.isFile())
                    size += fileInside.length();
                else if (fileInside.isDirectory())
                    size += getSize(fileInside);
            }
        }
        return size;
    }

    /**
     * converts stringDate into format corresponding to requirements 
     * @param stringDate is a date of creation converted into String type
     * @return String with date converted into format corresponding to requirements 
     */
    public String convertDate(String stringDate) {

        String convertedDate = stringDate.substring(8, 10) + "." + stringDate.substring(5, 7) + "."
                + stringDate.substring(0, 4);
        return convertedDate;
    }
}
