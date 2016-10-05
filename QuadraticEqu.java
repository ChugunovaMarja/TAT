import java.util.Scanner;

/** 
 * main class  
 * searching for roots
 * of quadratic equation
 */
public class QuadraticEqu {
  /**
   * checking discriminant and
   * calling for fuctions
   * checking data and searching roots
   */
  public static void main(String[] args) { 

    double a = 0;
    double b = 0;
    double c = 0;

    System.out.println("Enter coefficient a");
    a = readData();
	  System.out.println("Enter coefficient b");
    b = readData();
	  System.out.println("Enter coefficient c");
    c = readData();

    checkValid(a);

    double d = Discriminant(a, b, c);

    if (d < 0) {
        System.out.println("No real roots");
        System.exit(0);	
    }
    double[] roots = new double[2];
    roots = roots(a,b,c,d);

    System.out.println("x1 = " + roots[0]);
    System.out.println("x2 = " + roots[1]);
  }
  /**
   * reads data and checks if it's double
   */
  public static double readData() {
      Scanner sc = new Scanner(System.in);
	    double n = 0;
	    while (true) {
		    try {
		      n = Double.parseDouble(sc.next());
			    break;
		    } catch (NumberFormatException e) {
            System.out.println("Coefficient must be double. Try again");
        }
	  }
	  return n;
  }
  /**
   * checking for zero
   */
  public static void checkValid(double k) {
  if (Double.isInfinite(1/k)) {
      System.out.println("First coefficient cannot be equal zero");
      System.exit(0);
      }
  }
  /**
   * returns discriminant
   */
  public static double Discriminant(double a, double b, double c) { 
     return (b*b-4*a*c);
  }
  /**
   * returns array with roots
   */
  public static double[] roots (double a, double b, double c, double d) { 
  double[] roots = new double[2];
  roots[0] = (-b-Math.sqrt(d))/(2*a);
  roots[1] = (-b+Math.sqrt(d))/(2*a);
  return roots;
  }
}
