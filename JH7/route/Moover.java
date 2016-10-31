package route;

import java.util.ArrayList;

/**
 * updates coordinates
 * Created by Maria on 29.10.2016.
 */
public class Moover {

    /**
     * updates coordinates according to number of next checkPoint
     * @param item is a number of next checkPoint
     * @return ArrayList with previous and next points
     */
    public static ArrayList<CheckPoint> move(int item, ArrayList<CheckPoint> checkPoints) {
        RouteBuilder routeBuilder = new RouteBuilder();
 //       ArrayList<CheckPoint> checkPoints = routeBuilder.getRoute();
        ArrayList<CheckPoint> points = new ArrayList<CheckPoint>();
        CheckPoint nextPoint = checkPoints.get(item);
        CheckPoint previousPoint = checkPoints.get(item - 1);
        points.add(previousPoint);
        points.add(nextPoint);

        return points;
    }
}
