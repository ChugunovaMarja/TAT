package triangle;

import com.sun.org.apache.xerces.internal.impl.dv.DatatypeValidator;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

/**
 * Created by Maria on 07.11.2016.
 */
public class ValidatorTest {
    @DataProvider(name = "invalid data")
    public Object[][] getData() {
        return new Object[][]{
                {-4},
                {0},
                {Double.NaN},
                {Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY},
                {Double.MAX_VALUE}
        };
    }

    @DataProvider(name = "valid data")
    public Object[][] getData2() {
        return new Object[][]{
                {10},
                {Double.MIN_VALUE}
        };
    }

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

    @DataProvider(name = "valid triangle sides")
    public Object[][] getSides2() {
        return new Object[][]{
                {3, 3, 3},
                {3, 4, 5},
                {7, 3, 6}
        };
    }

    @Test (dataProvider = "invalid data")
    public void testDataValidatorNegative(double data) throws Exception {
        assertFalse(Validator.dataValidator(data));
    }

    @Test (dataProvider = "valid data")
    public void testDataValidatorPositive(double data) throws Exception {
        assertTrue(Validator.dataValidator(data));
    }

    @Test (dataProvider = "invalid triangle sides")
    public void testTriangleValidatorNegative(double a, double b, double c) throws Exception {
        assertFalse(Validator.triangleValidator(a, b, c));
    }

    @Test (dataProvider = "valid triangle sides")
    public void testTriangleValidatorPositive(double a, double b, double c) throws Exception {
        assertTrue(Validator.triangleValidator(a, b, c));
    }
}