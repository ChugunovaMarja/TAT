import java.util.Scanner;

/** 
 * main class searching for roots
 * of quadratic equation
 * @author Maria Chugunova
 */
public class QuadraticEqu {
  /**
   * @brief checking discriminant and calling for fuctions
   * checking data and searching roots
   * @param a is the first coefficient of quadratic equation
   * @param b is the second coefficient of quadratic equation
   * @param c is the third coefficient of quadratic equation
   * @param d is the discriminant of quadratic equation
   */
  public static void main(String[] args) { 

    double a = 0;
    double b = 0;
    double c = 0;

    while(isNull(a)==true) {
      System.out.println("Enter coefficient a");
      a = readData();
    }
    System.out.println("Enter coefficient b");
    b = readData();
    System.out.println("Enter coefficient c");
    c = readData();

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
   * @brief reads data and checks if it's double
   * @return Double returns entered coefficient if it's double
   */
  public static double readData() {
      Scanner sc = new Scanner(System.in);
      while (true) {
        try {
          return Double.parseDouble(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Coefficient must be double. Try again");
        }
      }
  }
  /**
   * @brief checking if parameter equal zero and returning false if it is
   * @param i gets false if parameter is zero
   * @return boolean i == false if parameter is zero
   */
  public static boolean isNull(double k) {
      if (Double.isInfinite(1/k)) {
        System.out.println("First coefficient cannot be equal zero");
        return true;
      } else {
          return false;
      }
  }
  /**
   * @brief calculates discriminant
   * @param a is the first coefficient of quadratic equation
   * @param b is the second coefficient of quadratic equation
   * @param c is the third coefficient of quadratic equation
   * @return double discriminant of quadratic equation
   */
  public static double Discriminant(double a, double b, double c) { 
     return (b*b-4*a*c);
  }
  /**
   * @brief calculates roots and returns array with x1 and x2
   * @param a is the first coefficient of quadratic equation
   * @param b is the second coefficient of quadratic equation
   * @param c is the third coefficient of quadratic equation
   * @param d is the discriminant of quadratic equation
   * @return double[] array with roots of quadratic equation
   */
  public static double[] roots (double a, double b, double c, double d) { 
  double[] roots = new double[2];
  roots[0] = (-b-Math.sqrt(d))/(2*a);
  roots[1] = (-b+Math.sqrt(d))/(2*a);
  return roots;
  }
}
