package route;

import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maria on 31.10.2016.
 */
public class StatisticsCollectorTest {
    @Test
    public void collectStatistics() throws Exception {

        ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
        checkPoints.add(new CheckPoint(0, 0));
        checkPoints.add(new CheckPoint(10, 0));
        checkPoints.add(new CheckPoint(20, 0));
        checkPoints.add(new CheckPoint(20, 10));
        checkPoints.add(new CheckPoint(20, 20));

        Bus bus = new Bus();
        StatisticsCollector statisticsCollector = new StatisticsCollector();

        assertEquals(":   Time:   0.6666666666666666   Cost:   1.1428571428571428", statisticsCollector.collectStatistics(bus, checkPoints));
    }

}