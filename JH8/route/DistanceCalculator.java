package route;

/**
 * describes calculation of distance between two points
 * Created by Maria on 29.10.2016.
 */
public class DistanceCalculator {

    /**
     * calculates distance between previous and next points
     * @param previousPoint is a previous point
     * @param nextPoint is a next point
     * @return distance between two points
     */
    public static double calculateDistance (CheckPoint previousPoint, CheckPoint nextPoint) {
        double distance = Math.sqrt(Math.abs(Math.pow((nextPoint.getX() - previousPoint.getX()), 2)
                + Math.pow((nextPoint.getY() - previousPoint.getY()), 2)));
        return distance;
    }
}
