package route;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Maria on 31.10.2016.
 */
public class CostCalculatorTest {
    @Test
    public void calculateCost() throws Exception {
        assertEquals(5, CostCalculator.calculateCost(20, 4), 0.01);
    }

}