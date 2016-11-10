package triangle;

/**
 * contains entry point
 * Created by Maria on 07.11.2016.
 */
public class TriangleParameters {

    /**
     * point of entry;
     * creates triangle and prints its type
     */
    public static void main(String[] args) {

        DataReader dataReader = new DataReader();
        double[] sides = dataReader.readSides();

        Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);

        System.out.println(triangle.getType());
    }
}
