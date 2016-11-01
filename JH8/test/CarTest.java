package route;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by Maria on 01.11.2016.
 */
public class CarTest {
    double distance = 0;
    ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
    CheckPoint previoisPoint = new CheckPoint(0.0,0.0);
    CheckPoint nextPoint = new CheckPoint(3.0,4.0);
    int item = 1;

    @Test
    public void getNamePositive() throws Exception {
        Car car = new Car();
        assertEquals(car.getName(), "Car");
    }

    @Test
    public void getNameNegative() throws Exception {
        Car car = new Car();
        assertNotEquals(car.getName(), "Bus");
    }

    @Test
    public void moveTestPositive() {
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        Car car = new Car();

        car.move(item, checkPoints);

        assertEquals(car.getPreviousPoint().getX(), 0.0);
        assertEquals(car.getPreviousPoint().getY(), 0.0);
        assertEquals(car.getNextPoint().getX(), 3.0);
        assertEquals(car.getNextPoint().getY(), 4.0);
    }

    @Test
    public void getDistancePositive() {
        Car car = new Car();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        car.move(item, checkPoints);

        assertEquals(car.getDistance(), 5.0);
    }

    @Test
    public void getDistanceNegative() {
        Car car = new Car();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        car.move(item, checkPoints);

        assertNotEquals(car.getDistance(), 4);
    }

    @Test
    public void getTimeTest() {
        Car car = new Car();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        car.move(item, checkPoints);
        car.getDistance();

        assertEquals(car.getTime(), 0.05882352941, 0.001 );
    }

    @Test
    public void getCostTest() {
        Car car = new Car();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        car.move(item, checkPoints);
        car.getDistance();

        assertEquals(car.getCost(), 0.25, 0.001 );
    }
}