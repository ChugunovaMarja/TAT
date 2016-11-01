package route;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
/**
 * Created by Maria on 01.11.2016.
 */
public class BusTest {
    double distance = 0;
    ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
    CheckPoint previoisPoint = new CheckPoint(0.0,0.0);
    CheckPoint nextPoint = new CheckPoint(3.0,4.0);
    int item = 1;

    @Test
    public void getNamePositive() throws Exception {
        Bus bus = new Bus();
        assertEquals(bus.getName(), "Bus");
    }

    @Test
    public void getNameNegative() throws Exception {
        Bus bus = new Bus();
        assertNotEquals(bus.getName(), "Car");
    }

    @Test
    public void moveTestPositive() {
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        Bus bus = new Bus();

        bus.move(item, checkPoints);

        assertEquals(bus.getPreviousPoint().getX(), 0.0);
        assertEquals(bus.getPreviousPoint().getY(), 0.0);
        assertEquals(bus.getNextPoint().getX(), 3.0);
        assertEquals(bus.getNextPoint().getY(), 4.0);
    }

    @Test
    public void getDistancePositive() {
        Bus bus = new Bus();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        bus.move(item, checkPoints);

        assertEquals(bus.getDistance(), 5.0);
    }

    @Test
    public void getDistanceNegative() {
        Bus bus = new Bus();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        bus.move(item, checkPoints);

        assertNotEquals(bus.getDistance(), 4);
    }

    @Test
    public void getTimeTest() {
        Bus bus = new Bus();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        bus.move(item, checkPoints);
        bus.getDistance();

        assertEquals(bus.getTime(), 0.083, 0.001 );
    }

    @Test
    public void getCostTest() {
        Bus bus = new Bus();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        bus.move(item, checkPoints);
        bus.getDistance();

        assertEquals(bus.getCost(), 0.1428, 0.001 );
    }

}