package route;

/**
 * Created by Maria on 26.10.2016.
 */
abstract public class MechanicalTransport implements Move, Statistics {

    abstract public void move(int item);

    abstract double CalculateDistance();

    abstract double time();

    abstract String nameOfTransport();

    abstract double countCost();

    abstract public String statistics();
}
