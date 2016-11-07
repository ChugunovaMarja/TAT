package route;

/**
 * describes calculation of cost of moving between two points
 * Created by Maria on 29.10.2016.
 */
public class CostCalculator {

    /**
     * calculates cost of moving between two points
     * @param distance is a distance between two points
     * @param COST_FOR_KM is a cost of moving for one km for kind of transport
     * @return cost of moving between two points
     */
    public static double calculateCost (double distance, double COST_FOR_KM ) {
        return (distance/COST_FOR_KM );
    }
}
