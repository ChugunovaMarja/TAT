package route;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * reads ckeckpoints from file and adds them into ArrayList
 * Created by Maria on 26.10.2016.
 */
public class RouteBuilder {

    private BufferedReader br = null;
    private String coordinate = "";
    private ArrayList<CheckPoint> checkPoints = makeListOfPoints();

    /**
     * reads checkPoints from file, splits each line into x and y
     * coordinates, adds converted to double coordinates into
     * ArrayList as instances of CheckPoint class;
     * @return ArrayList of instances of CheckPoint class;
     */
    private ArrayList<CheckPoint> makeListOfPoints()  {
        ArrayList<CheckPoint> checkPoints = new ArrayList<CheckPoint>();
        try {
            br = new BufferedReader(new FileReader("./CheckPoints.txt"));
            while ((coordinate = br.readLine()) != null) {
                String[] splitedCoordinates = coordinate.split(" ");
                checkPoints.add(new CheckPoint(Double.parseDouble(splitedCoordinates[0]),
                        Double.parseDouble(splitedCoordinates[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e) {
            System.out.println("Wrong coordinate format. Must be numeric");
        }
        return checkPoints;
    }

    public ArrayList getRoute() {
        return checkPoints;
    }

}
