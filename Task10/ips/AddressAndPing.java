package ips;

/**
 * describes object containing ip address and its ping time 
 */
public class AddressAndPing {
    
    private String ip = "";
    private int time = 0;
    
    /**
     * constructs instance of ip address and ping time
     * @param ip is ip address
     * @param time of ping
     */
    AddressAndPing(String ip, int time) {
        this.ip = ip;
        this.time = time;
    }
    
    public String getIp() {
        return ip;
    }
    public int getTime() {
        return time;
    }

}
