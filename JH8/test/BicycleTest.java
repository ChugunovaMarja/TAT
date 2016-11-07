package route;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by Maria on 01.11.2016.
 */
public class BicycleTest {

    double distance = 0;
    ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
    CheckPoint previoisPoint = new CheckPoint(0.0,0.0);
    CheckPoint nextPoint = new CheckPoint(3.0,4.0);
    int item = 1;

    @Test
    public void getNamePositive() throws Exception {
        Bicycle bicycle = new Bicycle();
        assertEquals(bicycle.getName(), "Bicycle");
    }

    @Test
    public void getNameNegative() throws Exception {
        Bicycle bicycle = new Bicycle();
        assertNotEquals(bicycle.getName(), "Legs");
    }

    @Test
    public void moveTestPositive() {
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        Bicycle bicycle = new Bicycle();

        bicycle.move(item, checkPoints);

        assertEquals(bicycle.getPreviousPoint().getX(), 0.0);
        assertEquals(bicycle.getPreviousPoint().getY(), 0.0);
        assertEquals(bicycle.getNextPoint().getX(), 3.0);
        assertEquals(bicycle.getNextPoint().getY(), 4.0);
    }

    @Test
    public void getDistancePositive() {
        Bicycle bicycle = new Bicycle();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        bicycle.move(item, checkPoints);

        assertEquals(bicycle.getDistance(), 5.0);
    }

    @Test
    public void getDistanceNegative() {
        Bicycle bicycle = new Bicycle();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        bicycle.move(item, checkPoints);

        assertNotEquals(bicycle.getDistance(), 4);
    }

    @Test
    public void getTimeTest() {
        Bicycle bicycle = new Bicycle();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        bicycle.move(item, checkPoints);
        bicycle.getDistance();

        assertEquals(bicycle.getTime(), 0.33, 0.1 );
    }


}
