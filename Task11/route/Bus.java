package route;

import java.util.ArrayList;
/**
 * describes bus
 * Created by Maria on 26.10.2016.
 */
public class Bus extends MechanicalTransport {
    final private double COST_FOR_KM = 35;
    final private double SPEED = 60;

    RouteBuilder routeBuilder = new RouteBuilder();
    private ArrayList<CheckPoint> checkPoints = routeBuilder.getRoute();
    private double distance = CalculateDistance();
    private double cost = countCost();

    private double time = time();
    CheckPoint previousPoint;
    CheckPoint nextPoint;

    /**
     * moves to next check point
     * @param item is a number of check point
     */
    @Override
    public void move(int item) {
            nextPoint = checkPoints.get(item);
            previousPoint = checkPoints.get(item - 1);
    }

    /**
     * calculates length of route
     * @return lenght of route
     */
    @Override
    protected double CalculateDistance() {
        double distance = 0;
        for (int item = 1; item < checkPoints.size(); ++item) {
                move(item);
                distance += Math.sqrt((nextPoint.getX() - previousPoint.getX())*(nextPoint.getX() - previousPoint.getX()) - (nextPoint.getY() - previousPoint.getY())*(nextPoint.getY() - previousPoint.getY()));
        }
        return distance;
    }

    /**
     * counts time of moving on route
     * @return time of moving
     */
    @Override
    protected double time() {
        return (distance/SPEED);
    }

    /**
     * @return name of transport
     */
    @Override
    protected String nameOfTransport () {
        return "Bus";
    }

    @Override
    protected double countCost() {
        return (distance/COST_FOR_KM);
    }

    @Override
    public String statistics() {
        return (nameOfTransport() + ":   Time = " + time + "  Cost = " + cost);
    }
}
