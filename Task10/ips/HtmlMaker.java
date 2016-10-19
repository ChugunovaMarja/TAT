package ips;

import java.util.ArrayList;

/**
 * describes html table with info about server
 * @param header is a head of table
 * @param body is a body of table
 */
public class HtmlMaker {

    private String header = "";
    private String body = "";

    /**
     * contains code describing head of table
     * @return string with code of head of table
     */
    public String makeHeader() {

        header = "<html><head><meta http-equiv=" + "Content-Language" + " content=" + "en-us" + "><meta http-equiv="
                + "Content-Type" + " content=" + "text/html; charset=windows-1252"
                + "><title>&#1053;&#1086;&#1074;&#1072;&#1103; &#1089;&#1090;"
                + "&#1088;&#1072;&#1085;&#1080;&#1094;&#1072; 1</title></head>" + "<body><table border=" + "0"
                + " width=" + "70%" + " height=" + "43" + " bordercolorlight=" + "#FFFFFF" + " bordercolordark="
                + "#FFFFFF" + "><tr><td height=" + "43" + " width=" + "50%" + " align=" + "center" + " bgcolor="
                + "#999999" + "><font face=" + "Arial" + "><b>Server</b></font></td><td height=" + "43" + " width="
                + "50%" + " align=" + "center" + " bgcolor=" + "#999999" + "><font face=" + "Arial"
                + "><b>Response, ms</b></font></td>" + "</tr></table></body></html>";

        return header;
    }

    /**
     * describes code of body of table, where color of background depends on
     * parity of string and value of time (red if value is max)
     * @param ipAndTime list of instances of AddressAndPing class,
     *           containing ip address and ping time
     * @param max is a maximum value of ping time
     * @return string with code of body of table
     * @param iterator complies to number of iteration and serves
     *           for checking table string for parity
     */
    public String bodyMaker(ArrayList<AddressAndPing> ipAndTime, int max) {

        int iterator = 0;

        for (AddressAndPing string : ipAndTime) {
            if ((string.getTime() != max) && ((iterator % 2) == 0)) {
                body += "<html><head><meta http-equiv=" + "Content-Language" + " content=" + "en-us"
                        + "><meta http-equiv=" + "Content-Type" + " content=" + "text/html; charset=windows-1252"
                        + "><title>&#1053;&#1086;&#1074;&#1072;&#1103; &#1089;&#1090;"
                        + "&#1088;&#1072;&#1085;&#1080;&#1094;&#1072; 1</title></head>" + "<body><table border=" + "0"
                        + " width=" + "70%" + " height=" + "43" + " bordercolorlight=" + "#FFFFFF" + " bordercolordark="
                        + "#FFFFFF" + "><tr><td height=" + "43" + " width=" + "50%" + " align=" + "center" + " bgcolor="
                        + "#EFEFEF" + "><font face=" + "Arial" + ">" + string.getIp() + "</font></td><td height=" + "43"
                        + " width=" + "50%" + " align=" + "center" + " bgcolor=" + "#EFEFEF" + "><font face=" + "Arial"
                        + ">" + string.getTime() + "</font></td>" + "</tr></table></body></html>";
            }
            if ((string.getTime() != max) && ((iterator % 2) != 0)) {
                body += "<html><head><meta http-equiv=" + "Content-Language" + " content=" + "en-us"
                        + "><meta http-equiv=" + "Content-Type" + " content=" + "text/html; charset=windows-1252"
                        + "><title>&#1053;&#1086;&#1074;&#1072;&#1103; &#1089;&#1090;"
                        + "&#1088;&#1072;&#1085;&#1080;&#1094;&#1072; 1</title></head>" + "<body><table border=" + "0"
                        + " width=" + "70%" + " height=" + "43" + " bordercolorlight=" + "#FFFFFF" + " bordercolordark="
                        + "#FFFFFF" + "><tr><td height=" + "43" + " width=" + "50%" + " align=" + "center" + " bgcolor="
                        + "#D9D9D9" + "><font face=" + "Arial" + ">" + string.getIp() + "</font></td><td height=" + "43"
                        + " width=" + "50%" + " align=" + "center" + " bgcolor=" + "#D9D9D9" + "><font face=" + "Arial"
                        + ">" + string.getTime() + "</font></td>" + "</tr></table></body></html>";
            }
            if (string.getTime() == max) {
                body += "<html><head><meta http-equiv=" + "Content-Language" + " content=" + "en-us"
                        + "><meta http-equiv=" + "Content-Type" + " content=" + "text/html; charset=windows-1252"
                        + "><title>&#1053;&#1086;&#1074;&#1072;&#1103; &#1089;&#1090;"
                        + "&#1088;&#1072;&#1085;&#1080;&#1094;&#1072; 1</title></head>" + "<body><table border=" + "0"
                        + " width=" + "70%" + " height=" + "43" + " bordercolorlight=" + "#FFFFFF" + " bordercolordark="
                        + "#FFFFFF" + "><tr><td height=" + "43" + " width=" + "50%" + " align=" + "center" + " bgcolor="
                        + "#FF0000" + "><font face=" + "Arial" + ">" + string.getIp() + "</font></td><td height=" + "43"
                        + " width=" + "50%" + " align=" + "center" + " bgcolor=" + "#FF0000" + "><font face=" + "Arial"
                        + ">" + string.getTime() + "</font></td>" + "</tr></table></body></html>";
            }
            iterator++;
        }
        return body;
    }
}
