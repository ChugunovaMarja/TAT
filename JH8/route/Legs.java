package route;

import java.util.ArrayList;


/**
 * describes pedestrian way of moving
 * Created by Maria on 26.10.2016.
 */
public class Legs implements Move, Name {

    private double costForKm = 0;
    private double speed = 5;

    private double distance = 0;
    CheckPoint previousPoint;
    CheckPoint nextPoint;

    public CheckPoint getPreviousPoint() {
        return previousPoint;
    }

    public CheckPoint getNextPoint() {
        return nextPoint;
    }

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
        return "Legs";
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
