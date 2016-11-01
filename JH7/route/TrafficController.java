package route;

import java.util.ArrayList;

/**
 * controls moving of transport
 * Created by Maria on 29.10.2016.
 */
public class TrafficController {

    /**
     * makes transport move
     * @param transport is an instance of type of transport
     * @param item is a number of checkPoint
     */
    public void followTheRoute(Move transport, int item, ArrayList<CheckPoint> checkPoints) {
            transport.move(item, checkPoints);
    }
}
