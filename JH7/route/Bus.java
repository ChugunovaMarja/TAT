package route;

import java.sql.Time;
import java.util.ArrayList;
/**
 * describes movint by bus
 * Created by Maria on 26.10.2016.
 */
public class Bus extends MechanicalTransport {

    /**
     * constructs instance of bus and determines speed and costForKm
     */
    public Bus () {
        super.speed = 60;
        super.costForKm = 35;
    }

    /**
     * @return name of transport
     */
    @Override
    public String getName () {
        return "Bus";
    }
}
