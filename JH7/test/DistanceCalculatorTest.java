package route;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maria on 31.10.2016.
 */
public class DistanceCalculatorTest {
    @Test
    public void calculateDistance() throws Exception {
        CheckPoint firstPoint = new CheckPoint(0, 5);
        CheckPoint secondPoint = new CheckPoint(10, 15);

        assertEquals(14.14, DistanceCalculator.calculateDistance(firstPoint, secondPoint), 0.1);

    }

}