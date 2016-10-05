import java.util.Scanner;

/** 
 * main class showing type of triangle
 * @author Maria Chugunova
 */
public class Triangle {
  /**
   * @brief gets data and calls functions checking 
   * data and showing type of triangle. The program does not involve 
   * input from the command line, only keyboard
   */
  public static void main(String[] args) { 

    double a = 0;
    double b = 0;
    double c = 0;

    while(isEqualToZero(a)==true) {
      System.out.println("Enter first side");
      a = readData();
    }
    while(isEqualToZero(b)==true) {
      System.out.println("Enter second side");
      b = readData();
    }
    while(isEqualToZero(c)==true) {
      System.out.println("Enter third side");
      c = readData();
    };

    if(checkExistence(a,b,c)==true) {
        System.out.println(getType(a,b,c));
    }
  }
  /**
   * @brief reads data and checks if it's double
   * @return Double returns entered side if it's double
   */
    public static double readData() {
      Scanner sc = new Scanner(System.in);
      while (true) {
        try {
          return Double.parseDouble(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Value of side must be double. Try again");
        }
      }
  }

  /**
   * @brief checking if parameter equal zero and returning true if it is
   * @return boolean i == false if parameter is zero
   */
  public static boolean isEqualToZero(double k) {
      if (Double.isInfinite(1/k)) {
        System.out.println("Sides cannot be equal zero");
        return true;
      } else {
          return false;
      }
  }

  /**
   * @brief checks if triangle with entered sides exist
   * @param a is the first side of triangle
   * @param b is the second side of triangle
   * @param c is the third side of triangle
   * @return boolean true if triangle exists
   */
  public static boolean checkExistence (double a, double b, double c) { 
     boolean i = false;
     if ((a+b>c) && (a+c>b) && (b+c>a)) {
       i = true;
     } else {
           System.out.println("Triangle doesn't exist");
           System.exit(0);
      }
  return i;
  }
  /**
   * @brief determines type of triangle
   * @param a is the first side of triangle
   * @param b is the second side of triangle
   * @param c is the third side of triangle
   * @return string type of triangle
   */
  public static String getType(double a, double b, double c) { 
      if ((a==b) && (b==c) && (a==c)) {
          return ("Ravnostoronnij");
      } 
      if (((a==b) && (a!=c)) || ((a==c) && (a!=b)) || ((b==c) && (b!=a))) {
          return("Ravnobokij");
      } else {
           return("Obychnyj");
      }
  }

}
