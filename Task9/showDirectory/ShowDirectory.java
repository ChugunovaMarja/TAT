package showDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

/**
 * main class containing point of entry
 * @author Maria
 */
public class ShowDirectory {

    /**
     * point of entry,
     * gets list of files in directory and 
     * information about them from method 
     * of class FileInfoGetter and writes
     * into new html page info from methods of
     * HtmlPage class
     * @param args is ignored
     * @param fileInfoGetter is an instance of class
     *           FileInfoGetter, containing info about files
     * @param fileInfoList is a list with info about files from directory
     * @param htmlPage gets table with information about directory
     *           files from methods of class HtmlPage
     * @param hPage is an instance of HtmlPage class
     */
    public static void main(String[] args) {

        ArrayList<FileInfo> fileInfoList = new ArrayList<FileInfo>();

        FileInfoGetter fileInfoGetter = new FileInfoGetter();
        fileInfoList = fileInfoGetter.infoGetter();

        File htmlPage = new File("htmlPage.html");
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(htmlPage));
            HtmlPage hPage = new HtmlPage();
            String page = hPage.header() + hPage.bodyMaker(fileInfoList);
            bw.write(page);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
