package route;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Maria on 31.10.2016.
 */
public class TimeCalculatorTest {

    @Test
    public void calculateTime() throws Exception {
        assertEquals(2.0, TimeCalculator.calculateTime(10.0, 5.0), 0.01);
    }

}