package productList;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * main class, contains entry point
 * @author Maria
 */
public class ProductList {

    /**
     * point of entry; 
     * makes list of product until user writes 'done'
     * asks user about command until he writes 'exit'
     * @param args is ignored
     * @param productList is a list of entered by user products
     * @param enteredCommand is entered by user command
     * @param chooser is a list of available commands
     */
    public static void main(String[] args) {
        // TODO realize checking for validity of entered data
        
        ArrayList<Product> productList = new ArrayList<Product>();
        productList = makeList();

        CommandChooser chooser = new CommandChooser().add(new CountTypes())
                                                     .add(new CountAll())
                                                     .add(new AveragePrice())
                                                     .add(new AveragePriceForType());
        String enteredCommand = "";
        
        while(!enteredCommand.equals("exit")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter command: ");
            enteredCommand = sc.nextLine();
            chooser.commandChooser(enteredCommand, productList);
        }
    }
    
    /**
     * makes a list of entered by user products
     * @param ask is for asking user if he wants to add one more product
     * @param type is a type of product
     * @param name is a name of product
     * @param quantity is a quantity of product
     * @param price is a price of product
     * @param productList is a list of products
     * @return productList - list of products
     */
      public static ArrayList makeList() {
        String ask = "";
        String type;
        String name;
        int quantity;
        double price;
        ArrayList<Product> productList = new ArrayList<Product>();
        
        while(!ask.equals("done")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter type of product: ");
            type = sc.nextLine();
            System.out.println("Enter name of product: ");
            name = sc.nextLine();
            System.out.println("Enter quantity of product: ");
            quantity = sc.nextInt();
            System.out.println("Enter price of product: ");
            price = sc.nextDouble();
            productList.add(new Product(type, name, quantity, price));
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Type 'done' if you've finished your list"
                       + " of products. If not, press Enter ");
            ask = sc2.nextLine();
            }
        return productList;
      }
}
