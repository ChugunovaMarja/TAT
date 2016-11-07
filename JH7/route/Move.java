package route;

import java.util.ArrayList;

/**
 * says what transport can do and have
 * Created by Maria on 26.10.2016.
 */
interface Move {
    void move(int item, ArrayList<CheckPoint> checkPoints);
    MovementDetails getMovementDetails();
}
