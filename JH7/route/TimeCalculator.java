package route;

/**
 * describes calculation of time of moving between two points
 * Created by Maria on 29.10.2016.
 */
public class TimeCalculator {

    /**
     * calculates cost of moving between two points
     * @param distance is a distance between two points
     * @param SPEED is a speed of transport
     * @return time of moving between two points
     */
    public static double calculateTime(double distance, double SPEED) {
        return (distance/SPEED);
    }
}
