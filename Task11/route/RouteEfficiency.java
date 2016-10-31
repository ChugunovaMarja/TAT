package route;

import java.util.ArrayList;

/**
 * Created by Maria on 25.10.2016.
 */
public class RouteEfficiency {
//todo check points for validity
    public static void main(String[] args) {

        Bus bus = new Bus();
        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Legs legs = new Legs();

        System.out.println(bus.statistics());
        System.out.println(car.statistics());
        System.out.println(bicycle.statistics());
        System.out.println(legs.statistics());
    }
}
