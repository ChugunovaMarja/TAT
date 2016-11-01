package route;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maria on 31.10.2016.
 */
public class TimeCalculatorTest {

    @Test
    public void calculateTime() throws Exception {
        assertEquals(2.0, TimeCalculator.calculateTime(10.0, 5.0), 0.01);
    }

}