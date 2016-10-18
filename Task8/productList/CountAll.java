/**
 * 
 */
package productList;

import java.util.ArrayList;

/**
 * class realizing command "count all"
 *
 */
public class CountAll extends Command {
    
    public String getCommandName() {
        return "count all";
    }
    
    public void doCommand(ArrayList<Product> productList) {
        
        int generalQuantity = 0;
        for(Product i: productList) {
            generalQuantity+=i.quantity;
        }
        System.out.println(generalQuantity);
    }
}
