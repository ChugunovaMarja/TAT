package route;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

/**
 * contains point of entry
 * Created by Maria on 25.10.2016.
 */
public class RouteEfficiency {

    /**
     * point of entry
     */
    public static void main(String[] args) {

        RouteBuilder routeBuilder = new RouteBuilder();
        ArrayList<CheckPoint> checkPoints = routeBuilder.getRoute();
        RouteValidator routeValidator = new RouteValidator();

        if (routeValidator.checkInvalidityOfRoute(checkPoints)) {
            System.out.println("Incorrect route");
            System.exit(0);
        }

        ArrayList listOfTransport = listOfTransport();
        String[] statisticsForEachTransport = statisticsForEachTransport(listOfTransport, checkPoints);
        String[] arrayOfTransportNames = arrayOfTransportNames(listOfTransport);

        printStatistic(statisticsForEachTransport, arrayOfTransportNames);
    }

    /**
     * makes list of transport
     * @return list of transport
     */
    public static ArrayList listOfTransport() {

        ArrayList listOfTransport = new ArrayList();

        listOfTransport.add(new Bus());
        listOfTransport.add(new Car());
        listOfTransport.add(new Bicycle());
        listOfTransport.add(new Legs());

        return listOfTransport;
    }

    /**
     * makes list with strings of statistics for each transport from listOfTransport
     * @param listOfTransport is a list of transport
     * @return String with statistics for transport
     */
    public static String[] statisticsForEachTransport(ArrayList<Move> listOfTransport, ArrayList<CheckPoint> checkPoints) {

        String[] statisticsForEachTransport = new String[listOfTransport.size()];
        StatisticsCollector statisticsCollector = new StatisticsCollector();

        for(int item = 0; item < listOfTransport.size(); item ++) {
            statisticsForEachTransport[item] = statisticsCollector.collectStatistics(listOfTransport.get(item), checkPoints);
        }
        return statisticsForEachTransport;
    }

    /**
     * makes array with names of transport
     * @param listOfTransport is a list of transport
     * @return array with names of transport
     */
    public static String[] arrayOfTransportNames(ArrayList<Name> listOfTransport) {

        String[] arrayOfTransportNames = new String[listOfTransport.size()];
        StatisticsCollector statisticsCollector = new StatisticsCollector();

        for (int item = 0; item < listOfTransport.size(); item++) {
            arrayOfTransportNames[item] = statisticsCollector.nameGetter(listOfTransport.get(item));
        }
        return arrayOfTransportNames;
    }
    /**
     * prints statistics for each transport
     * @param statisticsForEachTransport list with statistics for each transport
     */
    public static void printStatistic(String[] statisticsForEachTransport, String[] arrayOfTransportNames) {

        for(int item = 0; item < statisticsForEachTransport.length; item++) {
            System.out.println(arrayOfTransportNames[item] + statisticsForEachTransport[item]);
        }
    }
}
