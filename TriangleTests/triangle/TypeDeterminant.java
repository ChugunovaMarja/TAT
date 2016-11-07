package triangle;

/**
 * triangle type determinator
 * Created by Maria on 07.11.2016.
 */
public class TypeDeterminant {

    /**
     * determinates type of triangle
     * @param a first side
     * @param b second side
     * @param c third side
     * @return string with type of triangle or message about its existence
     */
    public static String determinateType(double a, double b, double c) {

        if(!Validator.triangleValidator(a,b,c)) {
            return "Triangle doesnt exist";
        }
        if ((a == b) && (b == c) && (a == c)) {
            return ("Equilateral");
        }
        if (((a == b) && (a != c)) || ((a == c) && (a != b)) || ((b == c) && (b != a))) {
            return("Isosceles");
        }
        return("Ordinary");
    }
}
