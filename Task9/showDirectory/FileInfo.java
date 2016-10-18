package showDirectory;

import java.io.File;
import java.nio.file.attribute.*;

/**
 * describes attributes of files
 * @param name is name of file
 * @param type is type of file (Directory or file)
 * @param date is a date of creation of file
 * @param size is a size of file
 */
public class FileInfo {

    private String name;
    private String type;
    private String date;
    private double size;

    /**
     * constructs instance of file containing its attributes
     * @param fileName is a name of file, recieved from method infoGetter 
     *           of FileInfoGetter class
     * @param fileType is a type of file, recieved from method infoGetter 
     *           of FileInfoGetter class
     * @param fileDate is a date of file creation, recieved from method infoGetter 
     *           of FileInfoGetter class
     * @param fileSize is a size of file, recieved from method infoGetter 
     *           of FileInfoGetter class
     */
    FileInfo(String fileName, String fileType, String fileDate, double fileSize) {
        this.name = fileName;
        this.type = fileType;
        this.date = fileDate;
        this.size = fileSize;
    }

    protected String getName() {
        return name;
    }

    protected String getType() {
        return type;
    }

    protected String getDate() {
        return date;
    }

    protected double getSize() {
        return size;
    }

}
