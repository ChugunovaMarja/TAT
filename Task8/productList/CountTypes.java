/**
 * 
 */
package productList;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * class realizing command "count types"
 *
 */
public class CountTypes extends Command {

    public String getCommandName() {
        return "count types";
    }
    
  public void doCommand(ArrayList<Product> productList) {
        
    HashSet<String> types = new HashSet<String>();
    
    for(Product i: productList) {
        types.add(i.type);
    }
    System.out.println(types.size());
    }
    
}
