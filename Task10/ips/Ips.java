package ips;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import java.util.HashMap;

/**
 * contains point of entry
 * @author Maria
 */
public class Ips {

    /**
     * point of entry, chooses source of ip list
     * and makes an ArrayList with instances of
     * Address and ping class, containing ip
     * and random time 
     * @param args contains array with ips or may be empty
     * @param ip gets string with ip
     * @param htmlPage is a new html page with table
     * @param randTime is a random time of answer
     * @param ipAndTime is a list with instances of 
     *           Address and ping class
     * @param hPage is an instance of HtmlMaker class
     * @param page is content of html table
     * @param max is a maximum value of time
     */
    public static void main(String[] args) {

        // todo check if ip is valid

        ArrayList<AddressAndPing> ipAndTime = new ArrayList<AddressAndPing>();
        String ip = null;
        BufferedReader br = null;
        File htmlPage = new File("htmlPage.html");
        
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                int randTime = 10 + (int) (Math.random() * ((500 - 10) + 1));
                ipAndTime.add(new AddressAndPing(args[i], randTime));
            }
        } else {
            try {
                br = new BufferedReader(new FileReader("./IpList.txt"));
                while ((ip = br.readLine()) != null) {
                    int randTime = 10 + (int) (Math.random() * ((500 - 10) + 1));
                    ipAndTime.add(new AddressAndPing(ip, randTime));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int max = getMax(ipAndTime);
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(htmlPage));
            HtmlMaker hPage = new HtmlMaker();
            String page = hPage.makeHeader() + hPage.bodyMaker(ipAndTime, max);
            bw.write(page);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * finds the maximum value of time 
     * @param ipAndTime is a list of instances of AddressAndPing
     * @return max is a maximum value of time
     */
    public static int getMax(ArrayList<AddressAndPing> ipAndTime) {
        int max = 0;
        for (AddressAndPing item : ipAndTime) {
            if(item.getTime() > max) {
                max = item.getTime();
            }
        }
        return max;
    }
}
