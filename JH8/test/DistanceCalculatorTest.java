package route;

import org.omg.CORBA.DoubleHolder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by Maria on 31.10.2016.
 */
public class DistanceCalculatorTest {

    @DataProvider(name = "check points true")
    public Object[][] getPoints1() {
        return new Object[][]{
                {5.0, new CheckPoint(10, 10), new CheckPoint(13, 14)},
                {14.142135623730950488016887242097, new CheckPoint(0, 5), new CheckPoint(10, 15)},
                {7.0710678118654752440084436210485, new CheckPoint(25, 40), new CheckPoint(30, 35)},
                {141.42135623730950488016887242097, new CheckPoint(0, 0), new CheckPoint(100, 100)},
                {1.1180339887498948482045868343656, new CheckPoint(1.1, 7.5), new CheckPoint(0.9, 6.4)}
        };
    }

    @DataProvider(name = "check points false")
    public Object[][] getPoints2() {
        return new Object[][]{
                {4, new CheckPoint(10, 10), new CheckPoint(13, 14)},
                {5.5, new CheckPoint(0, 5), new CheckPoint(10, 15)},
                {0.1, new CheckPoint(25, 40), new CheckPoint(30, 35)},
                {542, new CheckPoint(0, 0), new CheckPoint(100, 100)},
                {0, new CheckPoint(1.1, 7.5), new CheckPoint(0.9, 6.4)}
        };
    }


    @Test(dataProvider = "check points true")
    public void calculateDistancePositive(double expected, CheckPoint firstPoint, CheckPoint secondPoint) throws Exception {

        double delta = 0.00001;
        assertEquals(DistanceCalculator.calculateDistance(firstPoint, secondPoint), expected, delta);

    }

    @Test(dataProvider = "check points false")
    public void calculateDistanceNegative(double expected, CheckPoint firstPoint, CheckPoint secondPoint) throws Exception {

        double delta = 0.00001;
        assertNotEquals(DistanceCalculator.calculateDistance(firstPoint, secondPoint), expected, delta);

    }
}