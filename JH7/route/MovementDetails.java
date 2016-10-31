package route;

import java.util.ArrayList;
/**
 * Created by Maria on 30.10.2016.
 */
public class MovementDetails {

    private double distance;
    private double time;
    private double cost;

     public MovementDetails (double distance, double time, double cost) {
            this.distance = distance;
            this.time = time;
            this.cost = cost;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public double getCost() {
        return cost;
    }
}
