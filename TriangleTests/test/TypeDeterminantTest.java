package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Maria on 07.11.2016.
 */
public class TypeDeterminantTest {

    @DataProvider(name = "invalid triangle sides")
    public Object[][] getSides() {
        return new Object[][]{
                {-1, 2, 3},
                {1, -2, 3},
                {1, 2, -3},
                {0, 1, 2},
                {1, 0, 2},
                {1, 2, 0},
                {Double.MAX_VALUE, 2, 3},
                {1, Double.MAX_VALUE, 3},
                {1, 2, Double.MAX_VALUE},
                {Double.NaN, 2, 3},
                {1, Double.NaN, 3},
                {1, 2, Double.NaN},
                {Double.POSITIVE_INFINITY, 2, 3},
                {1, Double.POSITIVE_INFINITY, 3},
                {1, 2, Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY, 2, 3},
                {1, Double.NEGATIVE_INFINITY, 3},
                {1, 2, Double.NEGATIVE_INFINITY},
                {1, 1, 10}
        };
    }

    @Test (dataProvider = "invalid triangle sides")
    public void testDeterminateTypeNegative(double a, double b, double c) throws Exception {
        assertTrue(TypeDeterminant.determinateType(a, b, c).equals("Triangle doesnt exist"));
    }

    @Test
    public void testDeterminateTypeEquilateral() throws Exception {
        assertTrue(TypeDeterminant.determinateType(3, 3, 3).equals("Equilateral"));
    }

    @Test
    public void testDeterminateTypeIsosceles() throws Exception {
        assertTrue(TypeDeterminant.determinateType(2, 2, 3).equals("Isosceles"));
    }

    @Test
    public void testDeterminateTypeOrdinary() throws Exception {
        assertTrue(TypeDeterminant.determinateType(7, 3, 6).equals("Ordinary"));
    }
}