package route;

import java.util.ArrayList;

/**
 * collects statistics about moving on transport
 * Created by Maria on 29.10.2016.
 */
public class StatisticsCollector {

    /**
     * makes arrays with values of distance, time and cost
     * for each checkPoint and adds their full sums into
     * string describing statistics
     * @param transport is a given way of moving
     * @return string describing statistics for given way of moving
     */
    public String collectStatistics(Move transport, ArrayList<CheckPoint> checkPoints) {

        ArrayList<MovementDetails> movementDetails = new ArrayList<MovementDetails>();
        TrafficController trafficController = new TrafficController();

        for (int item = 1; item < checkPoints.size(); ++item) {
            trafficController.followTheRoute(transport, item, checkPoints);
            movementDetails.add(transport.getMovementDetails());
        }

        String fullStatistics = (":   " + "Time:   " + fullTime(movementDetails)
                + "   Cost:   " + fullCost(movementDetails));
        return  fullStatistics;
    }

    public String nameGetter(Name transport) {
        return transport.getName();
    }

    /**
     * counts full time for all route
     * @param movementDetails is a list with details of movement between each point
     * @return full time for the route
     */
    private double fullTime(ArrayList<MovementDetails> movementDetails) {
        double fullTime = 0;
        for(int item = 0; item < movementDetails.size(); item++) {
            fullTime += movementDetails.get(item).getTime();
        }
        return fullTime;
    }

    /**
     * counts full cost for all route
     * @param movementDetails is a list with details of movement between each point
     * @return full cost for the route
     */
    private double fullCost(ArrayList<MovementDetails> movementDetails) {
        double fullCost = 0;
        for(int item = 0; item < movementDetails.size(); item++) {
            fullCost += movementDetails.get(item).getCost();
        }
        return fullCost;
    }
}
