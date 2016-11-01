package route;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by Maria on 01.11.2016.
 */
public class LegsTest {

    double distance = 0;
    ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
    CheckPoint previoisPoint = new CheckPoint(0.0,0.0);
    CheckPoint nextPoint = new CheckPoint(3.0,4.0);
    int item = 1;

    @Test
    public void getNamePositive() throws Exception {
        Legs legs = new Legs();
        assertEquals(legs.getName(), "Legs");
    }

    @Test
    public void getNameNegative() throws Exception {
        Legs legs = new Legs();
        assertNotEquals(legs.getName(), "Bicycle");
    }

    @Test
    public void moveTestPositive() {
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        Legs legs = new Legs();

        legs.move(item, checkPoints);

        assertEquals(legs.getPreviousPoint().getX(), 0.0);
        assertEquals(legs.getPreviousPoint().getY(), 0.0);
        assertEquals(legs.getNextPoint().getX(), 3.0);
        assertEquals(legs.getNextPoint().getY(), 4.0);
    }

    @Test
    public void getDistancePositive() {
        Legs legs = new Legs();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        legs.move(item, checkPoints);

        assertEquals(legs.getDistance(), 5.0);
    }

    @Test
    public void getDistanceNegative() {
        Legs legs = new Legs();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        legs.move(item, checkPoints);

        assertNotEquals(legs.getDistance(), 4);
    }

    @Test
    public void getTimeTest() {
        Legs legs = new Legs();
        checkPoints.add(previoisPoint);
        checkPoints.add(nextPoint);

        legs.move(item, checkPoints);
        legs.getDistance();

        assertEquals(legs.getTime(), 1.0, 0.1 );
    }

}