/**
 * 
 */
package productList;

/**
 * class describing product
 * @param type is a type of product
 * @param name is a name of product
 * @param quantity is a quantity of product
 * @param prica is a price of product
 */
public class Product {

    String type;
    String name;
    int quantity;
    double price;
    
    /**
     * constructs entity of product
     * @param type is a type of product
     * @param name is a name of product
     * @param quantity is a quantity of product
     * @param prica is a price of product
     */
    public Product (String type, String name, int quantity, double price) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

}
