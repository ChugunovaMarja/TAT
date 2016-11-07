package route;

import java.util.ArrayList;

/**
 * checking route for validity
 * Created by Maria on 31.10.2016.
 */
public class RouteValidator {

    /**
     * checks if first and last checkPoints of route are equal
     * @param checkPoints is a list of checkPoints
     * @return true if they are equal
     */
    public boolean checkInvalidityOfRoute(ArrayList<CheckPoint> checkPoints) {
        return ((checkPoints.get(0).getX() == checkPoints.get(checkPoints.size()-1).getX())
                && ((checkPoints.get(0).getY() == checkPoints.get(checkPoints.size()-1).getY())));
    }
}
