/**
 * 
 */
package productList;

import java.util.ArrayList;

/**
 * class realizing command "average price"
 *
 */
public class AveragePrice extends Command {

    public String getCommandName() {
        return "average price";
    }
    
    public void doCommand(ArrayList<Product> productList) {
        
        double generalPrice = 0;
        for(Product i: productList) {
            generalPrice+=i.price;
        }
        double averagePrice = generalPrice/productList.size();
        System.out.println(averagePrice);
    }
}
