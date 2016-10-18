/**
 * 
 */
package productList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * class realizing command "average price type"
 *
 */
public class AveragePriceForType extends Command {
    
    String chosenType = "";
    
    public String getCommandName() {
        return "average price type";
    }
    
public void doCommand(ArrayList<Product> productList) {
        
        double generalPriceForType = 0;
        int numberOfType = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the type of product ");
        chosenType = sc.nextLine();
        
        for(Product i: productList) {
            if((i.type).equals(chosenType)) {
              generalPriceForType+=i.price;
              numberOfType++;
            }
        }
        double averagePriceForType = generalPriceForType/numberOfType;
        System.out.println(averagePriceForType);
    }

}
