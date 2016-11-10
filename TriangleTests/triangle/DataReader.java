package triangle;

import java.util.Scanner;

/**
 * reads sides of triangle
 * Created by Maria on 07.11.2016.
 */
public class DataReader {

    Scanner sc = new Scanner(System.in);

    /**
     * makes array of sides
     * @return
     */
    public double[] readSides() {
        double[] sides = {getSide("first"), getSide("second"), getSide("third")};
        return sides;
    }

    /**
     * gets one side
     * @param s is a number of side
     * @return value of side if it complies validation rules(its double and >0)
     */
    private double getSide(String s) {
        double side = 0;
        try {
            while (!Validator.dataValidator(side)) {
                System.out.println("Enter " + s + " side");
                side = Double.parseDouble(sc.next());
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Wrong data format");
            getSide(s);
        }
        return side;
    }
}
