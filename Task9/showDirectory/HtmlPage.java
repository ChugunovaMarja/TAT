package showDirectory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;

/**
 * describes construction of html page
 * @param header describes construction of head of table with info about files
 * @param body describes construction of body of table with info about files
 */
public class HtmlPage {

    private String header = "";
    private String body = "";

    /**
     * serves for making head of table with info about files
     * @param header is code of head of table with info about files
     * @return code of head of table with info about files
     */
    public String header() {
        header = "<html> <head> <meta http-equiv=" + "Content-Language" + " content=" + "ru" + "><meta http-equiv="
                + "Content-Type" + " content=" + "text/html; charset=windows-1251"
                + "><title>Новая страница 1</title></head>" + "<body> <table border=" + "0" + " width=" + "70%"
                + " height=" + "48" + " bordercolor=" + "#FFFFFF" + "><tr><td height=" + "44" + " width=" + "25%"
                + " align=" + "center" + " valign=" + "top" + " bgcolor=" + "#CECFCE" + "><font size=" + "4" + " face="
                + "Arial" + ">ИМЯ</font></td><td height=" + "44" + " width=" + "25%" + " align=" + "center" + " valign="
                + "top" + " bgcolor=" + "#CECFCE" + "><font size=" + "4" + " face=" + "Arial"
                + ">ТИП</font></td>    <td height=" + "44" + " width=" + "25%" + " align=" + "center" + " valign=" + "top"
                + " bgcolor=" + "#CECFCE" + "><font size=" + "4" + " face=" + "Arial"
                + ">ДАТА СОЗДАНИЯ</font></td>    <td height=" + "44" + " width=" + "25%" + " align=" + "center"
                + " valign=" + "top" + " bgcolor=" + "#CECFCE" + "><font face=" + "Arial" + "><font size=" + "4"
                + ">РАЗМЕР (в </font><span lang=" + "en-us" + "><font size=" + "4" + ">Kb)</font></span></font></td>"
                + "</tr></table></body></html>";
        return header;
    }

    /**
     * 
     * serves for making body of table with info about files 
     * where color of background depends on parity of table string
     * @param body is code of body of table with info about files
     * @param iterator complies to number of iteration and serves
     *           for checking table string for parity
     * @return code of body of table with info about files
     */
    public String bodyMaker(ArrayList<FileInfo> fileInfoList) {

        int iterator = 0;
        
        for (FileInfo fileInstance : fileInfoList) {
            if ((iterator % 2) == 0) {
                body += "<html><head><meta http-equiv=" + "Content-Language" + " content=" + "ru" + "><meta http-equiv="
                        + "Content-Type" + " content=" + "text/html; charset=windows-1251"
                        + "><title>Новая страница 1</title></head><body><table border=" + "0" + " width=" + "70%"
                        + " height=" + "48" + " bordercolor=" + "#FFFFFF" + "><tr><td height=" + "44" + " width="
                        + "25%" + " align=" + "center" + " valign=" + "top" + " bgcolor=" + "#EFEFEF" + "><span lang="
                        + "en-us" + "><font face=" + "Arial" + " size=" + "4" + "> " + fileInstance.getName()
                        + "</font></span></td><td height=" + "44" + " width=" + "25%" + " align=" + "center"
                        + " valign=" + "top" + " bgcolor=" + "#EFEFEF" + "><span lang=" + "en-us" + "><font face="
                        + "Arial" + " size=" + "4" + ">" + fileInstance.getType() + "</font></span></td><td height="
                        + "44" + " width=" + "25%" + " align=" + "center" + " valign=" + "top" + " bgcolor=" + "#EFEFEF"
                        + "><span lang=" + "en-us" + "><font face=" + "Arial" + " size=" + "4" + ">"
                        + fileInstance.getDate() + "</font></span></td><td height=" + "44" + " width=" + "25%"
                        + " align=" + "center" + " valign=" + "top" + " bgcolor=" + "#EFEFEF" + "><span lang=" + "en-us"
                        + "><font face=" + "Arial" + " size=" + "4" + ">" + fileInstance.getSize()
                        + "</font></span></td></tr></table></body></html>";
            } else {
                body += "<html><head><meta http-equiv=" + "Content-Language" + " content=" + "ru" + "><meta http-equiv="
                        + "Content-Type" + " content=" + "text/html; charset=windows-1251"
                        + "><title>Новая страница 1</title></head><body><table border=" + "0" + " width=" + "70%"
                        + " height=" + "48px" + " bordercolor=" + "#FFFFFF" + "><tr><td height=" + "44px" + " width="
                        + "25%" + " align=" + "center" + " valign=" + "top" + " bgcolor=" + "#F7F7F7" + "><span lang="
                        + "en-us" + "><font face=" + "Arial" + " size=" + "4" + "> " + fileInstance.getName()
                        + "</font></span></td><td height=" + "44" + " width=" + "25%" + " align=" + "center"
                        + " valign=" + "top" + " bgcolor=" + "#F7F7F7" + "><span lang=" + "en-us" + "><font face="
                        + "Arial" + " size=" + "4" + ">" + fileInstance.getType() + "</font></span></td><td height="
                        + "44" + " width=" + "25%" + " align=" + "center" + " valign=" + "top" + " bgcolor=" + "#F7F7F7"
                        + "><span lang=" + "en-us" + "><font face=" + "Arial" + " size=" + "4" + ">"
                        + fileInstance.getDate() + "</font></span></td><td height=" + "44" + " width=" + "25%"
                        + " align=" + "center" + " valign=" + "top" + " bgcolor=" + "#F7F7F7" + "><span lang=" + "en-us"
                        + "><font face=" + "Arial" + " size=" + "4" + ">" + fileInstance.getSize()
                        + "</font></span></td></tr></table></body></html>";
            }
            iterator++;

        }
        return body;
    }
}
