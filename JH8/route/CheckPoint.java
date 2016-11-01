package route;

/**
 * describes checkPoint
 * Created by Maria on 26.10.2016.
 */
public class CheckPoint {
    private double x = 0;
    private double y = 0;

    /**
     * creates instance of CheckPoint
     * with coordinate x and coordinate y
     * @param x is a coordinate x from file
     * @param y is a coordinate y from file
     */
    CheckPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
