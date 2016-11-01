package route;

import java.util.ArrayList;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Maria on 31.10.2016.
 */
public class MooverTest {
    @Test
    public void move() throws Exception {

        ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
        ArrayList<CheckPoint> pointsBefore = new ArrayList<CheckPoint>();
        ArrayList<CheckPoint> pointsAfter;

        checkPoints.add(new CheckPoint(0,0));
        checkPoints.add(new CheckPoint(10,0));
        checkPoints.add(new CheckPoint(5, 0));

        pointsBefore.add(checkPoints.get(0));
        pointsBefore.add(checkPoints.get(1));

        int item = 2;

        pointsAfter = Moover.move(item, checkPoints);

        assertEquals(pointsAfter.get(0), pointsBefore.get(1));
    }

}