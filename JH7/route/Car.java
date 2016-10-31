package route;

import java.util.ArrayList;

/**
 * describes moving by car
 * Created by Maria on 26.10.2016.
 */
public class Car extends MechanicalTransport {

    /**
     * constructs instance of bus and determines speed and costForKm
     */
    public Car () {
        super.speed = 85;
        super.costForKm = 20;
    }

    /**
     * @return name of transport
     */
    @Override
    public String getName () {
        return "Car";
    }
}
