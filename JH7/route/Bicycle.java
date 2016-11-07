package route;

import java.util.ArrayList;

/**
 * describes moving on bicycle
 * Created by Maria on 26.10.2016.
 */
public class Bicycle implements Move, Name {

    private double costForKm = 0;
    private double speed = 15;

    private double distance = 0;
    CheckPoint previousPoint;
    CheckPoint nextPoint;

    /**
     * moves to next check point
     * @param item is a number of check point
     */
    @Override
    public void move(int item, ArrayList<CheckPoint> checkPoints) {
        previousPoint = Moover.move(item, checkPoints).get(0);
        nextPoint = Moover.move(item, checkPoints).get(1);
    }

    /**
     * calculates distance between two points
     */
    public double getDistance() {
        this.distance = DistanceCalculator.calculateDistance(previousPoint, nextPoint);
        return distance;
    }

    /**
     * calculates time of moving between two points
     * @return time of moving
     */
    public double getTime() {
        return TimeCalculator.calculateTime(distance, speed);
    }

    /**
     * @return name of transport
     */
    @Override
    public String getName () {
        return "Bicycle";
    }

    /**
     * calculates cost of moving between two points
     */
    public double getCost() {
        return costForKm;
    }

    /**
     * makes instance with details about moving between two points
     * @return
     */
    @Override
    public MovementDetails getMovementDetails() {
        return (new MovementDetails(getDistance(), getTime(), getCost()));
    }
}
