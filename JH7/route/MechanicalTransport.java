package route;

import java.util.ArrayList;

/**
 * describes MechanicalTransport
 * Created by Maria on 26.10.2016.
 */
public class MechanicalTransport implements Move, Name {

    protected double speed;
    protected double costForKm;
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
        return null;
    }

    /**
     * calculates cost of moving between two points
     */
    public double getCost() {
        return CostCalculator.calculateCost(distance, costForKm);
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
