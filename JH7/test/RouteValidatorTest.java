package route;

import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maria on 31.10.2016.
 */
public class RouteValidatorTest {
    @Test
    public void checkInvalidityOfRoutePositive() throws Exception {
        ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
        checkPoints.add(new CheckPoint(10, 20));
        checkPoints.add(new CheckPoint(10, 20));

        RouteValidator routeValidator = new RouteValidator();

        assertTrue(routeValidator.checkInvalidityOfRoute(checkPoints));
    }

    @Test
    public void checkInvalidityOfRouteNegative() throws Exception {
        ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
        checkPoints.add(new CheckPoint(0, 20));
        checkPoints.add(new CheckPoint(10, 20));

        RouteValidator routeValidator = new RouteValidator();

        assertFalse(routeValidator.checkInvalidityOfRoute(checkPoints));
    }

}