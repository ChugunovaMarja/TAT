package triangle;

/**
 * describes triangle
 * Created by Maria on 07.11.2016.
 */
public class Triangle {

    double a = 0;
    double b = 0;
    double c = 0;

    String type = "";

    /**
     * constructs instance of triangle with sides a, b and c
     * and gets type of triangle from TypeDeterminant
     * @param a is a first side
     * @param b is a second side
     * @param c is a third side
     */
    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        this.type = TypeDeterminant.determinateType(a,b,c);
    }

    public String getType() {
        return type;
    }

}