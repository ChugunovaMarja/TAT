package route;

import java.util.ArrayList;

/**
 * Created by Maria on 26.10.2016.
 */
public class Car extends MechanicalTransport {
    final private double COST_FOR_KM = 20;
    final private double SPEED = 85;

    RouteBuilder routeBuilder = new RouteBuilder();
    private ArrayList<CheckPoint> checkPoints = routeBuilder.getRoute();
    private double distance = CalculateDistance();
    private double cost = countCost();

    private double time = time();
    CheckPoint previousPoint;
    CheckPoint nextPoint;
   // int item = 1;

    @Override
    public void move(int item) {
        if (item < checkPoints.size()) {
            nextPoint = checkPoints.get(item);
            previousPoint = checkPoints.get(item - 1);
        }
    }

    @Override
    protected double CalculateDistance() {
        for (int item = 1; item < checkPoints.size(); ++item) {
            try {
                move(item);
                distance += Math.sqrt((nextPoint.getX() - previousPoint.getX()) * (nextPoint.getX() - previousPoint.getX())
                        - (nextPoint.getY() - previousPoint.getY()) * (nextPoint.getY() - previousPoint.getY()));
                //             item++;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Out Of Bounds");
                System.exit(0);
            }
        }
        return distance;
    }

    @Override
    protected double time() {
        return (distance/SPEED);
    }

    @Override
    protected String nameOfTransport () {
        return "Car";
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
