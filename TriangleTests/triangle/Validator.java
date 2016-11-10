package triangle;

/**
 * validates entered data
 * Created by Maria on 07.11.2016.
 */
public class Validator {

    /**
     * checks if side is > 0 and if it is NaN
     * @param data is an entered side
     * @return true if data is correct, false if incorrect
     */
    public static boolean dataValidator(double data) {

        if (data == Double.MIN_VALUE) {
            return true;
        }
        if (data == Double.MAX_VALUE) {
            return false;
        }
        if (Double.isInfinite(1 / data)) {
            return false;
        }
        if (data < 0) {
            return false;
        }
        if (Double.isNaN(data)) {
            return false;
        }
        if (Double.isInfinite(data)) {
            return false;
        }
        return true;
    }

    /**
     * checks if triangle exist
     * @param a is a first side
     * @param b is a second side
     * @param c is a third side
     * @return true if triangle exist, false if not
     */
    public static boolean triangleValidator(double a, double b, double c) {
        if (dataValidator(a) && dataValidator(b) && dataValidator(c)) {
            if ((a + b > c) && (a + c > b) && (b + c > a)) {
                return true;
            }
        }
        return false;
    }
}
