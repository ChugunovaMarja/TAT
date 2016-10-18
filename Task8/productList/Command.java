/**
 * 
 */
package productList;

import java.util.ArrayList;

/**
 * abstract class integrating commands
 *
 */
public abstract class Command {

    abstract public String getCommandName();
    
    abstract public void doCommand(ArrayList<Product> productList);
}
